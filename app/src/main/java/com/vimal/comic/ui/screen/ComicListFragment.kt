package com.vimal.comic.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.vimal.core.ui.BaseFragment
import com.vimal.core.utils.viewBinding
import com.vimal.comic.R
import com.vimal.comic.databinding.FragmentComicListBinding
import com.vimal.comic.ui.adapters.ComicListAdapter
import com.vimal.comic.viewmodels.ComicListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicListFragment : BaseFragment<ComicListViewModel>(R.layout.fragment_comic_list) {

    val binding by viewBinding(FragmentComicListBinding::bind)
    override val viewModel: ComicListViewModel by viewModels()
    var comicAdapter = ComicListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adapter =comicAdapter
        viewModel.comicList.observe(viewLifecycleOwner, {
            it?.let {
                comicAdapter.setItems(ArrayList(it))
            }
        })
    }
}