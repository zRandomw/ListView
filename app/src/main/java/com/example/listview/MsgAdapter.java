package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    List<Msg> list;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        LinearLayout linearLayout2;

        public TextView textView;
        public TextView textView2;
        public ViewHolder(View itemView) {
            super(itemView);
            this.linearLayout=itemView.findViewById(R.id.left_layout);
            this.linearLayout2=itemView.findViewById(R.id.right_layout);
            this.textView=itemView.findViewById(R.id.left_msg);
            this.textView2=itemView.findViewById(R.id.right_msg);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public MsgAdapter(List<Msg> list) {
        this.list = list;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
      ViewHolder viewHolder = new ViewHolder(view);
      return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            Msg msg=list.get(position);
            if (msg.getType()==Msg.TYPE_RECEIVED){
                holder.linearLayout.setVisibility(View.VISIBLE);
                holder.linearLayout2.setVisibility(View.GONE);
                holder.textView.setText(msg.getContent());
            }else if(msg.getType()==Msg.TYPE_SENT){
                holder.linearLayout2.setVisibility(View.VISIBLE);
                holder.linearLayout.setVisibility(View.GONE);
                holder.textView2.setText(msg.getContent());
            }
    }
}
