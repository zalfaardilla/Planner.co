package com.roomdb.note.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Note implements Serializable {

    /*
     * Membuat id menjadi primary key dan sqlite akan membuat otomatis id yang unik
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    /*
     * Membuat judul menjadi kolom dalam entitas
     */
    @ColumnInfo(name = "judul")
    private String judul;

    /*
     * Membuat catatan menjadi kolom dalam entitas
     */
    @ColumnInfo(name = "catatan")
    private String catatan;

    /*
     * Membuat tanggal menjadi kolom dalam entitas
     */
    @ColumnInfo(name = "tanggal")
    private Date tanggal;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}