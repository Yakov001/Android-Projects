package android.bignerdranch.com

class Sound (assetPath : String) {
    private var mAssetPath = assetPath
    private var mName : String
    private var mSoundId : Int? = null

    init {
        mAssetPath = assetPath
        var components = assetPath.split("/")
        var filename = components[components.size - 1]
        mName = filename.replace(".wav", "")
    }

    fun getName () : String {
        return mName
    }

    fun getAssetPath () : String{
        return mAssetPath
    }

    fun getSoundId () : Int? {
        return mSoundId
    }

    fun setSoundId (sound : Int) {
        mSoundId = sound
    }

}