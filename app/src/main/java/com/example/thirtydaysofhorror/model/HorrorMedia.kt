package com.example.thirtydaysofhorror.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HorrorMedia(
    @StringRes val titleStringId: Int,
    @DrawableRes val imageResId: Int,
    @StringRes val descriptionStringId: Int
)