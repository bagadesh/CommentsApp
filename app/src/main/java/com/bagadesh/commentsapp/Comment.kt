package com.bagadesh.commentsapp

/**
 * Created by bagadesh on 15/07/22.
 */
data class Comment(
    val message: String,
    var isReply: Boolean,
    val comment: List<Comment>? = null,
)
