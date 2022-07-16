package com.bagadesh.commentsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by bagadesh on 15/07/22.
 */


@Composable
fun CommentsUI(
    modifier: Modifier = Modifier,
    commentList: List<Comment>,
    padding: Dp = 9.dp
) {
    LazyColumn(
        modifier = modifier.then(
            Modifier.padding(start = padding)
        )

    ) {
        item {
            Text(text = "Header")
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Red))
        }
        items(commentList) {
            CommentUI(comment = it)
            it.comment?.let { children ->
                CommentsUI(modifier = Modifier.height(200.dp), commentList = children, padding = padding + 20.dp)
            }
        }
    }
}

@Composable
fun CommentUI(comment: Comment) {
    var message by remember {
        mutableStateOf("")
    }
    var isReplay by remember {
        mutableStateOf(comment.isReply)
    }
    Column(
        modifier = Modifier
            .padding(5.dp)
            .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(10.dp))
            .padding(5.dp)
    ) {
        Text(text = comment.message)
        if (isReplay) {
            TextField(value = message, onValueChange = {
                message = it
            })
        }
        Button(
            modifier = Modifier.padding(start = 20.dp),
            onClick = {
                isReplay = !isReplay
            }) {
            Text(text = "reply")
        }
    }
//    Row(verticalAlignment = Alignment.CenterVertically) {
//
//    }
}