package dali.hmida.mobilechallenge.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileImage (
        val small: String,
        val medium: String,
        val large: String,
): Parcelable