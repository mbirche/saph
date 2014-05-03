/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.dao.StudentClassDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentClassFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentClassService;
import br.com.fatecmogidascruzes.saph.model.Entity;
import br.com.fatecmogidascruzes.saph.model.StudentClass;

/**
 *
 * @author marcelo
 */
public class StudentClassService extends AbstractService implements IStudentClassFacade, IStudentClassService{

    private static StudentClassService service;
    private StudentClassDAO dao;
    public static StudentClassService getInstance(){
        if(service == null){
            service = new StudentClassService();
            return service;
        }else{
            return service;
        }
    }
    public StudentClassService(){
        dao = new StudentClassDAO();
    }

    @Override
    public void delete(Entity entity){
        StudentClass stClass = (StudentClass) entity;
        stClass.getClassAssignments().clear();
        stClass.getStudents().clear();
        super.delete(entity);
    }
}
