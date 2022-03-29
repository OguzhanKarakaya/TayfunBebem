package com.example.tayfunbebem

import com.google.gson.annotations.SerializedName

data class ClothesModel(
    @SerializedName("clothesType") var kiyafetTipi: String? = "",
    @SerializedName("clothesPrice") var kiyafetFiyati: String? = "",
    @SerializedName("clothesDescription") var kiyafetAciklamasi: String? = "",
    @SerializedName("clothesLocation") var kiyafetLokasyonu: ClothesLocationModel? = null,
    @SerializedName("imageUrl") var imageUrl: String? = ""
)