package mumtaz.binar.jcnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import mumtaz.binar.jcnews.data.ResponseNewsItem
import mumtaz.binar.jcnews.ui.theme.JCNewsTheme
import mumtaz.binar.jcnews.viewmodel.NewsViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsViewModel = viewModel(modelClass = NewsViewModel::class.java)
                    val datanews by newsViewModel.dataState.collectAsState()


                    LazyColumn{
                        if (datanews.isEmpty()){
                            item {

                            }
                        }

                        items(datanews){
                            NewsComposeCustom(news = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(news : ResponseNewsItem) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JCNewsTheme {
//        Greeting(",","","",",","","","")
    }
}