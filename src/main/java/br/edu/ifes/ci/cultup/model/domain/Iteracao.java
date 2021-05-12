/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.domain;

import java.io.Serializable;
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
@Table(name = "iteracao")
public class Iteracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ite_seq")
    @SequenceGenerator(name = "ite_seq", sequenceName = "iteracao_itecodigo_seq", allocationSize = 1)
    @Column(name = "itecodigo")
    private Integer itecodigo;

    @Column(name = "iteinteresse")
    private Boolean iteinteresse;

    @Column(name = "iteeuvou")
    private Boolean iteeuvou;

    @Column(name = "itefavorito")
    private Boolean itefavorito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pesscodigo", referencedColumnName = "pesscodigo")
    private Pessoa pesscodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "evecodigo", referencedColumnName = "evecodigo")
    private Evento evecodigo;

    public Iteracao(Pessoa pesscodigo, Evento evecodigo) {
        this.evecodigo = evecodigo;
        this.pesscodigo = pesscodigo;
    }

}
