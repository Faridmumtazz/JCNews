package mumtaz.binar.jcnews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mumtaz.binar.jcnews.NewsRepository
import mumtaz.binar.jcnews.data.ResponseNewsItem
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val api : NewsRepository): ViewModel(){

    private val newsState = MutableStateFlow(emptyList<ResponseNewsItem>())
    val dataState : StateFlow<List<ResponseNewsItem>> get() = newsState

    init {
        viewModelScope.launch {
            val news = api.getNews()
            newsState.value = news
        }
    }
}