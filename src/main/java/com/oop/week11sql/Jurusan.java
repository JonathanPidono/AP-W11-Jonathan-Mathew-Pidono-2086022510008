package com.oop.week11sql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jurusan")
public class Jurusan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nama_jurusan;
    private String kode_jurusan;
    private String fakultas;

    public Jurusan() {}

    public Jurusan(String nama_jurusan, String kode_jurusan, String fakultas) {
        this.nama_jurusan = nama_jurusan;
        this.kode_jurusan = kode_jurusan;
        this.fakultas = fakultas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_jurusan() {
        return nama_jurusan;
    }

    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    public String getKode_jurusan() {
        return kode_jurusan;
    }

    public void setKode_jurusan(String kode_jurusan) {
        this.kode_jurusan = kode_jurusan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
}