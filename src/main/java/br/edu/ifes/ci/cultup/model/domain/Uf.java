/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.ci.cultup.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author RyanO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "uf")
public class Uf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ufcodigo")
    private Integer ufcodigo;

    @Column(name = "ufsigla", length = 2)
    private String ufsigla;

    @Column(name = "ufnome")
    private String ufnome;

    @Column(name = "paiscodigo")
    private Integer paiscodigo;

    public Integer getUfcodigo() {
        return this.ufcodigo;
    }

    @Override
    public String toString() {
        return this.ufnome;
    }

}
