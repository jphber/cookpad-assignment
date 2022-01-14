package com.jeanbernuy.cookpad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jeanbernuy.cookpad.R
import com.jeanbernuy.cookpad.databinding.FragmentDetailBinding
import com.jeanbernuy.cookpad.databinding.FragmentMainBinding

/**
 * A simple [Fragment] contains Collection Detail.
 *
 * created by: Jean Bernuy
 */
class CollectionDetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: CollectionDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context,args.itemCollection.title,Toast.LENGTH_LONG).show()
    }

}