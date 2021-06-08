package com.example.appgilbertoecommerce

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class InfoProduto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_produto)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //Slaid aula11 pag 9
    }
}