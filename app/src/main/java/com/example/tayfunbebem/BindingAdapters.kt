package com.example.tayfunbebem

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("app:changeTextFont")
    fun changeText(
        textView: TextView,
        text: String
    ) {
        if (!text.isNullOrBlank()) {
            textView.text = text
            textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }
}