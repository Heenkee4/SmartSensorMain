package View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import se.ssdab.airqualitysystem.R;

import static se.ssdab.airqualitysystem.R.id.exponent_tv;
import static se.ssdab.airqualitysystem.R.id.exponent_tv2;
import static se.ssdab.airqualitysystem.R.id.show_happy_face;

public class GreenScreen extends AppCompatActivity {
    private TextView exponent_tv, exponent_tv2;
    private ImageView show_face;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.green_screen);

        exponent_tv = (TextView) findViewById(R.id.exponent_tv);
        exponent_tv2 = (TextView) findViewById(R.id.exponent_tv2);
        show_face = (ImageView) findViewById(R.id.show_happy_face);

        exponent_tv.setText(Html.fromHtml("12.0µg/m<sup>3</sup>"));
    }
}
