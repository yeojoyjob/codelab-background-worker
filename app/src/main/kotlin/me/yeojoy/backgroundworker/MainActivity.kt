package me.yeojoy.backgroundworker

import android.app.Activity
import android.os.Bundle


/**
 * This project is to implement background worker in android application.
 * So I made a mimic with codelab in https://developer.android.com/codelabs/android-workmanager#0
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}