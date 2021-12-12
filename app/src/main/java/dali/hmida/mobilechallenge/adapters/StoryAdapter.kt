package dali.hmida.mobilechallenge.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dali.hmida.mobilechallenge.databinding.PictureItemBinding
import dali.hmida.mobilechallenge.databinding.StoryItemBinding
import dali.hmida.mobilechallenge.models.Picture


open class StoryAdapter(
    private val context: Context,
    private var list: ArrayList<Picture>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onClickListener : OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            StoryItemBinding.inflate(
                LayoutInflater.from(context),parent,
                false)
        )
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (holder is MyViewHolder) {

            Glide.with(context)
                .load(model.user.profile_image.large)
                .centerCrop()
                .placeholder(ColorDrawable(Color.parseColor(model.color)))
                .into(holder.binding.story)

        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    interface OnClickListener{
        fun onClick(position: Int, model: Picture)
    }

    private class MyViewHolder(binding: StoryItemBinding) : RecyclerView.ViewHolder(binding.root){
        var binding = binding
    }
}
