package com.onuremren.googleyemekapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager.widget.ViewPager
import com.onuremren.googleyemekapp.viewPager.SliderItemAdapter
import com.onuremren.googleyemekapp.databinding.ActivityMainBinding
import com.onuremren.googleyemekapp.model.OrderViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var viewPager: ViewPager
    val sharedViewModel  by viewModels<OrderViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GoogleYemekApp)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       val navHostFragment = supportFragmentManager
           .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

       setupActionBarWithNavController(navController)

   }
   override fun onSupportNavigateUp(): Boolean {

       return navController.navigateUp() || super.onSupportNavigateUp()
   }
}