package com.netguru.codereview.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class ShopListResponse(
    val list_id: String,
    val userId: Int,
    val listName: String
)
