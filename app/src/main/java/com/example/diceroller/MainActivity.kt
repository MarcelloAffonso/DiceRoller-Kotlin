package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // ImageView do dado
    // lateinit -> avisa pro compilador que essa variável não será nula
    lateinit var diceImage: ImageView

    // Variável numérica para representação do dado
    var diceValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa o botão
        val rollButton: Button = findViewById(R.id.roll_button)

        // Troca o texto do botão
        rollButton.text = getString(R.string.lets_roll_baby)

        // Seta um listener no botão
        rollButton.setOnClickListener {
            rollDice()
        }

        // Instancia o ImageView que carrega a imagem do dado
        diceImage = findViewById(R.id.dice_image)
    }

    // Simula a rolagem de um dado e seta o resource do ImageView com a imagem que corresponde ao valor obtido
    private fun rollDice() {
        // Captura um valor entre 0 e 5 e soma 1 ao resultado, simulando o rolar de um dado
        val randomInt = Random.nextInt(6) + 1

        // Se repetir o valor, exibe Toast informando a repetição
        if(randomInt == this.diceValue){
            Toast.makeText(this,
                "WOW! It rolled " + this.diceValue.toString() + " again!",
                Toast.LENGTH_SHORT).show()
        }

        // O valor gerado passa a ser o valor atual do dado
        this.diceValue = randomInt;

        // Seleciona a imagem correspondente ao valor obtido
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Atualiza a imagem do dado
        diceImage.setImageResource(drawableResource)
    }

}