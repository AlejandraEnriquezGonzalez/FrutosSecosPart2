package cl.isisur.frutossecos;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cl.isisur.basedatosfirebase2022.R;
import cl.isisur.frutossecos.Clases.Clientes;

public class MainActivity2 extends AppCompatActivity {

    private List<Clientes> ListClientes = new ArrayList<Clientes>();
    private List<String> ListNombre = new ArrayList();
    ArrayAdapter<Clientes> arrayAdapterClientes;
    ArrayAdapter<String> arrayAdapterString;


    EditText eTNombre,eTApellido;
    Button bTAgregar2, btEliminar2;
    ListView lvListadoClientes;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        eTNombre=findViewById(R.id.eTNombre);
        eTApellido=findViewById(R.id.eTApellido);
        bTAgregar2 =findViewById(R.id.bTAgregar2);
        btEliminar2=findViewById(R.id.btEliminar2);
        lvListadoClientes=findViewById(R.id.lvListado);
        inicializarFireBase();
        listarDatos();

        bTAgregar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clientes cli = new Clientes();
                //cli.setIdClientes("11111");
                cli.setidCliente(UUID.randomUUID().toString());
                cli.setNombre(eTNombre.getText().toString());
                cli.setapellido(eTApellido.getText().toString());
                databaseReference.child("Libro").child(cli.getidCliente()).setValue(cli);


            }
        });


    }
    private void listarDatos() {
        databaseReference.child("Producto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListClientes.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    Clientes cli =objs.getValue(Clientes.class);
                    ListClientes.add(cli);
                    ListNombre.add(""+cli.getNombre()+" "+cli.getapellido());
                    arrayAdapterString =new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_expandable_list_item_1,ListNombre);
                    lvListadoClientes.setAdapter(arrayAdapterString);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }

}