/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.UserFacade;
import br.com.fatecmogidascruzes.saph.model.Phone;
import br.com.fatecmogidascruzes.saph.model.PhoneType;
import br.com.fatecmogidascruzes.saph.model.Role;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author marcelo
 */
@ManagedBean (name = "usuarioMB")
@SessionScoped
public class UsuarioMB {
    
    private UserFacade userFacade;
    private DualListModel dualListModel;
     private DualListModel dualListModelEdit;
    private List<Role> source;
    private List<Role> sourceEdit;

    
    private List<User> allUsers;
    private List<User> allStudents;
    private List<User> allCoordinators;
    private List<User> allTeachers;
    
    private Boolean showRA;
    private Boolean showRF;
     private Boolean showRAEdit;
    private Boolean showRFEdit;
    
    private User user;
    private User updatingUser;
    private User deletingUser;
    
    private List<PhoneType> phoneTypes;
    private Phone phoneAux;
    private Phone phoneAuxEdit;
    private String phoneMask;
    private String phoneMaskEdit;
    private String emailAux;
    private String emailAuxEdit;

    public UsuarioMB() {
        
        userFacade = (UserFacade) FacadeFactory.getInstance().getFacade(User.class);
       
        user = new User();
        updatingUser = new User();
        resetPickList();
        resetPickListEdit();
        fillRolesLists();
        showRA = false;
        showRF = false;

        phoneTypes = new ArrayList<PhoneType>();
        phoneTypes.add(PhoneType.FIXED);
        phoneTypes.add(PhoneType.CELLPHONE);
        phoneAux = new Phone();
        phoneAux.setPhoneType(PhoneType.CELLPHONE);
        emailAux = "";
        phoneAuxEdit = new Phone();
        phoneAuxEdit.setPhoneType(PhoneType.CELLPHONE);
        emailAuxEdit = "";
        
    }

