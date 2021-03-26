package com.example.listeplanete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class PlaneteAdapter extends BaseAdapter {

    Data data;
    MainActivity activ;
   static int nb=0;




    public PlaneteAdapter(MainActivity mainActivity){
        data = new Data();
        this.activ = mainActivity;
    }

    @Override
    public int getCount() {
        return data.getPlanetes().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getPlanetes().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activ.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);
        nomPlanete.setText(data.getPlanetes().get(position));
        final Button clic = activ.findViewById(R.id.button);
        //clic.setEnabled(false);

        //  installer l'adaptateur pour la liste déroulante (spinner)
        String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(activ, android.R.layout.simple_spinner_item, taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if (checkBox.isChecked()) {
                        spinner.setEnabled(false);
                        spinadapter.notifyDataSetChanged();
                        nb +=1;
                        if(nb == 9){
                            clic.setEnabled(true);
                        }
                        else{
                            clic.setEnabled(false);
                        }
                    } else {
                        spinner.setEnabled(true);
                        spinadapter.notifyDataSetChanged();
                        nb -=1;

                    }
                    Toast.makeText(activ, ""+nb, Toast.LENGTH_SHORT).show();

            }
        });

        return itemView;
    }
}
