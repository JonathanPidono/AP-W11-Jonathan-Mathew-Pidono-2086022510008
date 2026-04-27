package com.oop.week11sql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/matakuliah")
public class MataKuliahController {

    @Autowired
    private MataKuliahRepository matakuliahRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<MataKuliah> getAllMK() {
        return matakuliahRepository.findAll();
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewMK(
            @RequestParam String kode_mk,
            @RequestParam String nama_mk,
            @RequestParam int sks) {

        MataKuliah mk = new MataKuliah();
        mk.setKode_mk(kode_mk);
        mk.setNama_mk(nama_mk);
        mk.setSks(sks);

        matakuliahRepository.save(mk);
        return "Mata Kuliah Saved";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody MataKuliah getMKById(@PathVariable int id) {
        return matakuliahRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateMK(
            @PathVariable int id,
            @RequestParam String kode_mk,
            @RequestParam String nama_mk,
            @RequestParam int sks) {

        MataKuliah mk = matakuliahRepository.findById(id).orElse(null);
        if (mk == null) return "Data tidak ditemukan";

        mk.setKode_mk(kode_mk);
        mk.setNama_mk(nama_mk);
        mk.setSks(sks);

        matakuliahRepository.save(mk);
        return "Mata Kuliah Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteMK(@PathVariable int id) {
        matakuliahRepository.deleteById(id);
        return "Mata Kuliah Deleted";
    }
}