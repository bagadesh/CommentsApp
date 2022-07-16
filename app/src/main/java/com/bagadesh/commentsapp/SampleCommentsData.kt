package com.bagadesh.commentsapp

/**
 * Created by bagadesh on 15/07/22.
 */

val sampleCommentData: List<Comment> by lazy {
    provideData()
}

fun provideData():List<Comment> {
    val data = mutableListOf<Comment>()

    repeat(30) { first ->
        val temp =  mutableListOf<Comment>()
        repeat(3) {second ->
            val temp2 =  mutableListOf<Comment>()
            repeat(3) {third ->
                temp2.add(
                    Comment(
                        "comment$first$second$third",
                        false,
                    )
                )
            }
            temp.add(
                Comment(
                    "comment$first$second",
                    false,
                    temp2
                )
            )
        }
        data.add(
            Comment(
                "comment$first",
                false,
                temp
            )
        )
    }
    return data
}