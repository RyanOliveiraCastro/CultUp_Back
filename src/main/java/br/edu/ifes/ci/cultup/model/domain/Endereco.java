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
@Table(name = "endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end_seq")
    @SequenceGenerator(name = "end_seq", sequenceName = "endereco_endcodigo_seq", allocationSize = 1)
    @Column(name = "endcodigo")
    private Integer endcodigo;

    @Column(name = "endcep")
    private String endcep;

    @Column(name = "endlogradouro")
    private String endlogradouro;

    @Column(name = "endbairro")
    private String endbairro;

    @Column(name = "endpontoreferencia")
    private String endpontoreferencia;

    @Column(name = "endnumero")
    private Integer endnumero;

    @Column(name = "enddate")
    private String enddate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cidcodigo", referencedColumnName = "cidcodigo")
    private Cidade cidcodigo;
}
