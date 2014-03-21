/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.teste;

import br.com.fatecmogidascruzes.saph.controller.AbilityFacade;
import br.com.fatecmogidascruzes.saph.controller.AbstractFacade;
import br.com.fatecmogidascruzes.saph.controller.AlternativeFacade;
import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.controller.KnowledgeAreaFacade;
import br.com.fatecmogidascruzes.saph.controller.QuestionFacade;
import br.com.fatecmogidascruzes.saph.controller.TestApplicationFacade;
import br.com.fatecmogidascruzes.saph.controller.TestFacade;
import br.com.fatecmogidascruzes.saph.dao.AbstractDAO;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.AlternativeText;
import br.com.fatecmogidascruzes.saph.model.Answer;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Coordinator;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Entity;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Performance;
import br.com.fatecmogidascruzes.saph.model.Question;
import br.com.fatecmogidascruzes.saph.model.QuestionText;
import br.com.fatecmogidascruzes.saph.model.Role;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import br.com.fatecmogidascruzes.saph.model.Test;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author marcelo
 */
public class Teste {

    public static void main(String[] args) {

//        teste1();
//        teste2();
//        teste3();
//        teste4();
        //teste5();
//        teste6();
//        teste7();
        teste8();
        
        System.exit(0);
    }
    private static void teste8(){
        
        TestApplicationFacade facade = (TestApplicationFacade) FacadeFactory.getInstance().getFacade(TestApplication.class);
        
        TestApplication ta = new TestApplication();
        Test test = new Test();
        
        QuestionText queTxt1 = new QuestionText();
        queTxt1.setText("Pergunta 1");
        QuestionText queTxt2 = new QuestionText();
        queTxt2.setText("Pergunta 2");
        QuestionText queTxt3 = new QuestionText();
        queTxt3.setText("Pergunta 3");
        QuestionText queTxt4 = new QuestionText();
        queTxt4.setText("Pergunta 4");
        
        Question que1 = new Question();
        que1.setQuestionText(queTxt1);
        Question que2 = new Question();
        que2.setQuestionText(queTxt2);
        Question que3 = new Question();
        que3.setQuestionText(queTxt3);
        Question que4 = new Question();
        que4.setQuestionText(queTxt4);
        
        test.addQuestion(que1);
        test.addQuestion(que2);
        test.addQuestion(que3);
        test.addQuestion(que4);
        
        ta.setTest(test);
        
        facade.save(ta);
    }
    private static void teste7(){
        
        TestFacade facade = (TestFacade) FacadeFactory.getInstance().getFacade(Test.class);
        
        Test test = new Test();
        
        QuestionText queTxt1 = new QuestionText();
        queTxt1.setText("Pergunta 1");
        QuestionText queTxt2 = new QuestionText();
        queTxt2.setText("Pergunta 2");
        QuestionText queTxt3 = new QuestionText();
        queTxt3.setText("Pergunta 3");
        QuestionText queTxt4 = new QuestionText();
        queTxt4.setText("Pergunta 4");
        
        Question que1 = new Question();
        que1.setQuestionText(queTxt1);
        Question que2 = new Question();
        que2.setQuestionText(queTxt2);
        Question que3 = new Question();
        que3.setQuestionText(queTxt3);
        Question que4 = new Question();
        que4.setQuestionText(queTxt4);
        
        test.addQuestion(que1);
        test.addQuestion(que2);
        test.addQuestion(que3);
        test.addQuestion(que4);
        
        facade.save(test);
    }
    private static void teste6(){
        QuestionFacade facade = (QuestionFacade) FacadeFactory.getInstance().getFacade(Question.class);
        
        Question que = new Question();
        Question que1 = new Question();
        
        QuestionText qText = new QuestionText();
        QuestionText qText1 = new QuestionText();
        
        qText.setText("Quem nasceu primeiro?");
        qText1.setText("Pergunta séria?");
        
        que.setQuestionText(qText);
        que1.setQuestionText(qText1);
        
        Ability abi1 = new Ability();
        abi1.setName("ability 1");
        Ability abi2 = new Ability();
        abi2.setName("ability 2");
        EvaluatedItem ev1 = new EvaluatedItem();
        ev1.setAbility(abi1);
        EvaluatedItem ev2 = new EvaluatedItem();
        ev2.setAbility(abi2);
        AlternativeText altText1 = new AlternativeText();
        altText1.setText("O ovo");
        AlternativeText altText2 = new AlternativeText();
        altText2.setText("A galinha séria");
        Alternative alt1 = new Alternative();
        alt1.setAlternativeText(altText1);
        alt1.addEvaluatedItem(ev1);
        Alternative alt2 = new Alternative();
        alt2.setAlternativeText(altText2);
        alt2.addEvaluatedItem(ev2);
        
        que.addAlternative(alt1);
        que1.addAlternative(alt2);
        
        facade.save(que);
        facade.save(que1);
        
        List queList1 = facade.getQuestionsByAbility(abi2);
    }
    private static void teste5() {

        AlternativeFacade facade = (AlternativeFacade) FacadeFactory.getInstance().getFacade(Alternative.class);

        KnowledgeArea kArea1 = new KnowledgeArea();
        kArea1.setName("Programação 1");

        KnowledgeArea kArea2 = new KnowledgeArea();
        kArea2.setName("Programação 2");

        KnowledgeArea kArea3 = new KnowledgeArea();
        kArea3.setName("Programação 3");

        Ability ab1 = new Ability();
        ab1.setName("Ability 1");
        ab1.addKnowledgeArea(kArea1);

        Ability ab2 = new Ability();
        ab2.setName("Ability 2");
        ab2.addKnowledgeArea(kArea1);
        ab2.addKnowledgeArea(kArea2);

        Ability ab3 = new Ability();
        ab3.setName("Ability 3");
        ab3.addKnowledgeArea(kArea1);
        ab3.addKnowledgeArea(kArea2);
        ab3.addKnowledgeArea(kArea3);

        EvaluatedItem evIt1 = new EvaluatedItem();
        evIt1.setAbility(ab1);
        evIt1.setPerformance(Performance.SATISFATORY);

        EvaluatedItem evIt2 = new EvaluatedItem();
        evIt2.setAbility(ab1);
        evIt2.setPerformance(Performance.INSATISFATORY);

        EvaluatedItem evIt3 = new EvaluatedItem();
        evIt3.setAbility(ab2);
        evIt3.setPerformance(Performance.SATISFATORY);

        EvaluatedItem evIt4 = new EvaluatedItem();
        evIt4.setAbility(ab3);
        evIt4.setPerformance(Performance.INSATISFATORY);

        Alternative alt1 = new Alternative();
        alt1.addEvaluatedItem(evIt1);
        alt1.addEvaluatedItem(evIt2);
        alt1.addEvaluatedItem(evIt3);
       
        
        Alternative alt2 = new Alternative();
        alt2.addEvaluatedItem(evIt3);
        alt2.addEvaluatedItem(evIt4);

        facade.save(alt1);
        facade.save(alt2);

//        List eva = facade.getEvaluatedItemsByAbility(alt, ab3);
//        List eva1 = facade.getEvaluatedItemsByPerformance(alt, Performance.INSATISFATORY);
//        List eva2 = facade.getAlternativesByAbility(ab1);
          List eva3 = facade.getAlternativesByKnowledgeArea(kArea1);
          List eva4 = facade.getAlternativesByKnowledgeArea(kArea2);
          List eva5 = facade.getAlternativesByKnowledgeArea(kArea3);
    }

