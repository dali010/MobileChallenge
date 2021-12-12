package dali.hmida.mobilechallenge.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Urls (
    val raw: String,
    val full: String,
    val regular: String,
    val thumb: String,
):Parcelable