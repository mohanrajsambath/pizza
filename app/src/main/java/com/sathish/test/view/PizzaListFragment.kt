package com.sathish.test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mypratice.test.databinding.FragmentPizzalistBinding
import com.sathish.test.view.adapter.PizzaItemRecyclerViewAdapter
import com.sathish.test.viewmodel.PizzasListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-04-2020
 * File Name : PizzaListFragment.kt
 * ClassName : PizzaListFragment
 * Module Name : app
 * Desc : 
 */

class PizzaListFragment : Fragment() {
    private lateinit var binding: FragmentPizzalistBinding
    private val pizzaViewModel: PizzasListViewModel by viewModel()
    private val pizzaAdapter: PizzaItemRecyclerViewAdapter = PizzaItemRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPizzalistBinding.inflate(inflater,container,false)
        binding.viewModel = pizzaViewModel
        binding.adapter = pizzaAdapter
        setUpViewModelObserver()
        return binding.root
    }


    private fun setUpViewModelObserver() {

        // adds the new set of results to the adapter list
        pizzaViewModel.pizzaData().observe(viewLifecycleOwner, Observer {
            pizzaAdapter.update(it)
        })

        /**
         * displaying error status from viewModel communicate via Observer
         * display the error message
         */
        pizzaViewModel.errorMessage.observe(
            viewLifecycleOwner,
            Observer {
                Toast.makeText(this.requireActivity(), it, Toast.LENGTH_SHORT).show()
            }
        )
    }

}