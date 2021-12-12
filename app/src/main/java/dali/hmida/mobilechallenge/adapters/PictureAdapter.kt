package dali.hmida.mobilechallenge.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dali.hmida.mobilechallenge.databinding.PictureItemBinding
import dali.hmida.mobilechallenge.models.Picture



open class PictureAdapter(
    private val context: Context,
    private var list: ArrayList<Picture>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onClickListener : OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            PictureItemBinding.inflate(
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
                .load(model.urls.regular)
                .placeholder(ColorDrawable(Color.parseColor(model.color)))
                .into(holder.binding.picture)

            holder.binding.picture.setOnClickListener{
                if(onClickListener != null){
                    onClickListener!!.onClick(position,model)
                }
            }

            holder.binding.root.setOnClickListener{
                if(onClickListener != null){
                    onClickListener!!.onClick(position,model)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    interface OnClickListener{
        fun onClick(position: Int, model: Picture)
    }

    private class MyViewHolder(binding: PictureItemBinding) : RecyclerView.ViewHolder(binding.root){
        var binding = binding
    }
}
