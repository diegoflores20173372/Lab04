package org.idnp.datastoresamplegra

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.fonts.Font
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
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

        val edtPA: EditText = findViewById(R.id.edtPA)
        val edtEP: EditText = findViewById(R.id.edtEP)
        val edtCA: EditText = findViewById(R.id.edtCA)
        val edtNA: EditText = findViewById(R.id.edtNA)
        val edtS: EditText = findViewById(R.id.edtS)
        val edtD: EditText = findViewById(R.id.edtD)
        val btnSaveInfo: Button = findViewById(R.id.btnSaveFormData)
        lifecycleScope.launch {
            dataLab04.academicPeriod.collect { aP ->
                edtPA.setText(aP)
            }
        }
        lifecycleScope.launch {
            dataLab04.professionalSchool.collect { pS ->
                edtEP.setText(pS)
            }
        }
        lifecycleScope.launch {
            dataLab04.courseCode.collect { cC ->
                edtCA.setText(cC)
            }
        }
        lifecycleScope.launch {
            dataLab04.courseName.collect { cN ->
                edtNA.setText(cN)
            }
        }
        lifecycleScope.launch {
            dataLab04.semester.collect { s ->
                edtS.setText(s)
            }
        }
        lifecycleScope.launch {
            dataLab04.duration.collect { d ->
                edtD.setText(d)
            }
        }
        btnSaveInfo.setOnClickListener {
            lifecycleScope.launch {
                dataLab04.saveDataCourse(
                    edtPA.text.toString(),
                    edtEP.text.toString(),
                    edtCA.text.toString(),
                    edtNA.text.toString(),
                    edtS.text.toString(),
                    edtD.text.toString()
                )
            }
        }

        //Change background color
        val layoutFull: LinearLayout = findViewById(R.id.mainContainer)
        val edtColorName: EditText = findViewById(R.id.edtColorBack)
        val buttonColorBack: Button = findViewById(R.id.btnColorBack)
        buttonColorBack.setOnClickListener {
            when (edtColorName.text.toString()) {
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
                else -> {
                    lifecycleScope.launch {
                        dataLab04.backgroundColor.collect { myColor ->
                            layoutFull.setBackgroundColor(Integer.parseInt(myColor.toString()))
                        }
                    }
                }
            }
        }

        //Change Font
        val txtPA: TextView = findViewById(R.id.txtPA)
        val txtEP: TextView = findViewById(R.id.txtEP)
        val txtCA: TextView = findViewById(R.id.txtCA)
        val txtNA: TextView = findViewById(R.id.txtNA)
        val txtS: TextView = findViewById(R.id.txtS)
        val txtD: TextView = findViewById(R.id.txtD)
        val txtChangeBack: TextView = findViewById(R.id.txtChangeBackColor)
        val txtChangeFont: TextView = findViewById(R.id.txtChangeFont)
        val txtChangeSize: TextView = findViewById(R.id.txtChangeSize)
        val edtFont: EditText = findViewById(R.id.edtFont)
        val buttonFont: Button = findViewById(R.id.btnFont)
        buttonFont.setOnClickListener {
            when (edtFont.text.toString()) {
                "Black" -> {
                    lifecycleScope.launch {
                        dataLab04.saveFontText("sans-serif-black")
                        dataLab04.fontText.collect { myFont ->
                            txtPA.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtEP.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtCA.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtNA.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtS.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtD.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtChangeBack.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtChangeFont.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtChangeSize.typeface = Typeface.create(myFont, Typeface.BOLD)
                        }
                    }
                }
                "Monospace" -> {
                    lifecycleScope.launch {
                        dataLab04.saveFontText("sans-serif-condensed")
                        dataLab04.fontText.collect { myFont ->
                            txtPA.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtEP.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtCA.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtNA.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtS.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtD.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtChangeBack.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtChangeFont.typeface = Typeface.create(myFont, Typeface.BOLD)
                            txtChangeSize.typeface = Typeface.create(myFont, Typeface.BOLD)
                        }
                    }
                }
                "Sans Serif" -> {
                    lifecycleScope.launch {
                        dataLab04.saveFontText("sans-serif-medium")
                        dataLab04.fontText.collect { myFont ->
                            txtPA.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtEP.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtCA.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtNA.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtS.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtD.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtChangeBack.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtChangeFont.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            txtChangeSize.typeface = Typeface.create(myFont, Typeface.NORMAL)
                        }
                    }
                }
                else -> {
                    lifecycleScope.launch {
                        dataLab04.fontText.collect { myFont ->
                            if (myFont == "sans-serif-medium") {
                                txtPA.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtEP.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtCA.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtNA.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtS.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtD.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtChangeBack.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtChangeFont.typeface = Typeface.create(myFont, Typeface.NORMAL)
                                txtChangeSize.typeface = Typeface.create(myFont, Typeface.NORMAL)
                            } else {
                                txtPA.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtEP.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtCA.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtNA.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtS.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtD.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtChangeBack.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtChangeFont.typeface = Typeface.create(myFont, Typeface.BOLD)
                                txtChangeSize.typeface = Typeface.create(myFont, Typeface.BOLD)
                            }
                        }
                    }
                }
            }
        }

        //Change Size
        //We use the same TextView in the last exercise
        val edtSize: EditText = findViewById(R.id.edtSize)
        val buttonSize: Button = findViewById(R.id.btnSize)
        buttonSize.setOnClickListener {
            val fontSize = edtSize.text.toString()
            if (fontSize == "") {
                lifecycleScope.launch {
                    dataLab04.sizeText.collect { mySizeText ->
                        txtPA.textSize = mySizeText
                        txtEP.textSize = mySizeText
                        txtCA.textSize = mySizeText
                        txtNA.textSize = mySizeText
                        txtS.textSize = mySizeText
                        txtD.textSize = mySizeText
                        txtChangeBack.textSize = mySizeText
                        txtChangeFont.textSize = mySizeText
                        txtChangeSize.textSize = mySizeText
                    }
                }
            } else {
                lifecycleScope.launch {
                    dataLab04.saveSizeText(fontSize.toFloat())
                    dataLab04.sizeText.collect { mySizeText ->
                        txtPA.textSize = mySizeText
                        txtEP.textSize = mySizeText
                        txtCA.textSize = mySizeText
                        txtNA.textSize = mySizeText
                        txtS.textSize = mySizeText
                        txtD.textSize = mySizeText
                        txtChangeBack.textSize = mySizeText
                        txtChangeFont.textSize = mySizeText
                        txtChangeSize.textSize = mySizeText
                    }
                }
            }
        }
    }
}