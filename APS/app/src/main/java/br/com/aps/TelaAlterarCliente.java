package br.com.aps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TelaAlterarCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consultar);
        BancoController crud = new BancoController(getBaseContext());

        final Cursor cursor = crud.carregaCliente();
        String[] nomeCampos = new String[] {CriaBanco.getID(), CriaBanco.getTITULO()};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_alterar_cliente,cursor,nomeCampos,idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getID()));
                Intent intent = new Intent(ConsultaDados.this, AlteraDados.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

    }
}
