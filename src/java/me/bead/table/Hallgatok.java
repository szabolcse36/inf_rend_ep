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
@Table(name = "hallgatok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hallgatok.findAll", query = "SELECT h FROM Hallgatok h")
    , @NamedQuery(name = "Hallgatok.findByIdHalNeptun", query = "SELECT h FROM Hallgatok h WHERE h.idHalNeptun = :idHalNeptun")
    , @NamedQuery(name = "Hallgatok.findByNev", query = "SELECT h FROM Hallgatok h WHERE h.nev = :nev")
    , @NamedQuery(name = "Hallgatok.findByTankor", query = "SELECT h FROM Hallgatok h WHERE h.tankor = :tankor")
    , @NamedQuery(name = "Hallgatok.findByHalTargy", query = "SELECT h FROM Hallgatok h WHERE h.halTargy = :halTargy")})
public class Hallgatok implements Serializable {

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
    @Column(name = "nev")
    private String nev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tankor")
    private String tankor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hal_targy")
    private String halTargy;

    public Hallgatok() {
    }

    public Hallgatok(String idHalNeptun) {
        this.idHalNeptun = idHalNeptun;
    }

    public Hallgatok(String idHalNeptun, String nev, String tankor, String halTargy) {
        this.idHalNeptun = idHalNeptun;
        this.nev = nev;
        this.tankor = tankor;
        this.halTargy = halTargy;
    }

    public String getIdHalNeptun() {
        return idHalNeptun;
    }

    public void setIdHalNeptun(String idHalNeptun) {
        this.idHalNeptun = idHalNeptun;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTankor() {
        return tankor;
    }

    public void setTankor(String tankor) {
        this.tankor = tankor;
    }

    public String getHalTargy() {
        return halTargy;
    }

    public void setHalTargy(String halTargy) {
        this.halTargy = halTargy;
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
        if (!(object instanceof Hallgatok)) {
            return false;
        }
        Hallgatok other = (Hallgatok) object;
        if ((this.idHalNeptun == null && other.idHalNeptun != null) || (this.idHalNeptun != null && !this.idHalNeptun.equals(other.idHalNeptun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.bead.table.Hallgatok[ idHalNeptun=" + idHalNeptun + " ]";
    }
    
}
