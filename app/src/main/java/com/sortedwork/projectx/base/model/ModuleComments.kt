package com.sortedwork.projectx.base.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alok Omkar on 2018-03-31.
 */
class ModuleComments(
        var commentId: String = "",
        var parentId: String = "",
        var commentType: String = "",
        var comments : String = "",
        var commentImage: String = "",
        var senderId: String = "",
        var taggedUsers: ArrayList<String> = ArrayList()
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(commentId)
        writeString(parentId)
        writeString(commentType)
        writeString(comments)
        writeString(commentImage)
        writeString(senderId)
        writeStringList(taggedUsers)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ModuleComments

        if (commentId != other.commentId) return false
        if (parentId != other.parentId) return false
        if (senderId != other.senderId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = commentId.hashCode()
        result = 31 * result + parentId.hashCode()
        result = 31 * result + senderId.hashCode()
        return result
    }


    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ModuleComments> = object : Parcelable.Creator<ModuleComments> {
            override fun createFromParcel(source: Parcel): ModuleComments = ModuleComments(source)
            override fun newArray(size: Int): Array<ModuleComments?> = arrayOfNulls(size)
        }
    }


}