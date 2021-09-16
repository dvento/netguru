package com.netguru.codereview.ui.model

import com.netguru.codereview.network.model.ShopListItemResponse

class ShopList(
    val id: String,
    val userId: Int,
    val listName: String,
    val iconUrl: String,
    val items: List<ShopListItemResponse>
)
