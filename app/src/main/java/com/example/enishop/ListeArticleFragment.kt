package com.example.enishop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.enishop.databinding.FragmentListeArticleBinding
import com.example.enishop.repository.ArticleRepository


class ListeArticleFragment : Fragment() {

    lateinit var binding: FragmentListeArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.fragment_liste_article,
//            container,
//            false
//        )
        binding = FragmentListeArticleBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articles = ArticleRepository.getAllArticles()

//        var content = ""
//        articles.forEach {article ->
//            content += "${article.title}\n"
//        }
//        binding.tvArticles.text = content

        articles.forEach {
            //création d'une instance de textview
            val tv = TextView(context)
            tv.text = it.title

            //j'ajoute l'instance dans le layout à utiliser
            binding.lytArticleList.addView(tv)
        }

        binding.buttonToDetail.setOnClickListener {
            val direction =
                ListeArticleFragmentDirections.actionListToDetailArticle(articles.random())
            Navigation.findNavController(view).navigate(direction)
        }

    }


}