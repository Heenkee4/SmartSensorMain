package View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import se.ssdab.airqualitysystem.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.middle_screen);
        //getActionBar().hide();
        //getSupportActionBar().hide(); Fix later

        Button nxtButton = (Button) findViewById(R.id.next_btn);

        nxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(String.valueOf(MainActivity.this)));
                setContentView(R.layout.bluetooth_screen);
            }
        });
    }
}
