package com.example.gameinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gameinformation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.searchFragment
            )
        )

    //    setupActionBarWithNavController(navController, appBarConfiguration)
     //  navController.addOnDestinationChangedListener{_,destination,_->
     //      when(destination.id){
     //          R.id.homeFragment, R.id.favoriteFragment ->{
     //              binding.navView.visibility = View.VISIBLE
     //              supportActionBar?.show()
     //          }

     //          R.id.splashFragment, R.id.authFragment ->{
     //              binding.navView.visibility = View.GONE
     //              supportActionBar?.hide()
     //          }
     //      }
     //  }

      // if (supportFragmentManager.findFragmentById(R.id.splashFragment) is AuthFragment) {
      //     supportActionBar?.hide()
      // }


        navView.setupWithNavController(navController)
    }
}