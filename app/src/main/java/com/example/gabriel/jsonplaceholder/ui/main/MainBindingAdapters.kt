package com.example.gabriel.jsonplaceholder.ui.main

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("initials")
fun bindUserInitials(textView: TextView, name: String) {
    val firstLetter = name.first()
    val space = name.lastIndexOf(" ")
    val lastName = name.substring(space + 1)
    val lastLetter = lastName.first()
    val sb = StringBuilder()
    val initials = sb.append(firstLetter).append(lastLetter)

    textView.text = initials
}