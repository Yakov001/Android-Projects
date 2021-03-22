package android.bignerdranch.photogallery

import android.net.Uri
import android.util.Log
import android.widget.Gallery
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class FlickrFetchr {
    companion object{
        private const val API_KEY = "80e04f54f56a4c4b410e53ba9edd79bc"
        private const val TAG = "FlickrFetchr"
    }

    fun getUrlBytes (urlSpec: String) : ByteArray {
        var url : URL = URL(urlSpec)
        var connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        try {
            val out : ByteArrayOutputStream = ByteArrayOutputStream()
            val inStream = connection.inputStream

            if (connection.responseCode != HttpURLConnection.HTTP_OK) {
                throw  IOException(connection.responseMessage +
                        ": with " +
                        urlSpec)
            }

            var bytesRead : Int = 0
            val buffer = ByteArray(1024)

            /*while ((bytesRead = inStream.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead)
            }*/

            do {
                bytesRead = inStream.read(buffer)
                if (bytesRead == -1){
                    break
                }
                out.write(buffer, 0, bytesRead)
            } while (bytesRead > 0)

            out.close()
            return out.toByteArray()

        } finally  {connection.disconnect()}

    }

    fun getUrlString(urlSpec: String) : String {
        return String(getUrlBytes(urlSpec))
    }

    fun fetchItems () : MutableList<GalleryItem> {
        var items = ArrayList<GalleryItem>()

        try {
            var url = Uri.parse("https://api.flickr.com/services/rest/")
                .buildUpon()
                .appendQueryParameter("method", "flickr.photos.getRecent")
                .appendQueryParameter("api_key", API_KEY)
                .appendQueryParameter("format", "json")
                .appendQueryParameter("nojsoncallback", "1")
                .appendQueryParameter("extras", "url_s")
                .build().toString()
            var jsonString = getUrlString(url)
            Log.i(TAG, "Received JSON: $jsonString")
            var jsonBody = JSONObject(jsonString)
            parseItems(items, jsonBody)
        } catch (ioe : IOException) {
            Log.e(TAG, "Failed to fetch items", ioe)
        } catch ( je : JSONException) {
            Log.e(TAG, "Failed to parse JSON", je)
        }

        return items
    }

    fun parseItems ( items : MutableList<GalleryItem>, jsonBody : JSONObject){
        var photosJsonObject = jsonBody.getJSONObject("photos")
        var photoJsonArray : JSONArray = photosJsonObject.getJSONArray("photo")

        for ( i in 0..photoJsonArray.length()){
            var photoJsonObject : JSONObject = photoJsonArray.get(i) as JSONObject

            var item = GalleryItem(
                photoJsonObject.getString("id"),
                photoJsonObject.getString("title")
            )

            if(!photoJsonObject.has("url_s")) continue

            item.setmUrl(photoJsonObject.getString("url_s"))
            items.add(item)
        }
    }
}