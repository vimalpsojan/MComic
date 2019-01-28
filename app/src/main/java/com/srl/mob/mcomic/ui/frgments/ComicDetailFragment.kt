package com.srl.mob.mcomic.ui.frgments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.srl.mob.mcomic.R
import com.srl.mob.mcomic.databinding.FragmentComicDetailBinding
import com.srl.mob.mcomic.model.Comic
import com.srl.mob.mcomic.viewmodel.ComicListViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ComicDetailFragment : Fragment() {

    lateinit var binding: FragmentComicDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comic_detail, container, false)
        binding.isLoading = false
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var viewModel: ComicListViewModel= ViewModelProviders.of(this,null).get(ComicListViewModel::class.java)
        viewModel.selectedComic.observe(this,object: Observer<Comic>{
            override fun onChanged(t: Comic?) {

            }
        })
    }


}
