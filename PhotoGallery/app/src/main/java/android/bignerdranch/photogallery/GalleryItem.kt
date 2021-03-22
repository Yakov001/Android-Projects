package android.bignerdranch.photogallery

data class GalleryItem (val mCaption : String, val mId : String ) {

    private lateinit var mUrl : String

    override fun toString(): String {
        return mCaption
    }

    fun setmUrl (string: String) {mUrl = string}
}