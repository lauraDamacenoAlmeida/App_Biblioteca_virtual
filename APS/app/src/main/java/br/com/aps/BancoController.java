package br.com.aps;
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
    public String insereDado(String nome, String endereco, String celular,String email,String cpf, String data_nascimento,String categoria_leitor){
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
}
