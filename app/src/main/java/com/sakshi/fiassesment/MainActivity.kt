package com.sakshi.fiassesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sakshi.fiassesment.databinding.ActivityMainBinding
import com.sakshi.fiassesment.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        addObservers()
    }

    private fun addObservers() {
        viewModel.showToast.observe(this, {
            if (it) Toast.makeText(this, "Details Submitted Successfully", Toast.LENGTH_SHORT)
                .show()
            this.finish()

        })

        viewModel.dismissActivity.observe(this, {
            this.finish()
        })
    }
}