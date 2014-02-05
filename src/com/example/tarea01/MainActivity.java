package com.example.tarea01;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnItemClickListener{

	String tienda = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String [] array_countries = getResources().getStringArray(R.array.array_countries);
				
        ArrayList<String> countries = new ArrayList<String>(Arrays.asList(array_countries));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);

        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        registerForContextMenu(list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info_store, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		tienda = adapterView.getItemAtPosition(position).toString();
		Intent i = new Intent(getApplicationContext(),InfoStoreActivity.class);
		i.putExtra("name", tienda);
		startActivity(i);
		
	}
	
	 @Override
     public boolean onPrepareOptionsMenu(Menu menu){
             boolean landscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
             MenuItem share = menu.getItem(menu.size()-1);
             share.setVisible(landscape);                
             return true;
     }
	 
	 @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
         super.onCreateContextMenu(menu, v, menuInfo);
         AdapterView.AdapterContextMenuInfo info =
                 (AdapterView.AdapterContextMenuInfo) menuInfo;
         tienda = ((TextView) info.targetView).getText().toString();            
         
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.main, menu);
     }        

     @Override
     public boolean onContextItemSelected(MenuItem item) {
             return onOptionsItemSelected(item);
     }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
			Intent i;
            switch (item.getItemId()) {
                    case R.id.action_info:
                    		i = new Intent(getApplicationContext(),InfoStoreActivity.class);
                    		i.putExtra("name", tienda);
                    		startActivity(i);
                            return true;
                    case R.id.action_image:
	                    	i = new Intent(getApplicationContext(),ImageViewActivity.class);
	                		i.putExtra("name", tienda);
	                		startActivity(i);
                            return true;
                    default :
                            return super.onOptionsItemSelected(item);
            }                
    }

}
