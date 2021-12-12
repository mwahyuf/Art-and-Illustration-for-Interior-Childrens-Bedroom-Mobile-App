package com.example.uas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<itemModelGaleri> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView creatorName;
        TextView textSubHead;
        ImageView imageIcon;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textHead = itemView.findViewById(R.id.textView);
            creatorName = itemView.findViewById(R.id.textView_creator);
            textSubHead = itemView.findViewById(R.id.textView_genre);
            imageIcon = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    RecyclerViewAdapter(Context context,ArrayList<itemModelGaleri> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_galeri, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        TextView textHead = holder.textHead;
        TextView creatorName = holder.creatorName;
        TextView textSubHead = holder.textSubHead;
        ImageView imageIcon = holder.imageIcon;

        textHead.setText(dataItem.get(position).getName());
        creatorName.setText(dataItem.get(position).getCreator());
        textSubHead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(v -> {

            if (dataItem.get(position).getName().equals("Liyue")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.phantasy_1);
                intent.putExtra("JUDUL_DEFAULT", "Judul : Liyue");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Tony Krugar");
                intent.putExtra("GENRE_DEFAULT", "Genre : Fantasy");
                intent.putExtra("TANGGAL_DEFAULT", "5 Agustus 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("The Forest Vibe")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.phantasy_2);
                intent.putExtra("JUDUL_DEFAULT", "Judul : The Forest Vibe");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Aaron Yoghurt");
                intent.putExtra("GENRE_DEFAULT", "Genre : Fantasy");
                intent.putExtra("TANGGAL_DEFAULT", "2 Juni 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("The Autumn")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.phantasy_3);
                intent.putExtra("JUDUL_DEFAULT", "Judul : The Autumn");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Tony Grisha");
                intent.putExtra("GENRE_DEFAULT", "Genre : Fantasy");
                intent.putExtra("TANGGAL_DEFAULT", "10 Juni 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("Kid's Idol")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.super_hero_idol);
                intent.putExtra("JUDUL_DEFAULT", "Judul : Kid's Idol");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : John Kennedy");
                intent.putExtra("GENRE_DEFAULT", "Genre : Super Hero");
                intent.putExtra("TANGGAL_DEFAULT", "28 Februari 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("The Flash")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.the_flash);
                intent.putExtra("JUDUL_DEFAULT", "Judul : The Flash");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Kenzo");
                intent.putExtra("GENRE_DEFAULT", "Genre : Super Hero");
                intent.putExtra("TANGGAL_DEFAULT", "29 Februari 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("Camping")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.cartoon_1);
                intent.putExtra("JUDUL_DEFAULT", "Judul : Camping");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Shun Nita");
                intent.putExtra("GENRE_DEFAULT", "Genre : Cartoon");
                intent.putExtra("TANGGAL_DEFAULT", "15 Juli 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("Library")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.cartoon_2);
                intent.putExtra("JUDUL_DEFAULT", "Judul : Library");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Tony Jaa");
                intent.putExtra("GENRE_DEFAULT", "Genre : Cartoon");
                intent.putExtra("TANGGAL_DEFAULT", "12 Juli 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("Fishing")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.cartoon_3);
                intent.putExtra("JUDUL_DEFAULT", "Judul : Fishing");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Iko Taslim");
                intent.putExtra("GENRE_DEFAULT", "Genre : Cartoon");
                intent.putExtra("TANGGAL_DEFAULT", "7 Maret 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("Cost of Freedom")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.sunset);
                intent.putExtra("JUDUL_DEFAULT", "Judul : Cost of Freedom");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Carla");
                intent.putExtra("GENRE_DEFAULT", "Genre : Cartoon");
                intent.putExtra("TANGGAL_DEFAULT", "20 Juli 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("Planet")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.titan);
                intent.putExtra("JUDUL_DEFAULT", "Judul : Planet");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Keith Shadith");
                intent.putExtra("GENRE_DEFAULT", "Genre : Fantasy");
                intent.putExtra("TANGGAL_DEFAULT", "1 Maret 2021");
                context.startActivity(intent);
            }

            if (dataItem.get(position).getName().equals("The Patriot")){
                Intent intent = new Intent(context, GaleriDefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.supremacy);
                intent.putExtra("JUDUL_DEFAULT", "Judul : The Patriot");
                intent.putExtra("PEMBUAT_DEFAULT", "Dibuat oleh : Eren Fadli");
                intent.putExtra("GENRE_DEFAULT", "Genre : Cartoon");
                intent.putExtra("TANGGAL_DEFAULT", "8 Desember 2021");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }


}
