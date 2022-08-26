package com.singularitycoder.helpme

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.singularitycoder.helpme.databinding.FragmentAddApiKeyBottomSheetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddApiKeyBottomSheetFragment : BottomSheetDialogFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = AddApiKeyBottomSheetFragment()
    }

    private lateinit var binding: FragmentAddApiKeyBottomSheetBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddApiKeyBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTransparentBackground()
        binding.setupUserActionListeners()
    }

    override fun onResume() {
        super.onResume()
        if (context.clipboard()?.text.isNullOrBlank().not() && binding.etApiKey.editText?.text.isNullOrBlank()) {
            binding.etApiKey.editText?.setText(context.clipboard()?.text)
        }
    }

    private fun FragmentAddApiKeyBottomSheetBinding.setupUserActionListeners() {
        etApiKey.editText?.doAfterTextChanged { it: Editable? ->
            if (etApiKey.editText?.text.isNullOrBlank()) {
                etApiKey.error = "This is required!"
            } else {
                etApiKey.error = null
            }
        }
        etApiKey.editText?.setOnFocusChangeListener { view, isFocused ->
            etApiKey.boxStrokeWidth = if (isFocused) 2.dpToPx() else 0
        }
        ibAddApiKey.setOnClickListener {
            if (etApiKey.editText?.text.isNullOrBlank()){
                etApiKey.boxStrokeWidth = 2.dpToPx()
                etApiKey.error = "This is required!"
                return@setOnClickListener
            }
            if (etApiKey.editText?.text?.length!! < 50 || etApiKey.editText?.text?.length!! > 60){
                etApiKey.boxStrokeWidth = 2.dpToPx()
                etApiKey.error = "Invalid API Key"
                return@setOnClickListener
            }
            (activity as? MainActivity)?.addApiKey(apiKey = etApiKey.editText?.text.toString())
            dismiss()
        }
    }
}