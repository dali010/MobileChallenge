package dali.hmida.mobilechallenge

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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

        Glide.with(this.requireContext())
            .load(picture.urls.regular)
            .centerCrop()
            .placeholder(ColorDrawable(Color.parseColor(picture.color)))
            .into(binding.imageDetails)

        Glide.with(this.requireContext())
            .load(picture.user.profile_image.medium)
            .centerCrop()
            .placeholder(ColorDrawable(Color.parseColor(picture.color)))
            .into(binding.logoDetails)

        binding.tvShortDescription.text = picture.description.toString()
        binding.tvCreatedAtDetail.text= picture.created_at.toString()
        binding.tvUpdateAtDetail.text = picture.updated_at.toString()


        Log.i("www","${picture.user.username}")
        return binding.root
    }

}