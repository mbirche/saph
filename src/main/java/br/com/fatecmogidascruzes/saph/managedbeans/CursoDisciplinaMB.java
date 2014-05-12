/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.CourseFacade;
import br.com.fatecmogidascruzes.saph.facade.DisciplineFacade;
import br.com.fatecmogidascruzes.saph.facade.UserFacade;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Role;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcelo
 */
@ManagedBean(name = "cursoDisciplinaMB")
@SessionScoped
public class CursoDisciplinaMB {

    private Course course;
    private Course updatingCourse;
    private Course deletingCourse;
    private List<Course> courses;


    private Discipline discipline;
    private Discipline updatingDiscipline;
    private Discipline deletingDiscipline;
    private List<Discipline> disciplines;

    private List<User> allCoordinators;

    private UserFacade userFacade;
    private CourseFacade courseFacade;
    private DisciplineFacade disciplineFacade;

    public CursoDisciplinaMB() {
        course = new Course();
        updatingCourse = new Course();

        discipline = new Discipline();
        updatingDiscipline = new Discipline();

        userFacade = (UserFacade) FacadeFactory.getInstance().getFacade(User.class);
        courseFacade = (CourseFacade) FacadeFactory.getInstance().getFacade(Course.class);
        disciplineFacade = (DisciplineFacade) FacadeFactory.getInstance().getFacade(Discipline.class);
        refreshCourseList();
        refreshDisciplineList();
        allCoordinators = getCoordinators();
    }

    public void deleteDiscipline(){
        disciplineFacade.delete(deletingDiscipline);
        refreshDisciplineList();
    }
    public void saveDiscipline(){
        discipline.getCourse().addDiscipline(discipline);
        disciplineFacade.save(discipline);
        discipline = new Discipline();
        refreshDisciplineList();
    }
    private void refreshDisciplineList(){
        disciplines = (List<Discipline>)(List)disciplineFacade.getAll(Discipline.class);
    }
    public void refreshCourseDisciplineWindow(){
        refreshCoordinatorList();
    }
    public void deleteCourse(){
        courseFacade.delete(deletingCourse);
        refreshCourseList();
    }
    private void refreshCourseList(){
        courses = (List<Course>) (List) courseFacade.getAll(Course.class);
    }
    private void refreshCoordinatorList(){
        allCoordinators = getCoordinators();
    }
    public void saveCourse(){
        
        courseFacade.save(course);
        course = new Course();
        refreshCourseList();
    }

    private List<User> getCoordinators() {
        List<User> allUsers = (List<User>) (List) userFacade.getAll(User.class);
        List<User> coordinators = new ArrayList<User>();

        for (User usr : allUsers) {
            if (usr.getRoles().contains(Role.Coordenador)) {
                coordinators.add(usr);
            }
        }
        return coordinators;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getUpdatingCourse() {
        return updatingCourse;
    }

    public void setUpdatingCourse(Course updatingCourse) {
        this.updatingCourse = updatingCourse;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Discipline getUpdatingDiscipline() {
        return updatingDiscipline;
    }

    public void setUpdatingDiscipline(Discipline updatingDiscipline) {
        this.updatingDiscipline = updatingDiscipline;
    }

    public List<User> getAllCoordinators() {
        return allCoordinators;
    }

    public void setAllCoordinators(List<User> allCoordinators) {
        this.allCoordinators = allCoordinators;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getDeletingCourse() {
        return deletingCourse;
    }

    public void setDeletingCourse(Course deletingCourse) {
        this.deletingCourse = deletingCourse;
    }

    public Discipline getDeletingDiscipline() {
        return deletingDiscipline;
    }

    public void setDeletingDiscipline(Discipline deletingDiscipline) {
        this.deletingDiscipline = deletingDiscipline;
    }

}
