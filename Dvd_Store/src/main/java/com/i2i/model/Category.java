package com.i2i.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author manikandan 
 *
 */
@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name = "id")		
	private int id;
	
	@Column(name="name")
	private String name;
	
/*	@OneToMany(mappedBy = "category")
	private Set<Disc> discs = new HashSet<Disc>();   */
	
	public Category(){};
	
	
	public Category(String name) {
		this.name = name;
	}
	
/*	public Category(String name, Set<Disc> discs) {
		this.name = name;
		this.setDiscs(discs);
	}*/

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	/*public Set<Disc> getDiscs() {
		return discs;
	}

	public void setDiscs(Set<Disc> discs) {
		this.discs = discs;
	}*/

}
