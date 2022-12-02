package test.amsalwahyudi.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
@Table
public class DataPribadi {
    @Id
    @Column (name = "nik", nullable = false)
    private Integer nik;
    @Column (name = "nama_lengkap", nullable = false)
    private String namaLengkap;
    @Column (name = "jenis_kelamin")
    private String jenisKelamin;
    @Temporal(TemporalType.DATE)
    @Column (name = "tanggal_lahir")
    private Date tanggalLahir;
    @Column (name = "alamat")
    private String alamat;
    @Column (name = "negara")
    private String negara;

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }
}
