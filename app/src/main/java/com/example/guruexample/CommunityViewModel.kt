package com.example.guruexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.guruexample.Room.Community

class CommunityViewModel (application: Application): AndroidViewModel(application) {
    private val repository = CommunityRepository(application)
    private val communities = repository.getAll()

    fun getAll(): LiveData<List<Community>> {
        return this.communities
    }

    fun insert(community: Community) {
        repository.insert(community)
    }

    fun delete(community: Community) {
        repository.delete(community)
    }
}