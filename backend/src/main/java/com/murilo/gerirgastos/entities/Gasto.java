package com.murilo.gerirgastos.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Gasto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorGasto;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar dataGasto;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cd_financa")
    private Financa financa;

    public Gasto(Long id, Double valorGasto, Calendar dataGasto) {
        this.id = id;
        this.valorGasto = valorGasto;
        this.dataGasto = dataGasto;
    }

    public Gasto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(Double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Calendar getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(Calendar dataGasto) {
        this.dataGasto = dataGasto;
    }

    public Financa getFinanca() {
        return financa;
    }

    public void setFinanca(Financa financa) {
        this.financa = financa;
    }
}
