package estudo.com.appminhaideiadb.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import estudo.com.appminhaideiadb.api.AppUtil;
import estudo.com.appminhaideiadb.datamodel.ClienteDataModel;
import estudo.com.appminhaideiadb.datamodel.ProdutoDataModel;
import estudo.com.appminhaideiadb.model.Cliente;


public class AppDataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "AppMinhaIdeia.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase ( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(AppUtil.TAG,"AppDataBase:Criando Banco de Dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: tabela cliente... "+ClienteDataModel.criarTabela()  );

        db.execSQL(ProdutoDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: tabela cliente... "+ProdutoDataModel.criarTabela()  );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert(String tabela, ContentValues dados){

        db = getWritableDatabase();

        boolean retorno = false;

        //regra de negocio
        try{

            //o que deve ser realizado?
            //Salvar os dados

            retorno = db.insert(tabela,null,dados) > 0;

        }catch (Exception e){

            Log.d(AppUtil.TAG, "insert: "+e.getMessage() );

        }


        return retorno;
    }
    public boolean deleteById(String tabela, int id){

        db = getWritableDatabase();

        boolean retorno = false;

        //regra de negocio
        try{

            //o que deve ser realizado?
            //Salvar os dados

            //retorno = db.insert(tabela,null,dados) > 0;
            retorno = db.delete(tabela,"id=?",new String[]{String.valueOf(id)}) > 0;

        }catch (Exception e){

            Log.d(AppUtil.TAG, "insert: "+e.getMessage() );

        }


        return retorno;
    }
    @SuppressLint("Range")
    public List<Cliente>getAllClientes(String tabela){

        db = getWritableDatabase();
        List<Cliente>clientes = new ArrayList<>();
        Cliente obj;

        String sql = "SELECT * FROM "+tabela;
        Cursor cursor;
        cursor = db.rawQuery(sql,null);

        if (cursor.moveToFirst()){
            do {
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));

                clientes.add(obj);

            }while (cursor.moveToNext());


        }
        return clientes;
    }
}


