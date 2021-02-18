package android.bignerdranch.com

import android.app.Activity
import android.bignerdranch.com.databinding.FragmentBeatBoxBinding
import android.bignerdranch.com.databinding.ListItemSoundBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeatBoxFragment : Fragment() {

    private lateinit var mBeatBox : BeatBox

    companion object {
        fun newInstance () : BeatBoxFragment {
            return BeatBoxFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Я тут что-то набалумутил с аргументом BeatBox. Могут быть баги )))
        mBeatBox = BeatBox(context = activity as Activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding : FragmentBeatBoxBinding = DataBindingUtil.
            inflate(inflater, R.layout.fragment_beat_box, container,false)
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 3)
        binding.recyclerView.adapter = SoundAdapter(mBeatBox.getSounds())
        return binding.root
    }

    //____________________________________________________________________________________________//
    private inner class SoundHolder (binding: ListItemSoundBinding) : RecyclerView.ViewHolder (binding.root) {

        private var mBinding : ListItemSoundBinding = binding

        init {
            mBinding.viewModel = SoundViewModel(mBeatBox)
        }

        fun bind (sound : Sound) {
            mBinding.viewModel?.setSound(sound)
            mBinding.executePendingBindings()
        }
    }

    //____________________________________________________________________________________________//
    private inner class SoundAdapter ( sounds : List<Sound>) : RecyclerView.Adapter<SoundHolder>() {
        private var mSounds : MutableList<Sound> = sounds as MutableList<Sound>

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            var inflater = LayoutInflater.from(parent.context)
            var binding : ListItemSoundBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_sound, parent, false)
            return SoundHolder(binding)
        }

        override fun getItemCount(): Int {
            return mSounds.size
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            var sound = mSounds[position]
            holder.bind(sound)
        }

    }
}