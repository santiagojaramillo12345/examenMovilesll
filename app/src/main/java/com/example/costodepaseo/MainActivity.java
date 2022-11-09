package com.example.costodepaseo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jetcantidad;
    RadioButton jrbpremium,jrbnormal,jrbeconomico;
    TextView jtvtotal,jtvfinca,jtvvehiculo;
    CheckBox jcbvehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar barra de titulo y asociar objetos Java y Xml
        getSupportActionBar().hide();
        jetcantidad=findViewById(R.id.etcantidad);
        jrbpremium=findViewById(R.id.rbpremiun);
        jrbnormal=findViewById(R.id.rbnormal);
        jrbeconomico=findViewById(R.id.rbeconomico);
        jtvfinca=findViewById(R.id.tvfinca);

        jtvtotal=findViewById(R.id.tvtotal);
        jtvvehiculo=findViewById(R.id.tvvehiculo);

        jcbvehiculo=findViewById(R.id.cbvehiculo);
    }

    public void Calcular_valor_viaje(View view){
        String cantidad_personas=jetcantidad.getText().toString();
        if (cantidad_personas.isEmpty()){
            Toast.makeText(this, "La cantidad de personas es requerida", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }
        else{
            int cantidad,valor_finca,valor_vehiculo,valor_total,valor_sobrecarga;
            cantidad=Integer.parseInt(cantidad_personas);
            if (cantidad < 1){
                Toast.makeText(this, "La cantidad de personas debe ser mayor a 1", Toast.LENGTH_SHORT).show();
                jetcantidad.requestFocus();

            }


            else{
                if (jrbpremium.isChecked()){
                    jtvfinca.setText("1000000");
                    valor_finca=1000000;
                }
                else{
                    if (jrbnormal.isChecked()){
                        jtvfinca.setText("800000");
                        valor_finca=800000;
                    }
                    else {
                        jtvfinca.setText("500000");
                        valor_finca = 500000;
                    }
                }
                if (jcbvehiculo.isChecked()){
                    jtvvehiculo.setText("30000");
                    valor_vehiculo=30000;
                }
                else{
                    jtvvehiculo.setText("0");
                    valor_vehiculo=0;
                }

                valor_total=cantidad * valor_finca + valor_vehiculo;
               if (cantidad>30 && cantidad<50){

                   valor_sobrecarga=(10*valor_total)/100;

                   jtvtotal.setText(String.valueOf(valor_sobrecarga));

               }

else {


                jtvtotal.setText(String.valueOf(valor_total));
            }
        }
    }}

    public void Limpiar(View view){
        jrbpremium.setChecked(true);

        jcbvehiculo.setChecked(false);
        jtvvehiculo.setText("0");
        jtvtotal.setText("0");
        jtvfinca.setText("1000000");
        jetcantidad.setText("");
        jetcantidad.requestFocus();
    }
}
