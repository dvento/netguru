package com.netguru.codereview.network

class ShopListRepository(private val shopListApi: ShopListApi) {

    suspend fun getShopLists() = shopListApi.getShopLists()

    suspend fun getShopListItems(listId: String) = shopListApi.getShopListItems(listId)

    fun updateEvents() = shopListApi.getUpdateEvents()
}
