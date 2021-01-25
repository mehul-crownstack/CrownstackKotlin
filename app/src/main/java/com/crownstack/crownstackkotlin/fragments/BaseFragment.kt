package com.crownstack.crownstackkotlin.fragments

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.crownstack.crownstackkotlin.R

open class BaseFragment : Fragment() {

    protected lateinit var mContentView: View
    protected lateinit var mNavController: NavController
    private lateinit var mProgressDialog: Dialog

    protected fun showProgressDialog(context: Context?) {
        activity?.runOnUiThread {
            context?.run {
                mProgressDialog = Dialog(this)
                val inflate = LayoutInflater.from(this).inflate(R.layout.progress_dialog, null)
                mProgressDialog.setContentView(inflate)
                mProgressDialog.setCancelable(false)
                mProgressDialog.window!!.setBackgroundDrawable(
                    ColorDrawable(Color.TRANSPARENT)
                )
                mProgressDialog.show()
            }
        }
    }

    protected fun stopProgress() {
        activity?.runOnUiThread { mProgressDialog.run { mProgressDialog.dismiss() } }
    }

    fun showToast(message:String = "sample testing") {
        activity?.runOnUiThread { Toast.makeText(activity, message, Toast.LENGTH_SHORT).show() }
    }

}