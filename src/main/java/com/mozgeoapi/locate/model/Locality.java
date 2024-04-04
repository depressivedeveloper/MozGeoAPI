package com.mozgeoapi.locate.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity(name = "locality")
public class Locality {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;
    @Column(nullable = false, unique = true)
    private String uuid;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "locality_id")
    private List<Neighborhood> neighborhoodList;

    public Locality() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Locality(String name) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
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

    public List<Neighborhood> getNeighborhoodList() {
        return neighborhoodList;
    }

    public void setNeighborhoodList(List<Neighborhood> neighborhoodList) {
        this.neighborhoodList = neighborhoodList;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", neighborhoodList=" + neighborhoodList +
                '}';
    }
}
