package estudo.com.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import estudo.com.appminhaideiadb.api.AppUtil;
import estudo.com.appminhaideiadb.datamodel.ClienteDataModel;
import estudo.com.appminhaideiadb.datasource.AppDataBase;
import estudo.com.appminhaideiadb.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);
        Log.d(AppUtil.TAG,"ClienteController:conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();
        //key, valor

        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());

        // enviar os dados (dadosDoObjeto) para a classe AppDatabase
        //Utilizando metodo capaz de adicionar o OBJ no banco de dados,
        // tabela qualquer uma (Cliente).

        //retorno sempre sera FALSE ou VERDADEIRO
        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();
        //key, valor
        //vai utilizar o metodo UPDATE  do SQL

        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());

        // enviar os dados (dadosDoObjeto) para a classe AppDatabase
        //Utilizando metodo capaz de alterar o OBJ no banco de dados,
        // tabela qualquer uma (Cliente),respeitando o id ou o PK (primary key)
        return true;
    }

    @Override
    public boolean deletar(int id) {

        return deleteById(ClienteDataModel.TABELA, id);

        //dadoDoObjeto = new ContentValues();
        //key, valor
        //vai utilizar o metodo UPDATE  do SQL

        //deletar
        //vai utilizar o DELETE from TABELA where ID = ???
        //dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());


        // enviar os dados (dadosDoObjeto) para a classe AppDatabase
        //Utilizando metodo capaz de alterar o OBJ no banco de dados,
        // tabela qualquer uma (Cliente),respeitando a condição
        // Condição, o registro tem que ser igual ao  id informado.

    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        return getAllClientes(ClienteDataModel.TABELA);
    }
}
