package com.lucien3344.progress_view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        circleProgressBar.setDoProgress(50f, "分")
        progresline_sys.setDoProgress("说一说", 80.0f, "%")
        progresline_xyx.setProgress(25.0f, "MB/100MB")

    }
}
