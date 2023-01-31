package com.example.guruexample.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CommunityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(community: Community)

    @Query("SELECT * FROM community")
    fun getAll(): LiveData<List<Community>>

    @Query("SELECT * FROM community WHERE _id IN (:communityIds)")
    fun loadAllByIds(communityIds: IntArray): List<Community>

    @Query("SELECT * FROM community WHERE title LIKE :title AND " +
            "content LIKE :content LIMIT 1")
    fun findByTitle_content(title: String, content: String): Community

    @Insert
    fun insertAll(vararg communities: Community)

    @Delete
    fun delete(community: Community)
}