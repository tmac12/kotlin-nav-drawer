package it.tmac12.kotlinnavdrawer

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import it.tmac12.kotlinnavdrawer.util.replaceFragmentInActivity
import it.tmac12.kotlinnavdrawer.view.fragment.Fragment_One
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.toast
import android.R.attr.fragment
import android.support.v4.app.Fragment
import it.tmac12.kotlinnavdrawer.view.fragment.FragmentOnePresenter
import it.tmac12.kotlinnavdrawer.view.fragment.Fragment_Two


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            snackbar(view,"Hi!","Action"){toast("Azione!!")}
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, fragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                toast("Click Camera")


                /*
                //from google sample
                val fragmentOne = supportFragmentManager.findFragmentById(R.id.contentFrame)
                        as Fragment_One? ?: Fragment_One.newInstance().also {
                    replaceFragmentInActivity(it, R.id.contentFrame)
                }
                */

                //my way
                /*
                supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, Fragment_One.newInstance()).commit()
                        */
                navigateTo(Fragment_One.newInstance())

            }
            R.id.nav_gallery -> {
                toast("Nav gallery")

                /*
                supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, Fragment_Two.newInstance()).commit()
                */
                navigateTo(Fragment_Two.newInstance())

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {
                drawer_layout!!.closeDrawers()
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
