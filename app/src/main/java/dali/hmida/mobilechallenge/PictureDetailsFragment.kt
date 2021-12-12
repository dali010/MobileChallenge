package dali.hmida.mobilechallenge

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import dali.hmida.mobilechallenge.databinding.FragmentHomeBinding
import dali.hmida.mobilechallenge.databinding.FragmentPictureDetailsBinding


class PictureDetailsFragment : Fragment() {

    private var _binding: FragmentPictureDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<PictureDetailsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPictureDetailsBinding.inflate(inflater,container,false)

        val picture = args.picture
        Log.i("www","${picture.user.username}")
        return binding.root
    }

}