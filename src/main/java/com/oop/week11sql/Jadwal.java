package com.oop.week11sql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jadwal")
public class Jadwal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String hari;
    private String jam;
    private String ruangan;
    private String kode_mk;

    public Jadwal() {}

    public Jadwal(String hari, String jam, String ruangan, String kode_mk) {
        this.hari = hari;
        this.jam = jam;
        this.ruangan = ruangan;
        this.kode_mk = kode_mk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getKode_mk() {
        return kode_mk;
    }

    public void setKode_mk(String kode_mk) {
        this.kode_mk = kode_mk;
    }
}