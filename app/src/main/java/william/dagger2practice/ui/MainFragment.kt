package william.dagger2practice.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import william.dagger2practice.R
import william.dagger2practice.Volley.APIController
import william.dagger2practice.databinding.MainFragmentBinding
import william.dagger2practice.databinding.MainRepoItemBinding
import william.dagger2practice.di.Injectable
import william.dagger2practice.utils.ext.observe
import javax.inject.Inject

/**
 * Created by fangru.wu on 2018/02/08.
 */
class MainFragment : Fragment(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var userViewModel: UserViewModel

    @Inject
    lateinit var apiController: APIController


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private val adapter = MainAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(MainViewModel::class.java)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)


        viewModel.repos.observe(this) {
            it ?: return@observe
            adapter.run {
                items.clear()
                items.addAll(it)
                notifyDataSetChanged()
            }
        }
        userViewModel.loginUserId.observe(this) {
            viewModel.ownerId.value = it
        }


    }

    companion object {
        fun newInstance() = MainFragment()
    }
}

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    val items = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(DataBindingUtil.inflate<MainRepoItemBinding>(
                LayoutInflater.from(parent.context), R.layout.main_repo_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.binding.repo = items[position]
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(val binding: MainRepoItemBinding) : RecyclerView.ViewHolder(binding.root)
}