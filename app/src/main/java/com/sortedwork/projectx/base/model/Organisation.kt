package com.sortedwork.projectx.base.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alok Omkar on 2018-03-31.
 */
class Organisation(
        var organisationId: String = "",
        var organisationName: String = "",
        var organisationPhoto: String = "",
        var members: ArrayList<Role> = ArrayList()
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.createTypedArrayList(Role.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(organisationId)
        writeString(organisationName)
        writeString(organisationPhoto)
        writeTypedList(members)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Organisation> = object : Parcelable.Creator<Organisation> {
            override fun createFromParcel(source: Parcel): Organisation = Organisation(source)
            override fun newArray(size: Int): Array<Organisation?> = arrayOfNulls(size)
        }
    }
}