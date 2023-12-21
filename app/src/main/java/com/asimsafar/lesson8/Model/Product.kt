package com.asimsafar.lesson8.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(val name: String,
                    val code : String,
                    val desc: String) : Parcelable {
}