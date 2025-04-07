package com.example.androidstudy.ui.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface PostsDao {

    @Query("SELECT * FROM postentity")
    suspend fun getAll(): List<PostEntity>?

    @Query("SELECT * FROM postentity WHERE id = :postId")
    suspend fun getById(postId: Long): PostEntity?

    @Insert
    suspend fun insert(postEntity: PostEntity?)

    @Update
    suspend fun update(postEntity: PostEntity?)

    @Delete
    suspend fun delete(postEntity: PostEntity?)
}