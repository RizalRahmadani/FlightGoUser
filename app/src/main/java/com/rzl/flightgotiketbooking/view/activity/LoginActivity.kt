package com.rzl.flightgotiketbooking.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.rzl.flightgotiketbooking.R
import com.rzl.flightgotiketbooking.databinding.ActivityLoginBinding
import com.rzl.flightgotiketbooking.view.fragment.HomesFragment
import com.rzl.flightgotiketbooking.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    private lateinit var  auth : FirebaseAuth
    private lateinit var  googleSignInClient : GoogleSignInClient
    private lateinit var viewModel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //btn
        binding.btnSignIn.setOnClickListener{
            startActivity(Intent(this@LoginActivity, MainActivity::class.java) )
        }
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }


        //sign google
         auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.btnGoogle.setOnClickListener {
            signInGoole()
        }
    }

    private fun signInGoole() {
        val signInItent = googleSignInClient.signInIntent
        launcher.launch(signInItent)
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResult(task)
        }
    }

    private fun loginAction() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (email == "" && password ==""){
            binding.itlEmail.error = "Please fill out this field."
            binding.itlPassword.error = "Please fill out this field."
        }else{
            viewModel.saveLoginStatus(true)
            viewModel.apiLogin(email, password)
            viewModel.LoginLive().observe(this){
                if (it != null){
                    //save token to Data Store
                    viewModel.saveData(it.data.role, it.data.accessToken)
                    Log.d("ACCESS TOKEN: ", it.data.accessToken)
                    val intent = Intent(this@LoginActivity, HomesFragment::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "Halo ${it.data.role}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun handleResult(task: Task<GoogleSignInAccount>) {
            if(task.isSuccessful){
                val account : GoogleSignInAccount? = task.result
                if (account != null){
                    updateUI(account)
                }
            }else{
                Toast.makeText(this,task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener{
            if(it.isSuccessful){
                val  intent : Intent = Intent (this, MainActivity::class.java)
                intent.putExtra("name", account.displayName)
                startActivity(intent)
            }else{
                Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}