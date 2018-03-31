package com.sortedwork.projectx.base

/**
 * Created by Alok Omkar on 2018-03-31.
 */
interface BaseView {
    fun showProgress( message : Int )
    fun hideProgress()
    fun onError( message: Int )
}