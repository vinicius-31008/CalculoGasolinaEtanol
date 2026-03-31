package sp.senai.br.gasolinaeetanol;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtLitroGas, txtAutGas, txtLitroEt, txtAutEt;

    TextView txtResultGas, txtResultEt, txtResultado;

    ConstraintLayout tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtLitroGas = findViewById(R.id.txtLitroGas);
        txtAutGas = findViewById(R.id.txtAutGas);
        txtLitroEt = findViewById(R.id.txtLitroEt);
        txtAutEt = findViewById(R.id.txtAutEt);

        txtResultGas = findViewById(R.id.txtResultGas);
        txtResultEt = findViewById(R.id.txtResultEt);
        txtResultado = findViewById(R.id.txtResultado);

        tela = findViewById(R.id.tela);
    }

    public void Calcular(View v){

        float LitroGas = Float.parseFloat(txtLitroGas.getText().toString());
        float autGas = Float.parseFloat(txtAutGas.getText().toString());
        float resultGas = LitroGas/autGas;
        txtResultGas.setText("Resultado: "+resultGas);

        float LitroEt = Float.parseFloat(txtLitroEt.getText().toString());
        float autEt = Float.parseFloat(txtAutEt.getText().toString());
        float resultEt = LitroEt/autEt;
        txtResultEt.setText("Resultado: "+resultEt);

        if(resultGas < resultEt){
            txtResultado.setText("O melhor combustivel a se usar é gasolina");
            tela.setBackgroundColor(Color.rgb(255,255,0));
        }else if(resultGas == resultEt){
            txtResultado.setText("ambos tem o mesmo valor");
            tela.setBackgroundColor(Color.rgb(0,255,0));
        }else{
            txtResultado.setText("O melhor combustivel a se usar é etanol");
            tela.setBackgroundColor(Color.rgb(0,255,255));
        }
    }


}