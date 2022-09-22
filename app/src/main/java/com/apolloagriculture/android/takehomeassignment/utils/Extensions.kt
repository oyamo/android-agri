package com.apolloagriculture.android.takehomeassignment.utils

/**Split camel case text to human readable text ==> camelCase->Camel Case*/
fun String.splitCamelCase(): String {
    return this.replace(
        String.format(
            "%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])",
            "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])"
        ).toRegex(),
        " "
    )
}
