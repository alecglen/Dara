package com.example.test.practiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

const val EXTRA_MESSAGE = "com.example.practiceapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    private val random = SecureRandom()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the send button */
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val chars = message.toCharArray()
        val salt = getNextSalt()
        val hashed = hashPassword(chars, salt, 5, 256)
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, hashed.toString())
        }
        startActivity(intent)
    }

    private fun getNextSalt(): ByteArray {
        val salt = ByteArray(32)
        random.nextBytes(salt)
        return salt
    }

    private fun hashPassword(password: CharArray, salt: ByteArray, iterations: Int, keyLength: Int): ByteArray {

        try {
            val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
            val spec = PBEKeySpec(password, salt, iterations, keyLength)
            val key = skf.generateSecret(spec)
            return key.encoded

        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        } catch (e: InvalidKeySpecException) {
            throw RuntimeException(e)
        }

    }
}
