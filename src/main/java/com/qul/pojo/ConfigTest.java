package com.qul.pojo;

import java.io.Serializable;

public class ConfigTest implements Serializable {

    private Long id;

    private int kaiguan;

    private String noot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKaiguan() {
        return kaiguan;
    }

    public void setKaiguan(int kaiguan) {
        this.kaiguan = kaiguan;
    }

    public String getNoot() {
        return noot;
    }

    public void setNoot(String noot) {
        this.noot = noot;
    }

    @Override
    public String toString() {
        return "ConfigTest{" +
                "id=" + id +
                ", kaiguan=" + kaiguan +
                ", noot='" + noot + '\'' +
                '}';
    }
}
