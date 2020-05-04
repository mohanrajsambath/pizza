package com.sathish.test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mypratice.test.databinding.FragmentIngredientlistBinding
import com.sathish.test.view.adapter.IngredientItemRecyclerViewAdapter
import com.sathish.test.view.adapter.setImageUrl
import com.sathish.test.viewmodel.IngredientViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :25-04-2020
 * File Name : IngredientListFragment.kt
 * ClassName : IngredientListFragment
 * Module Name : app
 * Desc :
 */

class IngredientListFragment : Fragment() {

    private lateinit var binding: FragmentIngredientlistBinding
    private val ingredientViewModel: IngredientViewModel by viewModel()
    private val ingredientAdapter: IngredientItemRecyclerViewAdapter =
        IngredientItemRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIngredientlistBinding.inflate(inflater, container, false)
        binding.viewModel = ingredientViewModel
        binding.adapter = ingredientAdapter
        setUpViewModelObserver()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarOrderDescription.title = arguments!!.getString("name")
        setImageUrl(view = binding.imgVwContentItems, imageURL = arguments!!.getString("image"))

    }

    private fun setUpViewModelObserver() {

        val ingredientId = arguments!!.getIntegerArrayList("id")

        // Set value to viewmodel
        ingredientViewModel.loadIngredientData(ingredientId as List<Int>)



        // adds the new set of results to the adapter list
        ingredientViewModel.ingredientData().observe(viewLifecycleOwner, Observer {
            ingredientAdapter.update(it)
        })

        /**
         * displaying error status from viewModel communicate via Observer
         * display the error message
         */
        ingredientViewModel.errorMessage.observe(
            viewLifecycleOwner,
            Observer {
                Toast.makeText(this.requireActivity(), it, Toast.LENGTH_SHORT).show()
            }
        )

    }

}