package com.xy.entity;

public class TempEntity {
    private Integer id;

    private String name;

    private String abcDd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbcDd() {
        return abcDd;
    }

    public void setAbcDd(String abcDd) {
        this.abcDd = abcDd;
    }

    @Override
    public String toString() {
        return "TempEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abcDd='" + abcDd + '\'' +
                '}';
    }
}