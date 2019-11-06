package br.com.aps;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;


public class cadastrarClientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_clientes);
        Button btnCadastrar = (Button)findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BancoController crud = new BancoController(getBaseContext());

                EditText nome = (EditText)findViewById(R.id.nome);
                EditText endereco = (EditText)findViewById((R.id.endereco));
                EditText celular = (EditText)findViewById(R.id.celular);
                EditText email = (EditText)findViewById(R.id.email);
                EditText cpf = (EditText)findViewById(R.id.cpf);
                EditText data_nascimento = (EditText)findViewById(R.id.data_nascimento);
                EditText categoria_leitor = (EditText)findViewById(R.id.categoria_leitor);

                String nomeString = nome.getText().toString();
                String enderecoString = endereco.getText().toString();
                String celularString = celular.getText().toString();
                String emailString = email.getText().toString();
                String cpfString = cpf.getText().toString();
                String nascimentoString = data_nascimento.getText().toString();
                String catLeitorString = categoria_leitor.getText().toString();

                String resultado;
                resultado = crud.insereCliente(nomeString,enderecoString,celularString,emailString,cpfString,nascimentoString,catLeitorString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


            };
    });
}
}