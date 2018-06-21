package schieck.alarm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", ">>>>>>> FCM SUBSCRIBE TOPIC 'alarm'")
        FirebaseMessaging.getInstance().subscribeToTopic("alarm")

//        val mDatabase = FirebaseDatabase.getInstance().reference
//        mDatabase.child("users").child(userId).
    }
}
