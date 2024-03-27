package ed.maevski.imdb.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ed.maevski.ImdbTest.databinding.FragmentHomeBinding

class HomeFragment() : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

//    private lateinit var adapter: ArtRecyclerAdapter
//    private lateinit var scopeHomeFragment: CoroutineScope

    private val homeFragmentViewModel: HomeViewModel by viewModels()

/*    private var picturesDataBase = listOf<Item>()
        //Используем backing field
        set(value) {
            //Если придет такое же значение, то мы выходим из метода
            if (field == value) return
            //Если пришло другое значение, то кладем его в переменную
            field = value
            //Обновляем RV адаптер
            adapter.items = picturesDataBase
        }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

//        homeFragmentViewModel.getDeviantArts()
//        homeFragmentViewModel.picturesListData =
//            homeFragmentViewModel.interactor.getDeviantPicturesFromDBWithCategory()

/*        adapter = PictureRecyclerAdapter(object : PictureRecyclerAdapter.OnItemClickListener {
            override fun click(picture: DeviantPicture) {
                Toast.makeText(requireContext(), picture.title, Toast.LENGTH_SHORT).show()
                (requireActivity() as MainActivity).launchDetailsFragment(picture)
            }
        })*/


        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {}
            }
        )

        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }


        initPullToRefresh()
    }

    private fun initPullToRefresh() {
        //Вешаем слушатель, чтобы вызвался pull to refresh
//        binding.pullToRefresh.setOnRefreshListener {
//            //Чистим адаптер(items нужно будет сделать паблик или создать для этого публичный метод)
////            adapter.items.
///*            filmsAdapter.items.clear()*/
//            //Делаем новый запрос фильмов на сервер
//            homeFragmentViewModel.getDeviantArts()
//            //Убираем крутящееся колечко
//            binding.pullToRefresh.isRefreshing = false
//        }
    }

    override fun onStop() {
        super.onStop()
//        scopeHomeFragment.cancel()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        private const val POSITION_ONE = 1
    }
}