package dali.hmida.mobilechallenge.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Picture(
    val id: String?,
    val width: String?,
    val height: String?,
    val color: String?,
    val created_at: String?,
    val updated_at: String?,
    val description: String?,
    val urls: Urls,
    val user: User,
    val likes: String?,
    ):Parcelable


