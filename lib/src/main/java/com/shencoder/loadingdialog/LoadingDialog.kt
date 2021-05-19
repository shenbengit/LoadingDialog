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
class LoadingDialog private constructor(
    builder: Builder
) : Dialog(builder.context, builder.themeResId) {

    private val mTvHint: TextView

    companion object {

        @JvmStatic
        fun builder(context: Context) = Builder(context)

        @JvmStatic
        fun builder(context: Context, @StyleRes themeResId: Int) = Builder(context, themeResId)

        /**
         * 创建默认配置的[LoadingDialog]
         */
        @JvmStatic
        fun createDefault(context: Context) = builder(context).create()

        /**
         * 创建默认配置的[LoadingDialog]
         */
        @JvmStatic
        fun createDefault(context: Context, @StyleRes themeResId: Int) =
            builder(context, themeResId).create()
    }

    init {
        setContentView(R.layout.dialog_loading)
        setCancelable(builder.mCancelable)
        setCanceledOnTouchOutside(builder.mTouchOutsideCancelable)
        mTvHint = findViewById(R.id.tvHint)
        setHintText(builder.mHintText)
        showHintText(builder.isShowHintText)
    }

    /**
     * 动态设置提示文字
     */
    fun setHintText(text: String) {
        mTvHint.text = text
    }

    fun showHintText(isShow: Boolean) {
        mTvHint.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    class Builder @JvmOverloads internal constructor(
        internal val context: Context,
        @StyleRes internal val themeResId: Int = R.style.LoadingDialog
    ) {
        private companion object {
            private const val DEFAULT_HINT_TEXT = "请稍后..."
        }

        /**
         * @see [Dialog.setCancelable]
         */
        internal var mCancelable = false
        fun setCancelable(cancelable: Boolean) = apply { this.mCancelable = cancelable }

        /**
         * @see [Dialog.setCanceledOnTouchOutside]
         */
        internal var mTouchOutsideCancelable = false
        fun setCanceledOnTouchOutside(cancelable: Boolean) =
            apply { this.mTouchOutsideCancelable = cancelable }

        /**
         * 是否显示提示性文字
         */
        internal var isShowHintText = true
        fun showHintText(isShow: Boolean) = apply { this.isShowHintText = isShow }

        /**
         * 设置显示的提示性文字内容
         */
        internal var mHintText = DEFAULT_HINT_TEXT
        fun setHintText(text: String) = apply { this.mHintText = text }

        /**
         * 创建[LoadingDialog]
         */
        fun create() = LoadingDialog(this)
    }
}