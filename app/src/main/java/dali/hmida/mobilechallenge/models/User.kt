package dali.hmida.mobilechallenge.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val idUser : String?,
    val username : String?,
    val name : String?,
    val profile_image : ProfileImage,
    val TotalPhotos : String?,
    val collection : String?
): Parcelable