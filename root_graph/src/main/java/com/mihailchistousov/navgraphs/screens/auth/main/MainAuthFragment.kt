package com.mihailchistousov.navgraphs.screens.auth.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.setupWithNavController

class MainAuthFragment: Fragment(R.layout.main) {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(activity, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        if(savedInstanceState == null)
            view.findViewById<NavigationView>(R.id.navView).init(childFragmentManager)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        view?.findViewById<NavigationView>(R.id.navView).init(childFragmentManager)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)

    }

    private fun NavigationView?.init(fragmentManager: FragmentManager) {
        val navGraphIds = listOf(R.navigation.nav_main_auth, R.navigation.nav_maps, R.navigation.nav_settings)
        this?.menu?.findItem(R.id.main_auth)?.isChecked = true
        this?.setupWithNavController(
            drawerLayout = view?.findViewById(R.id.drawerLayout),
            navGraphIds = navGraphIds,
            fragmentManager = fragmentManager,
            containerId = R.id.drawer_nav_host_container,
        )
    }

}