package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.TypefaceSpan
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView1))

        val actionBar = supportActionBar
        actionBar?.title = "Фільми на вечір"
        val typeface = ResourcesCompat.getFont(this, R.font.montserrat_regular)
        val spannableString = SpannableStringBuilder("Фільми на вечір")
        if (typeface != null) {
            spannableString.setSpan(
                CustomTypefaceSpan(typeface),
                0,
                spannableString.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            actionBar?.title = spannableString
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.fragmentContainerView1)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }
}
