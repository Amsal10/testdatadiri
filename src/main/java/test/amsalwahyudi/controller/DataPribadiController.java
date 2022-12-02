package test.amsalwahyudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.amsalwahyudi.model.dto.DataPribadiDto;
import test.amsalwahyudi.model.dto.DefaultResponse;
import test.amsalwahyudi.model.entity.DataPribadi;
import test.amsalwahyudi.repository.DataPribadiRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/datapribadi")
public class DataPribadiController {
    @Autowired
    private DataPribadiRepository dataPribadiRepository;

    @PostMapping("/add")
    public DefaultResponse<DataPribadiDto> savedatapribadi(@RequestBody DataPribadiDto dataPribadiDto){
        DataPribadi buku = convertDtoToEntity(dataPribadiDto);
        DefaultResponse<DataPribadiDto> response = new DefaultResponse();
        Optional<DataPribadi> optional = dataPribadiRepository.findById(dataPribadiDto.getNik());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, Data Sudah Tersedia");
        } else {
            dataPribadiRepository.save(buku);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Berhasil Simpan Data");
        }

        return response;
    }
    public DataPribadi convertDtoToEntity(DataPribadiDto dto){
        DataPribadi dataPribadi = new DataPribadi();
        dataPribadi.setNik(dto.getNik());
        dataPribadi.setNamaLengkap(dto.getNama());
        dataPribadi.setJenisKelamin(dto.getJk());
        dataPribadi.setTanggalLahir(dto.getTtl());
        dataPribadi.setAlamat(dto.getAlamat());
        dataPribadi.setNegara(dto.getNegara());

        return dataPribadi;
    }

    // menampilkan seluruh data buku --buku/listbuku
    @GetMapping("/listdatapribadi")
    public List<DataPribadiDto> getListDataPribadi(){
        List<DataPribadiDto> list = new ArrayList();
        for(DataPribadi dataPribadi : dataPribadiRepository.findAll()){
            list.add(convertEntityToDto(dataPribadi));
        }
        return list;
    }

    public DataPribadiDto convertEntityToDto(DataPribadi entity){
        DataPribadiDto dto = new DataPribadiDto();
        dto.setNik(entity.getNik());
        dto.setNama(entity.getNamaLengkap());
        dto.setJk(entity.getJenisKelamin());
        dto.setTtl(entity.getTanggalLahir());
        dto.setAlamat(entity.getAlamat());
        dto.setNegara(entity.getNegara());

        return dto;
    }
    // menampilkan buku berdasarkan id --/buku/getbyid/{idbuku}
//    @GetMapping("/getbyid/{idBuku}")
//    public DataDto<DataPribadiDto> getByIdBuku(@PathVariable Integer idBuku) {
//        DataDto<DataPribadiDto> data = new DataDto<>();
//        Optional<test.amsalwahyudi.model.entity.DataPribadi> opt = dataPribadi.findByIdBuku(idBuku);
//        if (opt.isPresent()) {
//            data.setMessage("Data Ditemukan");
//            data.setData(convertEntityToDto(opt.get()));
//        } else {
//            data.setMessage("Data Tidak Ditemukan");
//        }
//        return data;
//    }
//    @GetMapping("/getbyjudul/{judulBuku}")
//    public DataDto<BukuDto> getByJudulBuku(@PathVariable String judulBuku) {
//        DataDto<BukuDto> data = new DataDto<>();
//        Optional<Buku> opt = bukuRepository.findByJudulBuku(judulBuku);
//        if (opt.isPresent()) {
//            data.setMessage("Data Ditemukan");
//            data.setData(convertEntityToDto(opt.get()));
//        } else {
//            data.setMessage("Data Tidak Ditemukan");
//        }
//        return data;
//    }

//    @GetMapping("/search/{search}")
//    public List<BukuDto> search(@PathVariable String search) {
////        String convertString = String.valueOf(search);
//        List<BukuDto> list = new ArrayList();
//        for(Buku buku :bukuRepository.search(search)){
//            list.add(convertEntityToDto(buku));
//        }
//        return list;
//    }
//    @GetMapping("/totalbuku")
//    public List<TotalBuku> getTotalBayar(){
//        List<TotalBuku> list = bukuRepository.getListTotalBuku();
//
//        return list;
//    }

    // menghapus data buku dari table  --/buku/delete/{idbuku}
    @DeleteMapping("/delete/{idDataPribadi}")
    public DefaultResponse deleteById(@PathVariable("idDataPribadi") Integer idNik) {
        DefaultResponse df = new DefaultResponse();
        Optional<DataPribadi> optionalDataPribadi = dataPribadiRepository.findById(idNik);
        if (optionalDataPribadi.isPresent()){
            dataPribadiRepository.delete(optionalDataPribadi.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }
    // meng-update judul buku dan penulis buku berdasarkan idBuku --/buku/update/{idbuku}
    @PutMapping("/update/{idDataPribadi}")
    public DefaultResponse update(@PathVariable("idDataPribadi") Integer idNik, @RequestBody DataPribadiDto dataPribadiDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<DataPribadi> optionalDataPribadi = dataPribadiRepository.findById(idNik);
        DataPribadi dataPribadi = optionalDataPribadi.get();
        if (optionalDataPribadi.isPresent()) {
            dataPribadi.setNik(dataPribadiDto.getNik());
            dataPribadi.setNamaLengkap(dataPribadiDto.getNama());
            dataPribadi.setJenisKelamin(dataPribadiDto.getJk());
            dataPribadi.setTanggalLahir(dataPribadiDto.getTtl());
            dataPribadi.setAlamat(dataPribadiDto.getAlamat());
            dataPribadi.setNegara(dataPribadiDto.getNegara());
            dataPribadiRepository.save(dataPribadi);
            df.setStatus(Boolean.TRUE);
//            df.setData(bukuDto);
            df.setMessage("Data berhasil diperbarui");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Sudah Terdaftar");
        }
        return df;
    }

}
