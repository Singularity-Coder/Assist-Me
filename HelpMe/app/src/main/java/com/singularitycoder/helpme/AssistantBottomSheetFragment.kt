package com.singularitycoder.helpme

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import com.singularitycoder.helpme.databinding.FragmentAssistantBottomSheetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssistantBottomSheetFragment : BottomSheetDialogFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = AssistantBottomSheetFragment()
    }

    private lateinit var binding: FragmentAssistantBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssistantBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTransparentBackground()
        binding.setupUserActionListeners()
        binding.observeForData()
    }

    // https://stackoverflow.com/questions/40616833/bottomsheetdialogfragment-listen-to-dismissed-by-user-event
    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    private fun FragmentAssistantBottomSheetBinding.setupUserActionListeners() {
        etQuestion.doTextFieldEmptyValidation()
        etQuestion.setBoxStrokeOnFocusChange()

        tvAnswer.doTextFieldEmptyValidation()
        tvAnswer.setBoxStrokeOnFocusChange()

        btnAddQuestion.setOnClickListener {
            if (isValidateInput().not()) return@setOnClickListener
            dismiss()
        }
    }

    private fun FragmentAssistantBottomSheetBinding.observeForData() {
    }

    private fun FragmentAssistantBottomSheetBinding.isValidateInput(): Boolean {
        if (etQuestion.editText?.text.isNullOrBlank()) {
            etQuestion.boxStrokeWidth = 2.dpToPx()
            etQuestion.error = "This is required!"
            return false
        }

        return true
    }

    private fun TextInputLayout.doTextFieldEmptyValidation() {
        editText?.doAfterTextChanged { it: Editable? ->
            if (editText?.text.isNullOrBlank()) {
                error = "This is required!"
            } else {
                error = null
                isErrorEnabled = false
            }
        }
    }

    private fun TextInputLayout.setBoxStrokeOnFocusChange() {
        editText?.setOnFocusChangeListener { view, isFocused ->
            boxStrokeWidth = if (isFocused) 2.dpToPx() else 0
        }
    }
}