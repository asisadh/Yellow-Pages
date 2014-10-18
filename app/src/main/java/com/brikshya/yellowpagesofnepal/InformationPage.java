package com.brikshya.yellowpagesofnepal;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class InformationPage extends ActionBarActivity implements View.OnClickListener{

    private String company_title;
    private int id;
    private String[] company;

    private TextView title;
    private TextView solo;
    private TextView h_no;
    private TextView m_no;
    private TextView email;
    private TextView website;

    private ImageButton b_home,b_mobile,b_email,b_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        title = (TextView) findViewById(R.id.title);
        solo = (TextView) findViewById(R.id.solo);
        h_no = (TextView) findViewById(R.id.h_no);
        m_no = (TextView) findViewById(R.id.m_no);
        email = (TextView) findViewById(R.id.email);
        website = (TextView) findViewById(R.id.site);

        b_home = (ImageButton) findViewById(R.id.b_home);
        b_mobile = (ImageButton) findViewById(R.id.b_mobile);
        b_email = (ImageButton) findViewById(R.id.b_email);
        b_web = (ImageButton) findViewById(R.id.b_web);


        //gets the name of company that was touched
        Intent i = getIntent();
        company_title = i.getStringExtra("company");

        id = getResources().getIdentifier(company_title, "array", getApplicationContext().getPackageName());
        company = getResources().getStringArray(id);

        //change the default value to clicked value
        title.setText(company_title);

        solo.setText(company[0]);
        h_no.setText(company[1]);
        m_no.setText(company[2]);
        email.setText(company[3]);
        website.setText(company[4]);

        b_home.setOnClickListener(this);
        b_mobile.setOnClickListener(this);
        b_email.setOnClickListener(this);
        b_web.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.b_home :
                String home_no = company[1];

                Intent homeIntent = new Intent(Intent.ACTION_CALL);
                homeIntent.setData(Uri.parse("tel:"+home_no));

                try {
                    startActivity(homeIntent);
                    finish();
                    Log.i("Finished making a call...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InformationPage.this,
                            "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.b_mobile :
                String mobile_no = company[2];

                Intent mobileIntent = new Intent(Intent.ACTION_CALL);
                mobileIntent.setData(Uri.parse("tel:"+mobile_no));

                try {
                    startActivity(mobileIntent);
                    finish();
                    Log.i("Finished making a call...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InformationPage.this,
                            "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.b_email :
                String email_address = company[3];

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {email_address.toString()});

                try {
                    startActivity(emailIntent);
                    finish();
                    Log.i("Finished making a call...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InformationPage.this,
                            "Email sending Failed, please try again later.", Toast.LENGTH_SHORT).show();
                }



                break;

            case R.id.b_web :

                Uri uriUrl = Uri.parse("http://"+company[4]);

                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);

                startActivity(launchBrowser);

                break;

        }

    }
}
