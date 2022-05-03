package estudo.com.appminhaideiadb.datamodel;

public class ClienteDataModel {

    // modelo objeto relacional

    //Toda classe data model tem esta estrutura



    //5 - Query de consulta gerais


    //1 - Atributo nome da tabela

    public static final String TABELA = "Cliente";

    //2 - Atributos um para um com os nomes dos campos

    public static final String ID = "id";//integer
    public static final String NOME = "nome"; // text
    public static final String EMAIL = "email"; // text

    //3 - Query para criar a tabela no banco de dados

    public static String queryCriarTabela = " ";

    //4 - Metodo para gerar o script para criar a tabela;

    public static String criarTabela(){

        //Concatenação de String
        queryCriarTabela+= "CREATE TABLE " +TABELA+"(";
        queryCriarTabela+= ID+" integer primary key autoincrement, ";
        queryCriarTabela+= NOME+ " text, ";
        queryCriarTabela+= EMAIL+ " text ";
        queryCriarTabela+= ")";

        return queryCriarTabela;
    }
}
