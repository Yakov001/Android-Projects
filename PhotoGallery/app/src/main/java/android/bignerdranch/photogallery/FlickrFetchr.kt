package android.bignerdranch.photogallery

import android.net.Uri
import android.util.Log
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
                    throw IOException("BAD!")
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

    fun fetchItems () {
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
        } catch (ioe : IOException) {
            Log.e(TAG, "Failed to fetch items", ioe)
        }
    }
}