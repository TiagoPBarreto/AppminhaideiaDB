package estudo.com.appminhaideiadb.controller;

import java.util.List;

public interface ICrud<T> {

    //Metodos para persistencia de dados no Banco de Dados

    //incluir
    public boolean incluir(T obj);
    // alterar
    public boolean alterar(T obj);
    //deletar
    public boolean deletar(int id);
    //listar
    public List<T> listar();

    //CRUD - Create retrieve Update Delete


}