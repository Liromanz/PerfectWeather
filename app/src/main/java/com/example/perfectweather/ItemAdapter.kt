package com.example.perfectweather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter(
    private val context: Context,
    private val images: List<ItemOfList>,
    val listener: (ItemOfList) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ImageViewHolder>() {

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val typeWeatherText = view.findViewById<TextView>(R.id.typeWeatherText)
        val morSrc = view.findViewById<TextView>(R.id.morTime)
        val tempMorSrc = view.findViewById<TextView>(R.id.tempMorTime)
        val iconMorSrc = view.findViewById<ImageView>(R.id.iconMorTime)
        val daySrc = view.findViewById<TextView>(R.id.dayTime)
        val tempDaySrc = view.findViewById<TextView>(R.id.tempDayTime)
        val iconDaySrc = view.findViewById<ImageView>(R.id.iconDayTime)
        val eveSrc = view.findViewById<TextView>(R.id.eveTime)
        val tempEveSrc = view.findViewById<TextView>(R.id.tempEveTime)
        val iconEveSrc = view.findViewById<ImageView>(R.id.iconEveTime)
        val nigSrc = view.findViewById<TextView>(R.id.nigTime)
        val tempNigSrc = view.findViewById<TextView>(R.id.tempNigTime)
        val iconNigSrc = view.findViewById<ImageView>(R.id.iconNigTime)

        fun bindView(item: ItemOfList, listener: (ItemOfList) -> Unit) {
            typeWeatherText.text = item.infoWeather

            morSrc.text = item.infoPreview[PreviewInfo.FIRSTSECTION.ordinal]
            tempMorSrc.text = item.tempPreview[PreviewInfo.FIRSTSECTION.ordinal]
            Picasso.get().load("http://openweathermap.org/img/wn/${item.iconPreview[PreviewInfo.FIRSTSECTION.ordinal]}@2x.png").resize(35,35).centerCrop().into(iconMorSrc)
            daySrc.text = item.infoPreview[PreviewInfo.SECONDSECTION.ordinal]
            tempDaySrc.text = item.tempPreview[PreviewInfo.SECONDSECTION.ordinal]
            Picasso.get().load("http://openweathermap.org/img/wn/${item.iconPreview[PreviewInfo.SECONDSECTION.ordinal]}@2x.png").resize(35,35).centerCrop().into(iconDaySrc)
            eveSrc.text = item.infoPreview[PreviewInfo.THIRDSECTION.ordinal]
            tempEveSrc.text = item.tempPreview[PreviewInfo.THIRDSECTION.ordinal]
            Picasso.get().load("http://openweathermap.org/img/wn/${item.iconPreview[PreviewInfo.THIRDSECTION.ordinal]}@2x.png").resize(35,35).centerCrop().into(iconEveSrc)
            nigSrc.text = item.infoPreview[PreviewInfo.FOURTHSECTION.ordinal]
            tempNigSrc.text = item.tempPreview[PreviewInfo.FOURTHSECTION.ordinal]
            Picasso.get().load("http://openweathermap.org/img/wn/${item.iconPreview[PreviewInfo.FOURTHSECTION.ordinal]}@2x.png").resize(35,35).centerCrop().into(iconNigSrc)

            itemView.setOnClickListener { listener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position], listener)
    }

}