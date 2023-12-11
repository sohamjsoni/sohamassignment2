package com.example.sohamassignment2
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import android.provider.ContactsContract
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
    }
    fun addContact(view: View) {
        val etContactName: EditText = findViewById(R.id.etName)
        val etContactNumber: EditText = findViewById(R.id.etNumber)
        val name: String = etContactName.text.toString()
        val phone = etContactNumber.text.toString()
        val intent = Intent(ContactsContract.Intents.Insert.ACTION)
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name)
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Added Contact", Toast.LENGTH_SHORT).show()
            }
            else
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled Added Contact", Toast.LENGTH_SHORT).show()
            }
        }
    }
}