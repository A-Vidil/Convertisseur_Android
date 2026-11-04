package fr.btsciel.demo1

import android.R.attr.button
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val df = DecimalFormat("#.##")
    private val taux:Double = 1.89
    private var haut = 0.0
    private var bas = 0.0

    private lateinit var edHaut : EditText
    private lateinit var edBas : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edHaut = findViewById(R.id.editTextHaut)
        edBas = findViewById(R.id.editTextBas)

      val  buttonBas = findViewById<ImageButton>(R.id.buttonBas)
      val  buttonHaut = findViewById<ImageButton>(R.id.buttonHaut)

        buttonBas.setOnClickListener(){
            Log.d("deb","Button bas clicked")
            haut = edHaut .text.toString().replace(",",".").toDoubleOrNull()?:0.0

            if(haut > 0.0){
                bas = haut * taux
                edBas.setText(df.format(bas))
                Toast.makeText(this, "cool", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Erreur de saisie", Toast.LENGTH_SHORT).show()
            }
        }

        buttonHaut.setOnClickListener(){
            Log.d("deb","Button bas clicked")
            bas = edBas .text.toString().replace(",",".").toDoubleOrNull()?:0.0
            if(bas > 0.0) {
                haut = bas / taux
                edHaut.setText(df.format(haut))
                Toast.makeText(this, "cool", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Erreur de saisie", Toast.LENGTH_SHORT).show()

            }

        }



        }
    }