package com.oop.week11sql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jadwal")
public class JadwalController {

    @Autowired
    private JadwalRepository jadwalRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Jadwal> getAllJadwal() {
        return jadwalRepository.findAll();
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewJadwal(
            @RequestParam String hari,
            @RequestParam String jam,
            @RequestParam String ruangan,
            @RequestParam String kode_mk) {

        Jadwal j = new Jadwal();
        j.setHari(hari);
        j.setJam(jam);
        j.setRuangan(ruangan);
        j.setKode_mk(kode_mk);

        jadwalRepository.save(j);
        return "Jadwal Saved";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Jadwal getJadwalById(@PathVariable int id) {
        return jadwalRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateJadwal(
            @PathVariable int id,
            @RequestParam String hari,
            @RequestParam String jam,
            @RequestParam String ruangan,
            @RequestParam String kode_mk) {

        Jadwal j = jadwalRepository.findById(id).orElse(null);
        if (j == null) return "Data tidak ditemukan";

        j.setHari(hari);
        j.setJam(jam);
        j.setRuangan(ruangan);
        j.setKode_mk(kode_mk);

        jadwalRepository.save(j);
        return "Jadwal Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteJadwal(@PathVariable int id) {
        jadwalRepository.deleteById(id);
        return "Jadwal Deleted";
    }
}