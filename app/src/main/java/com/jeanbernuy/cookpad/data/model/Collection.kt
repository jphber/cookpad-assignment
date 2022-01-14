package com.jeanbernuy.cookpad.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Collection(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("recipe_count") var recipeCount: Int? = null,
    @SerializedName("preview_image_urls") var previewImageUrls: ArrayList<String> = arrayListOf()

): Parcelable

@Parcelize
class Collections: ArrayList<Collection>(), Parcelable