    private static void teste4() {

        AbilityFacade facade = (AbilityFacade) FacadeFactory.getInstance().getFacade(Ability.class);
        AbstractFacade facadeKA = (KnowledgeAreaFacade) FacadeFactory.getInstance().getFacade(KnowledgeArea.class);

        KnowledgeArea kArea1 = new KnowledgeArea();
        kArea1.setName("Pensamento Abstrato");
        KnowledgeArea kArea2 = new KnowledgeArea();
        kArea2.setName("Pensamento Concreto");

        Ability ability1 = new Ability();
        ability1.setName("Pensar");
        ability1.addKnowledgeArea(kArea1);
//        
        Ability ability2 = new Ability();
        ability2.setName("Direito");
        ability2.addKnowledgeArea(kArea1);
        ability2.addKnowledgeArea(kArea2);
//        
        facade.save(ability1);
        facade.save(ability2);

        List abilities = facade.getAbilityByKnowledgeArea(kArea1);

        List abilities2 = facade.getAbilityByKnowledgeArea(kArea2);

    }

    private static void teste3() {

        AbstractFacade facade = (KnowledgeAreaFacade) FacadeFactory.getInstance().getFacade(KnowledgeArea.class);

        KnowledgeArea kArea = new KnowledgeArea();
        kArea.setName("Orientação a Objetos");

        facade.save(kArea);

        kArea.setName("Lógica de programação");

        facade.update(kArea);

        List kAreas = facade.getAll(KnowledgeArea.class);

        KnowledgeArea kArea1 = (KnowledgeArea) facade.get(10l, KnowledgeArea.class);

        facade.delete(kArea);

        List kAreas1 = facade.getAll(KnowledgeArea.class);
    }

