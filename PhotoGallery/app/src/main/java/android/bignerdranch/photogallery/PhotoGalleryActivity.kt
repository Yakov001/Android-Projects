package android.bignerdranch.photogallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class PhotoGalleryActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return PhotoGalleryFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}