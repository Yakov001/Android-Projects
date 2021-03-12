package android.bignerdranch.com

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel (beatBox: BeatBox, speed: Float = 1.0f) : BaseObservable() {
    private lateinit var mSound : Sound
    private var mBeatBox: BeatBox = beatBox
    private var mSpeed : Float = speed

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

    fun onButtonClicked() {
        mBeatBox.play(mSound, BeatBoxFragment.getSpeed())
    }

    fun getSpeed () : Float {
        return mSpeed
    }


}