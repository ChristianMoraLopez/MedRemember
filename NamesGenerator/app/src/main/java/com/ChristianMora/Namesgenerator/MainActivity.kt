package com.ChristianMora.Namesgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ChristianMora.Namesgenerator.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    private fun  newNames ()
    {



    }

    fun generateName(nameLength : Int) :String
    {
        var r = Random()
        val consonants = arrayOf("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "l", "n", "p", "q", "r", "s", "sh", "zh", "t", "v", "w", "x", "z")
        val vowels = arrayOf("a", "e", "i", "o", "u", "ae", "y")
        var Name = ""
        Name += consonants[r.nextInt(consonants.size)].uppercase()
        Name += vowels[r.nextInt(vowels.size)].lowercase()

        var letters = 2
        while (letters < nameLength)
        {
            Name +=  consonants[r.nextInt(consonants.size)]
            letters++
            Name +=  vowels[r.nextInt(vowels.size)]
            letters++

        }

        return Name

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var textView = findViewById<EditText>(R.id.LengthName)

        val submitButton = findViewById<Button>(R.id.button_first)
        val displayMessage=findViewById<TextView>(R.id.nameResponse)
        submitButton.setOnClickListener{
            var textAsString = textView.text.toString().toInt()
            val newName =generateName(textAsString)
            displayMessage.text = "El nombre generado es: \n $newName"
        }

        textView.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                var textAsString = textView.text.toString().toInt()
                val newName =generateName(textAsString)
                displayMessage.text = "El nombre generado es: \n $newName"
                true
            } else {
                false
            }

        }

        val restartButton = findViewById<Button>(R.id.restart)
        restartButton.setOnClickListener{
            textView.text = null
            recreate()
        }

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


    }





    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }


}








