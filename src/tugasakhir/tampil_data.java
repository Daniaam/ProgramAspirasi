/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

/**
 *
 * @author IlhamTaufiqurrahmanS
 */
public class tampil_data {
    
    private String nisn;
    private String nama;
    private String absen;
    private String kelas;
    private String hp;
    private String aspirasi;

    public tampil_data(String nisn, String nama, String absen, String kelas, String hp, String aspirasi) {
        this.nisn = nisn;
        this.nama = nama;
        this.absen = absen;
        this.hp = hp;
        this.kelas = kelas;
        this.aspirasi = aspirasi;
        
    }

    tampil_data(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the nisn
     */
    public String getNisn() {
        return nisn;
    }

    /**
     * @param nisn the nisn to set
     */
    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the absen
     */
    public String getAbsen() {
        return absen;
    }

    /**
     * @param absen the absen to set
     */
    public void setAbsen(String absen) {
        this.absen = absen;
    }

    /**
     * @return the hp
     */
    

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    public String getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(String hp) {
        this.hp = hp;
    }

    /**
     * @return the aspirasi
     */
    public String getAspirasi() {
        return aspirasi;
    }

    /**
     * @param aspirasi the aspirasi to set
     */
    public void setAspirasi(String aspirasi) {
        this.aspirasi = aspirasi;
    }
    

  
    
    
    
    
    
}
