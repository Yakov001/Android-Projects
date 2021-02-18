package android.bignerdranch.com

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel (beatBox: BeatBox) : BaseObservable() {
    private lateinit var mSound : Sound
    private var mBeatBox: BeatBox = beatBox

    fun getSound (): Sound {
        return mSound
    }

    fun setSound (sound : Sound) {
        mSound = sound
        notifyChange()
    }

    @Bindable
    fun getTitle () : String {
        return mSound.getName()
    }


}