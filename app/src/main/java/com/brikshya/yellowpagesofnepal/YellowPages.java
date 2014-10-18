package com.brikshya.yellowpagesofnepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class YellowPages extends ActionBarActivity {

    ListView listview;
    String[] company;

    //comment posted

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow_pages);

        listview = (ListView) findViewById(R.id.list);
        company = getResources().getStringArray(R.array.Company);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.single_view,R.id.title,company);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new ListClickListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.yellow_pages, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ListClickListener implements AdapterView.OnItemClickListener {

        public ListClickListener(){

        }

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long l) {

            Intent i = new Intent(YellowPages.this,InformationPage.class);
            i.putExtra("company" , company[position]);
            startActivity(i);

        }
    }

}
