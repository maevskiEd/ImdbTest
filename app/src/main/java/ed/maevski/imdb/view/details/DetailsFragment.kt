package ed.maevski.imdb.view.details

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import ed.maevski.ImdbTest.R
import ed.maevski.ImdbTest.databinding.FragmentDetailsBinding
import ed.maevski.imdb.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailsFragment : Fragment(), HasAndroidInjector {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var detailsViewModel: DetailsViewModel

    @Inject
    lateinit var vmFactory: DetailsViewModel.Factory

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
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val imdbid = arguments?.getString("imdbid")

        detailsViewModel =
            ViewModelProvider(this, vmFactory)[DetailsViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            if (imdbid != null) {
                detailsViewModel.getMovieById(imdbid)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            detailsViewModel.selectedMovieFlow.collect {selectedMovie ->
                if (selectedMovie != null) {
                    withContext(Dispatchers.Main) {
                        setFilmsDetails(selectedMovie)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setFilmsDetails(selectedMovie: Movie) {
        val circularProgressDrawable = CircularProgressDrawable(requireContext())
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        binding.detailsToolbar.title = selectedMovie.title
        //Устанавливаем картинку
        Glide.with(this)
            .load(selectedMovie.poster)
            .placeholder(R.drawable.load)
            .centerCrop()
            .into(binding.detailsPoster)
        //Устанавливаем описание
        binding?.detailsDescription?.text = selectedMovie.description

//        binding?.detailsFabFavorites?.setImageResource(
//            if (film.isInFavorites) R.drawable.baseline_favorite
//            else R.drawable.baseline_favorite_border_24
//        )
    }

}