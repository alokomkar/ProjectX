package com.sortedwork.projectx.base.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alok Omkar on 2018-03-31.
 */
class User(
        var userId: String = "",
        var firstName: String = "",
        var lastName: String = "",
        var userPhoto: String = "",
        var userEmail: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(userId)
        writeString(firstName)
        writeString(lastName)
        writeString(userPhoto)
        writeString(userEmail)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (userId != other.userId) return false

        return true
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }


}