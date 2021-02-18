package android.bignerdranch.com

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import java.io.IOException

class BeatBox (var context : Context) {

    private var mAssets : AssetManager = context.assets
    private var mSounds : MutableList<Sound> = arrayListOf()

    init {
        mAssets = context.assets
        loadSounds()
    }
    companion object {
        private var TAG = "BeatBox"
        private var SOUNDS_FOLDER = "sample_sounds"

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
            var assetPath = SOUNDS_FOLDER + "/" + it
            var sound = Sound(assetPath)
            mSounds.add(sound)
        }

    }

    fun getSounds() : List<Sound> {
        return mSounds
    }

}