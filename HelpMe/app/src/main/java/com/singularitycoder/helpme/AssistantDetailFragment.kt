package com.singularitycoder.helpme

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.singularitycoder.helpme.databinding.FragmentAssistantDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class AssistantDetailFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(assistant: Assistant) = AssistantDetailFragment().apply {
            arguments = Bundle().apply { putParcelable(ARG_PARAM_ASSISTANT, assistant) }
        }
    }

    private val chatsList = mutableListOf<ChatMessage>()
    private val chatsAdapter = ChatsAdapter()

    private lateinit var binding: FragmentAssistantDetailBinding

    private val speechToTextResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
            result ?: return@registerForActivityResult
            if (result.resultCode != Activity.RESULT_OK) return@registerForActivityResult
            val data: Intent? = result.data
            val text = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            binding.askGpt3(prompt = text?.firstOrNull() ?: "")
        }

    private var assistantParam: Assistant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        assistantParam = arguments?.getParcelable<Assistant>(ARG_PARAM_ASSISTANT)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssistantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
        binding.setupUserActionListeners()
    }

    private fun FragmentAssistantDetailBinding.setupUI() {
        tvAssistantName.text = assistantParam?.name
        rvChats.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatsAdapter
        }
        chatsAdapter.chatsList = chatsList.apply {
            add(
                ChatMessage(
                    id = 0,
                    message = "Summarize this for a second-grade student:\n\nJupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined.",
                    chatItem = ChatItem.RIGHT,
                    chatTextColor = R.color.title_color,
                    chatBackgroundColor = R.color.black_50
                )
            )
            add(
                ChatMessage(
                    id = 0,
                    message = "Jupiter is a gas planet that is fifth from the sun and is bigger than any other planet in our solar system.",
                    chatItem = ChatItem.LEFT,
                    chatTextColor = assistantParam?.nameColor ?: 0,
                    chatBackgroundColor = assistantParam?.backgroundColor ?: 0
                )
            )
        }
        listOf("Request 1", "Request 2", "Request 3").forEach { it: String ->
            val chip = Chip(requireContext()).apply {
                text = it
                isCheckable = false
                isClickable = false
                chipBackgroundColor = ColorStateList.valueOf(requireContext().color(R.color.black_50))
                setTextColor(requireContext().color(R.color.title_color))
                elevation = 2f
                setOnClickListener {
                }
            }
            binding.chipGroupDefaultRequests.addView(chip)
        }
    }

    private fun FragmentAssistantDetailBinding.setupUserActionListeners() {
        etAskAnything.doAfterTextChanged { prompt: Editable? ->
            if (prompt.isNullOrBlank()) {
                ibSendTextOrVoiceMessage.setImageDrawable(context?.drawable(R.drawable.ic_round_keyboard_voice_24))
            } else {
                ibSendTextOrVoiceMessage.setImageDrawable(context?.drawable(R.drawable.ic_round_send_24))
            }
        }
        chatsAdapter.setItemLongClickListener { it: ChatMessage ->
            etAskAnything.setText(it.message)
        }
        ibBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStackImmediate()
        }
        ibSettings.setOnClickListener {
            AssistantSettingsBottomSheetFragment.newInstance().show(requireActivity().supportFragmentManager, TAG_ASSISTANT_SETTINGS_BOTTOM_SHEET)
        }
        ibDefaultRequest.setOnClickListener {
            scrollViewDefaultRequests.isVisible = scrollViewDefaultRequests.isVisible.not()
        }
        ibSendTextOrVoiceMessage.setOnClickListener {
            if (etAskAnything.text.isNullOrBlank()) {
                // Start Speech to Text
                val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                    putExtra(
                        RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                    )
                    putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
                    putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking Now!")
                }
                speechToTextResult.launch(intent)
            } else {
                askGpt3(prompt = etAskAnything.text.toString())
            }
        }
    }

    private fun FragmentAssistantDetailBinding.askGpt3(prompt: String) {
        // TODO insert in DB
        // TODO make API call
        if (prompt.isBlank()) return
        chatsAdapter.chatsList = chatsList.apply {
            add(
                ChatMessage(
                    id = 0,
                    message = prompt,
                    chatItem = ChatItem.RIGHT,
                    chatTextColor = R.color.title_color,
                    chatBackgroundColor = R.color.black_50
                )
            )
        }
        chatsAdapter.notifyItemInserted(chatsList.size)
        etAskAnything.setText("")
    }
}

private const val ARG_PARAM_ASSISTANT = "ARG_PARAM_ASSISTANT"