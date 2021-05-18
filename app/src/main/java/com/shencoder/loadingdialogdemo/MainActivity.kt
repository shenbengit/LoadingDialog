package com.shencoder.loadingdialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import com.shencoder.loadingdialog.LoadingDialog

class MainActivity : AppCompatActivity() {
    private lateinit var loadingDialog: LoadingDialog

    private val mHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadingDialog = LoadingDialog.Builder(this, R.style.LoadingDialog)
            .setCancelable(false)
            .setCanceledOnTouchOutside(false)
            .setHintText("请稍后...")
            .showHintText(true)
            .create()
        findViewById<Button>(R.id.btnShow).setOnClickListener {
            loadingDialog.show()
            mHandler.postDelayed({ loadingDialog.dismiss() }, 3000L)
        }

    }
}