package me.bead.controller;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
 
@ManagedBean
public class UserLoginViewController {
     
    private String username;
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
     
    
    public void login(ActionEvent event) throws IOException{
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
      
        
         if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
             
    loggedIn = true;
     message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Üdvözöllek", username + "!");
    FacesContext context2 = FacesContext.getCurrentInstance();
  
    context2.getExternalContext().redirect("faces/ee_neptun.xhtml");
            context2.getExternalContext().getFlash().setKeepMessages(true);
             
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hibás bejelentkezés!", "Próbáld újra!");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
           }   
}