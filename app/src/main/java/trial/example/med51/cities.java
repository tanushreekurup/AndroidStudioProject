package trial.example.med51;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class cities extends AppCompatActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        listView=(ListView)findViewById(R.id.listview);
        editText=(EditText)findViewById(R.id.txtsearch1);
        initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")){
                    initList();
                }
                else{
                    searchItem(s.toString());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void searchItem(String textToSearch){
        for (String item:items){
            if (!item.contains(textToSearch)){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList(){
        items=new String[]{"Ahmedabad","Kutch","Porbandar","Rajkot","Bhavnagar","Bilimora","Surat"};
        listItems=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,listItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(view.getContext(),Ahmedabad.class);
                    startActivity(intent);
                }

                if (position==1){
                    Intent intent=new Intent(view.getContext(),Kutch.class);
                    startActivity(intent);
                }

                if (position==2){
                    Intent intent=new Intent(view.getContext(),Porbandar.class);
                    startActivity(intent);
                }

                if (position==3){
                    Intent intent=new Intent(view.getContext(),Rajkot.class);
                    startActivity(intent);
                }

                if (position==4){
                    Intent intent=new Intent(view.getContext(),Bhavnagar.class);
                    startActivity(intent);
                }

                if (position==5){
                    Intent intent=new Intent(view.getContext(),Bilimora.class);
                    startActivity(intent);
                }

                if (position==6){
                    Intent intent=new Intent(view.getContext(),Surat.class);
                    startActivity(intent);
                }

            }
        });
    }
}
