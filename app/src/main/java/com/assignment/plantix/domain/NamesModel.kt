package com.assignment.plantix.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NamesModel(
    @SerializedName("name") @Expose var name: String? = null,
    @SerializedName("email") @Expose var email: String? = null) {
}