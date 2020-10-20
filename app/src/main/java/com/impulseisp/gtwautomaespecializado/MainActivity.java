package com.impulseisp.gtwautomaespecializado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Mazo mazo = new Mazo();
    private int numCowboys = 1;
    private int numConstructores = 1;
    private int numIngenieros = 1;
    private int especializacion = 0; // 0 = cowboy, 1 = constructor, 2 = ingeniero


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void setupPartida(View view) {
        Switch expansionActivadaSwitch = (Switch) findViewById(R.id.expansionActivadaSwitch);

        Boolean expansion = expansionActivadaSwitch.isChecked();



        mazo = new Mazo(expansion);
        numCowboys = 1;
        numConstructores = 1;
        numIngenieros = 1;

        RadioGroup nivelDificultadGrupo = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton nivelDificultad = (RadioButton) findViewById(nivelDificultadGrupo.getCheckedRadioButtonId());
        RadioButton nivelFacil = (RadioButton) findViewById(R.id.radioButtonEasy);
        RadioButton nivelMedio = (RadioButton) findViewById(R.id.radioButtonMedium);
        RadioButton nivelDificil = (RadioButton) findViewById(R.id.radioButtonHard);
        RadioButton nivelMuyDificil = (RadioButton) findViewById(R.id.radioButtonVeryHard);

        setContentView(R.layout.setup_main);

        TextView textoPrimerEnvioView = (TextView) findViewById(R.id.textoPrimerEnvioView);
        TextView textoTrabajadoresSetupView = (TextView) findViewById(R.id.textoTrabajadoresSetupView);
        ImageView imageTrabajadorAzar1View = (ImageView) findViewById(R.id.imageTrabajadorAzar1View);
        ImageView imageTrabajadorAzar2View = (ImageView) findViewById(R.id.imageTrabajadorAzar2View);
        LinearLayout trabajadoresAzarLinearLayout = (LinearLayout) findViewById(R.id.trabajadoresAzarLinearLayout);


        ImageView especialidadAzarImageView = (ImageView) findViewById(R.id.especialidadAzarImageView);
        especializacion = getTrabajadorAlAzar();
        if (especializacion == 0) {
            especialidadAzarImageView.setImageDrawable(getDrawable(R.drawable.cowboy_w70));
        } else if (especializacion == 1) {
            especialidadAzarImageView.setImageDrawable(getDrawable(R.drawable.constructor_w70));
        } else {
            especialidadAzarImageView.setImageDrawable(getDrawable(R.drawable.ingeniero_w70));
        }


        if (nivelDificultad == nivelFacil) {
            if (expansion) {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadFacil_exp);
            } else {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadFacil);
            }

            textoTrabajadoresSetupView.setVisibility(View.GONE);
            trabajadoresAzarLinearLayout.setVisibility(View.GONE);

        } else if (nivelDificultad == nivelMedio) {
            if (expansion) {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadMedio_exp);
            } else {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadMedio);
            }

            textoTrabajadoresSetupView.setText(R.string.sNotaTrabajadoresMedio);
            if (especializacion == 0) {
                numCowboys++;
            } else if (especializacion == 1) {
                numConstructores++;
            } else {
                numIngenieros++;
            }

            trabajadoresAzarLinearLayout.setVisibility(View.GONE);


        } else if (nivelDificultad == nivelDificil) {
            if (expansion) {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadDificil_exp);
            } else {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadDificil);
            }

            textoTrabajadoresSetupView.setText(R.string.sNotaTrabajadoresDificil);
            int n1 = getTrabajadorAlAzar();
            int n2 = getTrabajadorAlAzar(n1);
            if (n1 == 0) {
                imageTrabajadorAzar1View.setImageDrawable(getDrawable(R.drawable.cowboy_w70));
                numCowboys++;
            } else if (n1 == 1) {
                imageTrabajadorAzar1View.setImageDrawable(getDrawable(R.drawable.constructor_w70));
                numConstructores++;
            } else {
                imageTrabajadorAzar1View.setImageDrawable(getDrawable(R.drawable.ingeniero_w70));
                numIngenieros++;
            }

            if (n2 == 0) {
                imageTrabajadorAzar2View.setImageDrawable(getDrawable(R.drawable.cowboy_w70));
                numCowboys++;
            } else if (n2 == 1) {
                imageTrabajadorAzar2View.setImageDrawable(getDrawable(R.drawable.constructor_w70));
                numConstructores++;
            } else {
                imageTrabajadorAzar2View.setImageDrawable(getDrawable(R.drawable.ingeniero_w70));
                numIngenieros++;
            }


        } else {
            if (expansion) {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadDificil_exp);
            } else {
                textoPrimerEnvioView.setText(R.string.sInicioCiudadDificil);
            }

            imageTrabajadorAzar2View.setVisibility(View.GONE);

            textoTrabajadoresSetupView.setText(R.string.sNotaTrabajadoresMuyDificil);
            numCowboys++;
            numConstructores++;
            numIngenieros++;

            int n1 = getTrabajadorAlAzar();
            if (n1 == 0) {
                imageTrabajadorAzar1View.setImageDrawable(getDrawable(R.drawable.cowboy_w70));
                numCowboys++;
            } else if (n1 == 1) {
                imageTrabajadorAzar1View.setImageDrawable(getDrawable(R.drawable.constructor_w70));
                numConstructores++;
            } else {
                imageTrabajadorAzar1View.setImageDrawable(getDrawable(R.drawable.ingeniero_w70));
                numIngenieros++;
            }


        }








    }


    @SuppressLint("SetTextI18n")
    public void iniciaPartida(View view) {


        setContentView(R.layout.robo_main);

        TextView numCowbowsTextView = (TextView) findViewById(R.id.numCowboysTextView);
        TextView numConstructoresTextView = (TextView) findViewById(R.id.numConstructoresTextView);
        TextView numIngenierosTextView = (TextView) findViewById(R.id.numIngenierosTextView);
        numCowbowsTextView.setText(getText(R.string.sCowboys) + ": " + String.valueOf(numCowboys));
        numConstructoresTextView.setText(getText(R.string.sConstructores) + ": " + String.valueOf(numConstructores));
        numIngenierosTextView.setText(getText(R.string.sIngenieros) + ": " + String.valueOf(numIngenieros));

        ImageView imagenCarta = (ImageView) findViewById(R.id.imagenCartaView);
        TextView textoAyuda = (TextView) findViewById(R.id.textoAyudaView);
        TextView cartasRestantes = findViewById(R.id.cartasRestantesView);

        Carta cartaRobada = mazo.robaUnaCarta();

        imagenCarta.setImageDrawable(getDrawable(cartaRobada.getAccion()));
        textoAyuda.setText(cartaRobada.getTextoAyuda());
        cartasRestantes.setText(String.valueOf(mazo.getCartasRestantes()));
    }

    public void robaNuevaCarta(View view) {
        ImageView imagenCarta = (ImageView) findViewById(R.id.imagenCartaView);
        TextView textoAyuda = (TextView) findViewById(R.id.textoAyudaView);
        TextView cartasRestantes = findViewById(R.id.cartasRestantesView);
        cerrarAyuda(view);

        Carta cartaRobada = mazo.robaUnaCarta();

        if (cartaRobada.getOtorgaTrabajador()) {
            FrameLayout frame = (FrameLayout) findViewById(R.id.seleccionaTrabajador);
            Button botonRobarCarta = (Button) findViewById(R.id.bRobaNuevaCarta);

            botonRobarCarta.setVisibility(View.GONE);
            frame.setVisibility(View.VISIBLE);
        } else if (cartaRobada.getSoloIngeniero()) {
            LinearLayout frame = (LinearLayout) findViewById(R.id.seleccionSoloIngeniero);
            Button botonRobarCarta = (Button) findViewById(R.id.bRobaNuevaCarta);

            botonRobarCarta.setVisibility(View.GONE);
            frame.setVisibility(View.VISIBLE);
        }


        imagenCarta.setImageDrawable(getDrawable(cartaRobada.getAccion()));
        textoAyuda.setText(cartaRobada.getTextoAyuda());
        cartasRestantes.setText(String.valueOf(mazo.getCartasRestantes()));

    }

    public void abrirAyuda(View view) {
        FrameLayout frame = (FrameLayout) findViewById(R.id.popUpAyuda);
        frame.setVisibility(View.VISIBLE);
    }

    public void cerrarAyuda(View view) {
        FrameLayout frame = (FrameLayout) findViewById(R.id.popUpAyuda);
        frame.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    public void addCowBoy(View view) {
        numCowboys++;
        FrameLayout frame = (FrameLayout) findViewById(R.id.seleccionaTrabajador);
        Button botonRobarCarta = (Button) findViewById(R.id.bRobaNuevaCarta);
        TextView numCowbowsTextView = (TextView) findViewById(R.id.numCowboysTextView);
        numCowbowsTextView.setText(getText(R.string.sCowboys) + ": " + String.valueOf(numCowboys));

        frame.setVisibility(View.GONE);
        botonRobarCarta.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    public void addConstructor(View view) {
        numConstructores++;
        FrameLayout frame = (FrameLayout) findViewById(R.id.seleccionaTrabajador);
        Button botonRobarCarta = (Button) findViewById(R.id.bRobaNuevaCarta);
        TextView numConstructoresTextView = (TextView) findViewById(R.id.numConstructoresTextView);


        numConstructoresTextView.setText(getText(R.string.sConstructores) + ": " + String.valueOf(numConstructores));
        frame.setVisibility(View.GONE);
        botonRobarCarta.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    public void addIngeniero(View view) {
        numIngenieros++;
        FrameLayout frame = (FrameLayout) findViewById(R.id.seleccionaTrabajador);
        LinearLayout frame2 = (LinearLayout) findViewById(R.id.seleccionSoloIngeniero);
        Button botonRobarCarta = (Button) findViewById(R.id.bRobaNuevaCarta);
        TextView numIngenierosTextView = (TextView) findViewById(R.id.numIngenierosTextView);

        numIngenierosTextView.setText(getText(R.string.sIngenieros) + ": " + String.valueOf(numIngenieros));
        frame.setVisibility(View.GONE);
        frame2.setVisibility(View.GONE);
        botonRobarCarta.setVisibility(View.VISIBLE);
    }

    public void cancelAddIngeniero(View view) {
        LinearLayout frame = (LinearLayout) findViewById(R.id.seleccionSoloIngeniero);
        Button botonRobarCarta = (Button) findViewById(R.id.bRobaNuevaCarta);
        frame.setVisibility(View.GONE);
        botonRobarCarta.setVisibility(View.VISIBLE);
    }

    public int getTrabajadorAlAzar() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public int getTrabajadorAlAzar(int numSinRepetir) {
        Random rand = new Random();
        int n = rand.nextInt(3);
        if (n == numSinRepetir) {
            return getTrabajadorAlAzar(numSinRepetir);
        } else {
            return n;
        }
    }
}