    public void deleteRoleStudent(){
        deletingUser.getRoles().remove(Role.Aluno);
        if(deletingUser.getRoles().isEmpty()){
            userFacade.delete(deletingUser);
        }else{
            userFacade.update(deletingUser);
        }
        fillRolesLists();
    }
     public void deleteRoleTeacher(){
        deletingUser.getRoles().remove(Role.Professor);
        if(deletingUser.getRoles().isEmpty()){
            userFacade.delete(deletingUser);
        }else{
            userFacade.update(deletingUser);
        }
        fillRolesLists();
    }
      public void deleteRoleCoordinator(){
        deletingUser.getRoles().remove(Role.Coordenador);
        if(deletingUser.getRoles().isEmpty()){
            userFacade.delete(deletingUser);
        }else{
            userFacade.update(deletingUser);
        }
        fillRolesLists();
    }
    private void fillRolesLists(){
        allUsers = (List<User>)(List)userFacade.getAll(User.class);
        allStudents = new ArrayList<User>();
        allCoordinators = new ArrayList<User>();
        allTeachers = new ArrayList<User>();
        
        for(User usr : allUsers){
            List<Role> roles = usr.getRoles();
            if(roles.contains(Role.Aluno)){
                allStudents.add(usr);
            }
            if(roles.contains(Role.Coordenador)){
                allCoordinators.add(usr);
            }
            if(roles.contains(Role.Professor)){
                allTeachers.add(usr);
            }
        }
    }
    private void resetPickList(){
        source = new ArrayList<Role>();
        source.add(Role.Coordenador);
        source.add(Role.Professor);
        source.add(Role.Aluno);

        dualListModel = new DualListModel(source, user.getRoles());

    }
    private void resetPickListEdit(){
        
        sourceEdit = new ArrayList<Role>(source);
        
        for(Role rol : updatingUser.getRoles()){
            if(rol.equals(Role.Coordenador) || rol.equals(Role.Professor)){
                showRFEdit = true;
            }
            if(rol.equals(Role.Aluno)){
                showRAEdit = true;
            }
            if(sourceEdit.contains(rol)){
                sourceEdit.remove(rol);
            }
        }

        dualListModelEdit = new DualListModel(sourceEdit, updatingUser.getRoles());
    }
    public void saveUser(){
        userFacade.save(user);
        user = new User();
        resetPickList();
        limpaTelefone();
        emailAux = "";
        fillRolesLists();
    }
    public void saveUserEdit(){
        userFacade.save(updatingUser);
        updatingUser = new User();
        resetPickListEdit();
        limpaTelefone();
        emailAuxEdit = "";
        fillRolesLists();
    }
    public void removeEmail(String email){
        user.getEmails().remove(email);
    }
     public void removeEmailEdit(String email){
        updatingUser.getEmails().remove(email);
    }
    public void addEmail(){
        user.getEmails().add(emailAux);
        emailAux = "";
    }
    public void addEmailEdit(){
        updatingUser.getEmails().add(emailAuxEdit);
        emailAuxEdit = "";
    }
    public void removePhone(Phone phone){
        user.getPhones().remove(phone);
    }
     public void removePhoneEdit(Phone phone){
        updatingUser.getPhones().remove(phone);
    }
    public void addPhone(){
        user.getPhones().add(phoneAux);
        limpaTelefone();
    }
    public void addPhoneEdit(){
        updatingUser.getPhones().add(phoneAuxEdit);
        limpaTelefone();
    }
    public void limpaTelefone(){
        phoneAux = new Phone();
    }
    public void limpaTelefoneEdit(){
        phoneAuxEdit = new Phone();
    }
    public void clearPhoneNumbers(){
        phoneAux.setCode("");
        phoneAux.setNumber("");
    }
      public void clearPhoneNumbersEdit(){
        phoneAuxEdit.setCode("");
        phoneAuxEdit.setNumber("");
    }
    public void onTransfer(TransferEvent event) {
        if (event.isAdd()) {
            for (Object o : event.getItems()) {
                Role role = (Role) o;
                user.getRoles().add(role);
                
                if(role.equals(Role.Coordenador) || role.equals(Role.Professor)){
                    
                    showRF = true;
                }
                if(role.equals(Role.Aluno)){
                    showRA = true;
                }
            }

        } else {
            for (Object o : event.getItems()) {
                Role role = (Role) o;
                user.getRoles().remove(role);
                if(role.equals(Role.Coordenador) || role.equals(Role.Professor)){
                    if(!user.getRoles().contains(Role.Professor) && !user.getRoles().contains(Role.Coordenador)){
                        showRF = false;
                    }
                }
                if(role.equals(Role.Aluno)){
                    showRA = false;
                }
            }
        }
    }
    public void onTransferEdit(TransferEvent event) {
        if (event.isAdd()) {
            for (Object o : event.getItems()) {
                Role role = (Role) o;
                updatingUser.getRoles().add(role);
                
                if(role.equals(Role.Coordenador) || role.equals(Role.Professor)){
                    
                    showRFEdit = true;
                }
                if(role.equals(Role.Aluno)){
                    showRAEdit = true;
                }
            }

        } else {
            for (Object o : event.getItems()) {
                Role role = (Role) o;
                updatingUser.getRoles().remove(role);
                if(role.equals(Role.Coordenador) || role.equals(Role.Professor)){
                    if(!updatingUser.getRoles().contains(Role.Professor) && !updatingUser.getRoles().contains(Role.Coordenador)){
                        showRFEdit = false;
                    }
                }
                if(role.equals(Role.Aluno)){
                    showRAEdit = false;
                }
            }
        }
    }
    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }

    public List<Role> getSource() {
        return source;
    }

    public void setSource(List<Role> source) {
        this.source = source;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean isShowRA() {
        return showRA;
    }

    public void setShowRA(Boolean showRA) {
        this.showRA = showRA;
    }

    public Boolean isShowRF() {
        return showRF;
    }

    public void setShowRF(Boolean showRF) {
        this.showRF = showRF;
    }   

    public User getUpdatingUser() {
        return updatingUser;
    }

    public void setUpdatingUser(User updatingUser) {
        this.updatingUser = updatingUser;
        resetPickListEdit();
    }

    public User getDeletingUser() {
        return deletingUser;
    }

    public void setDeletingUser(User deletingUser) {
        this.deletingUser = deletingUser;
    }

    public Phone getPhoneAux() {
        return phoneAux;
    }

    public void setPhoneAux(Phone phoneAux) {
        this.phoneAux = phoneAux;
    }

    public String getPhoneMask() {
        
        if (phoneAux.getPhoneType() == PhoneType.FIXED) {

            phoneMask = "9999-9999";
        } else if (phoneAux.getPhoneType() == PhoneType.CELLPHONE) {
            phoneMask = "99999-9999";
        }
        return phoneMask;
    }

    public void setPhoneMask(String phoneMask) {
        this.phoneMask = phoneMask;
    }

    public String getEmailAux() {
        return emailAux;
    }

    public void setEmailAux(String emailAux) {
        this.emailAux = emailAux;
    }

    public List<PhoneType> getPhoneTypes() {
        return phoneTypes;
    }

    public void setPhoneTypes(List<PhoneType> phoneTypes) {
        this.phoneTypes = phoneTypes;
    }

    public List<User> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List<User> allStudents) {
        this.allStudents = allStudents;
    }

    public List<User> getAllCoordinators() {
        return allCoordinators;
    }

    public void setAllCoordinators(List<User> allCoordinators) {
        this.allCoordinators = allCoordinators;
    }

    public List<User> getAllTeachers() {
        return allTeachers;
    }

    public void setAllTeachers(List<User> allTeachers) {
        this.allTeachers = allTeachers;
    }

    public DualListModel getDualListModelEdit() {
        return dualListModelEdit;
    }

    public void setDualListModelEdit(DualListModel dualListModelEdit) {
        this.dualListModelEdit = dualListModelEdit;
    }

    public Boolean isShowRAEdit() {
        return showRAEdit;
    }

    public void setShowRAEdit(Boolean showRAEdit) {
        this.showRAEdit = showRAEdit;
    }

    public Boolean isShowRFEdit() {
        return showRFEdit;
    }

    public void setShowRFEdit(Boolean showRFEdit) {
        this.showRFEdit = showRFEdit;
    }

    public Phone getPhoneAuxEdit() {
        return phoneAuxEdit;
    }

    public void setPhoneAuxEdit(Phone phoneAuxEdit) {
        this.phoneAuxEdit = phoneAuxEdit;
    }

    public String getPhoneMaskEdit() {
        if (phoneAuxEdit.getPhoneType() == PhoneType.FIXED) {

            phoneMaskEdit = "9999-9999";
        } else if (phoneAuxEdit.getPhoneType() == PhoneType.CELLPHONE) {
            phoneMaskEdit = "99999-9999";
        }
        
        return phoneMaskEdit;
    }

    public void setPhoneMaskEdit(String phoneMaskEdit) {
        this.phoneMaskEdit = phoneMaskEdit;
    }

    public String getEmailAuxEdit() {
        return emailAuxEdit;
    }

    public void setEmailAuxEdit(String emailAuxEdit) {
        this.emailAuxEdit = emailAuxEdit;
    }
    
}
