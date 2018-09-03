package com.pencelab.testproject

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private var root: Node? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewVersion.text = this.getApplicationVersion()


        /*val node10: Node = Node(null, null)

        val node7: Node = Node(null, null)
        val node8: Node = Node(null, null)
        val node9: Node = Node(node10, null)

        val node4: Node = Node(null, node7)
        val node5: Node = Node(null, null)
        val node6: Node = Node(node8, node9)

        val node2: Node = Node(node4, node5)
        val node3: Node = Node(null, node6)

        val node1: Node = Node(node2, node3)*/

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

    private fun getApplicationVersion() : String {
        val versionCode = BuildConfig.VERSION_CODE
        val versionName = BuildConfig.VERSION_NAME

        return "Version: $versionName (code $versionCode)"
    }

    private fun openMarket(){
        try {
            val playStoreURI: Uri = Uri.parse("market://details?id=$packageName")
            val intent = Intent(Intent.ACTION_VIEW, playStoreURI)
            startActivity(intent)
        }catch (exp:Exception){
            val playStoreURI: Uri = Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
            val intent = Intent(Intent.ACTION_VIEW, playStoreURI)
            startActivity(intent)
        }
    }
}
