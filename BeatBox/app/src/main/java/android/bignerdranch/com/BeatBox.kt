package android.bignerdranch.com

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException

class BeatBox (var context : Context) {

    private var mAssets : AssetManager = context.assets
    private var mSounds : MutableList<Sound> = arrayListOf()
    private var mSoundPool : SoundPool

    init {
        mAssets = context.assets
        // Этот конструктор считается устаревшим,
        // но он нужен для обеспечения совместимости
        mSoundPool = SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0)
        loadSounds()
    }
    companion object {
        private var TAG = "BeatBox"
        private var SOUNDS_FOLDER = "sample_sounds"
        private var MAX_SOUNDS = 5

    }

    fun play (sound: Sound) {
        var soundId = sound.getSoundId()
        if (soundId == null) return
        mSoundPool.play(soundId, 1.0f, 1.0f, 1 , 0, 1.0f)

    }

    private fun loadSounds() {
        var soundNames = arrayOf<String>()
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER) as Array<String>
            Log.i(TAG, "Found ${soundNames.size} sounds")
        } catch (ioe : IOException) {
            Log.e(TAG, "Could not list assets", ioe)
            return
        }

        soundNames.forEach {
            try {
                var assetPath = SOUNDS_FOLDER + "/" + it
                var sound = Sound(assetPath)
                load(sound)
                mSounds.add(sound)
            }
            catch (ioe : IOException) {
                Log.e(TAG, "Could not load sound ", ioe)
            }
        }

    }

    private fun load (sound : Sound){
        var afd = mAssets.openFd(sound.getAssetPath())
        var soundId = mSoundPool.load(afd, 1)
        sound.setSoundId(soundId)
        // throws IOException is Java version. Does not in Kotlin one
    }

    fun getSounds() : List<Sound> {
        return mSounds
    }

    fun release () {
        mSoundPool.release()
    }

}