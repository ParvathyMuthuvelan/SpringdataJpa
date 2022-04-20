package com.springjpa.springjpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springjpa.model.Person;
import com.springjpa.service.PersonService;

@SpringBootApplication
@ComponentScan({ "com*" })
@EnableJpaRepositories(basePackages = "com.springjpa.dao")
@EntityScan({ "com.springjpa.model" })
public class SpringjpaApplication // implements CommandLineRunner
{
	private static final Logger LOG = LoggerFactory.getLogger("JCG");

	@Autowired
	private static PersonService personService;
	/*@Autowired
	private static EmployeeService empService;
	@Autowired
	private static DepartmentService deptService;
	@Autowired
	private static SkillService skillService;*/

	public static void main(String[] args) {

		//SpringApplication.run(SpringjpaApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);
		personService = context.getBean(PersonService.class);
	//	Person person = personService.createPerson(new Person("Shubham", 23));
	//	person=personService.createPerson(new Person("Sai", 35));
		long count=personService.countPersons();
		LOG.info("No of rows in DB: {}", count);
		List<Person> personList=personService.getAllPersons();
	   for(Person obj:personList)
	   {
		   System.out.println(obj);
	   }
		System.out.println("Search with id ");
		Person obj=personService.getPersonById(16);
		System.out.println(obj);
		
		/*empService = context.getBean(EmployeeService.class);
		deptService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);*/

	//	List<Employee> empList=empService.getAllPermanentEmployees();
		//empList.forEach(e -> System.out.println(e));
		
		// Insert into Department table
	/*	Department dept = new Department();
		dept.setName("Chennai");
		deptService.save(dept);
		dept=new Department();
		dept.setName("Mumbai");
		dept.setEmployeeList(empList);
		deptService.save(dept);

		Insert into Employee table
		Department dep=deptService.get(2);
		Employee emp = new Employee();
		emp.setName("Sri");
		emp.setPermanent(true);
		emp.setSalary(45000);
	//	emp.setDateOfBirth(new Date());
		emp.setDepartment(dep);
		empService.save(emp);
//		
		emp = new Employee();
		emp.setName("Minu");
		emp.setPermanent(false);
		emp.setSalary(45000);
		//emp.setDateOfBirth(new Date());
		emp.setDepartment(dep);
		empService.save(emp);

		// To find employee--> department (many to one)

//		Employee employee = empService.get(2);
//		LOG.debug("Employee:{}", employee);
//		LOG.debug("Department:{}", employee.getDepartment().getName());
//		System.out.println(employee);
//		System.out.println(employee.getDepartment().getId());
//		System.out.println(employee.getDepartment().getName());

		// To find department-->employee (one to many)
//		Department dep1 = deptService.get(2);
//		System.out.println("Dept name=" + dep1.getName());
//		List<Employee> empList=dep1.getEmployeeList();
//		empList.forEach(e -> System.out.println(e));

		// Insert into skill table
		 Skill skill=new Skill();
		 skill.setName("Java");
		 skillService.save(skill);
		 skill=new Skill();
		 skill.setName("Hibernate");
		 skillService.save(skill);
		 skill=new Skill();
		 skill.setName("Spring");
		 skillService.save(skill);

		// Employee - skill (many - many)
		Set<Skill> skillSet = new HashSet<>();
		Employee e = empService.get(2);
		Skill s = skillService.get(1);
   	skillSet.add(s);
		s = skillService.get(2);
		skillSet.add(s);
		e.setSkillList(skillSet);
		empService.save(e);

		Employee emp = empService.get(2);
		System.out.println(emp.getName());
		Set<Skill> skills = emp.getSkillList();
		for (Skill sk : skills) {
			System.out.println(sk);
		}*/

		
//		 * public void run(String... strings) {
//		 * 
//		 * LOG.info("Current objects in DB: {}", service.countPersons());
//		 * 
//		 * Person person = service.createPerson(new Person("Shubham", 23));
//		 * LOG.info("Person created in DB : {}", person);
//		 * 
//		 * LOG.info("Current objects in DB: {}", service.countPersons());
//		 * 
//		 * person.setName("Sai"); Person editedPerson = service.editPerson(person);
//		 * LOG.info("Person edited in DB  : {}", person);
//		 * 
//		 * // service.deletePerson(person); // LOG.info("After deletion, count: {}",
//		 * service.countPersons()); }
//		 */
	}
}
