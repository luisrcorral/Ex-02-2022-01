package mx.tec.ex_01_2022_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView myTextViewOM;
    Button button2OM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Creating object managers
        myTextViewOM = findViewById(R.id.textView5);
        button2OM = findViewById(R.id.button2);

        // In the target activity we get the current intent
        Intent getCurrentIntent = getIntent();

        // With the intent at hand, we can extract the values bundled in extras.
        // Mind the fact that, to extract values, the methods are NOT overloaded.
        String myStringMessage = getCurrentIntent.getStringExtra("idString");
        int myInt  = getCurrentIntent.getIntExtra("idInt", 0);
        myTextViewOM.setText("String received: " + myStringMessage + "; int received" + myInt);

        // Finally, a simple button event listener to get back to the previous activity
        button2OM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startActivityIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(startActivityIntent);
            }
        });

    }
}