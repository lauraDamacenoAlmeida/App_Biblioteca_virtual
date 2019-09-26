package br.com.aps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class TelaCadastrar extends AppCompatActivity {
    private Button botaoCliente;
    private Button botaoCategoriaLeitores;
    private Button botaoCategoriaLivros;
    private Button botaoLivros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);
        botaoCliente = (Button) findViewById(R.id.btnCliente);
        botaoCategoriaLeitores = (Button) findViewById(R.id.btnCatLeitores);
        botaoCategoriaLivros = (Button) findViewById(R.id.btnCatLivros);
        botaoLivros = (Button) findViewById(R.id.btnLivros);

        botaoCliente.setOnClickListener((new View.OnClickListener(){
            public void onClick(View v) {

                Intent it = new Intent(TelaCadastrar.this, cadastrarClientes.class);
                startActivity(it);

            }
        }));


    }
}
