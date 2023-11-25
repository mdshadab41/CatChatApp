package com.example.catchatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        //Configure the toolbar to include an Up button and display which screen you've navigate to
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//       val navController = navHostFragment.navController
//        val builder =  AppBarConfiguration.Builder(navController.graph)
//        val appBarConfiguration = builder.build()
//        toolbar.setupWithNavController(navController, appBarConfiguration)

        //implementing bottom navigation------------------
//        val bottomNavView  = findViewById<BottomNavigationView>(R.id.bottom_nav)
//        bottomNavView.setupWithNavController(navController)

        //cofigure to drawer layout with navigation

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
       val navController = navHostFragment.navController
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        val builder =  AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawer)
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //add menu rsource file to toolbar
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Navigate to a destination when an item's clicked
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)
    }
}