package com.example.codelab____coroutine

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query


@Entity
data class Title constructor(

                val title : String,
    @PrimaryKey val id : Int = 0
    )

@Dao
interface TitleDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertTitle (title: Title)

    @get:Query ("select * from Title where id = 0")
    val titleLiveData : LiveData<Title?>
}