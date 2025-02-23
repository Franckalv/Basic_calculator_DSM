package com.example.basic_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val FirstNumTxt: TextView= findViewById(R.id.TxtFirstNum)
        val SecondNumTxt:TextView = findViewById(R.id.TxtSecondNum)
        val LblResult: TextView = findViewById(R.id.LblResult)

        val SumButton : Button = findViewById(R.id.btnSum)
        val ResButton : Button = findViewById(R.id.btnRes)
        val MulButton : Button = findViewById(R.id.btnMul)
        val DivButton : Button = findViewById(R.id.btnDiv)

        SumButton.setOnClickListener{

            val FirstNum: String = FirstNumTxt.getText().toString()
            val SecondNum: String = SecondNumTxt.getText().toString()

            if(isValidInput(FirstNum, SecondNum)){
                val FirstNumSum: Float = FirstNum.toFloat()
                val SecondNumSum: Float = SecondNum.toFloat()

                val resultado:Float = FirstNumSum + SecondNumSum;
                LblResult.text = String.format(Locale.getDefault(), "%.2f", resultado)
            }
        }

        ResButton.setOnClickListener{

            val FirstNum: String = FirstNumTxt.getText().toString()
            val SecondNum: String = SecondNumTxt.getText().toString()

            if(isValidInput(FirstNum, SecondNum)){
                val FirstNumSum: Float = FirstNum.toFloat()
                val SecondNumSum: Float = SecondNum.toFloat()

                val resultado:Float = FirstNumSum - SecondNumSum;
                LblResult.text = String.format(Locale.getDefault(), "%.2f", resultado)
            }
        }

        MulButton.setOnClickListener{

            val FirstNum: String = FirstNumTxt.getText().toString()
            val SecondNum: String = SecondNumTxt.getText().toString()

            if(isValidInput(FirstNum, SecondNum)){
                val FirstNumSum: Float = FirstNum.toFloat()
                val SecondNumSum: Float = SecondNum.toFloat()

                val resultado:Float = FirstNumSum * SecondNumSum;
                LblResult.text = String.format(Locale.getDefault(), "%.2f", resultado)
            }
        }

        DivButton.setOnClickListener{

            val FirstNum: String = FirstNumTxt.getText().toString()
            val SecondNum: String = SecondNumTxt.getText().toString()

            if(isValidInput(FirstNum, SecondNum)){
                val FirstNumSum: Float = FirstNum.toFloat()
                val SecondNumSum: Float = SecondNum.toFloat()

                if(SecondNumSum == 0F){
                    Toast.makeText(this, "No se puede dividir entre 0 ningún número", Toast.LENGTH_SHORT).show()
                }
                else{
                    val resultado:Float = FirstNumSum / SecondNumSum;
                    LblResult.text = String.format(Locale.getDefault(), "%.2f", resultado)
                }
            }
        }
    }

    private fun isValidInput(inputText: String?, inputText2: String?): Boolean {
        if (inputText.isNullOrEmpty() || inputText2.isNullOrEmpty()) {
            Toast.makeText(this, "No se puede dejar vacío el espacio", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
