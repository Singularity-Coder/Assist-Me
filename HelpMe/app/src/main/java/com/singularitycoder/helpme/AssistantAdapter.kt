package com.singularitycoder.helpme

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.singularitycoder.helpme.databinding.ListItemAssistantBinding

class AssistantAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var assistantsList = emptyList<Task>()
    private var itemClickListener: (task: Task) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ListItemAssistantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TaskViewHolder).setData(assistantsList[position])
    }

    override fun getItemCount(): Int = assistantsList.size

    override fun getItemViewType(position: Int): Int = position

    fun setItemClickListener(listener: (task: Task) -> Unit) {
        itemClickListener = listener
    }

    inner class TaskViewHolder(
        private val itemBinding: ListItemAssistantBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(task: Task) {
            itemBinding.apply {
                tvTaskName.apply {
                    text = task.name
                    setTextColor(root.context.color(task.nameColor))
                }
                tvTaskDescription.apply {
                    text = task.description
                    setTextColor(root.context.color(task.descriptionColor))
                }
                ivTaskImage.apply {
                    setImageDrawable(root.context.drawable(task.icon))
                    imageTintList = ColorStateList.valueOf(root.context.color(task.iconColor))
                }
                root.apply {
                    backgroundTintList = ColorStateList.valueOf(root.context.color(task.backgroundColor))
                    setOnClickListener {
                        itemClickListener.invoke(task)
                    }
                }
            }
        }
    }
}
