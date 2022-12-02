package test.amsalwahyudi.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DataPribadiDto {
    private Integer nik;
    private String nama;
    private String jk;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date ttl;
    private String alamat;
    private String negara;

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public Date getTtl() {
        return ttl;
    }

    public void setTtl(Date ttl) {
        this.ttl = ttl;
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
