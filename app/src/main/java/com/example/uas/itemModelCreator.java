package com.example.uas;

public class itemModelCreator {
    String nama;
    String lokasi;

    public itemModelCreator(String nama, String lokasi) {
        this.nama = nama;
        this.lokasi = lokasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}

