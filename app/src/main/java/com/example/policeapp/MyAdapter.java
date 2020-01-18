package com.example.policeapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);

        holder.textView.setText(listItem.getName());
        holder.mobileNo.setText(listItem.getMobile());
        holder.timeshift.setText(listItem.getTimeshift());
        holder.location.setText(listItem.getLocation());
        holder.assignedx.setText(listItem.getAssign());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView mobileNo;
        TextView timeshift;
        TextView location;
        TextView assignedx;
        Button button;
        public ViewHolder(final View itemView){
            super(itemView);

            this.textView=(TextView) itemView.findViewById(R.id.textView);
            this.mobileNo=(TextView) itemView.findViewById(R.id.mobileNo);
            this.timeshift=(TextView) itemView.findViewById(R.id.timeshift);
            this.location=(TextView) itemView.findViewById(R.id.location);
            this.assignedx=(TextView) itemView.findViewById(R.id.assignedx);
            this.button=(Button) itemView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),BeatActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("Name",textView.getText());
                    intent.putExtra("MobileNo",mobileNo.getText());
                    intent.putExtra("timeshift",timeshift.getText());
                    intent.putExtra("location",location.getText());
                    intent.putExtra("assignedx",assignedx.getText());
                    context.startActivity(intent);
                }
            });

        }
    }
}
