package com.pencelab.testproject

import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowActivity
import android.content.Intent
import org.robolectric.fakes.RoboMenuItem
import org.junit.Assert.*


@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    fun setUp(){
        this.mainActivity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun clickingMenuGooglePlay_shouldLaunchIntent() {
        val item = RoboMenuItem(R.id.menu_google_play)
        this.mainActivity.onOptionsItemSelected(item)
        val shadowActivity: ShadowActivity = Shadows.shadowOf(this.mainActivity)
        val startedIntent: Intent = shadowActivity.nextStartedActivity
        assertEquals(startedIntent.action, Intent.ACTION_VIEW)
    }
}