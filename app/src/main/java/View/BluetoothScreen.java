package View;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import se.ssdab.airqualitysystem.R;

public class BluetoothScreen extends Activity{

    private static final int REQUEST_CODE_BLUETOOTH_ON = 1313;
    private static final int BLUETOOTH_DISCOVERABLE_DURATION = 250;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.setContentView(R.layout.bluetooth_screen);

        if ((BluetoothManager.isBluetoothSupported())
                && (!BluetoothManager.isBluetoothEnabled()))
        {
            this.turnOnBluetooth();
        }
    }

    private void turnOnBlueTooth() {
        Intent requestBlueToothOn = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

        requestBlueToothOn.setAction(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

        requestBlueToothOn.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, BLUETOOTH_DISCOVERABLE_DURATION);

        this.startActivityForResult(requestBlueToothOn, REQUEST_CODE_BLUETOOTH_ON);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_BLUETOOTH_ON) {
            switch (resultCode) {
                case Activity.RESULT_OK: {

                }
                break;
                case Activity.RESULT_CANCELED: {

                }
                break;
                default:
                    break;
            }
        }
    }

    // private View view;

    /*
        public void enableBT(View view){
            this.view = view;
            BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (!mBluetoothAdapter.isEnabled()){
                Intent intentBtEnabled = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                // The REQUEST_ENABLE_BT constant passed to startActivityForResult() is a locally defined integer (which must be greater than 0), that the system passes back to you in your onActivityResult()
                // implementation as the requestCode parameter.
                int REQUEST_ENABLE_BT = 1;
                startActivityForResult(intentBtEnabled, REQUEST_ENABLE_BT);

            }
        }

        private void startActivityForResult(Intent intentBtEnabled, int request_enable_bt) {
        }*/
   /*@Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       final TextView out = (TextView) findViewById(R.id.out);
       final Button turnON = (Button) findViewById(R.id.turnON);
       final Button discoverable = (Button) findViewById(R.id.discoverable);
       final Button turnOFF = (Button) findViewById(R.id.turnOFF);
       final BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();

       turnON.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               if (!bluetooth.isEnabled()) {
                   Toast.makeText(getApplicationContext(),
                           "Turning ON Bluetooth", Toast.LENGTH_LONG);
                   // Intent enableBtIntent = new
                   // Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                   startActivityForResult(new Intent(
                           BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
               }
           }
       });
       discoverable.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View arg0) {
               if (!bluetooth.isDiscovering()) {
                   Toast.makeText(getApplicationContext(),
                           "MAKING YOUR DEVICE DISCOVERABLE",
                           Toast.LENGTH_LONG);
                   // Intent enableBtIntent = new
                   // Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                   startActivityForResult(new Intent(
                           BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE), 0);

               }
           }
       });
       turnOFF.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View arg0) {
               bluetooth.disable();
               Toast.makeText(getApplicationContext(),
                       "TURNING OFF BLUETOOTH", Toast.LENGTH_LONG);
           }
       });
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/

}
