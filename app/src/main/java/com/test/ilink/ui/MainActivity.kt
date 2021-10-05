package com.test.ilink.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.test.ilink.R
import com.test.ilink.presentation.ImagePresenter

class MainActivity : AppCompatActivity(), IMainView {
    private val presenter = ImagePresenter(this)
    lateinit var imageView: ImageView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnShowCat = findViewById(R.id.btnCat) as Button
        btnShowCat.setOnClickListener {
            presenter.onShowCatClick()
        }
        val btnShowDuck = findViewById(R.id.btnDuck) as Button
        btnShowDuck.setOnClickListener {
            presenter.onShowDuckClick()
        }
        imageView = findViewById(R.id.iv)
        progressBar = findViewById(R.id.progress)
    }

    override fun loadImage(url: String) {
        imageView.visibility = View.VISIBLE
        Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .into(imageView);
    }

    override fun showErrorMessage() {
        Toast.makeText(applicationContext, R.string.error, Toast.LENGTH_LONG).show()
    }

    override fun setProgressVisibility(value: Int) {
        progressBar.visibility = value
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}