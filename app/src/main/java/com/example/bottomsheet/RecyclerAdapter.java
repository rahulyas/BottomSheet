package com.example.bottomsheet;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    int row_index =0;
    Context context;
    ArrayList<Model> model;

    public RecyclerAdapter(Context context, ArrayList<Model> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.bind(model.get(position));
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView language1,language2;
        CardView cardview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            language1=itemView.findViewById(R.id.language1);
            language2=itemView.findViewById(R.id.language2);
            cardview=itemView.findViewById(R.id.cardview);
        }
        void bind(final Model model){
            language1.setText(model.language1);
            language2.setText(model.language2);
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.setSelected(!model.isSelected());
                    if(model.isSelected()){
                        cardview.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                        language1.setTextColor(Color.parseColor("#FF000000"));
                        language2.setTextColor(Color.parseColor("#8C8C8C"));
                    }else{
                        cardview.setBackgroundColor(Color.parseColor("#131217"));
                        language1.setTextColor(Color.parseColor("#ffffff"));
                        language2.setTextColor(Color.parseColor("#ffffff"));
                    }
                }
            });
        }
    }
    //Getting All Items Selected
    public ArrayList<Model> getAll(){ return model;}

    //Getting selected when btn clicked
    public ArrayList<Model> getSelected(){
        ArrayList<Model> selected = new ArrayList<>();
        for( int i=0; i< model.size() ; i++){
            if(model.get(i).isSelected()){
                selected.add(model.get(i));
            }
        }
        return selected;
    }

}
