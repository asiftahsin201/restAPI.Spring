package com.example.adp;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    private String name;
    private Long passmark;
    private Boolean option;
    private Double beCertificate;
    private Boolean ehScore;

    public Module() {}

    public Module(String name, Long passmark, Boolean option, Double beCertificate, Boolean ehScore) {
        this.name = name;
        this.passmark = passmark;
        this.option = option;
        this.beCertificate = beCertificate;
        this.ehScore = ehScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPassmark() {
        return passmark;
    }

    public void setPassmark(Long passmark) {
        this.passmark = passmark;
    }

    public Boolean getOption() {
        return option;
    }

    public void setOption(Boolean option) {
        this.option = option;
    }

    public Double getBeCertificate() {
        return beCertificate;
    }

    public void setBeCertificate(Double beCertificate) {
        this.beCertificate = beCertificate;
    }

    public Boolean getEhScore() {
        return ehScore;
    }

    public void setEhScore(Boolean ehScore) {
        this.ehScore = ehScore;
    }
}
