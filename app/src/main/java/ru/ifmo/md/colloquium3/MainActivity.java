package ru.ifmo.md.colloquium3;

import android.content.Context;
import android.database.Cursor;
import android.app.AlertDialog.Builder;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("Wallet", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS wallet(type VARCHAR, having REAL, price REAL);");
        Cursor c = db.rawQuery("SELECT * FROM wallet", null);
        if (c.getCount() == 0) {
            db.execSQL("INSERT INTO wallet VALUES('" + "RUR" + "','" + "10000.0" +
                    "','" + "1.0" + "');");
            db.execSQL("INSERT INTO wallet VALUES('" + "USD" + "','" + "0.0" +
                    "','" + "45.0" + "');");
            db.execSQL("INSERT INTO wallet VALUES('" + "EUR" + "','" + "0.0" +
                    "','" + "60.0" + "');");
            db.execSQL("INSERT INTO wallet VALUES('" + "GBP" + "','" + "0.0" +
                    "','" + "80.0" + "');");
        }

        String [] currencies = {"RUR", "USD", "EUR", "GBP"};

        c = db.rawQuery("SELECT having FROM wallet WHERE type='"+ currencies[0] +"'", null);
        c.getDouble(0);

        double selling = 0;
        //if selling foreign
        if (selling > c.getDouble(0)) {
            showMessage("Greed error", "You are trying to sell more than you have!");
        }

    }

    public void exchange(String from, String into, double amount) {
        //amount is how much of resulting currency you want to get
        if (db.rawQuery("SELECT having FROM wallet WHERE type='"+ into +"'", null).getDouble(0) )
    }

    public void showMessage(String title,String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
