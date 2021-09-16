package com.netguru.codereview.network

import com.netguru.codereview.network.model.ShopListItemResponse
import com.netguru.codereview.network.model.ShopListResponse
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ShopListApiMock : ShopListApi {
    override suspend fun getShopLists(): List<ShopListResponse> =
        coroutineScope {
            List(9999) { index ->
                ShopListResponse(
                    list_id = index.toString(),
                    userId = index,
                    listName = "ListName$index"
                )
            }
        }

    override suspend fun getShopListItems(listId: String): List<ShopListItemResponse> =
        coroutineScope {
            Thread.sleep(2)
            List(5) { index ->
                ShopListItemResponse(
                    itemId = index.toString(),
                    name = "Name$index",
                    quantity = 2.0
                )
            }
        }

    override fun getUpdateEvents(): Flow<String> = flow {
        var counter = 0
        while (true) {
            counter++
            delay(5000)
            emit("Update $counter")
        }
    }
}
