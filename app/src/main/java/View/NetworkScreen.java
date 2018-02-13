package View;


import android.app.AlertDialog;
import android.bluetooth.le.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

public class NetworkScreen {

    public String SSID = null;
    public String Pass = null;
    private WifiManager wifimanager;
    {
        try {


        String ssid = "\"" + SSID + "\"";
        String pass = "\"" + Pass + "\"";

        for (ScanResult result : results) {
            if (result.SSID.equals(SSID)) {
                String security = getScanResultSecurity(result);
                if (security.equals("PSK")) {

                    WifiConfiguration con = new WifiConfiguration();
                    con.SSID = ssid;
                    AlertDialog a = new AlertDialog.Builder(MainActivity.this).create();
                    a.setMessage("in");
                    a.show();
                    con.preSharedKey = pass;
                    con.hiddenSSID = true;
                    con.status = WifiConfiguration.Status.ENABLED;
                    con.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
                    con.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
                    con.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
                    con.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
                    con.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
                    con.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
                    con.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
                    con.allowedProtocols.set(WifiConfiguration.Protocol.WPA);

                    int ntid = wifimanager.addNetwork(con);

                    wifimanager.disconnect();
                    wifimanager.enableNetwork(ntid, true);
                    wifimanager.reconnect();
                    boolean b = wifimanager.saveConfiguration();
                    if (ntid != -1 && b) {

                        AlertDialog a2 = new AlertDialog.Builder(MainActivity.this).create();
                        a2.setMessage("saved");
                        a2.show();
                    }
                }

            }
        }
        }
    catch(Exception e){
        AlertDialog a = new AlertDialog.Builder(MainActivity.this).create();
        a.setMessage(e.getMessage());
        a.show();
    }
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
