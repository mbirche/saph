/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.UserFacade;
import br.com.fatecmogidascruzes.saph.model.Credential;
import br.com.fatecmogidascruzes.saph.model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcelo
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB {
    
    private static User loggedUser;
    private static Credential credential;
    
    private static UserFacade userFacade;

    public LoginMB() {
        userFacade = (UserFacade) FacadeFactory.getInstance().getFacade(User.class);
        credential = new Credential();
    }
    public static Boolean isLogged(){
        if(loggedUser == null){
            return false;
        }else{
            return true;
        }
    }
    public static void login(){
        loggedUser = userFacade.getUserByCredentials(credential);
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

}
