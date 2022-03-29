package com.example.tayfunbebem

import com.google.gson.annotations.SerializedName

data class ClothesLocationModel(
    @SerializedName("shopName") var shopName: String? = "",
    @SerializedName("shopMallName") var shopMallName: String? = ""
) {
    fun setShopLocation() : String {
        return "$shopName - $shopMallName"
    }
}
