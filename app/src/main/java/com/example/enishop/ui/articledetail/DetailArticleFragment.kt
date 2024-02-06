package com.example.enishop.ui.articledetail

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
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

        binding.tvArticleTitle.setOnClickListener {
            val article = binding.article
//            Intent(Intent.ACTION_WEB_SEARCH).also {
//                it.putExtra(SearchManager.QUERY, "eni-shop " + article?.title)
//                startActivity(it)
//            }
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/search?q=eni-shop " + article?.title)
            ).also {
                startActivity(it)
            }

        }

    }

}