package com.srl.mob.mcomic.frgments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.srl.mob.mcomic.R
import com.srl.mob.mcomic.adapters.ComicListAdapter
import com.srl.mob.mcomic.adapters.ItemClickCallBack
import com.srl.mob.mcomic.databinding.FragmentComicListBinding
import com.srl.mob.mcomic.di.Injectable
import com.srl.mob.mcomic.model.Comic
import com.srl.mob.mcomic.viewModel.ComicListViewModel
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ComicListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ComicListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ComicListFragment :Fragment(),Injectable,ItemClickCallBack<Comic>
{
    override fun onClick(item: Comic) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var binding: FragmentComicListBinding
    var comicAdapter: ComicListAdapter? = null


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comic_list, container, false)
        comicAdapter = ComicListAdapter(callBack = this)
        binding.list.adapter = comicAdapter
        binding.isLoading = true
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel:ComicListViewModel=ViewModelProviders.of(this,viewModelFactory).get(ComicListViewModel::class.java)
        observeViewModel(viewModel)
    }

    fun observeViewModel(viewModel: ComicListViewModel)
    {
        viewModel.getComicListObservable().observe(this,object:Observer<List<Comic>>{
            override fun onChanged(comics: List<Comic>?) {
                if(comics!=null)
                {
                    binding.isLoading=false
                    comicAdapter?.setItems(ArrayList(comics))
                }
            }
        })
    }

    companion object
    {

        @JvmStatic
        fun newInstance() =
                ComicListFragment().apply {
                    arguments = Bundle().apply {
                        //Add extras if need
                    }
                }
    }
}
