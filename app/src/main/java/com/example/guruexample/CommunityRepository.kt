package com.example.guruexample

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.guruexample.Room.Community
import com.example.guruexample.Room.CommunityDatabase

class CommunityRepository (application: Application){

    private val database = CommunityDatabase.getInstance(application)!!
    private val communityDao = database.communityDao()
    private val communities: LiveData<List<Community>> = communityDao.getAll()

    fun getAll(): LiveData<List<Community>> {
        return communities
    }

    fun insert(community: Community) {
        try {
            val thread = Thread(Runnable {
                communityDao.insert(community) })
            thread.start()
        } catch (e: Exception) { }
    }

    fun delete(community: Community) {
        try {
            val thread = Thread(Runnable {
                communityDao.delete(community)
            })
            thread.start()
        } catch (e: Exception) { }
    }
}