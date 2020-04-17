package com.dalcim.pizza

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun Context.showConfirmDialog(
    title: String,
    message: String,
    confirm: String,
    confirmAction: () -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(confirm) { _, _ -> confirmAction() }
        .create()
        .show()
}