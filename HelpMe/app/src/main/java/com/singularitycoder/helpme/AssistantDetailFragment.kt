package com.singularitycoder.helpme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.singularitycoder.helpme.databinding.FragmentAssistantDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssistantDetailFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = AssistantDetailFragment()
    }

    private val chatsAdapter = ChatsAdapter()

    private lateinit var binding: FragmentAssistantDetailBinding

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
    }

    private fun FragmentAssistantDetailBinding.setupUI() {
        rvChats.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatsAdapter
        }
    }
}