package com.sortedwork.projectx.base.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alok Omkar on 2018-03-31.
 */
class Project(
        var projectId: String = "",
        var projectName: String = "",
        var projectDescription: String = "",
        var organisationId: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(projectId)
        writeString(projectName)
        writeString(projectDescription)
        writeString(organisationId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Project> = object : Parcelable.Creator<Project> {
            override fun createFromParcel(source: Parcel): Project = Project(source)
            override fun newArray(size: Int): Array<Project?> = arrayOfNulls(size)
        }
    }
}
