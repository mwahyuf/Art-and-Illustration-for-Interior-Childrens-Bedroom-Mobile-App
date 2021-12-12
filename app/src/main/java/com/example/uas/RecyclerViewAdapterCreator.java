package com.example.uas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapterCreator extends RecyclerView.Adapter<RecyclerViewAdapterCreator.ViewHolder> {

    private ArrayList<itemModelCreator> dataItem;

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textCreatorName;
        TextView textCreatorLocation;
        LinearLayoutCompat parentLayoutCreator;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textCreatorName = itemView.findViewById(R.id.creatorName);
            textCreatorLocation = itemView.findViewById(R.id.creatorLocationText);
            parentLayoutCreator = itemView.findViewById(R.id.parentLayoutCreator);

        }
    }

    RecyclerViewAdapterCreator(Context context, ArrayList<itemModelCreator> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterCreator.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_creator, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCreator.ViewHolder holder, int position) {
        TextView textCreatorName = holder.textCreatorName;
        TextView textCreatorLocation = holder.textCreatorLocation;

        textCreatorName.setText(dataItem.get(position).getNama());
        textCreatorLocation.setText(dataItem.get(position).getLokasi());

        /*holder.parentLayoutCreator.setOnClickListener(v -> {

            if (dataItem.get(position).getNama().equals("Tony Krugar")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Tony Krugar");
                intent.putExtra("LOKASICREATOR_DEFAULT", "DKI Jakaarta, Indonesia");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "5 Desember 2018");
            }

            if (dataItem.get(position).getNama().equals("Aaron Yoghurt")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Aaron Yoghurt");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Jawa Barat, Bandung");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "20 Januari 2019");
            }

            if (dataItem.get(position).getNama().equals("Tony Grisha")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Tony Grisha");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Palembang, Sumatera Selatan");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "24 Agustus 2015");
            }

            if (dataItem.get(position).getNama().equals("Jhon Kennedy")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Jhon Kennedy");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Medan, Sumatera Utara");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "17 Agustus 2020");
            }

            if (dataItem.get(position).getNama().equals("Kenzo")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Kenzo");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Surabaya, Jawa Timur");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "15 Februari 2017");
            }

            if (dataItem.get(position).getNama().equals("Shun Nita")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Shun Nita");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Malang, Jawa Timur");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "29 Februari 2017");
            }

            if (dataItem.get(position).getNama().equals("Tony Jaa")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Tony Jaa");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Banjarmasin, Kalimantan Selatan");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "25 Januari 2019");
            }

            if (dataItem.get(position).getNama().equals("Iko Taslim")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Iko Taslim");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Pontianak, Kalimantan Barat");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "5 Oktober 2017");
            }

            if (dataItem.get(position).getNama().equals("Carla")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Carla");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Makassar, Sulawesi Selatan");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "22 September 2019");
            }

            if (dataItem.get(position).getNama().equals("Keith Shadith")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Keith Shadith");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Banda Aceh, Aceh");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "5 Mei 2020");
            }

            if (dataItem.get(position).getNama().equals("Eren Fadli")){
                Intent intent = new Intent(context, ProfilCreatorDefaultActivity.class);
                intent.putExtra("NAMACREATOR_DEFAULT", "Eren Fadli");
                intent.putExtra("LOKASICREATOR_DEFAULT", "Denpasar, Bali");
                intent.putExtra("SEJAKCREATOR_DEFAULT", "8 Desember 2015");
            }

        });*/

    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }


}
