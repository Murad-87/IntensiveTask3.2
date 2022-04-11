package com.example.myintensivetask32

import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.example.myintensivetask32.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showPicture()

    }

    private fun showPicture() {
        val glide = Glide.with(this)
        with(binding) {
            editT.addTextChangedListener { url ->
                if (isUrlValid(url.toString())) {
                    glide.load(url.toString())
                        .error(R.drawable.ic_error)
                        .centerCrop()
                        .into(imageView)
                } else {
                    Toast.makeText(this@MainActivity, "Ошибка", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isUrlValid(url: String) = URLUtil.isValidUrl(url)

}




