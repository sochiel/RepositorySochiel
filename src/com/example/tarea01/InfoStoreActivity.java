package com.example.tarea01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoStoreActivity extends ActionBarActivity {
	
	String tienda = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_store);
		
		Bundle b = this.getIntent().getExtras();                  
		String txtName = b.getString("name");
		tienda = txtName;
		
		String txtDescription = "";
		String txtAddress ="";
        String txtTelephone ="";
        String txtHorario ="";
        String txtWebsite ="";
        String txtEmail ="";
		
        if (txtName.equals("Nine West")) {
        	txtDescription = "Calzado exclusivo para ti, siempre a la moda con estilos vanguardistas.";
        	txtAddress ="Primer nivel D-Mall";
            txtTelephone ="2336-6889";
            txtHorario ="Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00";
            txtWebsite ="http://www.ninewestca.com/";
            txtEmail ="info@ninewestca.com";
        } else if (txtName.equals("Bershka")) {
        	txtDescription = "Productos situados de acorde a tu estilo, desde formal hasta deportiva, y de prendas básicas a las de mayor tendencia.";
        	txtAddress ="Primer nivel D-Mall";
            txtTelephone ="2336-6978";
            txtHorario ="Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00";
            txtWebsite ="http://www.bershka.com/";
            txtEmail ="contact@bershka.com";
        } else if (txtName.equals("Siman")) {
        	txtDescription = "Venta de ropa, accesorios, electrodomésticos y muebles.";
        	txtAddress ="Primer nivel D-Mall";
            txtTelephone ="2444-7777";
            txtHorario ="Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00";
            txtWebsite ="http://www.siman.com/guatemala/";
            txtEmail ="contacto@siman.com";
        } else if (txtName.equals("Adoc")) {
        	txtDescription = "Esta es una de las zapaterías más grandes de Guatemala. Aquí podrá encontrar zapatos para toda la familia.";
        	txtAddress ="Segundo nivel D-Mall";
            txtTelephone ="2336-6883";
            txtHorario ="Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00";
            txtWebsite ="https://es-la.facebook.com/adoccentroamerica";
            txtEmail ="servicio@adoc.com.gt";
        }

	txtTelephone = "Telefono: " + txtTelephone;
        txtWebsite = "Web: " + txtWebsite;
        txtEmail = "Contacto: " + txtEmail;
		
        TextView txtDescription1 = (TextView)findViewById(R.id.txtDescription);
		TextView txtName1 = (TextView)findViewById(R.id.txtName); 
		TextView txtAddress1 = (TextView)findViewById(R.id.txtAddress); 
		TextView txtTelephone1 = (TextView)findViewById(R.id.txtTelephone); 
		TextView txtHorario1 = (TextView)findViewById(R.id.txtHorario); 
		TextView txtWebsite1 = (TextView)findViewById(R.id.txtWebsite); 
		TextView txtEmail1 = (TextView)findViewById(R.id.txtEmail); 
		
		txtDescription1.setText(txtDescription);
		txtName1.setText(txtName);
		txtAddress1.setText(txtAddress);
		txtTelephone1.setText(txtTelephone);
		txtHorario1.setText(txtHorario);
		txtWebsite1.setText(txtWebsite);
		txtEmail1.setText(txtEmail);
		
		Linkify.addLinks(txtAddress1, Linkify.MAP_ADDRESSES);
		Linkify.addLinks(txtTelephone1, Linkify.PHONE_NUMBERS);
		Linkify.addLinks(txtWebsite1, Linkify.WEB_URLS);
		Linkify.addLinks(txtEmail1, Linkify.EMAIL_ADDRESSES);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info_store, menu);
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
