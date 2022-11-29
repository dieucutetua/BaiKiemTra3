package com.example.kiemtraso3;

public class ThuVien {
    private String tenNgonNgu,viDu, id;

    @Override
    public String toString() {
        return "ThuVien{" +
                "tenNgonNgu='" + tenNgonNgu + '\'' +
                ", viDu='" + viDu + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public ThuVien() {
    }

    public ThuVien(String tenNgonNgu, String viDu) {
        this.tenNgonNgu = tenNgonNgu;
        this.viDu = viDu;

    }

    public String getTenNgonNgu() {
        return tenNgonNgu;
    }

    public void setTenNgonNgu(String tenNgonNgu) {
        this.tenNgonNgu = tenNgonNgu;
    }

    public String getViDu() {
        return viDu;
    }

    public void setViDu(String viDu) {
        this.viDu = viDu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
