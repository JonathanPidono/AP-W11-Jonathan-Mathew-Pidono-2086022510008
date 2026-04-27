package com.oop.week11sql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orangnya")
public class Orangnya {
    public Orangnya() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nama;
    public String nim;
    public String kelas;
    public int killcount;
    public int death;
    public int assist;

    public Orangnya(String nama, String nim, String kelas, int killcount, int death, int assist) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.killcount = killcount;
        this.death = death;
        this.assist = assist;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getKillcount() {
        return killcount;
    }
    public void setKillcount(int killcount) {
        this.killcount = killcount;
    }

    public int getDeath() {
        return death;
    }
    public void setDeath(int death) {
        this.death = death;
    }

    public int getAssist() {
        return assist;
    }
    public void setAssist(int assist) {
        this.assist = assist;
    }

}