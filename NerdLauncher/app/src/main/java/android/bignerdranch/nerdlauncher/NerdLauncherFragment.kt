package android.bignerdranch.nerdlauncher

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
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
            String.CASE_INSENSITIVE_ORDER.compare(
                a.loadLabel(pm).toString(),
                b.loadLabel(pm).toString()
            )
        }

        Log.i(TAG, "Found ${activities.size} activities")
        mRecyclerView.adapter = ActivityAdapter(activities)
    }

    //---------------------------------------------------------------------------//

    private class ActivityHolder(itemView : View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        private lateinit var mResolveInfo : ResolveInfo
        private var mNameTextView : TextView = itemView as TextView

        fun bindActivity (resolveInfo: ResolveInfo) {
            mResolveInfo = resolveInfo
            var ctxt : Context = itemView.context
            var pm : PackageManager = ctxt.packageManager
            mNameTextView.text = mResolveInfo.loadLabel(pm).toString()
            mNameTextView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            var activityInfo = mResolveInfo.activityInfo
            var i : Intent = Intent(Intent.ACTION_MAIN).setClassName(activityInfo.applicationInfo.packageName,
            activityInfo.name).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(v!!.context, i, null)
        }
    }

    //---------------------------------------------------------------------------//

    private class ActivityAdapter(activities : List<ResolveInfo>) :
        RecyclerView.Adapter<ActivityHolder>() {

        private val mActivities = activities

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityHolder {
            var layoutInflater = LayoutInflater.from(parent.context)
            var view = layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
            return ActivityHolder(view)
        }

        override fun onBindViewHolder(holder: ActivityHolder, position: Int) {
            var mResolveInfo = mActivities.get(position)
            holder.bindActivity(mResolveInfo)
        }

        override fun getItemCount(): Int {
            return mActivities.size
        }

    }
}
