package com.lesson03.enity;

public class Khoa {
    String makh;
    String tenkh;

    public Khoa() {}
    public Khoa(String makh, String tenkh) {
        this.makh = makh;
        this.tenkh = tenkh;
    }

    public String getMakh() {
        return makh;
    }
    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }
    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }
}
