package com.oop.week11sql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jurusan")
public class JurusanController {

    @Autowired
    private JurusanRepository jurusanRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Jurusan> getAllJurusan() {
        return jurusanRepository.findAll();
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewJurusan(
            @RequestParam String nama_jurusan,
            @RequestParam String kode_jurusan,
            @RequestParam String fakultas) {

        Jurusan j = new Jurusan();
        j.setNama_jurusan(nama_jurusan);
        j.setKode_jurusan(kode_jurusan);
        j.setFakultas(fakultas);

        jurusanRepository.save(j);
        return "Jurusan Saved";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Jurusan getJurusanById(@PathVariable int id) {
        return jurusanRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateJurusan(
            @PathVariable int id,
            @RequestParam String nama_jurusan,
            @RequestParam String kode_jurusan,
            @RequestParam String fakultas) {

        Jurusan j = jurusanRepository.findById(id).orElse(null);
        if (j == null) return "Data tidak ditemukan";

        j.setNama_jurusan(nama_jurusan);
        j.setKode_jurusan(kode_jurusan);
        j.setFakultas(fakultas);

        jurusanRepository.save(j);
        return "Jurusan Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteJurusan(@PathVariable int id) {
        jurusanRepository.deleteById(id);
        return "Jurusan Deleted";
    }
}