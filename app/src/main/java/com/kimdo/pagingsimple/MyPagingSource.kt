package com.kimdo.pagingsimple

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay


private const val STARTING_KEY = 1
class MyPagingSource : PagingSource<Int, User>(){

    init {
        Log.d("My", "init")
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {

        Log.d("My", "load")
        val page = params.key ?: STARTING_KEY

        val range = page.until( page + params.loadSize )

        if( page != STARTING_KEY ) {
            delay( 3000 )
        }

        return LoadResult.Page(
            data = range.map {number ->
                User (
                    id = number,
                    userName = "UserNumber is $number"
                )
            },
            prevKey = null,
            nextKey = range.last + 1
        )

    }



    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }


}