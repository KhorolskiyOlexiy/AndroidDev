package com.example.movies.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.example.movies.CustomTypefaceSpan
import com.example.movies.R

class MovieFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(Color.parseColor("#2c2c2c"))

        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar

        val typeface = ResourcesCompat.getFont(requireContext(), R.font.montserrat_regular)
        val spannableString = SpannableStringBuilder("Про фільм")
        typeface?.let {
            spannableString.setSpan(CustomTypefaceSpan(it), 0, spannableString.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            actionBar?.title = spannableString
        }

        val titleMovie = view.findViewById<TextView>(R.id.textView5)
        val descriptionMovie = view.findViewById<TextView>(R.id.textView3)
        val imageMovie = view.findViewById<ImageView>(R.id.imageView2)

        val title = arguments?.getString("title")
        val description = arguments?.getString("description")
        val image = arguments?.getString("image")

        titleMovie.text = title
        descriptionMovie.text = description

        if (image != null) {
            Glide.with(requireContext())
                .load(resources.getIdentifier(image, "drawable", requireContext().packageName))
                .into(imageMovie)
        }
    }
}