package com.example.guruexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.community_main_fragment.*

class CommunityFragment : Fragment() {

    private lateinit var viewModel: CommunityViewModel

    companion object {
        fun newInstance() = CommunityFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.community_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val recyclerView = MainFragment_RecyclerView_view

        viewModel = ViewModelProvider(this).get(CommunityViewModel::class.java)
        viewModel.getAll().observe(this.viewLifecycleOwner, Observer { community ->
            recyclerView.adapter=MainCommunityAdapter(community)
        })
    }

}