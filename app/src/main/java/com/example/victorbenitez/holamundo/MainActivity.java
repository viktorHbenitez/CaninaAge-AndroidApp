package com.example.victorbenitez.holamundo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();  // Toma el nombre de la clase manejada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // GET THE VIEWS FROM content_main.xml
        // 1. Get el tipo de View que deseamos obtener (TextView)
        // R : Archivo que contiene todos los ID que vayamos creando

        // Obteniendo un View de tipo TextView y lo esa guardando en un objeto de tipo TextView que se llama answerText
        final TextView answerText = (TextView) findViewById(R.id.answer_text);
        // final : define variables constantes
        final EditText ageEdit = (EditText) findViewById(R.id.age_edit);
        // GET THE BUTTON VIEW AND ADD EVENT
        Button mainButton = (Button) findViewById(R.id.main_button);

        // call this method when the user pressed the button
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ageString = ageEdit.getText().toString(); // get value: string

                try {
                    int ageInt = Integer.parseInt(ageString); // cat the value to int
                    String res = getString(R.string.result);
                    answerText.setText(String.format(res, (ageInt * 6))); // mostar un resultado en un string declarado en string.xml

                }catch (NumberFormatException e){
                   //answerText.setText("NumberFormatException por favor introduce un numero entero");
                    Toast.makeText(MainActivity.this, getString(R.string.error_message), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
