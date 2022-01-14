package com.jeanbernuy.cookpad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeanbernuy.cookpad.R
import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.data.DataSource
import com.jeanbernuy.cookpad.data.model.Collection
import com.jeanbernuy.cookpad.data.repository.CollectionDataRepository
import com.jeanbernuy.cookpad.databinding.FragmentMainBinding
import com.jeanbernuy.cookpad.ui.adapters.CollectionAdapter
import com.jeanbernuy.cookpad.ui.viewmodels.CollectionViewModel
import com.jeanbernuy.cookpad.ui.viewmodels.VMFactory

/**
 * A simple [Fragment] that contains a list of Collections.
 *
 * created by: Jean Bernuy.
 */
class MainFragment : Fragment(), CollectionAdapter.OnCollectionClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CollectionViewModel> {
        VMFactory(
            CollectionDataRepository(
                DataSource()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        viewModel.fetchAllDataCollections.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvCollections.adapter =
                        CollectionAdapter(requireContext(), result.data, this)
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), R.string.error_message, Toast.LENGTH_LONG)
                        .show()
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), R.string.error_message, Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    private fun setupViews() {
        binding.rvCollections.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCollections.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCollectionSelected(item: Collection) {
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(item)
        findNavController().navigate(action)
    }

}