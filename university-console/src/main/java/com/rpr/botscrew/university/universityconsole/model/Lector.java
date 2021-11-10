package com.rpr.botscrew.university.universityconsole.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double salary;
	@Enumerated(EnumType.STRING)
	private Degree degree;
	@ManyToMany(mappedBy = "lectors", fetch = FetchType.EAGER)
	private Set<Department> departments = new HashSet<>();
	
	public Lector() {}
	
	public Lector(String name, double salary, Degree degree) {
		this.name = name;
		this.salary = salary;
		this.degree = degree;
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
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Degree getDegree() {
		return degree;
	}
	
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	public Set<Department> getDepartments() {
		return departments;
	}
	
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lector other = (Lector) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Lector [id=" + id + ", name=" + name + ", salary=" + salary + ", degree=" + degree + "]";
	}
	
	
	
}
