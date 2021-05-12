/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rroliveira
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eve_seq")
    @SequenceGenerator(name = "eve_seq", sequenceName = "evento_evecodigo_seq", allocationSize = 1)
    @Column(name = "evecodigo")
    private Integer evecodigo;

    @Column(name = "evetitulo")
    private String evetitulo;

    @Column(name = "evesubtitulo")
    private String evesubtitulo;

    @Column(name = "evedescricao")
    private String evedescricao;

    @Column(name = "evelocal")
    private String evelocal;

    @Column(name = "evedata")
    private String evedata;

    @Column(name = "evehora")
    private String evehora;

    @Column(name = "eveimagem")
    private String eveimagem;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endcodigo", referencedColumnName = "endcodigo")
    private Endereco endcodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pesscodigo", referencedColumnName = "pesscodigo")
    private Pessoa pesscodigo;

    public Evento(Integer evecodigo) {
        this.evecodigo = evecodigo;
    }

}
