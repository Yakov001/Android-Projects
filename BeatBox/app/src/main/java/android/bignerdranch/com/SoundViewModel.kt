package android.bignerdranch.com

class SoundViewModel (beatBox: BeatBox){
    private lateinit var mSound : Sound
    private var mBeatBox: BeatBox = beatBox

    fun getSound (): Sound {
        return mSound
    }

    fun setSound (sound : Sound) {
        mSound = sound
    }

    fun getTitle () : String {
        return mSound.getName()
    }


}