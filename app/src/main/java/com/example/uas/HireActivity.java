package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HireActivity extends AppCompatActivity {
    Spinner spProvinsi, spKotaKabupaten, spJenisArtwork, spUkuranFrame;

    String linkProvinsiAll = "https://dev.farizdotid.com/api/daerahindonesia/provinsi";
    String linkProvinsiSingle = "https://dev.farizdotid.com/api/daerahindonesia/provinsi/36";
    String linkKotaKabupaten = "https://dev.farizdotid.com/api/daerahindonesia/kota?id_provinsi=";

    ArrayList<String> listNamaProvinsi = new ArrayList<>();
    ArrayList<String> listNamaKotaKabupaten = new ArrayList<>();

    ArrayList<String> listIDProvinsi = new ArrayList<>();
    ArrayList<String> listIDKotaKabupaten = new ArrayList<>();

    Context context;
    ProgressDialog progressDialog;

    RadioGroup radioGroupHire;
    Button buttonSelanjutnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);

        context = this;
        progressDialog = new ProgressDialog(context);
        spProvinsi = findViewById(R.id.provinsiList);
        spKotaKabupaten = findViewById(R.id.kotaKabupatenList);
        spJenisArtwork = findViewById(R.id.jenisArtworkList);
        spUkuranFrame = findViewById(R.id.ukuranFrameList);

        radioGroupHire = findViewById(R.id.radioGroupHire);
        buttonSelanjutnya = findViewById(R.id.selanjutnyaHire);

        jenisArtworkData();
        ukuranFrameData();
        showData();

        buttonSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkIdHire = radioGroupHire.getCheckedRadioButtonId();
                if (checkIdHire == -1){
                    Toast.makeText(HireActivity.this, "Mohon untuk memilih terlebih dahulu!", Toast.LENGTH_LONG).show();
                } else {
                    findRadioButton(checkIdHire);
                }
                radioGroupHire.clearCheck();
            }
        });

    }

    private void findRadioButton(int checkIdHire) {
        switch (checkIdHire){
            case R.id.radioReferensi1:
                Intent radio_referensi1 = new Intent(HireActivity.this, HasilYangTelahDibuatActivity.class);
                startActivity(radio_referensi1);
                break;

            case R.id.radioReferensi2:
                Intent radio_referensi2 = new Intent(HireActivity.this, SesuaiKeinginanActivity.class);
                startActivity(radio_referensi2);
                break;

        }
    }


    private void ukuranFrameData() {
        ArrayAdapter<String> ukuranFrameAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.ukuran_frame));
        spUkuranFrame.setAdapter(ukuranFrameAdapter);
    }

    private void jenisArtworkData() {
        ArrayAdapter<String> artworkAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.jenis_artwork));
        spJenisArtwork.setAdapter(artworkAdapter);
    }

    private void showData() {
        progressDialog.setMessage("Memuat...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, linkProvinsiAll, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listIDProvinsi.clear();
                listNamaProvinsi.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("provinsi");
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        String id = object.getString("id");
                        String nama = object.getString("nama");

                        listIDProvinsi.add(id);
                        listNamaProvinsi.add(nama);
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listNamaProvinsi);
                    spProvinsi.setAdapter(arrayAdapter);

                    progressDialog.dismiss();
                    spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            showDataKota(listIDProvinsi.get(position));
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    private void showDataKota(String s) {
        progressDialog.setMessage("Memuat...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, linkKotaKabupaten + s,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listIDKotaKabupaten.clear();
                        listNamaKotaKabupaten.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("kota_kabupaten");
                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                String id = object.getString("id");
                                String nama = object.getString("nama");

                                listIDKotaKabupaten.add(id);
                                listNamaKotaKabupaten.add(nama);
                            }
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, listNamaKotaKabupaten);
                            spKotaKabupaten.setAdapter(arrayAdapter);
                            progressDialog.dismiss();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}