    private static void teste2() {

        AbstractDAO dao = new AbstractDAO();

        KnowledgeArea kArea1 = new KnowledgeArea();
        kArea1.setName("Paradigmas de programação");

        KnowledgeArea kArea2 = new KnowledgeArea();
        kArea2.setName("Lógica de programação");

        Ability abi1 = new Ability();
        abi1.addKnowledgeArea(kArea1);
        abi1.setName("Algorítmo");

        Ability abi2 = new Ability();
        abi2.addKnowledgeArea(kArea2);
        abi2.setName("Lógica matemática");

        EvaluatedItem evo1 = new EvaluatedItem();
        evo1.setAbility(abi1);
        evo1.setPerformance(Performance.SATISFATORY);

        EvaluatedItem evo2 = new EvaluatedItem();
        evo2.setAbility(abi1);
        evo2.setPerformance(Performance.INSATISFATORY);

        EvaluatedItem evo3 = new EvaluatedItem();
        evo3.setAbility(abi2);
        evo3.setPerformance(Performance.SATISFATORY);

        EvaluatedItem evo4 = new EvaluatedItem();
        evo4.setAbility(abi2);
        evo4.setPerformance(Performance.INSATISFATORY);

        AlternativeText aText1 = new AlternativeText();
        aText1.setText("Dummy answer for dummy question");

        AlternativeText aText2 = new AlternativeText();
        aText2.setText("The early bird take the worm");

        Alternative alt1 = new Alternative();
        alt1.addEvaluatedItem(evo1);
        alt1.addEvaluatedItem(evo2);
        alt1.setAlternativeText(aText1);

        Alternative alt2 = new Alternative();
        alt2.addEvaluatedItem(evo3);
        alt2.addEvaluatedItem(evo4);
        alt2.setAlternativeText(aText2);

        QuestionText qText = new QuestionText();
        qText.setText("Type anything!");

        Question question = new Question();
        question.addAlternative(alt1);
        question.addAlternative(alt2);
        question.setQuestionText(qText);

        Test test = new Test();
        test.addQuestion(question);

        ClassAssignment clAs = new ClassAssignment();

        TestApplication tApp = new TestApplication();
        tApp.setClassAssignment(clAs);
        tApp.setTest(test);

        Answer ans1 = new Answer();
        ans1.setQuestion(question);
        ans1.setAlternative(alt1);

        Answer ans2 = new Answer();
        ans2.setQuestion(question);
        ans2.setAlternative(alt2);

        Student st = new Student();
        st.setName("Marcelo");

        TestResult tResult = new TestResult();
        tResult.addAnswer(ans1);
        tResult.addAnswer(ans2);
        tResult.setStudent(st);
        tResult.setTestApplication(tApp);

        dao.save(tResult);

    }

    private static void teste1() {

        AbstractDAO dao = new AbstractDAO();

        Student st1 = new Student();

        st1.setName("Marcelo");
        st1.setSurname("Birche Ferri");
        st1.setRn("092321-4");

        Student st2 = new Student();

        st2.setName("Tabata");
        st2.setSurname("Cristina Henrique Ferri");
        st2.setRn("12302");

        Set<Role> roles = new HashSet<Role>();
        roles.add(Role.STUDENT);
        roles.add(Role.TEACHER);

        st1.setRoles(roles);
        st2.setRoles(roles);

        StudentClass stClass = new StudentClass();

        stClass.addStudent(st1);
        stClass.addStudent(st2);

        Coordinator coord = new Coordinator();
        coord.setName("Leandro Luque");

        Teacher teacher = new Teacher();
        teacher.setName("Rodrigo Rocha");

        Discipline disc = new Discipline();
        disc.setName("Orientação a Objeto");

        Course course = new Course();
        course.setName("Analise e Desenvolvimento de Sistemas");
        course.setCoordinator(coord);
        disc.setCourse(course);
        course.addDiscipline(disc);

        ClassAssignment clAs = new ClassAssignment();

        clAs.addStudentClass(stClass);
        teacher.addClassAssignment(clAs);
        clAs.addTeacher(teacher);

        clAs.setDiscipline(disc);
        clAs.setCourse(course);

        dao.save(clAs);

        List<Entity> assignments = dao.getAll(ClassAssignment.class);

    }
}
