package com.example.uts
import android.os.Parcel
import android.os.Parcelable

data class

ItemData(val imageFlora: Int, val name: String, val description: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageFlora)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ItemData> {
        override fun createFromParcel(parcel: Parcel): ItemData = ItemData(parcel)
        override fun newArray(size: Int): Array<ItemData?> = arrayOfNulls(size)
    }
}
