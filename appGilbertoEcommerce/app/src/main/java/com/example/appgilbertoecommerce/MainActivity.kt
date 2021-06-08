package com.example.appgilbertoecommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView





class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //O lateinit não força a variável ser iniciada agora
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var textTitle: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.toogle_open, R.string.toggle_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        //Até no slid(59) da aula(Navigation drawable) estava com erro
        navigationView.setNavigationItemSelectedListener(this)


        val itemProduto: LinearLayout = findViewById(R.id.ll_itens_produtos)
        itemProduto.setOnClickListener {
            val intent: Intent = Intent(this, InfoProduto::class.java)
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.nav_home -> Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
            R.id.nav_count -> Toast.makeText(this, "Conta", Toast.LENGTH_LONG).show()
            R.id.nav_categoria -> Toast.makeText(this, "Categoria", Toast.LENGTH_LONG).show()
            R.id.nav_ordens -> Toast.makeText(this, "Compras", Toast.LENGTH_LONG).show()
            R.id.nav_carrinho -> Toast.makeText(this, "Carrinho", Toast.LENGTH_LONG).show()
            R.id.nav_logout -> Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}