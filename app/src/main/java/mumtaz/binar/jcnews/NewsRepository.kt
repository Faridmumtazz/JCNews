package mumtaz.binar.jcnews

import mumtaz.binar.jcnews.api.ApiService
import mumtaz.binar.jcnews.data.ResponseNewsItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsapi : ApiService) {

    suspend fun getNews() : List<ResponseNewsItem>{
        return newsapi.getAllNews()
    }
}