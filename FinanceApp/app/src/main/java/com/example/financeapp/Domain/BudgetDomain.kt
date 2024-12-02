package com.example.financeapp.Domain

import android.os.Parcel
import android.os.Parcelable

data class BudgetDomain(
    var title :String ="",
    var price :Double =0.0,
    var  percent : Double =0.0
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeDouble(price)
        parcel.writeDouble(percent)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BudgetDomain> {
        override fun createFromParcel(parcel: Parcel): BudgetDomain {
            return BudgetDomain(parcel)
        }

        override fun newArray(size: Int): Array<BudgetDomain?> {
            return arrayOfNulls(size)
        }
    }
}
