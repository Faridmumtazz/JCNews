package mumtaz.binar.jcnews

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import mumtaz.binar.jcnews.data.ResponseNewsItem

@Composable
fun NewsComposeCustom(news: ResponseNewsItem){
    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        val context = LocalContext.current
        Card(modifier = Modifier

            .clickable {
                val pindah = Intent(context, DetailActivity::class.java)
                pindah.putExtra("SELECTED_DATA", news)
                context.startActivity(pindah)

            }
            .padding(5.dp)
            .fillMaxWidth()
        ) {
            Row() {

                Image(painter =  rememberImagePainter(news.image), contentDescription ="icon",
                modifier = Modifier.height(50.dp))
                Column(
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text(text = news.title)
                    Text(text = news.author)
                    Text(text = news.createdAt)
                }
            }
        }

    }
}