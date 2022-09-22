package com.apolloagriculture.android.takehomeassignment.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before

class MockWebServer {

    lateinit var foreCastApiService: ForecastApiService
    lateinit var mockHttpClient: HttpClient

    @Throws(IOException::class)
    private fun readFileWithoutNewLineFromResources(fileName: String): String {
        var inputStream: InputStream? = null
        try {
            inputStream =
                javaClass.classLoader?.getResourceAsStream(fileName)
            val builder = StringBuilder()
            val reader = BufferedReader(InputStreamReader(inputStream))

            var str: String? = reader.readLine()
            while (str != null) {
                builder.append(str)
                str = reader.readLine()
            }
            return builder.toString()
        } finally {
            inputStream?.close()
        }
    }

    val forecastSuccessResponse = readFileWithoutNewLineFromResources("forecast_success.json")

    @Before
    private fun setUp() {
        mockHttpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->

                    // Request handler/dispatcher
                    when (request.url.encodedPath) {
                        "/${ForecastApiService.FORECAST_URL}" -> {
                            respond(
                                content = forecastSuccessResponse,
                                status = HttpStatusCode.OK,
                                headers = headersOf(HttpHeaders.ContentType, "application/json")
                            )

                        }
                        else -> error("Unhandled ${request.url.encodedPath}")
                    }
                }
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    Json {
                        ignoreUnknownKeys = false
                        isLenient = false
                    }
                )
            }
        }

        foreCastApiService = ForecastApiService(httpClient = mockHttpClient)
    }

    @After
    private fun tearDown() {
        mockHttpClient.close()
    }

}