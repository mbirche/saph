package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.ClassAssignmentFacade;
import br.com.fatecmogidascruzes.saph.facade.StudentClassFacade;
import br.com.fatecmogidascruzes.saph.facade.UserFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
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
    private ClassAssignmentFacade clFacade;
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
    
    
    private ClassAssignment clAssignment;
    private ClassAssignment updatingClAssignment;
    private ClassAssignment deletingClAssignment;
    private List<ClassAssignment> clAssignments;

    public TurmaMB() {
        
        userFacade = (UserFacade) FacadeFactory.getInstance().getFacade(User.class);
        stFacade = (StudentClassFacade) FacadeFactory.getInstance().getFacade(StudentClass.class);
        clFacade = (ClassAssignmentFacade) FacadeFactory.getInstance().getFacade(ClassAssignment.class);
        
        fillRolesLists();
        resetPickList();
        refreshStudentClassesList();
        refreshClassAssignmentList();
        stClass = new StudentClass();
        updatingClass = new StudentClass();
        deletingClass = new StudentClass();
        
        clAssignment = new ClassAssignment();
        updatingClAssignment = new ClassAssignment();
        deletingClAssignment = new ClassAssignment();
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
    private void refreshClassAssignmentList(){
        clAssignments = (List<ClassAssignment>)(List)clFacade.getAll(ClassAssignment.class);
    }
    private void refreshStudentClassesList(){
        stClasses =(List<StudentClass>)(List) stFacade.getAll(StudentClass.class);
    }
    public void saveClassAssignment(){
        clFacade.save(clAssignment);
        refreshClassAssignmentList();
        clAssignment = new ClassAssignment();
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

    public List<ClassAssignment> getClAssignments() {
        return clAssignments;
    }

    public void setClAssignments(List<ClassAssignment> clAssignments) {
        this.clAssignments = clAssignments;
    }

    public ClassAssignment getClAssignment() {
        return clAssignment;
    }

    public void setClAssignment(ClassAssignment clAssignment) {
        this.clAssignment = clAssignment;
    }

    public ClassAssignment getUpdatingClAssignment() {
        return updatingClAssignment;
    }

    public void setUpdatingClAssignment(ClassAssignment updatingClAssignment) {
        this.updatingClAssignment = updatingClAssignment;
    }

    public ClassAssignment getDeletingClAssignment() {
        return deletingClAssignment;
    }

    public void setDeletingClAssignment(ClassAssignment deletingClAssignment) {
        this.deletingClAssignment = deletingClAssignment;
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
