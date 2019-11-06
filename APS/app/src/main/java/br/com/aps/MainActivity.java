package br.com.aps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_INFO_TEXTO = "KEY_INFO_TEXTO";
    private Button botao_Cadastrar;
    private Button botao_Consultar;
    private EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao_Cadastrar = (Button) findViewById(R.id.btnCadastrar);
        botao_Consultar = (Button) findViewById(R.id.btnConsultar);


        botao_Cadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this, TelaCadastrarCliente.class);

                startActivity(it);
            }
        });

        botao_Consultar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this, TelaAlterarCliente.class);

                startActivity(it);
            }
        });



    }
}