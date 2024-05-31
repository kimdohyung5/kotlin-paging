package com.kimdo.pagingsimple

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    val items: Flow<PagingData<User>> = Pager (
        config = PagingConfig( pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource()
        }

    ).flow
        .cachedIn(viewModelScope)
}