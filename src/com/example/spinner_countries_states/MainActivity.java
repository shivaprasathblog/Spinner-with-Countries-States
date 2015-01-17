package com.example.spinner_countries_states;
import com.example.spincon.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity 
{
	//Spinner for Country and State
	Spinner sp1,sp2;
	//Data to be populated in Spinner - sp1
	String[] Countries={"Select","India","America","Australia"};
	//Data to be populated in Spinner - sp2
	String[] India_States={"Select","Delhi","Tamil Nadu","Kerala","Gujarat",};
	String[] America_States={"Select","Washington","New York","New Jersey"};
	String[] Australia_States={"Select","Canberra","Sydney","Brisbane"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referring Spinner sp1,sp2 from XML
        sp1=(Spinner)findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);
        //Adapter for Spinner ,We use ArrayAdapter Bcz We Use Array of Type String 
        ArrayAdapter<String> aa=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, Countries);
        //Setting The Adapter for Spinner
	    sp1.setAdapter(aa);
        //Creating the Listener for Spinner
        sp1.setOnItemSelectedListener(new OnItemSelectedListener()
        {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) 
			{
				// TODO Auto-generated method stub
				//arg2==0 is "Select"
				if(arg2==0)
				{
					//Disabling the Spinner - sp2 if item(Select i,e arg==0) is selected
					sp2.setEnabled(false);
				}
				else
				{
					//arg==1 is India
					if(arg2==1)
					{
						sp2.setEnabled(true);
						//Data to be populated in Spinner - sp2 if India is Selected
						ArrayAdapter<String> india_adptr=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,India_States);
						sp2.setAdapter(india_adptr);
					}
					//arg==2 is America
					if(arg2==2)
					{
						sp2.setEnabled(true);
						//Data to be populated in Spinner - sp2 if America is Selected
						ArrayAdapter<String> america_adptr=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line, America_States);
						sp2.setAdapter(america_adptr);
					}
					//arg==3 is Australia
					if(arg2==3)
					{
						sp2.setEnabled(true);
						//Data to be populated in Spinner - sp2 if Australia is Selected
						ArrayAdapter<String> australia_adptr=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line, Australia_States);
						sp2.setAdapter(australia_adptr);
					}
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) 
			{
				// TODO Auto-generated method stub
			}
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}