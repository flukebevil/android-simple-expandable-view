package com.example.sarawootpokkam.expandebleview

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout

class TWSExpandableView : LinearLayout {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setUpView()
    }

    private var isExpandable = false
    private lateinit var layoutParams: LinearLayout.LayoutParams

    private fun setUpView() {
        this.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        toggle(false)
    }

    fun makeToggle() {
        when (isExpandable) {
            true -> {
                isExpandable = false
                this.layoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
            }
            false -> {
                isExpandable = true
                this.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }
    }

    fun toggle(isExpandable: Boolean) {
        when (isExpandable) {
            true -> {
                this@TWSExpandableView.isExpandable = true
                this.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
            false -> {
                this@TWSExpandableView.isExpandable = false
                this.layoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0)
            }
        }
    }

    fun isExpandable(): Boolean = isExpandable
}