package com.jason.pojo;

import java.io.Serializable;

/**
 * @Description: PACKAGE_NAME
 */
public class Emp implements Serializable {
    private Integer id;
    private String name;
    private String photo;
    private Integer did;

    @Override
    public String toString() {
        return "com.jason.pojo.Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", did=" + did +
                '}';
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Emp(Integer id, String name, String photo, Integer did) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.did = did;
    }

    public Emp() {
    }
}
