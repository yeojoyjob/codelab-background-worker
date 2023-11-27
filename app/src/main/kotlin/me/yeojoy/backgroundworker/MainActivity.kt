package me.yeojoy.backgroundworker

import android.app.Activity
import android.os.Bundle
import android.widget.Button


/**
 * This project is to implement background worker in android application.
 * So I made a mimic with codelab in https://developer.android.com/codelabs/android-workmanager#0
 */
class MainActivity : Activity() {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainViewModelFactory(application).create(MainViewModel::class.java)

        findViewById<Button>(R.id.go_button).setOnClickListener {
            viewModel?.applyBlur(1)
        }
    }
}