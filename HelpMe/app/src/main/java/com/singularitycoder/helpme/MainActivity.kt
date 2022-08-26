package com.singularitycoder.helpme

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.singularitycoder.helpme.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

// TODO Usecases to cover
// 1. Text to picture
// 2. Text to Video
// 3. Text to concept art - The way DALL-E does

// https://beta.openai.com/examples
// https://beta.openai.com/overview
// https://beta.openai.com/docs/quickstart/build-your-application
// https://developers.google.com/ml-kit/guides
// https://github.com/tesseract-ocr/tesseract
// https://developers.google.com/ml-kit
// https://stackoverflow.com/questions/47471159/how-to-extract-text-from-an-audio-file
// extract text from audio android programmatically

// TODO first steps
// Read docs
// On Click of task open bottom sheet with auto filled text from clipboard and make API call
// Task bottom sheet settings - hide show in the view

// Engine dropdown
// Scrollable
// Network connectivity check
// Input for question - Ask me anything
// Answer section


// API call Ktor

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val assistantAdapter = AssistantAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLightStatusBar(this)
        window.statusBarColor = Color.WHITE
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.setupUI()
        binding.setupUserActionListeners()
    }

    private fun ActivityMainBinding.setupUI() {
        rvTasks.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = assistantAdapter
        }
        assistantAdapter.assistantsList = assistantLists
    }

    private fun ActivityMainBinding.setupUserActionListeners() {
        etSearch.doAfterTextChanged { keyWord: Editable? ->
            ibClearSearch.isVisible = keyWord.isNullOrBlank().not()
            if (keyWord.isNullOrBlank()) {
                assistantAdapter.assistantsList = assistantLists
            } else {
                assistantAdapter.assistantsList = assistantAdapter.assistantsList.filter { it: Assistant -> it.name.contains(keyWord) }
            }
            assistantAdapter.notifyDataSetChanged()
        }
        ibClearSearch.setOnClickListener {
            etSearch.setText("")
            etSearch.requestFocus()
            etSearch.hideKeyboard()
        }
        assistantAdapter.setItemClickListener { it: Assistant ->
        }
        ibAddApiKey.setOnClickListener {
            AddApiKeyBottomSheetFragment.newInstance().show(supportFragmentManager, TAG_ADD_API_KEY_BOTTOM_SHEET)
        }
    }

    fun addApiKey(apiKey: String) {
    }
}