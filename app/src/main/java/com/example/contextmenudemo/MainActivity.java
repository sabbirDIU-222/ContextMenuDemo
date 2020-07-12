package com.example.contextmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    String[] name = {"sabbir","kawser","hasib","topu","limon",
    "md russel","tika","dihan","fula","muda","tepu"};
     ContextMenu contextMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inOne();


}
    public void inOne(){
        listView = findViewById(R.id.listviewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,name);

        listView.setAdapter(adapter);

        // remember of this register for context menu method ,
        // otherwise the context menu will not work
        // you can use context menu in any of view
        // just using this register for context menu method
        registerForContextMenu(listView);

      /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 you can use the on item listener method that can help you to select any of item
                 and better user exprience

            }
        });*/


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.simple_menu,menu);
        menu.setHeaderTitle("select any");


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        if(item.getItemId()==R.id.call){
            Toast.makeText(MainActivity.this,"call now",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.detail){
            Toast.makeText(MainActivity.this,"detail shown",Toast.LENGTH_SHORT).show();
        }else {
            return false;
        }

        return true;
    }
}
