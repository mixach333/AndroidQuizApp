package com.mix333.androidquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

fun RadioGroup.getCheckedText(view: View) : String{
    val checkedId = this.checkedRadioButtonId
    var result = ""
    if(checkedId!=-1){
        result = (view.findViewById<RadioButton>(checkedId)).text.toString()
    }
    return result
}
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isGone = MutableStateFlow(false)
        // for fun and for future complex time-consuming starting logic
        installSplashScreen().setKeepOnScreenCondition{
            isGone.value
        }
        lifecycleScope.launch{
            delay(1500)
            isGone.value = true
        }
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}