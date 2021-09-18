package com.netguru.codereview.network

import com.netguru.codereview.network.model.ShopListItemResponse
import com.netguru.codereview.network.model.ShopListResponse
import kotlinx.coroutines.flow.Flow

interface ShopListApi {
    suspend fun getShopLists(): List<ShopListResponse>
    suspend fun getShopListItems(listId: String): List<ShopListItemResponse>
    fun getUpdateEvents(): Flow<String>
}
