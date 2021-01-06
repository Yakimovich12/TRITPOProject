package com.example.organizer;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CheckBox;

import java.util.List;

public class DailyTaskAdapter extends ArrayAdapter <DailyTask>
{
private LayoutInflater inflater;
private int layout;
private List<DailyTask> dtl;
public DailyTaskAdapter(Context context,int resource,List<DailyTask> dtl0)
        {
        super(context,resource,dtl0);
        this.dtl=dtl0;
        this.inflater=LayoutInflater.from(context);
        this.layout=resource;
        }
public View getView(int position,View convertView,ViewGroup parent)
        {
        if(convertView==null)
        {
        convertView=inflater.inflate(this.layout,parent,false);
        }

        TextView nameT=(TextView)convertView.findViewById(R.id.name);
        TextView deadlineT=(TextView)convertView.findViewById(R.id.deadline);
        CheckBox flagT=(CheckBox)convertView.findViewById(R.id.flag);
        DailyTask dayT=dtl.get(position);
        nameT.setText(dayT.getName());
        deadlineT.setText((dayT.getDate().getYear()+"/"+dayT.getDate().getMonth()+"/"+dayT.getDate().getDay()));
        flagT.setChecked(dayT.getFlag());
        flagT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
        {
        //перезапись файлов genT
        dayT.setFlag(isChecked);
        }
        });

        return convertView;
        }

}

