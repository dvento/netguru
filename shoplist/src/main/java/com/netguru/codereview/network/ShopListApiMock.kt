package com.netguru.codereview.network

import com.netguru.codereview.network.model.ShopListItemResponse
import com.netguru.codereview.network.model.ShopListResponse
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ShopListApiMock : ShopListApi {
    object ShopListCons {
        const val listSize = 9999
        const val listItemSize = 5
        const val updateDelay = 5000L
    }
    override suspend fun getShopLists(): List<ShopListResponse> =
        coroutineScope {
            List(ShopListCons.listSize) { index ->
                ShopListResponse(
                    listId = index.toString(),
                    userId = index,
                    listName = "ListName$index"
                )
            }
        }

    override suspend fun getShopListItems(listId: String): List<ShopListItemResponse> =
        coroutineScope {
            Thread.sleep(2)
            List(ShopListCons.listItemSize) { index ->
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
            delay(ShopListCons.updateDelay)
            emit("Update $counter")
        }
    }
}
