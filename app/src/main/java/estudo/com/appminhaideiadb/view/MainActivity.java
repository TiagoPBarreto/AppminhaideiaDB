package estudo.com.appminhaideiadb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import estudo.com.appminhaideiadb.R;
import estudo.com.appminhaideiadb.api.AppUtil;
import estudo.com.appminhaideiadb.controller.ClienteController;
import estudo.com.appminhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {
    ClienteController  clienteController;
    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        for (int i = 0; i < 49; i++) {

            obj = new Cliente();
            obj.setNome("Tiago"+i);
            obj.setEmail(i+"_teste@teste");

            clienteController.incluir(obj);
        }



//        obj = new Cliente();
//        obj.setNome("Tiago");
//        obj.setEmail("teste@teste");
//
//        Log.d(AppUtil.TAG,"onCreate:App Minha ideia Database");
 //       clienteController = new ClienteController(getApplicationContext());

    }

}