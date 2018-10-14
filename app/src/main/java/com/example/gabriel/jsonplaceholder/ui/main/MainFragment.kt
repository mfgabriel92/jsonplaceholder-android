package com.example.gabriel.jsonplaceholder.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User
import com.example.gabriel.jsonplaceholder.databinding.FragmentMainBinding
import com.example.gabriel.jsonplaceholder.ui.main.viewmodel.MainViewModel
import com.example.gabriel.jsonplaceholder.ui.main.viewmodel.MainViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    @Inject lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        adapter = MainAdapter(binding.root.context)

        binding.rvMainActivity.adapter = adapter

        populateUi()

        return binding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    private fun populateUi() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.fetchAllUsers()
        viewModel.loading().observe(this, Observer<Boolean> {
            if (it == false) {
                pb_loading_users.visibility = View.GONE
            }
        })

        viewModel.result().observe(this, Observer<List<User>> {
            if (it != null) {
                adapter.submitList(it)
            }
        })

        viewModel.error().observe(this, Observer<String> {
            if (it != null) {
                Toast.makeText(binding.root.context, it, Toast.LENGTH_LONG).show()
            }
        })
    }
}
