package szabo.fpv.umb.ukladaniezaznamov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        //niečo som tu dopísal takže fon :D

    //TODO test more data and chcek function work
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,addtoArrayfromDatabase());

        listView.setAdapter(arrayAdapter);
    }

    private ArrayList<String> addtoArrayfromDatabase(){
        //TODO Data from Database
        arrayList.add("hello");
        arrayList.add("okej");
        arrayList.add("hello");
        arrayList.add("okej");

        return arrayList;
    }
}