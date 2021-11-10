package com.rpr.botscrew.university.universityconsole.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne
	private Lector head;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lector_department", joinColumns = @JoinColumn(name = "department_id"), inverseJoinColumns = @JoinColumn(name = "lector_id"))
	private Set<Lector> lectors = new HashSet<>();
	
	public Department() {}
	
	public Department(String name, Lector head) {
		this.name = name;
		this.head = head;
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

	public Lector getHead() {
		return head;
	}

	public void setHead(Lector head) {
		this.head = head;
	}

	public Set<Lector> getLectors() {
		return lectors;
	}

	public void setLectors(Set<Lector> lectors) {
		this.lectors = lectors;
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
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", head=" + head + "]";
	}
	
	
}
