package cl.isisur.frutossecos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
import cl.isisur.frutossecos.Clases.Productos;


public class MainActivity extends AppCompatActivity {
        private List<Productos> ListProductos = new ArrayList<Productos>();
        private List<String> ListLibroNombre = new ArrayList();
        ArrayAdapter<Productos> arrayAdapterProductos;
        ArrayAdapter<String> arrayAdapterString;

        
        ListView lvListadoProductos;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvListadoProductos=findViewById(R.id.lvListado);
        inicializarFireBase();
        listarDatos();


    }
    private void listarDatos() {
        databaseReference.child("Producto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
             ListProductos.clear();
             for (DataSnapshot objs : snapshot.getChildren()){
                 Productos pro =objs.getValue(Productos.class);
                 ListProductos.add(pro);
                 ListLibroNombre.add(""+pro.getNombre()+" "+pro.getEstado());
                 arrayAdapterString =new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,ListLibroNombre);
                 lvListadoProductos.setAdapter(arrayAdapterString);
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