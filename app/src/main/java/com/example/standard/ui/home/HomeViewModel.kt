package com.example.standard.ui.home

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var TAG = HomeViewModel::class.java.simpleName
    var count = 0
    lateinit var timer: CountDownTimer
    var _seconds =  MutableLiveData<Int>()



    fun startTime() {
        timer = object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                _seconds.value = millisUntilFinished.toInt()/1000
                Log.i(TAG,"time left = "+millisUntilFinished.toInt())
            }

            override fun onFinish() {
                Log.i(TAG, "timer  finished")
            }
        }.start()

    }


    fun increaseCount(){
        count++
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}