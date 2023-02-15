package com.example.flashcard

import android.os.Parcel
import android.os.Parcelable

class Question(firstNum: Int, secondNum: Int, operator: String) : Parcelable {

    var num1 = firstNum
    var num2 = secondNum
    var op = operator

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString()
    )

    fun calcOutput(): Int {
        return if(op=="+")
            num1+num2
        else
            num1-num2
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(num1)
        parcel.writeInt(num2)
        parcel.writeString(op)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }


}