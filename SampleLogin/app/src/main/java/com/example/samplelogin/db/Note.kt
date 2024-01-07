package com.example.samplelogin.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @ColumnInfo(name = "title")
    val title : String,
    val note : String
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
