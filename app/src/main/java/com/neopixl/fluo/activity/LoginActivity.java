package com.neopixl.fluo.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.neopixl.fluo.R;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Une fois la vue chargée, je peux récupérer mon editText créé dans le fichier xml
        // par son id : login_edittext_username
        loginEditText = (EditText) findViewById(R.id.login_edittext_username);

        passwordEditText = (EditText) findViewById(R.id.login_edittext_password);

        findViewById(R.id.login_button_signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Récupération de la valeur saisie par l'utilisateur
                String login = loginEditText.getText().toString();

                // Pour le récupérer sous forme d'entier
                // int age = Integer.parseInt(loginEditText.getText().toString());

                String password = passwordEditText.getText().toString();

                boolean isCredentialNotEmpty = !login.isEmpty() && !password.isEmpty();

                if (isCredentialNotEmpty) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Le login et le mot de passe ne sont pas vides.");
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    //builder.create().show();


                    // Intention de démarrer l'activité TVShowsActivity
                    Intent intent = new Intent(LoginActivity.this, TVShowsActivity.class);
                    // démarre l'écran via l'intent
                    startActivity(intent);

                    // Arrêter l'écran en cours
                    finish();


                }

            }
        });

    }
}
