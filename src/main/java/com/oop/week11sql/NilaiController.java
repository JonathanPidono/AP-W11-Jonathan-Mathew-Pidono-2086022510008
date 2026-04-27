package com.oop.week11sql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nilai")
public class NilaiController {

    @Autowired
    private NilaiRepository nilaiRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Nilai> getAllNilai() {
        return nilaiRepository.findAll();
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewNilai(
            @RequestParam String nim,
            @RequestParam String mata_kuliah,
            @RequestParam String semester,
            @RequestParam double nilai_akhir) {

        Nilai n = new Nilai();
        n.setNim(nim); // Pastikan ini sesuai dengan nama setter di file Nilai.java kamu
        n.setMata_kuliah(mata_kuliah);
        n.setSemester(semester);
        n.setNilai_akhir(nilai_akhir);

        nilaiRepository.save(n);
        return "Nilai Saved";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Nilai getNilaiById(@PathVariable int id) {
        return nilaiRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateNilai(
            @PathVariable int id,
            @RequestParam String nim,
            @RequestParam String mata_kuliah,
            @RequestParam String semester,
            @RequestParam double nilai_akhir) {

        Nilai n = nilaiRepository.findById(id).orElse(null);
        if (n == null) return "Data tidak ditemukan";

        n.setNim(nim);
        n.setMata_kuliah(mata_kuliah);
        n.setSemester(semester);
        n.setNilai_akhir(nilai_akhir);

        nilaiRepository.save(n);
        return "Nilai Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteNilai(@PathVariable int id) {
        nilaiRepository.deleteById(id);
        return "Nilai Deleted";
    }
}