package com.springjpa.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="person_info")
public class Person {
 
    @Id
    @GeneratedValue
    @Column(name="person_id")
    private Long id;
    @Column(name="person_name")
    private String name;
    @Column(name="person_age")
    private int age;
 
    public Person() {
    }
 
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
  
 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public String toString() {
        return String.format("Person{id=%d, name='%s', age=%d}", id, name, age);
    }
}

