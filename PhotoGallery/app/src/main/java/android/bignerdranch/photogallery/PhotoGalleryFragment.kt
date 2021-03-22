package android.bignerdranch.photogallery

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class PhotoGalleryFragment : Fragment() {
    private lateinit var mPhotoRecyclerView : RecyclerView
    private var mItems : List<GalleryItem> = ArrayList<GalleryItem>()

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

        setupAdapter()

        return v
    }

    private fun setupAdapter() {
        if (isAdded) mPhotoRecyclerView.adapter = PhotoAdapter(mItems)
    }

    private class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var mTitleTextView = itemView as TextView

        fun bindGalleryItem (item : GalleryItem) {
            mTitleTextView.text = item.toString()
        }
    }

    private class PhotoAdapter(galleryItems : List<GalleryItem>) : RecyclerView.Adapter<PhotoHolder>() {
        private var mGalleryItems : MutableList<GalleryItem> = galleryItems as MutableList<GalleryItem>

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
            var textView = TextView(parent.context)
            return PhotoHolder(textView)
        }

        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            var galleryItem = mGalleryItems.get(position)
            holder.bindGalleryItem(galleryItem)
        }

        override fun getItemCount(): Int {
            return mGalleryItems.size
        }

    }

    private inner class FetchItemsTask : AsyncTask<Void, Void, List<GalleryItem>>() {

        override fun doInBackground(vararg params: Void?): List<GalleryItem> {
            return FlickrFetchr().fetchItems()
        }

        override fun onPostExecute(result: List<GalleryItem>) {
            mItems = result
            setupAdapter()
        }

    }
}