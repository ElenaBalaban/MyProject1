package com.example.myproject1

import android.widget.ImageView
import coil.load
import coil.request.Disposable
import java.util.*


fun numberFormat(number: Long): String {
    return java.lang.String.format(Locale.FRANCE, "%,d", number)
}
fun loadPng (imageView: ImageView, url: String): Disposable {
    return imageView.load(url)
}
