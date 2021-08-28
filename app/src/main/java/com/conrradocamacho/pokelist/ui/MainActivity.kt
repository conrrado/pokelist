package com.conrradocamacho.pokelist.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.conrradocamacho.pokelist.R
import com.conrradocamacho.pokelist.databinding.ActivityMainBinding
import com.conrradocamacho.pokelist.ui.list.PokeListViewModel
import com.conrradocamacho.pokelist.utils.PokeViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: PokeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        viewModel.state.observe(this, {
            when(it) {
                PokeViewState.Loading -> { progressBar.visibility = View.VISIBLE }
                PokeViewState.Success -> { progressBar.visibility = View.GONE }
            }
        })
    }
}