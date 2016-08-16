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
 * @author Anandharaj Angamuthu
 *
 */
@Entity
@Table(name="Language")
public class Language {

	@Id
	@GeneratedValue
	@Column(name = "id")
    private int id;
	
	@Column(name = "name")	
    private String name;
	
	@OneToMany(mappedBy = "language")
    private Set<Disc> discs = new HashSet<Disc>();   
   
    public Language(){}
    
    public Language(String name ){
        this.name = name;
    }
	    
    //Getter and Setter
	    
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
		
	public Set<Disc> getDiscs() {
		return discs;
	}

	public void setDiscs(Set<Disc> discs) {
		this.discs = discs;
	}

}

