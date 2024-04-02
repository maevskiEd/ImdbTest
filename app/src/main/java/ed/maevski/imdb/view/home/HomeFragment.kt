package ed.maevski.imdb.view.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import ed.maevski.ImdbTest.R
import ed.maevski.ImdbTest.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeFragment : Fragment(),  HasAndroidInjector {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeFragmentViewModel: HomeViewModel

    @Inject
    lateinit var vmFactory: HomeViewModel.Factory

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        homeFragmentViewModel =
            ViewModelProvider(this, vmFactory)[HomeViewModel::class.java]

        val adapter = MoviesRecyclerAdapter() { imdbid ->

            // Обработка клика на элементе списка
            println("HomeFragment: movie id $imdbid")


            if (imdbid != null) {
                findNavController().navigate(
                    R.id.action_homeFragment_to_detailsFragment,
                    Bundle().apply {
                        putString("imdbid", imdbid)
                    })
            } else {
                println("HomeFragment: id = null")
            }
        }

        binding.mainRecycler.adapter = adapter
        binding.mainRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        viewLifecycleOwner.lifecycleScope.launch {
            homeFragmentViewModel.movieListFlow.collect {
                withContext(Dispatchers.Main) {
                    adapter.setData(it)
//                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

//    private fun initPullToRefresh() {
//        //Вешаем слушатель, чтобы вызвался pull to refresh
////        binding.pullToRefresh.setOnRefreshListener {
////            //Чистим адаптер(items нужно будет сделать паблик или создать для этого публичный метод)
//////            adapter.items.
/////*            filmsAdapter.items.clear()*/
////            //Делаем новый запрос фильмов на сервер
////            homeFragmentViewModel.getDeviantArts()
////            //Убираем крутящееся колечко
////            binding.pullToRefresh.isRefreshing = false
////        }
//    }
}