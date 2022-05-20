package org.idnp.datastoresamplegra

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Lab04Activity : AppCompatActivity() {
    private val Context.dataStore by preferencesDataStore(Lab04Data.DATA_NAME)
    lateinit var dataLab04: Lab04Data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab04)

        dataLab04 = Lab04Data(dataStore)

        //Change background color
        var layoutFull: LinearLayout = findViewById(R.id.mainContainer)
        val edtColorName: EditText = findViewById(R.id.edtColorBack)
        val buttonColorBack: Button = findViewById(R.id.btnColorBack)
        buttonColorBack.setOnClickListener {
            when(edtColorName.text.toString()) {
                "negro" -> {
                    lifecycleScope.launch {
                        dataLab04.saveNoteBackgroundColor(Color.BLACK.toString())
                        dataLab04.backgroundColor.collect { myColor ->
                            layoutFull.setBackgroundColor(Integer.parseInt(myColor.toString()))
                        }
                    }
                }
                "azul" -> {
                    lifecycleScope.launch {
                        dataLab04.saveNoteBackgroundColor(Color.BLUE.toString())
                        dataLab04.backgroundColor.collect { myColor ->
                            layoutFull.setBackgroundColor(Integer.parseInt(myColor.toString()))
                        }
                    }
                }
                "verde" -> {
                    lifecycleScope.launch {
                        dataLab04.saveNoteBackgroundColor(Color.GREEN.toString())
                        dataLab04.backgroundColor.collect { myColor ->
                            layoutFull.setBackgroundColor(Integer.parseInt(myColor.toString()))
                        }
                    }
                }
                "gris" -> {
                    lifecycleScope.launch {
                        dataLab04.saveNoteBackgroundColor(Color.GRAY.toString())
                        dataLab04.backgroundColor.collect { myColor ->
                            layoutFull.setBackgroundColor(Integer.parseInt(myColor.toString()))
                        }
                    }
                }
                "amarillo" -> {
                    lifecycleScope.launch {
                        dataLab04.saveNoteBackgroundColor(Color.YELLOW.toString())
                        dataLab04.backgroundColor.collect { myColor ->
                            layoutFull.setBackgroundColor(Integer.parseInt(myColor.toString()))
                        }
                    }
                }
                "rojo" -> {
                    lifecycleScope.launch {
                        dataLab04.saveNoteBackgroundColor(Color.RED.toString())
                        dataLab04.backgroundColor.collect { myColor ->
                            layoutFull.setBackgroundColor(Integer.parseInt(myColor.toString()))
                        }
                    }
                }
            }
        }

        //Change Font


    }
}