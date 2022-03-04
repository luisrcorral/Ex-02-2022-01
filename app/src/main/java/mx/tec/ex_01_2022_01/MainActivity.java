package mx.tec.ex_01_2022_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Create an object manager for the button1 defined in the XML layout
    private Button button1OM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the Java object manager with the corresponding XML view
        button1OM = findViewById(R.id.button1);

        // Add an event listener to the button1 object manager
        button1OM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // To start a new activity, Android leverages "Intents". An Intent is a messaging
                // object you can use to request an action from another app component.
                // We create a new intent and in the constructor method we provide two parameters:
                // the current activity, and the target activity. Note the difference in the extensions
                Intent startActivityIntent = new Intent(MainActivity.this, SecondActivity.class);

                // To send parameters through intents, we use the overloaded method putExtra.
                // putExtra receives two parameters: the id of the sent value, and the actual value.
                // You can send as many extras as you can (strings, ints, objects...)
                startActivityIntent.putExtra("idString", "AnyMessage");
                startActivityIntent.putExtra("idInt", 12345);

                // Finally, to start the new activity you call the method startActivity sending the
                // intent as parameter
                startActivity(startActivityIntent);
            }
        });
    }
}