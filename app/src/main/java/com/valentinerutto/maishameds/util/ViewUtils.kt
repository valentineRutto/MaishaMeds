package com.valentinerutto.maishameds.util

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Activity.makeAlertDialog(message: String, title: String): AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(true)
        .setPositiveButton("OK", null)

    return builder.create()
}

fun Activity.makeProgressDialog(message: String, context: Context): ProgressDialog {
    val progressDialog = ProgressDialog(context)
    progressDialog.setMessage(message)
    progressDialog.setCancelable(false)
    return progressDialog
}
