package com.oop.week11sql;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nilai")
public class Nilai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nim;
    public String mata_kuliah;
    public String semester;
    public double nilai_akhir;

    public Nilai() {}

    public Nilai(String nim, String mata_kuliah, String semester, double nilai_akhir) {
        this.nim = nim;
        this.mata_kuliah = mata_kuliah;
        this.semester = semester;
        this.nilai_akhir = nilai_akhir;
    }

    public int getId() { 
        return id; 
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public String getNim() { 
        return nim; 
    }

    public void setNim(String nim) { 
        this.nim = nim; 
    }

    public String getMata_kuliah() { 
        return mata_kuliah; 
    }

    public void setMata_kuliah(String mata_kuliah) { 
        this.mata_kuliah = mata_kuliah; 
    }

    public String getSemester() { 
        return semester; 
    }

    public void setSemester(String semester) { 
        this.semester = semester; 
    }

    public double getNilai_akhir() { 
        return nilai_akhir; 
    }

    public void setNilai_akhir(double nilai_akhir) { 
        this.nilai_akhir = nilai_akhir; 
    }
}