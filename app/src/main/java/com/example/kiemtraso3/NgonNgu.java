package com.example.kiemtraso3;

public class NgonNgu {
    private  String ngonNgu;
    private  int hinhAnh;

    public NgonNgu() {
    }

    public NgonNgu(String ngonNgu, int hinhAnh) {
        this.ngonNgu = ngonNgu;
        this.hinhAnh = hinhAnh;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
