package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.StudentClassFacade;
import br.com.fatecmogidascruzes.saph.facade.UserFacade;
import br.com.fatecmogidascruzes.saph.model.Role;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 * All fonts were produced for author's graduation project
 * @date 16/04/2014
 * @author Birche
 */
@ManagedBean(name="turmaMB")
@SessionScoped
public class TurmaMB {

    private UserFacade userFacade;
    private StudentClassFacade stFacade;
    private DualListModel<User> dualListModel;
    private List<User> allUsers;
    private List<User> allStudents;
    private List<User> allTeachers;
    private List<User> allCoordinators;
    private List<User> source;
    private List<User> target;
    
    private StudentClass stClass;
    private StudentClass updatingClass;
    private StudentClass deletingClass;
    private List<StudentClass> stClasses;

    public TurmaMB() {
        
        userFacade = (UserFacade) FacadeFactory.getInstance().getFacade(User.class);
        stFacade = (StudentClassFacade) FacadeFactory.getInstance().getFacade(StudentClass.class);
        
        fillRolesLists();
        resetPickList();
        refreshStudentClassesList();
        stClass = new StudentClass();
        updatingClass = new StudentClass();
        deletingClass = new StudentClass();
    }

    public void onTransfer(TransferEvent event) {
        if(event.isAdd()){
            for(Object o : event.getItems()){
                User usr = (User) o;               
                stClass.getStudents().add(usr);
            }
        }else{
            for(Object o : event.getItems()){
                User usr = (User) o;               
                stClass.getStudents().remove(usr);
            }
        }
    }
    public void deleteClass(){
        stFacade.delete(deletingClass);
        refreshStudentClassesList();
    }
    private void refreshStudentClassesList(){
        stClasses =(List<StudentClass>)(List) stFacade.getAll(StudentClass.class);
    }
    public void saveStudentClass(){
        stFacade.save(stClass);
        refreshStudentClassesList();
        resetPickList();
        stClass = new StudentClass();
    }
    public void refreshStudentClassWindow(){
        fillRolesLists();
        resetPickList();
    }
    private void resetPickList(){
        source = new ArrayList<User>(allStudents);
        target = new ArrayList<User>();

        dualListModel = new DualListModel(source, target);

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
    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }

    public List<User> getSource() {
        return source;
    }

    public void setSource(List<User> source) {
        this.source = source;
    }

    public List<User> getTarget() {
        return target;
    }

    public void setTarget(List<User> target) {
        this.target = target;
    }

    public StudentClass getStClass() {
        return stClass;
    }

    public void setStClass(StudentClass stClass) {
        this.stClass = stClass;
    }

    public List<StudentClass> getStClasses() {
        return stClasses;
    }

    public void setStClasses(List<StudentClass> stClasses) {
        this.stClasses = stClasses;
    }

    public StudentClass getUpdatingClass() {
        return updatingClass;
    }

    public void setUpdatingClass(StudentClass updatingClass) {
        this.updatingClass = updatingClass;
    }

    public StudentClass getDeletingClass() {
        return deletingClass;
    }

    public void setDeletingClass(StudentClass deletingClass) {
        this.deletingClass = deletingClass;
    }
    
}
