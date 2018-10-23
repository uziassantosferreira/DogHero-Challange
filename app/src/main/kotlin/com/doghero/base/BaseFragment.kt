package com.doghero.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doghero.extension.inflate

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        container?.inflate(layoutId())

    @LayoutRes
    abstract fun layoutId(): Int

    fun setTitle(@StringRes title: Int) {
        getActionBar()?.setTitle(title)
    }

    fun getActionBar() = (activity as BaseActivity).supportActionBar
}