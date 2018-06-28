package com.lucien3344.progress_view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        circleProgressBar.setDoProgress(56f, "分")
        progresline_sys.setDoProgress("说一说", 82.0f, "%")
        progresline_xyx.setDoProgress("学一学", 25.6f, "%")

    }
}
