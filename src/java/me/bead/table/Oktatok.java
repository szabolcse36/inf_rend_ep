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
@Table(name = "oktatok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oktatok.findAll", query = "SELECT o FROM Oktatok o")
    , @NamedQuery(name = "Oktatok.findByIdOktNeptun", query = "SELECT o FROM Oktatok o WHERE o.idOktNeptun = :idOktNeptun")
    , @NamedQuery(name = "Oktatok.findByOktNev", query = "SELECT o FROM Oktatok o WHERE o.oktNev = :oktNev")
    , @NamedQuery(name = "Oktatok.findByTanszek", query = "SELECT o FROM Oktatok o WHERE o.tanszek = :tanszek")
    , @NamedQuery(name = "Oktatok.findByOktTargy", query = "SELECT o FROM Oktatok o WHERE o.oktTargy = :oktTargy")})
public class Oktatok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "id_okt_neptun")
    private String idOktNeptun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "okt_nev")
    private String oktNev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tanszek")
    private String tanszek;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "okt_targy")
    private String oktTargy;

    public Oktatok() {
    }

    public Oktatok(String idOktNeptun) {
        this.idOktNeptun = idOktNeptun;
    }

    public Oktatok(String idOktNeptun, String oktNev, String tanszek, String oktTargy) {
        this.idOktNeptun = idOktNeptun;
        this.oktNev = oktNev;
        this.tanszek = tanszek;
        this.oktTargy = oktTargy;
    }

    public String getIdOktNeptun() {
        return idOktNeptun;
    }

    public void setIdOktNeptun(String idOktNeptun) {
        this.idOktNeptun = idOktNeptun;
    }

    public String getOktNev() {
        return oktNev;
    }

    public void setOktNev(String oktNev) {
        this.oktNev = oktNev;
    }

    public String getTanszek() {
        return tanszek;
    }

    public void setTanszek(String tanszek) {
        this.tanszek = tanszek;
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
        if (!(object instanceof Oktatok)) {
            return false;
        }
        Oktatok other = (Oktatok) object;
        if ((this.idOktNeptun == null && other.idOktNeptun != null) || (this.idOktNeptun != null && !this.idOktNeptun.equals(other.idOktNeptun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.bead.table.Oktatok[ idOktNeptun=" + idOktNeptun + " ]";
    }
    
}
