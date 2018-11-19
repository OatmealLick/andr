package mobile.org.sampleapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE = "message";

    private static String currentLanguage = "en_US";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    public void sendMessage(final View view) {
        final EditText editText = findViewById(R.id.messageET);
        Intent i = new Intent(this, ShowMessageActivity.class);
        i.putExtra(MESSAGE, editText.getText().toString());
        startActivity(i);
    }

    public void changeLanguage(final View view) {

        Locale locale;
        if (currentLanguage.equals("en_US")) {
            locale = new Locale("pl");
            currentLanguage = "pl";
        } else {
            locale = new Locale("en_US");
            currentLanguage = "en_US";
        }

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }
}
