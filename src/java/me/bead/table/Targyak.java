/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.bead.table;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author szabolcs
 */
@Entity
@Table(name = "targyak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Targyak.findAll", query = "SELECT t FROM Targyak t")
    , @NamedQuery(name = "Targyak.findByIdTargy", query = "SELECT t FROM Targyak t WHERE t.idTargy = :idTargy")
    , @NamedQuery(name = "Targyak.findByTargyNeve", query = "SELECT t FROM Targyak t WHERE t.targyNeve = :targyNeve")})
public class Targyak implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_targy")
    private String idTargy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "targy_neve")
    private String targyNeve;

    public Targyak() {
    }

    public Targyak(String idTargy) {
        this.idTargy = idTargy;
    }

    public Targyak(String idTargy, String targyNeve) {
        this.idTargy = idTargy;
        this.targyNeve = targyNeve;
    }

    public String getIdTargy() {
        return idTargy;
    }

    public void setIdTargy(String idTargy) {
        this.idTargy = idTargy;
    }

    public String getTargyNeve() {
        return targyNeve;
    }

    public void setTargyNeve(String targyNeve) {
        this.targyNeve = targyNeve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTargy != null ? idTargy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Targyak)) {
            return false;
        }
        Targyak other = (Targyak) object;
        if ((this.idTargy == null && other.idTargy != null) || (this.idTargy != null && !this.idTargy.equals(other.idTargy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.bead.table.Targyak[ idTargy=" + idTargy + " ]";
    }
    
}
