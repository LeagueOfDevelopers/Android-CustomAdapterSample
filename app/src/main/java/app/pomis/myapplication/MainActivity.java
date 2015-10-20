package app.pomis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cat> myCats;
    ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
        initListView();

    }

    void createBasicCats() {
        myCats = new ArrayList<>();
        myCats.add(new Cat("Уголёк", "лвоарвылоа"));
        myCats.add(new Cat("Засранец", "описание"));
        myCats.add(new Cat("Кека", "ваптдлав"));
    }


    void initAdapter(){
        mAdapter = new CatAdapter(this, R.layout.my_template, myCats);

    }
    void initListView(){
        ListView myListView = (ListView) findViewById(R.id.my_list_view);
        createBasicCats();


        myListView.setAdapter(mAdapter);
        findViewById(R.id.my_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCats.add(
                        new Cat(
                                ((EditText) findViewById(R.id.my_edit_text)).getText().toString(),
                                "Тут типа описание")
                );
                mAdapter.notifyDataSetChanged();
            }
        });

        myListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myCats.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
