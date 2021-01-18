package com.example.aditya.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     public void generatetable (final int progress,ListView mylistview,TextView seekBarValue){
         seekBarValue.setText(String.valueOf(progress));
        final ArrayList<Integer> tables=new ArrayList<Integer>();
        ArrayAdapter<Integer> myadapter=new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,tables);
        mylistview.setAdapter(myadapter);
        for(int i=1;i<=100;i++){
            tables.add(progress*i);
        }
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(progress)+"x"+String.valueOf((tables.get(position))/progress)+"="+tables.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekbar=(SeekBar) findViewById(R.id.seekBar);
        final TextView seekBarValue = (TextView)findViewById(R.id.seekbarValue);
        int max=20;
        int progress=10;
        seekbar.setMax(max);
        seekbar.setProgress(progress);
        final ListView mylistview=(ListView) findViewById(R.id.mylistview);
         generatetable(progress,mylistview,seekBarValue);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, final int progress, boolean fromUser) {
                if(progress==0){

                    seekBar.setProgress(1);
                    seekBarValue.setText(String.valueOf(1));
                }
                else{

                 generatetable(progress,mylistview,seekBarValue);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
