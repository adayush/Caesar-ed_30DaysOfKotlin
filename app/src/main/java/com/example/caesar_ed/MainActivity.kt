package com.example.caesar_ed

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val encryptAction: Button = findViewById(R.id.encrypt)
        encryptAction.setOnClickListener { encrypt() }

        val decryptAction: Button = findViewById(R.id.decrypt)
        decryptAction.setOnClickListener { decrypt() }
    }

    private fun encrypt() {
        val plainText: EditText = findViewById(R.id.plain_text_input)
        val shiftInt: EditText = findViewById(R.id.shift)

        if(plainText.text.isEmpty()) { toast() }

        val plain = plainText.text.toString()
        val shift = shiftInt.text.toString().toInt()

        val result = StringBuffer()
        for (i in plain.indices) {
            if (Character.isUpperCase(plain[i])) {
                val ch = ((plain[i].toInt() +
                        shift - 65) % 26 + 65).toChar()
                result.append(ch)
            } else {
                val ch = ((plain[i].toInt() +
                        shift - 97) % 26 + 97).toChar()
                result.append(ch)
            }
        }
        output(result.toString())
    }

    private fun decrypt() {
        val plainText: EditText = findViewById(R.id.plain_text_input)
        val shiftInt: EditText = findViewById(R.id.shift)

        if(plainText.text.isEmpty()) { toast() }

        val plain = plainText.text.toString()
        val shift = shiftInt.text.toString().toInt()

        val result = StringBuffer()
        for (i in plain.indices) {
            if (Character.isUpperCase(plain[i])) {
                val ch = ((plain[i].toInt() +
                        (26-shift) - 65) % 26 + 65).toChar()
                result.append(ch)
            } else {
                val ch = ((plain[i].toInt() +
                        (26-shift) - 97) % 26 + 97).toChar()
                result.append(ch)
            }
        }
        output(result.toString())
    }

    private fun output(result: String) {
        val resultText: TextView = findViewById(R.id.plain_text_output)
        resultText.text = result
    }

    private fun toast() {
        Toast.makeText(this, "Enter valid values", Toast.LENGTH_LONG).show()
        return
    }
}