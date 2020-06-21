package com.example.mysecondgridapp


import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.learn_more.*


class LearnMore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.learn_more)
        var bundle :Bundle ?=intent.extras

        webViewLearnMore.setWebViewClient(WebViewClient())

        webViewLearnMore.loadUrl(bundle!!.getString("url"))

    }

}