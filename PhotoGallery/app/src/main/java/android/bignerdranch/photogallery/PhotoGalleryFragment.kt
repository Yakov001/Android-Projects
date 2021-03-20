package android.bignerdranch.photogallery

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class PhotoGalleryFragment : Fragment() {
    private lateinit var mPhotoRecyclerView : RecyclerView

    companion object {
        fun newInstance() : PhotoGalleryFragment{
            return PhotoGalleryFragment()
        }

        private const val TAG = "PhotoGalleryFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        FetchItemsTask().execute()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_photo_gallery, container, false)
        mPhotoRecyclerView = v.findViewById(R.id.photo_recycler_view)
        mPhotoRecyclerView.layoutManager = GridLayoutManager(activity, 3)

        return v
    }

    private class FetchItemsTask : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void?): Void? {
            FlickrFetchr().fetchItems()
            return null
        }

    }
}