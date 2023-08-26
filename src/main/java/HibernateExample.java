import model.Department;
import model.Employee;
import model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import repository.DepartmentRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;
import utils.HibernateUtils;

import java.util.List;

public class HibernateExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query =session.createQuery("select e from Employee e inner join e.department d where d.departmentName = 'Finance'");
        List<Employee> employees = query.getResultList();
        employees.forEach(e->
                System.out.println(e.toString()));



//        ProjectRepository projectRepository=new ProjectRepository(session);
//        DepartmentRepository departmentRepository = new DepartmentRepository(session);
//        EmployeeRepository employeeRepository = new EmployeeRepository(session);
//        Project project=projectRepository.findById(1);
//        Department department = departmentRepository.findById(11);
//        System.out.println(department);
//        department.setDepartmentname("HR");
//        departmentRepository.update(department);
//        System.out.println("Department updated " + department);
//        System.out.println("Project with id 1: "+ project);
//        project.setDescription("Project test description");
//        projectRepository.update(project);
//        System.out.println("Updated project with id 1: " + projectRepository.findById(1));
        Query queryManyToMany = session.createQuery("select e.firstName, p.description from Employee e inner join e.projects p ");
        List<Object[]> projects = queryManyToMany.getResultList();
        projects.forEach(e->
                System.out.println("FirstName: " + e[0] + " Project Description " + e[1]));

        //Vendosim vete vlerat
        System.out.println("----- Kur vendosim vete vlerat ----------");
        Query queryManyToMany1 = session.createQuery("select e.firstName, p.description from Employee e inner join e.projects p where p.description= :projectDesc and e.firstName= :fname");
        queryManyToMany1.setParameter("projectDesc", "Java - Fitness Web App");
        queryManyToMany1.setParameter("fname", "Anna");
        List<Object[]> projects1 = queryManyToMany1.getResultList();
        projects1.forEach(e->
                System.out.println("FirstName: " + e[0] + " Project Description: " + e[1]));

        System.out.println("--------- Zgjidh te gjithe projektet-----------");
        Query queryManyToMany2 = session.createQuery("select p from Project p");
        List<Project> projects2 = queryManyToMany2.getResultList();
        projects2.forEach(e->
                System.out.println(e.toString()));

        System.out.println("--------- Zgjidh te gjithe punonjesit-------------");
        Query queryManyToMany3 = session.createQuery("select e from Employee e");
        List<Employee> projects3 = queryManyToMany3.getResultList();
        projects3.forEach(e->
                System.out.println(e.toString()));

        System.out.println("--------- Zgjidh te gjithe punonjesit ku emri fillon me J-------------");
        Query queryManyToMany4 = session.createQuery("select e from Employee e where e.firstName like 'J%'");
        List<Employee> projects4 = queryManyToMany4.getResultList();
        projects4.forEach(e->
                System.out.println(e.toString()));

//        System.out.println("--------- Zgjidh te gjithe punonjesit qe punojne ne departamentin Dev-------------");
//        Query queryManyToMany5 = session.createQuery("select e from Employee e inner join e.department d where d.name = 'Dev'");
//        List<Employee> projects5 = queryManyToMany5.getResultList();
//        projects5.forEach(e->
//                System.out.println(e.toString()));

        session.close();
    }
}
