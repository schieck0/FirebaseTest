package schieck.alarm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", ">>>>>>> FCM SUBSCRIBE TOPIC 'alarm'")
        FirebaseMessaging.getInstance().subscribeToTopic("alarm")

        val mDatabase = FirebaseDatabase.getInstance().reference
        mDatabase.child("params").child("state").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("MainActivity", ">>>>>>> STATE " + snapshot.value)
                tbAlarmState.isChecked = snapshot.value.toString() != "0"
            }

            override fun onCancelled(p0: DatabaseError) {}
        })


        tbAlarmState.setOnClickListener { view ->
            mDatabase.child("params").updateChildren(mapOf("state" to if (tbAlarmState.isChecked) 1 else 0))
        }

    }

}
