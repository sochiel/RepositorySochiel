package com.example.tarea01;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageViewActivity extends ActionBarActivity {

	ImageView imageView;
	TextView txtComment;
	String tienda = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view);
		
		imageView = (ImageView)findViewById(R.id.ImageView);
		txtComment = (TextView)findViewById(R.id.txtComment);
		
		Bundle b = this.getIntent().getExtras();                  
		String txtName = b.getString("name");
		tienda = txtName;
		String Comment = "";
		Drawable drawable = null;
		Resources res = getResources();
		
	if (txtName.equals("Siman")) {
        	drawable = res.getDrawable(R.drawable.siman);
        } else if (txtName.equals("Nine West")) {
        	drawable = res.getDrawable(R.drawable.ninewest);
        } else if (txtName.equals("Bershka")) {
        	drawable = res.getDrawable(R.drawable.bershka);
        } else if (txtName.equals("Adoc")) {
        	drawable = res.getDrawable(R.drawable.adoc);
        }
		Comment = "Comentario de prueba para " + txtName;
		
		imageView.setImageDrawable(drawable);
		txtComment = (TextView)findViewById(R.id.txtComment);
		txtComment.setText(Comment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_view, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
			Intent i;
            switch (item.getItemId()) {
		            case R.id.action_list:
		        		i = new Intent(getApplicationContext(),MainActivity.class);
		        		startActivity(i);
		                return true;
                    case R.id.action_info:
                    		i = new Intent(getApplicationContext(),InfoStoreActivity.class);
                    		i.putExtra("name", tienda);
                    		startActivity(i);
                            return true;
                    default :
                            return super.onOptionsItemSelected(item);
            }                
    }

}
