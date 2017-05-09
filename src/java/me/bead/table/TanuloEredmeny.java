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
@Table(name = "tanulo_eredmeny")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TanuloEredmeny.findAll", query = "SELECT t FROM TanuloEredmeny t")
    , @NamedQuery(name = "TanuloEredmeny.findByIdHalNeptun", query = "SELECT t FROM TanuloEredmeny t WHERE t.idHalNeptun = :idHalNeptun")
    , @NamedQuery(name = "TanuloEredmeny.findByHalTargy", query = "SELECT t FROM TanuloEredmeny t WHERE t.halTargy = :halTargy")
    , @NamedQuery(name = "TanuloEredmeny.findByEredmeny", query = "SELECT t FROM TanuloEredmeny t WHERE t.eredmeny = :eredmeny")})
public class TanuloEredmeny implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "id_hal_neptun")
    private String idHalNeptun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hal_targy")
    private String halTargy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eredmeny")
    private int eredmeny;

    public TanuloEredmeny() {
    }

    public TanuloEredmeny(String idHalNeptun) {
        this.idHalNeptun = idHalNeptun;
    }

    public TanuloEredmeny(String idHalNeptun, String halTargy, int eredmeny) {
        this.idHalNeptun = idHalNeptun;
        this.halTargy = halTargy;
        this.eredmeny = eredmeny;
    }

    public String getIdHalNeptun() {
        return idHalNeptun;
    }

    public void setIdHalNeptun(String idHalNeptun) {
        this.idHalNeptun = idHalNeptun;
    }

    public String getHalTargy() {
        return halTargy;
    }

    public void setHalTargy(String halTargy) {
        this.halTargy = halTargy;
    }

    public int getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(int eredmeny) {
        this.eredmeny = eredmeny;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHalNeptun != null ? idHalNeptun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TanuloEredmeny)) {
            return false;
        }
        TanuloEredmeny other = (TanuloEredmeny) object;
        if ((this.idHalNeptun == null && other.idHalNeptun != null) || (this.idHalNeptun != null && !this.idHalNeptun.equals(other.idHalNeptun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.bead.table.TanuloEredmeny[ idHalNeptun=" + idHalNeptun + " ]";
    }
    
}
