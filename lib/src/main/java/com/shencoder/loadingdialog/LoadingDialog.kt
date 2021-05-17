package com.shencoder.loadingdialog

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.annotation.StyleRes

/**
 * 加载dialog
 *
 * @author  ShenBen
 * @date    2021/05/17 11:12
 * @email   714081644@qq.com
 */
class LoadingDialog(
    builder: Builder
) : Dialog(builder.context, builder.themeResId) {

    private val mTvHint: TextView

    companion object {
        /**
         * 创建默认配置的[LoadingDialog]
         */
        fun createDefault(context: Context) = Builder(context).create()
    }

    init {
        setContentView(R.layout.dialog_loading)
        setCancelable(builder.mCancelable)
        setCanceledOnTouchOutside(builder.mTouchOutsideCancelable)
        mTvHint = findViewById(R.id.tvHint)
        mTvHint.text = builder.mHintText
        mTvHint.visibility = if (builder.isShowHintText) View.VISIBLE else View.GONE
    }

    class Builder @JvmOverloads constructor(
        internal val context: Context,
        @StyleRes internal val themeResId: Int = R.style.LoadingDialog
    ) {
        private companion object {
            private const val DEFAULT_HINT_TEXT = "请稍后..."
        }

        internal var mCancelable = false
        fun setCancelable(cancelable: Boolean) = apply { this.mCancelable = cancelable }

        internal var mTouchOutsideCancelable = false
        fun setCanceledOnTouchOutside(cancelable: Boolean) =
            apply { this.mTouchOutsideCancelable = cancelable }

        internal var isShowHintText = true
        fun showHintText(isShow: Boolean) = apply { this.isShowHintText = isShow }

        internal var mHintText = DEFAULT_HINT_TEXT
        fun setHintText(text: String) = apply { this.mHintText = text }

        /**
         * 创建[LoadingDialog]
         */
        fun create() = LoadingDialog(this)
    }
}