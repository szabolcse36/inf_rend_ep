package me.bead.controller;

import me.bead.table.OktatokTargyai;
import me.bead.jsf.util.JsfUtil;
import me.bead.jsf.util.JsfUtil.PersistAction;
import me.bead.bean.OktatokTargyaiFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("oktatokTargyaiController")
@SessionScoped
public class OktatokTargyaiController implements Serializable {

    @EJB
    private me.bead.bean.OktatokTargyaiFacade ejbFacade;
    private List<OktatokTargyai> items = null;
    private OktatokTargyai selected;

    public OktatokTargyaiController() {
    }

    public OktatokTargyai getSelected() {
        return selected;
    }

    public void setSelected(OktatokTargyai selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OktatokTargyaiFacade getFacade() {
        return ejbFacade;
    }

    public OktatokTargyai prepareCreate() {
        selected = new OktatokTargyai();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OktatokTargyaiCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OktatokTargyaiUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OktatokTargyaiDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OktatokTargyai> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public OktatokTargyai getOktatokTargyai(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<OktatokTargyai> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OktatokTargyai> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OktatokTargyai.class)
    public static class OktatokTargyaiControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OktatokTargyaiController controller = (OktatokTargyaiController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "oktatokTargyaiController");
            return controller.getOktatokTargyai(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OktatokTargyai) {
                OktatokTargyai o = (OktatokTargyai) object;
                return getStringKey(o.getIdOktNeptun());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OktatokTargyai.class.getName()});
                return null;
            }
        }

    }

}
