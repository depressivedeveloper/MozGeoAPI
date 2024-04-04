package com.mozgeoapi.locate.model;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity(name = "province")
@Table
public class Province {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;
    @Column(nullable = false, unique = true)
    private String uuid;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String capital;
    private Long latitude;
    private Long longitude;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id")
    private List<District> districtList;


    public Province(){
        this.uuid = UUID.randomUUID().toString();
    }

    public Province (String name, String capital) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.capital = capital;
    }

    public Province (String name, String capital, Long latitude, Long longitude) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", districtList=" + districtList +
                '}';
    }
}


