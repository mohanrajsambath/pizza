package com.sathish.test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mypratice.test.databinding.FragmentDrinksBinding
import com.sathish.test.view.adapter.DrinkItemRecyclerViewAdapter
import com.sathish.test.viewmodel.DrinkViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :20-04-2020 
 * File Name : DrinksListFragment.kt
 * ClassName : DrinksListFragment
 * Module Name : app
 * Desc : 
 */

class DrinkListFragment : Fragment() {

    private lateinit var binding: FragmentDrinksBinding
    private val drinkViewModel: DrinkViewModel by viewModel()
    private val drinkAdapter: DrinkItemRecyclerViewAdapter = DrinkItemRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinksBinding.inflate(inflater,container,false)
        binding.viewModel = drinkViewModel
        binding.adapter = drinkAdapter
        loadData()
        setUpViewModelObserver()
        return binding.root
    }

    private fun loadData() = drinkViewModel.loadDrinksList()

    private fun setUpViewModelObserver() {
        drinkViewModel.drinkData().observe(viewLifecycleOwner, Observer {
            drinkAdapter.update(it)
        })

        drinkViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.requireActivity(), it, Toast.LENGTH_SHORT).show()
        })
    }

}