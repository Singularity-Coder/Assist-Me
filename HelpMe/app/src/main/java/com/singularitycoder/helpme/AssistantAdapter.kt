package com.singularitycoder.helpme

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.singularitycoder.helpme.databinding.ListItemAssistantBinding

class AssistantAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var assistantsList = emptyList<Assistant>()
    private var itemClickListener: (assistant: Assistant) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ListItemAssistantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TaskViewHolder).setData(assistantsList[position])
    }

    override fun getItemCount(): Int = assistantsList.size

    override fun getItemViewType(position: Int): Int = position

    fun setItemClickListener(listener: (assistant: Assistant) -> Unit) {
        itemClickListener = listener
    }

    inner class TaskViewHolder(
        private val itemBinding: ListItemAssistantBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(assistant: Assistant) {
            itemBinding.apply {
                tvTaskName.apply {
                    text = assistant.name
                    setTextColor(root.context.color(assistant.nameColor))
                }
                tvTaskDescription.apply {
                    text = assistant.description
                    setTextColor(root.context.color(assistant.descriptionColor))
                }
                ivTaskImage.apply {
                    setImageDrawable(root.context.drawable(assistant.icon))
                    imageTintList = ColorStateList.valueOf(root.context.color(assistant.iconColor))
                }
                ivArrowRight.imageTintList = ColorStateList.valueOf(root.context.color(assistant.iconColor))
                root.apply {
                    backgroundTintList = ColorStateList.valueOf(root.context.color(assistant.backgroundColor))
                    setOnClickListener {
                        itemClickListener.invoke(assistant)
                    }
                }
            }
        }
    }
}
