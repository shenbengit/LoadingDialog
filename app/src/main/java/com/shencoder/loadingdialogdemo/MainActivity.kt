package com.shencoder.loadingdialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import com.shencoder.loadingdialog.LoadingDialog

class MainActivity : AppCompatActivity() {
    private val loadingDialog by lazy { LoadingDialog.createDefault(this) }

    private val mHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnShow).setOnClickListener {
            loadingDialog.show()
            mHandler.postDelayed({ loadingDialog.dismiss() }, 3000L)
        }

    }
}