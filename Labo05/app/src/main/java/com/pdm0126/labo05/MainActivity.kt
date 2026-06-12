package com.pdm0126.labo05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pdm0126.labo05.ui.theme.Labo05Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo05Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PostScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PostScreen(modifier: Modifier = Modifier) {
    val postDao = InitDatabase.database.postDao()
    val posts by postDao.getAllPosts().collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()

    Column(modifier = modifier.padding(16.dp)) {
        Button(onClick = {
            scope.launch {
                val newPost = Post(
                    title = "Post #${posts.size + 1}",
                    content = "Contenido de la publicación número ${posts.size + 1}",
                )
                postDao.insertPost(newPost)
            }
        }) {
            Text("Agregar Publicación")
        }
        LazyColumn {
            items(posts) { post ->
                Column(modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(text = post.title, style = MaterialTheme.typography.titleMedium)
                    Text(text = post.content, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Labo05Theme {
        PostScreen()
    }
}
