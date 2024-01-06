package com.example.samplelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.example.samplelogin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: LoginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){

        listenAlways()
      /*  binding.btnSubmit.setOnClickListener {
           // checkAllFields()
        }*/
        viewModel.mapFunction()
    }

    private fun listenAlways(){

        binding.etUserName.addTextChangedListener{
            binding.btnSubmit.isEnabled = formValidation()
        }
        binding.etPassword.addTextChangedListener {
          binding.btnSubmit.isEnabled =   formValidation()
            if(binding.etPassword.length() < 8){
                binding.etPassword.error = viewModel.getUserNameErrorMessage()
            }
        }
    }

    private fun formValidation() : Boolean{
       return binding.etUserName.length() > 0 &&
                binding.etPassword.length() > 8
    }

    private fun checkAllFields(){

        if(binding.etUserName.length() == 0){
            binding.etUserName.error = "Please enter Username"
        }
        if(binding.etPassword.length() < 8){
            binding.etPassword.error = "Enter minimum 8 characters"
        }
    }
}