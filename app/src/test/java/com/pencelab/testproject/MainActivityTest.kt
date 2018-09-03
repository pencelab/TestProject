package com.pencelab.testproject

import android.app.Activity
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import android.content.Intent
import android.net.Uri
import org.robolectric.fakes.RoboMenuItem
import org.junit.Assert.*
import org.robolectric.RuntimeEnvironment
import org.mockito.Mockito

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    fun setUp(){
        this.mainActivity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun clickingMenuGooglePlay_shouldLaunchIntentFromTryBlock(){
        val expectedIntent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${RuntimeEnvironment.application.packageName}"))
        this.mainActivity.onOptionsItemSelected(RoboMenuItem(R.id.menu_google_play))
        val shadowActivity = Shadows.shadowOf(this.mainActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        assertTrue(expectedIntent.filterEquals(startedIntent))
    }

    @Test
    fun clickingMenuGooglePlay_shouldLaunchIntentFromCatchBlock(){
        val spyActivity: Activity = Mockito.spy(this.mainActivity)
        Mockito.doThrow(RuntimeException()).doCallRealMethod().`when`(spyActivity).startActivity(Mockito.any())

        val expectedIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=${RuntimeEnvironment.application.packageName}"))
        spyActivity.onOptionsItemSelected(RoboMenuItem(R.id.menu_google_play))
        val shadowActivity = Shadows.shadowOf(spyActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        assertTrue(expectedIntent.filterEquals(startedIntent))
    }
}