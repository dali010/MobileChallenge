package dali.hmida.mobilechallenge

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dali.hmida.mobilechallenge.adapters.PictureAdapter
import dali.hmida.mobilechallenge.adapters.StoryAdapter
import dali.hmida.mobilechallenge.databinding.FragmentHomeBinding
import dali.hmida.mobilechallenge.models.Picture
import dali.hmida.mobilechallenge.viewModel.AppViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var picturesAdapter: PictureAdapter
    private lateinit var storiesAdapter: StoryAdapter

    private val viewModel:AppViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        //Setting up pictures
        binding.rvPictures.layoutManager = GridLayoutManager(this.context,2)
        viewModel.picturesList.observe(viewLifecycleOwner,{pictures ->
            picturesAdapter = PictureAdapter(this.requireContext(),pictures.toCollection(ArrayList<Picture>()))
            binding.rvPictures.adapter = picturesAdapter

            // Picture Details
            picturesAdapter.setOnClickListener(object : PictureAdapter.OnClickListener{
                override fun onClick(position: Int, model: Picture) {
                    val action = HomeFragmentDirections.actionHomeFragmentToPictureDetailsFragment(model)
                    Navigation.findNavController(binding.root)
                        .navigate(action)
                }
            })
        })


        //Setting up stories
        binding.rvStories.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL,false)
        viewModel.picturesList.observe(viewLifecycleOwner,{pictures ->
            storiesAdapter = StoryAdapter(this.requireContext(),pictures.toCollection(ArrayList<Picture>()))
            binding.rvStories.adapter = storiesAdapter
        })




        return binding.root

    }


}