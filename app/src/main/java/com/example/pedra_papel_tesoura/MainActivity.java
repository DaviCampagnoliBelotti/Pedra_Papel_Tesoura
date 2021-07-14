package com.example.pedra_papel_tesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView img_Pedra;
    private ImageView img_Papel;
    private ImageView img_Tesoura;
    private ImageView img_App;
    private TextView txt_Resultado;
    private TextView txt_Pontos_Jogador;
    private TextView txt_Pontos_App;
    private int pontos_Jogador = 0;
    private int pontos_App = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_Pedra = findViewById( R.id.img_Pedra );
        img_Papel = findViewById( R.id.img_Papel );
        img_Tesoura = findViewById( R.id.img_Tesoura );
        img_App = findViewById( R.id.img_App );
        txt_Resultado = findViewById( R.id.txt_Resultado );
        txt_Pontos_App = findViewById( R.id.txt_Pontos_App );
        txt_Pontos_Jogador = findViewById( R.id.txt_Pontos_Jogador );

        EscutadorClickImagem eci = new EscutadorClickImagem();
        img_Pedra.setOnClickListener( eci );
        img_Papel.setOnClickListener( eci );
        img_Tesoura.setOnClickListener( eci );
    }

    private class EscutadorClickImagem implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int escolhaUsuario = 0;
            ImageView img = (ImageView) v;
            switch (img.getId()) {
                case R.id.img_Pedra:
                    escolhaUsuario = 1;
                    break;
                case R.id.img_Papel:
                    escolhaUsuario = 2;
                    break;
                case R.id.img_Tesoura:
                    escolhaUsuario = 3;
                    break;
            }
            int escolhaApp = new Random().nextInt(3) + 1;
            switch (escolhaApp) {
                case 1:
                    img_App.setImageResource(R.drawable.pedra);
                    break;
                case 2:
                    img_App.setImageResource(R.drawable.papel);
                    break;
                case 3:
                    img_App.setImageResource(R.drawable.tesoura);
                    break;
            }

            if ((escolhaApp == 1 && escolhaUsuario == 3) ||
                    (escolhaApp == 2 && escolhaUsuario == 1) ||
                    (escolhaApp == 3 && escolhaUsuario == 2)) {
                txt_Resultado.setText("O app ganhou!");
                pontos_App ++;
                txt_Pontos_App.setText("" + pontos_App);
            } else {
                if ((escolhaApp == 3 && escolhaUsuario == 1) ||
                        (escolhaApp == 1 && escolhaUsuario == 2) ||
                        (escolhaApp == 2 && escolhaUsuario == 3)) {
                    txt_Resultado.setText("Você ganhou!");
                    pontos_Jogador ++;
                    txt_Pontos_Jogador.setText("" + pontos_Jogador);

                } else {
                    txt_Resultado.setText("Deu empate!");
                }
            }

        }
    }
}