package com.fetchmefun.listviewbasic;

public class MonHocModelClass {
    private String MonHoc;
    private String TinChi;
    private String Description;
    private int Image;

    public MonHocModelClass(String monHoc, String tinChi, String description, int image) {
        MonHoc = monHoc;
        TinChi = tinChi;
        Description = description;
        Image = image;
    }

    public String getMonHoc() {
        return MonHoc;
    }

    public void setMonHoc(String monHoc) {
        MonHoc = monHoc;
    }

    public String getTinChi() {
        return TinChi;
    }

    public void setTinChi(String tinChi) {
        TinChi = tinChi;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
