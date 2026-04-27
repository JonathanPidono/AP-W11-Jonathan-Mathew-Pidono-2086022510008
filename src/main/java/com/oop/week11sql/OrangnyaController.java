package com.oop.week11sql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orangnya")
public class OrangnyaController {

    @Autowired
    private OrangnyaRepository orangnyaRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Orangnya> getAllOrangnya() {
        return orangnyaRepository.findAll();
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewOrang(
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String kelas,
            @RequestParam int kill,
            @RequestParam int death,
            @RequestParam int assist) {

        Orangnya o = new Orangnya();
        o.setNama(nama);
        o.setNim(nim);
        o.setKelas(kelas);
        o.setKillcount(kill);
        o.setDeath(death);
        o.setAssist(assist);

        orangnyaRepository.save(o);
        return "Saved";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Orangnya getOrangById(@PathVariable int id) {
        return orangnyaRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/update/{id}")
    public @ResponseBody String updateOrang(
            @PathVariable int id,
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String kelas,
            @RequestParam int kill,
            @RequestParam int death,
            @RequestParam int assist) {

        Orangnya o = orangnyaRepository.findById(id).orElse(null);
        if (o == null) return "Data tidak ditemukan";

        o.setNama(nama);
        o.setNim(nim);
        o.setKelas(kelas);
        o.setKillcount(kill);
        o.setDeath(death);
        o.setAssist(assist);

        orangnyaRepository.save(o);
        return "Updated";
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteOrang(@PathVariable int id) {
        orangnyaRepository.deleteById(id);
        return "Deleted";
    }
}