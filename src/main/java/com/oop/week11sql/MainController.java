package com.oop.week11sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MainController {

    @Autowired private OrangnyaRepository orangnyaRepository;
    @Autowired private NilaiRepository nilaiRepository;
    @Autowired private MataKuliahRepository matakuliahRepository;
    @Autowired private JurusanRepository jurusanRepository;
    @Autowired private JadwalRepository jadwalRepository;
    @Autowired private DosenRepository dosenRepository;


    @GetMapping("/orangnya/all")
    public @ResponseBody Iterable<Orangnya> getAllOrangnya() {
        return orangnyaRepository.findAll();
    }

    @GetMapping("/orangnya/add")
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
        return "Orangnya Saved";
    }

    @GetMapping("/orangnya/{id}")
    public @ResponseBody Orangnya getOrangById(@PathVariable int id) {
        return orangnyaRepository.findById(id).orElse(null);
    }

    @GetMapping("/orangnya/update/{id}")
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
        return "Orangnya Updated";
    }

    @GetMapping("/orangnya/delete/{id}")
    public @ResponseBody String deleteOrang(@PathVariable int id) {
        orangnyaRepository.deleteById(id);
        return "Orangnya Deleted";
    }

    @GetMapping("/nilai/all")
    public @ResponseBody Iterable<Nilai> getAllNilai() {
        return nilaiRepository.findAll();
    }

    @GetMapping("/nilai/add")
    public @ResponseBody String addNewNilai(
            @RequestParam String nim, 
            @RequestParam String mata_kuliah,
            @RequestParam String semester, 
            @RequestParam double nilai_akhir) {

        Nilai n = new Nilai();
        n.setNim(nim); 
        n.setMata_kuliah(mata_kuliah);
        n.setSemester(semester); 
        n.setNilai_akhir(nilai_akhir);
        nilaiRepository.save(n);
        return "Nilai Saved";
    }

    @GetMapping("/nilai/{id}")
    public @ResponseBody Nilai getNilaiById(@PathVariable int id) {
        return nilaiRepository.findById(id).orElse(null);
    }

    @GetMapping("/nilai/update/{id}")
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

    @GetMapping("/nilai/delete/{id}")
    public @ResponseBody String deleteNilai(@PathVariable int id) {
        nilaiRepository.deleteById(id);
        return "Nilai Deleted";
    }

    @GetMapping("/matakuliah/all")
    public @ResponseBody Iterable<MataKuliah> getAllMK() {
        return matakuliahRepository.findAll();
    }

    @GetMapping("/matakuliah/add")
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

    @GetMapping("/matakuliah/{id}")
    public @ResponseBody MataKuliah getMKById(@PathVariable int id) {
        return matakuliahRepository.findById(id).orElse(null);
    }

    @GetMapping("/matakuliah/update/{id}")
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

    @GetMapping("/matakuliah/delete/{id}")
    public @ResponseBody String deleteMK(@PathVariable int id) {
        matakuliahRepository.deleteById(id);
        return "Mata Kuliah Deleted";
    }

    @GetMapping("/jurusan/all")
    public @ResponseBody Iterable<Jurusan> getAllJurusan() {
        return jurusanRepository.findAll();
    }

    @GetMapping("/jurusan/add")
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

    @GetMapping("/jurusan/{id}")
    public @ResponseBody Jurusan getJurusanById(@PathVariable int id) {
        return jurusanRepository.findById(id).orElse(null);
    }

    @GetMapping("/jurusan/update/{id}")
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

    @GetMapping("/jurusan/delete/{id}")
    public @ResponseBody String deleteJurusan(@PathVariable int id) {
        jurusanRepository.deleteById(id);
        return "Jurusan Deleted";
    }

    @GetMapping("/jadwal/all")
    public @ResponseBody Iterable<Jadwal> getAllJadwal() {
        return jadwalRepository.findAll();
    }

    @GetMapping("/jadwal/add")
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

    @GetMapping("/jadwal/{id}")
    public @ResponseBody Jadwal getJadwalById(@PathVariable int id) {
        return jadwalRepository.findById(id).orElse(null);
    }

    @GetMapping("/jadwal/update/{id}")
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

    @GetMapping("/jadwal/delete/{id}")
    public @ResponseBody String deleteJadwal(@PathVariable int id) {
        jadwalRepository.deleteById(id);
        return "Jadwal Deleted";
    }

    @GetMapping("/dosen/all")
    public @ResponseBody Iterable<Dosen> getAllDosen() {
        return dosenRepository.findAll();
    }

    @GetMapping("/dosen/add")
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

    @GetMapping("/dosen/{id}")
    public @ResponseBody Dosen getDosenById(@PathVariable int id) {
        return dosenRepository.findById(id).orElse(null);
    }

    @GetMapping("/dosen/update/{id}")
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

    @GetMapping("/dosen/delete/{id}")
    public @ResponseBody String deleteDosen(@PathVariable int id) {
        dosenRepository.deleteById(id);
        return "Dosen Deleted";
    }
}