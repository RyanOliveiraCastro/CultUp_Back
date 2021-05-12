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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author RyanO
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pess_seq")
    @SequenceGenerator(name = "pess_seq", sequenceName = "pessoa_pesscodigo_seq", allocationSize = 1)
    @Column(name = "pesscodigo")
    private Integer pesscodigo;

    @Column(name = "pessnome")
    private String pessnome;

    @Column(name = "pessdtnasc")
    private String pessdtnasc;

    @Column(name = "pessemail")
    private String pessemail;

    @Column(name = "pesssenha")
    private String pesssenha;

    @Column(name = "pessimagem")
    private String pessimagem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidcodigo", referencedColumnName = "cidcodigo")
    private Cidade cidcodigo;

    public Pessoa(Integer pesscodigo) {
        this.pesscodigo = pesscodigo;
    }

    public Pessoa(String pessemail) {
        this.pessemail = pessemail;
    }

    public Pessoa(String pessemail, String pesssenha) {
        this.pessemail = pessemail;
        this.pesssenha = pesssenha;
    }

    public Integer getPesscodigo() {
        return this.pesscodigo;
    }
}
