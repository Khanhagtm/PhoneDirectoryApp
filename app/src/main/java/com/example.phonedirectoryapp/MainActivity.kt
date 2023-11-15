package com.example.phonedirectoryapp

import User
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail_recycle.MyAdapter
import com.example.phonedirectoryapp.ui.theme.PhoneBookTheme
import java.util.*
import android.view.*

val userList = listOf(
    User(1, "Alonso", "8334339001", "alonso@gmail.com"),
    User(2, "Beckham", "2843874002", "beckham@gmail.com"),
    User(3, "Carlor", "12942724878", "carlor@gmail.com"),
    User(4, "David", "2982897424", "david@gmail.com"),
    User(5, "Everes", "187131818", "everes@gmail.com"),
    User(6, "Franch", "013119191", "franch@gmail.com"),
    User(7, "Gwen", "13113818", "gwen@gmail.com"),
    User(8, "Harry", "48292982", "harry@gmail.com"),
    User(9, "Ivankov", "924299892", "ivannkov@gmail.com"),
    User(10, "Jack", "24292829", "jack@gmail.com"),
    User(11, "Kane", "249282898", "kane@gmail.com"),
    User(12, "Leo", "24227827", "leo@gmail.com"),
    User(13, "Mathew", "22727272", "mathew@gmail.com"),
    User(14, "Noa", "227827278", "noa@gmail.com"),
    User(15, "Oliva", "292922292", "oliva@gmail.com"),
    User(16, "Peter", "9829829", "peter@gmail.com"),
    User(17, "Quin", "022992224", "quin@gmail.com"),
    User(18, "Ryan", "202042202", "ryan@gmail.com"),
    User(19, "Sara", "1000239292", "sara@gmail.com"),
    User(20, "Tom", "022229222", "tom@gmail.com")
)

class MainActivity : ComponentActivity() {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(userList)
        rv.adapter = myAdapter
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val clickedUser = myAdapter.getClickedUser()
        Log.d("TAG", clickedUser.toString())
        return when (item.itemId) {
            R.id.action_call -> {
                Log.d("TAG", "Call " + clickedUser?.getUserPhone())
                Toast.makeText(this@MainActivity, "Call " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_message -> {
                Log.v("TAG", "Send message to " + clickedUser?.getUserPhone())
                Toast.makeText(this, "Send message to " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_email -> {
                Log.v("TAG", "Send email to " + clickedUser?.getUserEmail())
                Toast.makeText(this, "Send email to " + clickedUser?.getUserEmail(), Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}

