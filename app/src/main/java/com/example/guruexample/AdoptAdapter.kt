package com.example.guruexample

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdoptAdapter(private val context: Context) : RecyclerView.Adapter<AdoptAdapter.ViewHolder>() {

    var datas = mutableListOf<AdoptData>()

    interface OnItemClickListener {
        fun onItemClick(v: View, data: AdoptData, pos: Int)
    }

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_adopt_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = itemView.findViewById(R.id.tv_rv_name)
        private val txtAge: TextView = itemView.findViewById(R.id.tv_rv_age)
        private val txtInfo: TextView = itemView.findViewById(R.id.tv_rv_info)
        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)



        fun bind(item: AdoptData) {
            txtName.text = item.name
            txtAge.text = item.age.toString()
            txtInfo.text = item.info
            Glide.with(itemView).load(item.img).into(imgProfile)
            /*itemView.setOnClickListener {
                Intent(context, AdoptDetailActivity::class.java).apply {
                    putExtra("data", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }*/
            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,item,pos)
                }
            }
        }
    }
}


