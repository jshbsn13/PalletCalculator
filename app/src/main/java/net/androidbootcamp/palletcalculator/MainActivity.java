package net.androidbootcamp.palletcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalCasesNum;
    int casesPerPallet;
    int result;
    int remainder;
    String strPallets = "Full Pallets: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enables the use of a logo in the action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //references
        final EditText total = (EditText)findViewById(R.id.txtTotalNumber);
        final EditText perPallet = (EditText)findViewById(R.id.txtPerPalletNum);
        Button calculate = (Button)findViewById(R.id.btnCalculate);
        Button clear = (Button)findViewById(R.id.btnClear);
        final TextView resultText = (TextView)findViewById(R.id.txtResult);

        //calculate button onClick handler
        calculate.setOnClickListener(new View.OnClickListener() {

            int pallets;


            @Override
            public void onClick(View view) {




                        try {
                            totalCasesNum = Integer.parseInt(total.getText().toString());
                            casesPerPallet = Integer.parseInt(perPallet.getText().toString());


                            pallets = totalCasesNum / casesPerPallet;
                            remainder = totalCasesNum % casesPerPallet;
                            strPallets += pallets + " + " + remainder + " Cases.";

                            resultText.setText(strPallets);

                            strPallets = "Full Pallets: ";
                        }
                        catch (Exception e){
                            Toast.makeText(getApplicationContext(), "Please enter numbers.",
                                    Toast.LENGTH_SHORT).show();
                        }


            }
        });
        //clear button handler
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total.setText("");
                perPallet.setText("");
                resultText.setText("");
            }
        });


    }
}
