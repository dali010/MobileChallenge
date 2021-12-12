package dali.hmida.mobilechallenge

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import dali.hmida.mobilechallenge.adapters.PictureAdapter
import dali.hmida.mobilechallenge.databinding.FragmentHomeBinding
import dali.hmida.mobilechallenge.models.Picture
import dali.hmida.mobilechallenge.viewModel.AppViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var picturesAdapter: PictureAdapter
    private val viewModel:AppViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.rvPictures.layoutManager = GridLayoutManager(this.context,2)
        viewModel.picturesList.observe(viewLifecycleOwner,{pictures ->
            picturesAdapter = PictureAdapter(this.requireContext(),pictures.toCollection(ArrayList<Picture>()))
            binding.rvPictures.adapter = picturesAdapter
        })

        return binding.root

    }


}