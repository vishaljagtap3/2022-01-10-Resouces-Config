package com.bitcode.resources

import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bitcode.resources.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var config = resources.configuration

        if(lastCustomNonConfigurationInstance != null && lastCustomNonConfigurationInstance is User){
            Toast.makeText(this, "got the data", Toast.LENGTH_LONG).show()
            binding.txtInfo.text = "Got back: " + (lastCustomNonConfigurationInstance as User).name
        }

        binding.btnSetInfo.setOnClickListener {
            binding.txtInfo.text = binding.edtInfo.text.toString()
        }

        var welcomeMessage = resources.getString(R.string.welcome_message)
        var cities = resources.getStringArray(R.array.cities)
        for(city in cities) {
            Log.e("tag", city)
        }
        var codes = resources.getIntArray(R.array.codes)
        var code = resources.getInteger(R.integer.enc_code)

        var drawable : Drawable = resources.getDrawable(R.drawable.ic_launcher_background)

        var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        Log.e("tag", "$welcomeMessage")
        Log.e("tag", "$cities")
        Log.e("tag", "$codes")
        Log.e("tag", "$code")
        resources.getBoolean(R.bool.isPassword)
        resources.getColor(R.color.bgColor)
        resources.getDimension(R.dimen.txt_height)
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        //if(newConfig.locale.displayLanguage)
        if(newConfig.keyboard == Configuration.KEYBOARD_12KEY) {

        }

        if(newConfig.touchscreen == Configuration.TOUCHSCREEN_FINGER){

        }

    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        Toast.makeText(this, "onRetainCalled", Toast.LENGTH_LONG).show()
        return User(binding.txtInfo.text.toString())
    }

}