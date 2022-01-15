package com.jeanbernuy.cookpad.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jeanbernuy.cookpad.R
import com.jeanbernuy.cookpad.databinding.FragmentDetailBinding

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
        setupCollectionDetail()
    }

    private fun setupCollectionDetail() = with(binding) {
        val itemImage =
            if (args.itemCollection.previewImageUrls.size > 0) args.itemCollection.previewImageUrls[0] else ""
        Glide.with(requireContext()).load(itemImage).centerCrop()
            .placeholder(R.drawable.cookpad_logo).into(ivCollectionPhoto)
        tvCollectionName.text = args.itemCollection.title
        tvCollectionDescription.text = args.itemCollection.description
        tvTotalRecipes.text = args.itemCollection.recipeCount.toString()
    }
}