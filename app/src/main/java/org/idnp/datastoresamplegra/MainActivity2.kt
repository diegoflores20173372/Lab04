package org.idnp.datastoresamplegra

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    private val Context.dataStore by preferencesDataStore(NotePrefs.PREFS_NAME)
    lateinit var notePrefs: NotePrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        notePrefs = NotePrefs(dataStore)

        var layoutConst: LinearLayout = findViewById(R.id.LayoutConst)
        var floatingActionButton: FloatingActionButton = findViewById(R.id.floatingActionButton)
        var nameColor: EditText = findViewById(R.id.etNameNewColor)
        var buttonSaveColor: Button = findViewById(R.id.btnSaveColor)

        layoutConst.setBackgroundColor(Color.RED)

        floatingActionButton.setOnClickListener {
            lifecycleScope.launch {
                notePrefs.backgroundColor.collect { mycolor ->
                    layoutConst.setBackgroundColor(Integer.parseInt(mycolor.toString()))
                }
            }
        }

        buttonSaveColor.setOnClickListener {
            var colorChoose = nameColor.text.toString()

            if(colorChoose == "negro"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.BLACK.toString())
                }
            }
            else if(colorChoose == "blue"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.BLUE.toString())
                }
            }
            else if(colorChoose == "cyan"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.CYAN.toString())
                }
            }
            else if(colorChoose == "dkgray"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.DKGRAY.toString())
                }
            }
            else if(colorChoose == "gray"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.GRAY.toString())
                }
            }
            else if(colorChoose == "green"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.GREEN.toString())
                }
            }
            else if(colorChoose == "ltgray"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.LTGRAY.toString())
                }
            }
            else if(colorChoose == "magenta"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.MAGENTA.toString())
                }
            }
            else if(colorChoose == "red"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.RED.toString())
                }
            }
            else if(colorChoose == "transparent"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.TRANSPARENT.toString())
                }
            }
            else if(colorChoose == "white"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.WHITE.toString())
                }
            }
            else if(colorChoose == "yellow"){
                lifecycleScope.launch {
                    notePrefs.saveNoteBackgroundColor(Color.YELLOW.toString())
                }
            }
        }

        val btnThirdActivity: Button = findViewById(R.id.btn_lab_04)
        btnThirdActivity.setOnClickListener {
            val intent = Intent(this, Lab04Activity::class.java)
            startActivity(intent)
        }

    }
}