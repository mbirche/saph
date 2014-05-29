/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.UserFacade;
import br.com.fatecmogidascruzes.saph.model.Credential;
import br.com.fatecmogidascruzes.saph.model.Role;
import br.com.fatecmogidascruzes.saph.model.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcelo
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {
    
    private static User loggedUser;
    private static Credential credential;
    private static String btnText;
    
    private static UserFacade userFacade;

    public LoginMB() {
        userFacade = (UserFacade) FacadeFactory.getInstance().getFacade(User.class);
        credential = new Credential();
        btnText = "";
    }
    public Boolean isLogged(){
        if(loggedUser == null){
            return false;
        }else{
            return true;
        }
    }
    public Boolean isStudent(){
        if(loggedUser != null && loggedUser.getRoles().contains(Role.Aluno)){
            return true;
        }else{
            return false;
        }
    }
    public Boolean isTeacher(){
        if(loggedUser != null && loggedUser.getRoles().contains(Role.Professor)){
            return true;
        }else{
            return false;
        }
    }
    public Boolean isCoordinator(){
        if(loggedUser != null && loggedUser.getRoles().contains(Role.Coordenador)){
            return true;
        }else{
            return false;
        }
    }
    public String login(){
        loggedUser = userFacade.getUserByCredentials(credential);
        if(loggedUser != null){
            btnText = "Logout, " + loggedUser.getName();
            return "bem_vindo.xhtml";
        }else{
            FacesContext.getCurrentInstance().addMessage("msgLogin", new FacesMessage("Informações inválidas"));
            return "null";
        }
    }
    public void logOut(){
        loggedUser = null;
        credential = new Credential();
    }
    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        LoginMB.loggedUser = loggedUser;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        LoginMB.credential = credential;
    }

    public String getBtnText() {
        return btnText;
    }

}
