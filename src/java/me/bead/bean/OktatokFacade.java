/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.bead.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.bead.table.Oktatok;

/**
 *
 * @author szabolcs
 */
@Stateless
public class OktatokFacade extends AbstractFacade<Oktatok> {

    @PersistenceContext(unitName = "me_bead_inf_re_epPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OktatokFacade() {
        super(Oktatok.class);
    }
    
}
