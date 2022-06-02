package mumtaz.binar.jcnews.api

import mumtaz.binar.jcnews.data.ResponseNewsItem
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    suspend fun getAllNews(): List<ResponseNewsItem>
}