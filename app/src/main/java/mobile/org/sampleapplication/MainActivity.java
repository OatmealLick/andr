package mobile.org.sampleapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE = "message";

    private String currentLanguage = "en";

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
        if (currentLanguage.equals("en")) {
            locale = new Locale("pl");
        } else {
            locale = new Locale("en");
        }

        Locale.setDefault(locale);
        Context context = this;
        Resources res = this.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }

        this.attachBaseContext(context);
    }
}
