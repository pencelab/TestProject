package com.pencelab.testproject

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewVersion.setText(this.getApplicationVersion())
    }

    fun getApplicationVersion() : String {
        val versionCode = BuildConfig.VERSION_CODE
        val versionName = BuildConfig.VERSION_NAME

        return "Version: $versionName (code $versionCode)"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.menu_google_play -> this.openMarket()
        }
        return super.onOptionsItemSelected(item)
    }

    fun openMarket(){
        try {
            val playstoreuri: Uri = Uri.parse("market://details?id=" + packageName)
            val intent = Intent(Intent.ACTION_VIEW, playstoreuri)
            startActivity(intent)
        }catch (exp:Exception){
            val playstoreuri: Uri = Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)
            val intent = Intent(Intent.ACTION_VIEW, playstoreuri)
            startActivity(intent)
        }
    }
}
