package com.jeanbernuy.cookpad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jeanbernuy.cookpad.R
import com.jeanbernuy.cookpad.core.Resource
import com.jeanbernuy.cookpad.data.DataSource
import com.jeanbernuy.cookpad.data.repository.CollectionDataRepository
import com.jeanbernuy.cookpad.ui.viewmodels.CollectionViewModel
import com.jeanbernuy.cookpad.ui.viewmodels.VMFactory

/**
 * A simple [Fragment] subclass.
 *
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchAllDataCollections.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "${result.data}", Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Error on server...", Toast.LENGTH_LONG).show()
                }
                else -> {
                }
            }
        })
    }

}