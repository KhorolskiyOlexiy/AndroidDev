package com.example.movies.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.CustomTypefaceSpan
import com.example.movies.Movie
import com.example.movies.MovieAdapter
import com.example.movies.R

class MainFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(Color.parseColor("#2c2c2c"))
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        val typeface = ResourcesCompat.getFont(requireContext(), R.font.montserrat_regular)
        val spannableString = SpannableStringBuilder("Фільми на вечір")
        typeface?.let {
            spannableString.setSpan(
                CustomTypefaceSpan(it),
                0,
                spannableString.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            actionBar?.title = spannableString
        }


        val movies = arrayListOf<Movie>()
        movies.add(Movie("Веном 2", "Журналист Эдди Брок привыкает к совместной жизни с инопланетным симбиотом Веномом. Когда безумный маньяк Клетус Кэссиди превращается в неудержимого монстра из-за опасного симбиота Карнажа, Эдди и Веном должны преодолеть свои разногласия, чтобы остановить нового врага, пока не стало слишком поздно.", "venom2"))
        movies.add(Movie("Джон Уик 4", "Сюжет В Нью-Йорке Джон Уик готовится отомстить Правлению Кланов, скрываясь под землей вместе с «Голубиным Королём». Он отправляется в Марокко и убивает Старейшину, единственного человека, стоящего выше Правления.", "john_wick4"))
        movies.add(Movie("Аватар: Путь воды", "После принятия образа аватара солдат Джейк Салли становится предводителем народа на'ви и берет на себя миссию по защите новых друзей от корыстных бизнесменов с Земли. Теперь ему есть за кого бороться — с Джейком его прекрасная возлюбленная Нейтири.", "avatar"))
        movies.add(Movie("Папина дочка", "Джиби нужно выбраться из грустной сказки и найти способ остаться для своей дочери героем и в реальной жизни. Перед сном Джиби всегда рассказывал своей маленькой дочери сказки. Вместе они придумали волшебный мир, где живут крошечные феи и величественные драконы, а папа всегда спасает принцессу-дочь от любых опасностей.", "father_dauther"))
        movies.add(Movie("Гнев человеческий", "Легендарный режиссер Гай Ричи снял фильм-экшн под названием «Гнев человеческий», в главной роли которого сыграл популярный актер Джейсон Стейтем. По сюжету загадочный и брутальный мужчина по имени Эйч, устраивается работать охранником инкассаторского грузовика, сообщив всем ложь, что просто нуждается в финансах", "gnev"))

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleMovies)
        val adapter = MovieAdapter(movies) { movie ->
            val bundle = bundleOf("movieTitle" to movie.title, "movieDescription" to movie.description)
            findNavController().navigate(R.id.action_mainFrag_to_movieFrag, bundle)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.onClick = { movie ->
            val bundle = Bundle().apply {
                putString("title", movie.title)
                putString("description", movie.description)
                putString("image", movie.imageUrl)
            }
            findNavController().navigate(R.id.action_mainFrag_to_movieFrag, bundle)
        }
    }
}