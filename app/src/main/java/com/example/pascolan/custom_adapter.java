package com.example.pascolan;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.UnsupportedEncodingException;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class custom_adapter extends RecyclerView.Adapter<custom_adapter.customviewholder> {

    private Context context;
    private User[] data;
    ImageView tick;

    public custom_adapter(Context context, User[] data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public customviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout,parent,false);
        return new customviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final customviewholder holder, int position) {
        final User user = data[position];

        try {
            String utf8 = new String(user.getN().getBytes("ISO-8859-1"),"UTF-8");
            holder.txtUser.setText(utf8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //String a = new String(utf8,"UTF-8");
        Glide.with(holder.imgUser.getContext()).load(user.getP()).into(holder.imgUser);

        holder.imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,holder.tick.getVisibility(),Toast.LENGTH_SHORT).show();
                //holder.tick.setVisibility(VISIBLE);

                if (holder.tick.getVisibility() != VISIBLE){
                    holder.tick.setVisibility(VISIBLE);
                    Toast.makeText(context,"ID: " + user.getI().toString(),Toast.LENGTH_SHORT).show();
                }
                else if(holder.tick.getVisibility() != INVISIBLE){
                    holder.tick.setVisibility(INVISIBLE);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class customviewholder extends RecyclerView.ViewHolder{
        ImageButton imgUser;
        TextView txtUser;
        ImageView tick;

        public customviewholder(View itemView) {
            super(itemView);
            imgUser = (ImageButton) itemView.findViewById(R.id.image);
            txtUser = (TextView)itemView.findViewById(R.id.name);
            tick = (ImageView)itemView.findViewById(R.id.imageView1);
        }
    }

}
