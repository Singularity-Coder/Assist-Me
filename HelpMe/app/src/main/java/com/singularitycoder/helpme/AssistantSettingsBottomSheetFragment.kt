package com.singularitycoder.helpme

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import android.widget.TextView
import androidx.core.view.get
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.Slider
import com.google.android.material.textfield.TextInputLayout
import com.singularitycoder.helpme.databinding.FragmentAssistantSettingsBottomSheetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssistantSettingsBottomSheetFragment : BottomSheetDialogFragment() {

    companion object {
        @JvmStatic
        fun newInstance() = AssistantSettingsBottomSheetFragment()
    }

    private lateinit var binding: FragmentAssistantSettingsBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssistantSettingsBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTransparentBackground()
        binding.setupUI()
        binding.setupUserActionListeners()
        binding.observeForData()
    }

    private fun FragmentAssistantSettingsBottomSheetBinding.setupUI() {
        layoutSliderTemperature.apply {
            tvSliderTitle.text = "Temperature"
            tvSliderValue.text = sliderDiscrete.value.toString()
            sliderDiscrete.apply {
                value = 3f
                stepSize = 1f
                valueFrom = 1f
                valueTo = 100f
                addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                    override fun onStartTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being started
                    override fun onStopTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being stopped
                })
                addOnChangeListener { slider, value, fromUser ->
                    // Responds to when slider's value is changed
                    tvSliderValue.text = value.toString()
                }
            }
        }
        layoutSliderMaxLength.apply {
            tvSliderTitle.text = "Maximum Length"
            tvSliderValue.text = sliderDiscrete.value.toString()
            sliderDiscrete.apply {
                value = 3f
                stepSize = 1f
                valueFrom = 1f
                valueTo = 4000f
                addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                    override fun onStartTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being started
                    override fun onStopTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being stopped
                })
                addOnChangeListener { slider, value, fromUser ->
                    // Responds to when slider's value is changed
                    tvSliderValue.text = value.toString()
                }
            }
        }
        layoutSliderTopP.apply {
            tvSliderTitle.text = "Top P"
            tvSliderValue.text = sliderDiscrete.value.toString()
            sliderDiscrete.apply {
                value = 0f
                stepSize = 0.01f
                valueFrom = 0f
                valueTo = 1f
                addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                    override fun onStartTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being started
                    override fun onStopTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being stopped
                })
                addOnChangeListener { slider, value, fromUser ->
                    // Responds to when slider's value is changed
                    tvSliderValue.text = value.toString()
                }
            }
        }
        layoutSliderFrequencyPenalty.apply {
            tvSliderTitle.text = "Frequency penalty"
            tvSliderValue.text = sliderDiscrete.value.toString()
            sliderDiscrete.apply {
                value = 0f
                stepSize = 0.01f
                valueFrom = 0f
                valueTo = 2f
                addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                    override fun onStartTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being started
                    override fun onStopTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being stopped
                })
                addOnChangeListener { slider, value, fromUser ->
                    // Responds to when slider's value is changed
                    tvSliderValue.text = value.toString()
                }
            }
        }
        layoutSliderPresencePenalty.apply {
            tvSliderTitle.text = "Presence penalty"
            tvSliderValue.text = sliderDiscrete.value.toString()
            sliderDiscrete.apply {
                value = 0f
                stepSize = 0.01f
                valueFrom = 0f
                valueTo = 2f
                addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                    override fun onStartTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being started
                    override fun onStopTrackingTouch(slider: Slider) = Unit // Responds to when slider's touch event is being stopped
                })
                addOnChangeListener { slider, value, fromUser ->
                    // Responds to when slider's value is changed
                    tvSliderValue.text = value.toString()
                }
            }
        }
    }

    // https://stackoverflow.com/questions/40616833/bottomsheetdialogfragment-listen-to-dismissed-by-user-event
    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    private fun FragmentAssistantSettingsBottomSheetBinding.setupUserActionListeners() {
        etSetStopSequences.doTextFieldEmptyValidation()
        etSetStopSequences.setBoxStrokeOnFocusChange()

        btnSetFilters.setOnClickListener {
            if (isValidateInput().not()) return@setOnClickListener
            dismiss()
        }

        etSelectModel.editText?.apply {
            isFocusable = false
            isClickable = true
            isLongClickable = false
            setOnClickListener {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, OpenAiModels.getModels())
                showListPopupMenu(view = etSelectModel.editText ?: return@setOnClickListener, adapter = adapter)
            }
        }
    }

    private fun showListPopupMenu(view: View, adapter: ArrayAdapter<String>) {
        ListPopupWindow(requireContext(), null, com.google.android.material.R.attr.listPopupWindowStyle).apply {
            anchorView = view
            setAdapter(adapter)
            setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                // Respond to list popup window item click.
                binding.etSelectModel.editText?.setText((parent?.get(position) as TextView).text)
                this.dismiss()
            }
            show()
        }
    }

    private fun FragmentAssistantSettingsBottomSheetBinding.observeForData() {
    }

    private fun FragmentAssistantSettingsBottomSheetBinding.isValidateInput(): Boolean {
        if (etSetStopSequences.editText?.text.isNullOrBlank()) {
            etSetStopSequences.boxStrokeWidth = 2.dpToPx()
            etSetStopSequences.error = "This is required!"
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