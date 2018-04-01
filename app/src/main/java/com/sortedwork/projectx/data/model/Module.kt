package com.sortedwork.projectx.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alok Omkar on 2018-03-31.
 */
class Module(
        var moduleId: String = "",
        var projectId: String = "",
        var moduleName: String = "",
        var moduleDescription: String = "",
        var moduleImages : ArrayList<String> = ArrayList(),
        var assignees: ArrayList<String> = ArrayList()
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.createStringArrayList(),
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(moduleId)
        writeString(projectId)
        writeString(moduleName)
        writeString(moduleDescription)
        writeStringList(moduleImages)
        writeStringList(assignees)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Module> = object : Parcelable.Creator<Module> {
            override fun createFromParcel(source: Parcel): Module = Module(source)
            override fun newArray(size: Int): Array<Module?> = arrayOfNulls(size)
        }
    }
}