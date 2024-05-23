package com.example.coursework.presentation.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.presentation.entity.ColorItem
import timber.log.Timber

internal class ColorAdapter(
//    val data: List<ColorItem>
) : RecyclerView.Adapter<ColorHolder>() {

    var data: List<ColorItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        return ColorHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        val currentItem = data[position]
        holder.onBind(currentItem)
    }

//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val currentItem = data[position]
////        Timber.tag("ITEM").e(currentItem.toString())
//        when (holder) {
//            is ColorHolder ->
//                holder.onBind(currentItem)
//        }
//        holder.itemView.setBackgroundColor(Integer.parseInt(currentItem.code))
////        holder.itemView.setBackgroundColor(
////            Color.rgb(
////            Color.red(currentItem.code),
////            Color.green(item.code),
////            Color.blue(item.code)
////        ))
//    }

    override fun getItemCount(): Int {
        return data.size
    }
}

//class CustomAdapter(private val dataSet: List<String>) :
//    RecyclerView.Adapter<ColorHolder>() {
//
////    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
////        // Поле для хранения цвета фона элемента
////        val backgroundView: View = view.findViewById(R.id.backgroundView)
////    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return ColorHolder.create(parent)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val item = dataSet[position]
//        holder.backgroundView.setBackgroundColor(getItemBackgroundColor(position))
//        // Здесь также можно устанавливать другие свойства элемента, например, текст
//    }
//
//    override fun getItemCount() = dataSet.size
//
//    // Примерная логика для получения цвета фона для элемента в зависимости от его позиции
//    private fun getItemBackgroundColor(position: Int): Int {
//        return if (position % 2 == 0) {
//            Color.LTGRAY // Четные элементы будут светло-серыми
//        } else {
//            Color.WHITE // Нечетные элементы будут белыми
//        }
//    }
//}
//internal class ColorListAdapter(
////    private val actionAdd: (NoteItem) -> Unit,
//) : ListAdapter<Color, RecyclerView.ViewHolder>(
//    object : DiffUtil.ItemCallback<NoteItem>() {
//        override fun areItemsTheSame(
//            oldItem: NoteItem,
//            newItem: NoteItem,
//        ): Boolean = (oldItem as? NoteItem)?.title == (newItem as? NoteItem)?.title
//
//        override fun areContentsTheSame(
//            oldItem: NoteItem,
//            newItem: NoteItem
//        ): Boolean = oldItem == newItem
//    }
//) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
//        when (viewType) {
//            R.layout.item_note -> NoteHolder.create(parent)
//            else -> throw IllegalStateException("Unknown item type!")
//        }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val currentItem = currentList[position]
//        when (holder) {
//            is NoteHolder -> holder.onBind(currentItem as NoteItem)
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int =
//        when (currentList[position]) {
//            is NoteItem -> R.layout.item_note
//            else -> throw IllegalArgumentException("Unknown item type!")
//        }
//}