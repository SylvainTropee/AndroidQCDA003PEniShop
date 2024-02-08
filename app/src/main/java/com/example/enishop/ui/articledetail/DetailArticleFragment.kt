package com.example.enishop.ui.articledetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.enishop.databinding.FragmentDetailArticleBinding
import com.squareup.picasso.Picasso


class DetailArticleFragment : Fragment() {

    lateinit var binding: FragmentDetailArticleBinding
    val args by navArgs<DetailArticleFragmentArgs>()
    val vm: DetailArticleViewModel by viewModels { DetailArticleViewModel.Factory }

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
        val currentArticle = args.article
        binding.article = currentArticle
        binding.vm = vm

        //affiche une image de manière asynchrone
        Picasso.get().load(currentArticle.urlPicture).into(binding.imageView)

        //permet automatiquement de mettre à jour la vue en cas de changement
        //uniquement dans les fragments équivalent à vm.fav.observe(){ binding.vm = vm }
        binding.lifecycleOwner = this
        vm.initCurrentArticle(currentArticle)

        binding.checkBox.setOnClickListener {
            if (binding.checkBox.isChecked) {
                vm.addArticleToFav(currentArticle).observe(viewLifecycleOwner) {
                    Toast.makeText(
                        view.context,
                        "L'article a bien ajouté à vos favoris !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                vm.deleteArticleFav(currentArticle)
            }
        }

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