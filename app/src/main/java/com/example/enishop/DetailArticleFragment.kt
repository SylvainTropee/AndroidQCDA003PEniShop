package com.example.enishop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.enishop.databinding.FragmentDetailArticleBinding


class DetailArticleFragment : Fragment() {

    lateinit var binding: FragmentDetailArticleBinding
    val args by navArgs<DetailArticleFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailArticleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //associe l'argument passé à la variable dans la vue
        binding.article = args.article
    }














}