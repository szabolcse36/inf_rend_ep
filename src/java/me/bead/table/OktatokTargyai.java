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
@Table(name = "oktatok_targyai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OktatokTargyai.findAll", query = "SELECT o FROM OktatokTargyai o")
    , @NamedQuery(name = "OktatokTargyai.findByIdOktNeptun", query = "SELECT o FROM OktatokTargyai o WHERE o.idOktNeptun = :idOktNeptun")
    , @NamedQuery(name = "OktatokTargyai.findByOktTargy", query = "SELECT o FROM OktatokTargyai o WHERE o.oktTargy = :oktTargy")})
public class OktatokTargyai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_okt_neptun")
    private Integer idOktNeptun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "okt_targy")
    private String oktTargy;

    public OktatokTargyai() {
    }

    public OktatokTargyai(Integer idOktNeptun) {
        this.idOktNeptun = idOktNeptun;
    }

    public OktatokTargyai(Integer idOktNeptun, String oktTargy) {
        this.idOktNeptun = idOktNeptun;
        this.oktTargy = oktTargy;
    }

    public Integer getIdOktNeptun() {
        return idOktNeptun;
    }

    public void setIdOktNeptun(Integer idOktNeptun) {
        this.idOktNeptun = idOktNeptun;
    }

    public String getOktTargy() {
        return oktTargy;
    }

    public void setOktTargy(String oktTargy) {
        this.oktTargy = oktTargy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOktNeptun != null ? idOktNeptun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OktatokTargyai)) {
            return false;
        }
        OktatokTargyai other = (OktatokTargyai) object;
        if ((this.idOktNeptun == null && other.idOktNeptun != null) || (this.idOktNeptun != null && !this.idOktNeptun.equals(other.idOktNeptun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.bead.table.OktatokTargyai[ idOktNeptun=" + idOktNeptun + " ]";
    }
    
}
