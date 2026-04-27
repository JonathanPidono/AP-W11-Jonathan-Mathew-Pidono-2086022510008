package com.oop.week11sql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dosen")
public class DosenController {

    @Autowired
    private DosenRepository dosenRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Dosen> getAllDosen() {
        return dosenRepository.findAll();
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewDosen(
            @RequestParam String nip,
            @RequestParam String nama_dosen,
            @RequestParam String email) {

        Dosen d = new Dosen();
        d.setNip(nip);
        d.setNama_dosen(nama_dosen);
        d.setEmail(email);

        dosenRepository.save(d);
        return "Dosen Saved";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Dosen getDosenById(@PathVariable int id) {
        return dosenRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateDosen(
            @PathVariable int id,
            @RequestParam String nip,
            @RequestParam String nama_dosen,
            @RequestParam String email) {

        Dosen d = dosenRepository.findById(id).orElse(null);
        if (d == null) return "Data tidak ditemukan";

        d.setNip(nip);
        d.setNama_dosen(nama_dosen);
        d.setEmail(email);

        dosenRepository.save(d);
        return "Dosen Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteDosen(@PathVariable int id) {
        dosenRepository.deleteById(id);
        return "Dosen Deleted";
    }
}