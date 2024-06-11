package com.example.noterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.example.noterapp.databinding.ActivityQuoteBinding
import java.lang.Exception

class QuoteActivity : AppCompatActivity() {
    lateinit var binding : ActivityQuoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)

        //coba buat intent ke MainActivity tapi gagal

//        val bnoter = findViewById<Button>(R.id.noter)
//        bnoter.setOnClickListener {
//        val Intent = Intent(this,MainActivity::class.java)
//            startActivity(Intent)
//        }

        setContentView(binding.root)

        getQuote()

        binding.nextBtn.setOnClickListener {
            getQuote()
        }
    }

    private fun getQuote(){
        setInProgress(true)

        GlobalScope.launch {
            try{
                val response = RetrofitInstance.quoteApi.getRandomQuote()
                runOnUiThread {
                    setInProgress(false)
                    response.body()?.first()?.let {
                        setUI(it)
                    }
                }

            }catch (e : Exception){
                runOnUiThread {
                    setInProgress(false)
                    Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun setUI(quote : QuoteModel){
        binding.quoteTv.text = quote.q
        binding.authorTv.text = quote.a
    }

    private fun setInProgress(inProgress : Boolean){
        if(inProgress){
            binding.progressBar.visibility = View.VISIBLE
            binding.nextBtn.visibility = View.GONE
        }else{
            binding.progressBar.visibility = View.GONE
            binding.nextBtn.visibility = View.VISIBLE
        }
    }
}