package szabo.fpv.umb.ukladaniezaznamov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        dbHelper.insertDataCountry("Nemecko");
        dbHelper.insertDataCountry("Slovensko");
        dbHelper.insertDataCountry("Česko");
        dbHelper.insertDataCountry("Anglicko");
        arrayList = dbHelper.GetCountries();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_view, arrayList);


        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);


    }
}