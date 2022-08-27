package com.singularitycoder.helpme

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.singularitycoder.helpme.databinding.ListItemLeftMessageBinding
import com.singularitycoder.helpme.databinding.ListItemRightMessageBinding
import com.singularitycoder.helpme.databinding.ListItemSpacerBinding

class ChatsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var chatsList = emptyList<ChatMessage>()
    private var itemLongClickListener: (chatMessage: ChatMessage) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemRightBinding =
            ListItemRightMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val itemLeftBinding =
            ListItemLeftMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val itemSpacerBinding =
            ListItemSpacerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return when (viewType) {
            ChatItem.RIGHT.ordinal -> RightMessageViewHolder(itemRightBinding)
            ChatItem.LEFT.ordinal -> LeftMessageViewHolder(itemLeftBinding)
            else -> SpacerViewHolder(itemSpacerBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RightMessageViewHolder -> holder.setData(chatsList[position])
            is LeftMessageViewHolder -> holder.setData(chatsList[position])
            is SpacerViewHolder -> holder.setData(82)
        }
    }

    override fun getItemCount(): Int = chatsList.size

    // Position gets messed up without itemViewType
    // https://stackoverflow.com/questions/44932450/wrong-order-of-restored-items-in-recyclerview
    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> ChatItem.RIGHT.ordinal
        1 -> ChatItem.LEFT.ordinal
        else -> ChatItem.SPACER.ordinal
    }

    fun setItemLongClickListener(listener: (chatMessage: ChatMessage) -> Unit) {
        itemLongClickListener = listener
    }

    inner class RightMessageViewHolder(
        private val itemBinding: ListItemRightMessageBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun setData(chatMessage: ChatMessage) {
            itemBinding.apply {
                tvRightMessage.text = chatMessage.message
                tvRightMessage.setTextColor(root.context.color(chatMessage.chatTextColor))
                ivRightHandle.setColorFilter(root.context.color(chatMessage.chatBackgroundColor))
                cardRightMessage.backgroundTintList =
                    ColorStateList.valueOf(root.context.color(chatMessage.chatBackgroundColor))
                root.setOnClickListener {
                    root.context.clipboard()?.text = tvRightMessage.text
                }
                root.setOnLongClickListener {
                    itemLongClickListener.invoke(chatMessage)
                    false
                }
            }
        }
    }

    inner class LeftMessageViewHolder(
        private val itemBinding: ListItemLeftMessageBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun setData(chatMessage: ChatMessage) {
            itemBinding.apply {
                tvLeftMessage.text = chatMessage.message
                tvLeftMessage.setTextColor(root.context.color(chatMessage.chatTextColor))
                ivLeftHandle.setColorFilter(root.context.color(chatMessage.chatBackgroundColor))
                cardLeftMessage.backgroundTintList =
                    ColorStateList.valueOf(root.context.color(chatMessage.chatBackgroundColor))
                root.setOnClickListener {
                    root.context.clipboard()?.text = tvLeftMessage.text
                }
                root.setOnLongClickListener {
                    itemLongClickListener.invoke(chatMessage)
                    false
                }
            }
        }
    }

    inner class SpacerViewHolder(
        private val itemBinding: ListItemSpacerBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun setData(padding: Int) {
            itemBinding.root.setPadding(0, 0, 0, padding)
        }
    }
}

enum class ChatItem {
    LEFT,
    RIGHT,
    SPACER
}