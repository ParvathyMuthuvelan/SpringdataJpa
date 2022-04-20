package com.springjpa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.dao.PersonRepository;
import com.springjpa.exception.InvalidIdException;
import com.springjpa.model.Person;

 
@Service
public class PersonServiceImpl implements PersonService 
{
 
    @Autowired
    private PersonRepository personRepository;

   // @Override
    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
 
   // @Override
    @Transactional
    public Person getPerson(Long id) {
        return personRepository.getOne(id);
    }
 
    //@Override
    @Transactional
    public Person editPerson(Person person) {
        return personRepository.save(person);
    }
 
   // @Override
    @Transactional
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
 
   // @Override
    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
 
  
 
    //@Override
    @Transactional
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
 
  // @Override
    public long countPersons() {
        return personRepository.count();
    }
    @Transactional
    public Person getPersonById(long id) //throws InvalidIdException
    {
        Optional<Person> person = personRepository.findById(id);
        return person.get();
     //   return person.orElseThrow(() -> new InvalidIdException("Invalid Id: " + id));
    }

//	@Override
	/*@Transactional
	public int updatePersonAge(int age,long id) {
		int result=personRepository.updatePersonAge(age,id);
		return result;
	}*/
}
