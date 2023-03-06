package com.example.taskwithroomdb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class Note(
    // room now 'll automatically generate column for these fields


    @PrimaryKey(autoGenerate = true) val id:Int =0,           // to distinguish one note from another

    @ColumnInfo(name = "title") val noteTitle:String,
    @ColumnInfo(name = "description") val noteDescription: String,
    @ColumnInfo(name = "timestamp") val timeStamp:String,
):Parcelable
