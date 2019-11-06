package br.com.aps;
import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public class BancoController {
    private SQLiteDatabase db;
    private CriarBanco banco;
    //Construtor da controlle do Banco de dados, onde assim que a classe BancoController é chamada é criado automaticamente uma instancia do banco.
    public BancoController(Context context){
        banco = new CriarBanco(context);
    }
    // Classe para realizar a inserção dos dados que estão na tela de cadastro
    public String insereCliente(String nome, String endereco, String celular,String email,String cpf, String data_nascimento,String categoria_leitor){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.getNOME(), nome);
        valores.put(CriarBanco.getENDERECO(), endereco);
        valores.put(CriarBanco.getCELULAR(), celular);
        valores.put(CriarBanco.getEMAIL(), email);
        valores.put(CriarBanco.getCPF(), cpf);
        valores.put(CriarBanco.getDataNascimento(), data_nascimento);
        valores.put(CriarBanco.getCategoriaLeitor(), categoria_leitor);

        resultado = db.insert(CriarBanco.getTABELA(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public Cursor carregaCliente() {
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getTITULO()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTABELA(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaClienteByCPF(String cpf){
        Cursor cursor;
        String[] campos =
                {CriarBanco.getNOME(),CriarBanco.getCPF(),CriarBanco.getEMAIL(),CriarBanco.getENDERECO(), CriarBanco.getCELULAR(), CriaBanco.getDataNascimento(),CriarBanco.getCategoriaLeitor()};
        String where = CriarBanco.getCPF() + "=" + cpf;
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBanco.getTABELA(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraCliente(String NomeCliente, String CPFCliente , String emailCliente, String enderecoCliente, String celularCliente, String dataNascimentoCliente, String CategoriaLeitorCliente)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriarBanco.getID() + "=" + id;
        valores = new ContentValues();
        
        valores.put(CriarBanco.getNOME(), NomeCliente);
        valores.put(CriarBanco.getCPF(), CPFCliente);
        valores.put(CriarBanco.getEMAIL(), emailCliente);
        valores.put(CriarBanco.getENDERECO(), enderecoCliente);
        valores.put(CriarBanco.getCELULAR(), celularCliente);
        valores.put(CriarBanco.getDataNascimento(), dataNascimentoCliente);
        valores.put(CriarBanco.getCategoriaLeitor(), CategoriaLeitorCliente);

        db.update(CriarBanco.getTABELA(),valores,where,null);
        db.close();
    }

}
