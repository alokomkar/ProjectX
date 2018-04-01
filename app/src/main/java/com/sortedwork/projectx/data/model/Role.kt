package com.sortedwork.projectx.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alok Omkar on 2018-03-31.
 */
class Role(
        var userId: String = "",
        var roleId : String = "",
        var permissions: Int = 0
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(userId)
        writeString(roleId)
        writeInt(permissions)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Role

        if (userId != other.userId) return false
        if (roleId != other.roleId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userId.hashCode()
        result = 31 * result + roleId.hashCode()
        return result
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Role> = object : Parcelable.Creator<Role> {
            override fun createFromParcel(source: Parcel): Role = Role(source)
            override fun newArray(size: Int): Array<Role?> = arrayOfNulls(size)
        }
    }



}