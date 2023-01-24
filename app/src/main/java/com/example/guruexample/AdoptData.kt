package com.example.guruexample

import android.os.Parcel
import android.os.Parcelable

data class AdoptData (
    val name : String,
    val age : Int,
    val img : Int,
    val info : String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeInt(img)
        parcel.writeString(info)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AdoptData> {
        override fun createFromParcel(parcel: Parcel): AdoptData {
            return AdoptData(parcel)
        }

        override fun newArray(size: Int): Array<AdoptData?> {
            return arrayOfNulls(size)
        }
    }
}