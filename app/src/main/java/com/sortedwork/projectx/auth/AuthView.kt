package com.sortedwork.projectx.auth

import com.sortedwork.projectx.base.BaseView

/**
 * Created by Alok Omkar on 2018-03-31.
 */
interface AuthView : BaseView {
    fun onSuccess( authType : String )
    fun onAuthUser( userEmail : String )
}