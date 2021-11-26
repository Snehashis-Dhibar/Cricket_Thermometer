package m.example.cricketthermometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText txt_in;
    Button btn;
    TextView txt_out;
    DecimalFormat formatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_in = findViewById(R.id.txt_in);
        btn = findViewById(R.id.btn);
        txt_out = findViewById(R.id.txt_out);
        txt_out.setVisibility(View.GONE);
        formatter = new DecimalFormat(getString(R.string.zero));



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_in.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, R.string.p_f_f, Toast.LENGTH_SHORT).show();
                }
                else {
                    int x = Integer.parseInt(txt_in.getText().toString().trim());
                    double temp = (x / 3.0) + 4.0;
                    String dis = getString(R.string.the_approx) + formatter.format(temp) + getString(R.string.deg_c);
                    txt_out.setText(dis);
                    txt_out.setVisibility(View.VISIBLE);

                }

            }
        });
    }
}