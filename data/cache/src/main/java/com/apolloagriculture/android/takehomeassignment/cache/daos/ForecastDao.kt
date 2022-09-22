package com.apolloagriculture.android.takehomeassignment.cache.daos

import kotlinx.coroutines.flow.Flow

interface ForecastDao {

    @Query("SELECT * FROM Movies_Shows_Table WHERE category=:category")
    fun getMoviesShows(category: String): Flow<List<MovieShowEntity>>

}