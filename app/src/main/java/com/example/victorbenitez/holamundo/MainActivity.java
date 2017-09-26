package com.example.victorbenitez.holamundo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        // Agregar propiedades desde MainActivity java file
        answerText.setText("Aqui puedes ver el resultado sobre la edad perruna de tu mascota");

        // GET THE IMAGEVIEW FROM content_main.xml
        ImageView coverImage = (ImageView) findViewById(R.id.cover_image);
        // set the image to the ImageView  ContextCompat.getDrawable(contexto, AccedemosRecursoArchivo)
        coverImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dog));

        // GET THE BUTTON VIEW AND ADD EVENT
        Button mainButton = (Button) findViewById(R.id.main_button);

        // call this method when the user pressed the button
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerText.setText("ACABAS DE PRESIONAR EL BOTON YA ERES PROGRAMADOR");
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
