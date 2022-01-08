package com.example.TanamanHias;

public class Tanaman {
    private String _id, _nama, _tipe;
    public Tanaman (String id, String nama, String tipe) {
        this._id = id;
        this._nama = nama;
        this._tipe = tipe;
    }
    public Tanaman() {
    }
    public String get_id() {
        return _id;
    } public void set_id(String _id) {
        this._id = _id;
    }public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_tipe() {
        return _tipe;
    }
    public void set_tipe(String _tipe) {
        this._tipe = _tipe;
    }
}
