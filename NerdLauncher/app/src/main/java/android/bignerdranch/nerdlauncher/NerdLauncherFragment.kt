package android.bignerdranch.nerdlauncher

import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class NerdLauncherFragment : Fragment(){

    private lateinit var mRecyclerView : RecyclerView

    companion object{
        private const val TAG = "NerdLauncherFragment"

        fun newInstance() : NerdLauncherFragment{
            return NerdLauncherFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_nerd_launcher, container, false)

        mRecyclerView = v.findViewById(R.id.app_recycler_view)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        setupAdapter()

        return v
    }

    private fun setupAdapter() {
        val startupIntent = Intent(Intent.ACTION_MAIN)
        startupIntent.addCategory(Intent.CATEGORY_LAUNCHER)

        val pm = activity?.packageManager
        val activities = pm!!.queryIntentActivities(startupIntent, 0)

        Collections.sort(activities) { a: ResolveInfo, b: ResolveInfo ->
            var pm = activity?.packageManager
            return@sort String.CASE_INSENSITIVE_ORDER.compare(
                a.loadLabel(pm).toString(),
                b.loadLabel(pm).toString()
            )
        }

        Log.i(TAG, "Found ${activities.size} activities")
    }
}
