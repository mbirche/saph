/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.config;

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
import br.com.fatecmogidascruzes.saph.model.Phone;
import br.com.fatecmogidascruzes.saph.model.PhoneType;
import br.com.fatecmogidascruzes.saph.model.Question;
import br.com.fatecmogidascruzes.saph.model.QuestionText;
import br.com.fatecmogidascruzes.saph.model.Role;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import br.com.fatecmogidascruzes.saph.model.Test;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Birche
 */
public class HSession {

    private static Session session = null;
    private static Configuration configuration = null;
    private static StandardServiceRegistryBuilder serviceRegistryBuilder = null;
    private static ServiceRegistry serviceRegistry = null;
    private static SessionFactory sessionFactory = null;
    private static HSession hs;

    private HSession() {

        try {
            configuration = new Configuration();
        } catch (Exception e) {
            e.printStackTrace();
        }
        configuration.configure(); // configures settings from hibernate.cfg.xml

        configuration.addAnnotatedClass(Entity.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Role.class);
        configuration.addAnnotatedClass(StudentClass.class);
        configuration.addAnnotatedClass(ClassAssignment.class);
        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Discipline.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Coordinator.class);
        configuration.addAnnotatedClass(KnowledgeArea.class);
        configuration.addAnnotatedClass(Ability.class);
        configuration.addAnnotatedClass(EvaluatedItem.class);
        configuration.addAnnotatedClass(Performance.class);
        configuration.addAnnotatedClass(Alternative.class);
        configuration.addAnnotatedClass(AlternativeText.class);
        configuration.addAnnotatedClass(Question.class);
        configuration.addAnnotatedClass(QuestionText.class);
        configuration.addAnnotatedClass(Answer.class);
        configuration.addAnnotatedClass(TestResult.class);
        configuration.addAnnotatedClass(Test.class);
        configuration.addAnnotatedClass(TestApplication.class);
        configuration.addAnnotatedClass(Phone.class);
        configuration.addAnnotatedClass(PhoneType.class);

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

        // If you miss the below line then it will complaing about a missing dialect setting
        serviceRegistryBuilder.applySettings(configuration.getProperties());

        serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();

    }

    public static Session getSession() {

        if (hs == null) {
            hs = new HSession();
            return session;

        } else if (!session.isOpen()) {
            session = sessionFactory.openSession();
            return session;
        } else {
            return session;
        }
    }

}
