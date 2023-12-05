package com.example.lb1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private var animals: List<Animal>, var context : Context) :
    RecyclerView.Adapter<AnimalAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_image)
        val name: TextView = view.findViewById(R.id.item_name)
        val desc: TextView = view.findViewById(R.id.item_desc)
        val btn: Button = view.findViewById<Button>(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return MyViewHolder(view) }

    override fun getItemCount(): Int {
        return animals.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = animals[position].name
        holder.desc.text = animals[position].description

        val imageId = context.resources.getIdentifier(
            animals[position].imageResId,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener{
            val intent = Intent(context, PageActivity2::class.java)
            intent.putExtra("item_name", animals[position].name)
            intent.putExtra("item_desc", animals[position].description)
            intent.putExtra("item_image", animals[position].imageResId)

            context.startActivity(intent)

        }

    }

}