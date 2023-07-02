package com.androidsquad.myportfolio

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import java.io.File
import java.io.FileOutputStream

open class MyProfile : MainActivity() {
    public  lateinit var preferencesHelper: PreferencesHelper
    private lateinit var imageView: ImageView
    public lateinit var sharedPreferences: SharedPreferences
    public lateinit var sharedPreferences2: SharedPreferences
    lateinit var contact:TextView
    lateinit var email:TextView
    lateinit var position:TextView
    lateinit var myName:TextView
    lateinit var changeFields:EditText
    lateinit var saveChanges:ImageView
    lateinit var bitmap:Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allocateActivityTitle("My Profile")
        val inflater: LayoutInflater=(this.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater)
        val replace = findViewById<RelativeLayout>(R.id.frame)
        val contentView = inflater.inflate(R.layout.activity_my_profile, null, false)
        replace.addView(contentView, 0)
        imageView = findViewById(R.id.imageView)
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        sharedPreferences2=getSharedPreferences("my_preferences", MODE_PRIVATE)
        contact=findViewById(R.id.phoneNumber)
        email=findViewById(R.id.emailAddress)
        myName=findViewById(R.id.name)
        position=findViewById(R.id.position)
        saveChanges=findViewById(R.id.saveChanges)
        changeFields=findViewById(R.id.changeFields)
        changeFields.setOnLongClickListener(View.OnLongClickListener {
            changeFields.visibility=View.INVISIBLE
            saveChanges.visibility=View.INVISIBLE
            true})
        // Load image from SharedPreferences if it exists
        val imagePath = sharedPreferences.getString("imagePath", null)
        if (imagePath != null) {
            val imageFile = File(imagePath)
            if (imageFile.exists()) {
                 bitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
                imageView.setImageBitmap(bitmap)
            }
        }
        // Choose image from gallery
        imageView.setOnClickListener() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)
        }
        val text1 = sharedPreferences2.getString(("MyName"), "")
        val text2 = sharedPreferences2.getString("MyPosition", "")
        val text3 = sharedPreferences2.getString("MyContact", "")
        val text4 = sharedPreferences2.getString("MyEmail", "")
        if (text1 != null) {
            if (!text1.trim().isEmpty()) {
                myName.text = text1
            }
        }
        if (text2 != null) {
            if (!text2.trim().isEmpty()) {
                position.text = text2
            }
        }
        if (text3 != null) {
            if (!text3.trim().isEmpty()) {
                contact.text = text3
            }
        }
        if (text4 != null) {
            if (!text4.trim().isEmpty()) {
                email.text = text4
            }
        }
        SaveFields()
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            if (selectedImageUri != null) {
                // Save image to internal storage
                val inputStream = contentResolver.openInputStream(selectedImageUri)
                val file = File(getDir("images", Context.MODE_PRIVATE), "image.jpg")
                val outputStream = FileOutputStream(file)
                inputStream?.copyTo(outputStream)
                outputStream.close()
                inputStream?.close()

                // Save image path to SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("imagePath", file.absolutePath)
                editor.apply()

                // Display image in ImageView
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                imageView.setImageBitmap(bitmap)
            }
        }
    }
    private fun LoadFields() {
        val text1 = sharedPreferences2.getString("MyName", "")
        val text2 = sharedPreferences2.getString("MyPosition", "")
        val text3 = sharedPreferences2.getString("MyContact", "")
        val text4 = sharedPreferences2.getString("MyEmail", "")

        myName.text = text1
        position.text = text2
        contact.text = text3
        email.text = text4
    }
    private fun SaveFields()
    {
        val editor = sharedPreferences2.edit()
        myName.setOnClickListener{
                changeFields.visibility=View.VISIBLE
                saveChanges.visibility=View.VISIBLE
                saveChanges.setOnClickListener{
                myName.text=changeFields.text
                changeFields.visibility=View.INVISIBLE
                saveChanges.visibility=View.INVISIBLE
                editor.putString("MyName", changeFields.getText().toString()).apply()
                if (::preferencesHelper.isInitialized) {
                    preferencesHelper.setString(this,"MyName",changeFields.getText().toString())
                }

                changeFields.setText("")}

        }
        position.setOnClickListener{
            changeFields.visibility=View.VISIBLE
            saveChanges.visibility=View.VISIBLE
            saveChanges.setOnClickListener{
                position.text=changeFields.text
                changeFields.visibility=View.INVISIBLE
                saveChanges.visibility=View.INVISIBLE
                editor.putString("MyPosition", changeFields.getText().toString()).apply()
                changeFields.setText("")
            }

        }
        contact.setOnClickListener{
            changeFields.visibility=View.VISIBLE
            saveChanges.visibility=View.VISIBLE
            saveChanges.setOnClickListener{
                contact.text=changeFields.text
                editor.putString("MyContact", changeFields.getText().toString()).apply()
                changeFields.setText("")
                changeFields.visibility=View.INVISIBLE
                saveChanges.visibility=View.INVISIBLE }

        }
        email.setOnClickListener{
            changeFields.visibility=View.VISIBLE
            saveChanges.visibility=View.VISIBLE
            saveChanges.setOnClickListener{
                email.text=changeFields.text
                editor.putString("MyEmail", changeFields.getText().toString()).apply()
                changeFields.setText("")
                changeFields.visibility=View.INVISIBLE
                saveChanges.visibility=View.INVISIBLE }

        }
    }
    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}
