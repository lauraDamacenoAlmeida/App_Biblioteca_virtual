package br.com.aps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class alterar_cliente extends AppCompatActivity {
    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_cliente);
       // codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());

        CPFCliente = (EditText)findViewById(R.id.editText4);
        NomeCliente = (EditText)findViewById(R.id.editText5);
        emailCliente = (EditText)findViewById(R.id.editText6);
        enderecoCliente = (EditText)findViewById(R.id.editText7);
        celularCliente = (EditText)findViewById(R.id.editText8);
        dataNascimentoCliente = (EditText)findViewById(R.id.editText9);
        CategoriaLeitorCliente = (EditText)findViewById(R.id.editText10);

        alterar = (Button)findViewById(R.id.button2);
        cursor = crud.carregaClienteByCPF(CPFCliente);

        NomeCliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.getNOME())));
        CPFCliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.getCPF())));
        emailCliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.getEMAIL())));
        enderecoCliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.getENDERECO())));
        celularCliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.getCELULAR())));
        dataNascimentoCliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.getDataNascimento())));
        CategoriaLeitorCliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.getCategoriaLeitor())));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crud.alteraCliente(
                        NomeCliente.getText().toString(),
                        CPFCliente.getText().toString(),
                        emailCliente.getText().toString(),
                        enderecoCliente.getText().toString(),
                        celularCliente.getText().toString(),
                        dataNascimentoCliente.getText().toString(),
                        CategoriaLeitorCliente.getText().toString()
                        );
                Intent intent = new Intent(alterar_cliente.this,TelaCadastrarCliente.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
