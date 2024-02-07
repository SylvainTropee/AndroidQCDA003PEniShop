package com.example.enishop.ui.articlelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enishop.databinding.FragmentListeArticleBinding


class ListeArticleFragment : Fragment() {

    lateinit var binding: FragmentListeArticleBinding
    val vm: ListArticleViewModel by viewModels { ListArticleViewModel.Factory }

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
        //vm = ViewModelProvider(requireActivity())[ListArticleViewModel::class.java]
        //vm = ViewModelProvider(this)[ListArticleViewModel::class.java]
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getArticleList()
        vm.articles.observe(viewLifecycleOwner) { articles ->

            val adapter = ArticleAdapter(articles){
                val direction =
                    ListeArticleFragmentDirections.actionListToDetailArticle(it)
                Navigation.findNavController(view).navigate(direction)
            }

            binding.recycler.adapter = adapter
            binding.recycler.layoutManager = LinearLayoutManager(context)
        }

        binding.btnFav.setOnClickListener {
            vm.getArticlesFav()
        }
    }
}