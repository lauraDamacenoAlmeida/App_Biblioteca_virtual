package br.com.aps;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class CriarBanco extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "clientes";
    private static final String TABELA_CATEGORIA_LEITORES = "categoria_leitores";
    private static final String ID = "_id";
    private static final String NOME = "nome";
    private static final String ENDERECO = "endereco";
    private static final String CELULAR = "celular";
    private static final String EMAIL = "email";
    private static final String CPF = "cpf";
    private static final String DATA_NASCIMENTO = "data_nascimento";
    private static final String CATEGORIA_LEITOR = "categoria_leitor";
    private static final int COD_CATEGORIA = "categoria_leitor";


    private static final int VERSAO = 1;

//Método para criar o banco de dados, onde por parametro é passado o nome, contexto e versão do banco
    public CriarBanco(Context context) {
        //super(context, name, factory, version);
        super(context, getNomeBanco(), null, getVERSAO());

    }
//Métodos para acessar os valores das variáveis privadas
    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getID() {
        return ID;
    }

    public static String getNOME() {
        return NOME;
    }

    public static String getENDERECO() {
        return ENDERECO;
    }

    public static String getCELULAR() {
        return CELULAR;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static String getCPF() {
        return CPF;
    }

    public static String getDataNascimento() {
        return DATA_NASCIMENTO;
    }


    public static String getCategoriaLeitor() {
        return CATEGORIA_LEITOR;
    }

    public static int getVERSAO() {
        return VERSAO;
    }
// assim que o banco é criado, é criado uma tabela com as seguintes colunas passadas pelo "( )", como por exemplo ID, Nome, endereç, celular, email,CPF, data de nascimento, categoria de leitores
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tabela_categoria_leitores = "CREATE TABLE "+ TABELA_CATEGORIA_LEITORES + "("+ COD_CATEGORIA + " int  primary key autoincrement,"
                + NOME + " text, " + ENDERECO + " text, " + CELULAR + " text, " + EMAIL + " text, "
                + " text, " + DATA_NASCIMENTO + " text, " + CATEGORIA_LEITOR + " text foreign key("+CATEGORIA+") references " +TABELA_CATEGORIA_LEITORES+"("+CATEGORIA+"));";

        String tabela_clientes = "CREATE TABLE "+ TABELA + "("+ CPF + " text primary key,"
                + NOME + " text, " + ENDERECO + " text, " + CELULAR + " text, " + EMAIL + " text, "
                + " text, " + DATA_NASCIMENTO + " text, " + CATEGORIA_LEITOR + " text foreign key("+CATEGORIA+") references " +TABELA_CATEGORIA_LEITORES+"("+CATEGORIA+"));";

        sqLiteDatabase.execSQL(tabela_clientes);
        sqLiteDatabase.execSQL(tabela_categoria_leitores);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABELA);
        onCreate(sqLiteDatabase);
    }
}
