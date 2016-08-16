package com.i2i.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author manikandan 
 *
 */
@Entity
@Table(name="Disc")
public class Disc {
	
	@Id
	@GeneratedValue
	@Column(name = "id")	
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="categoryId")
	private Category category ;
	
	@ManyToOne
	@JoinColumn(name ="languageId")
	private Language language;
	
	@Column(name = "name")	
	private String name;
	
	@Column(name = "directorName")
	private String directorName;
	
	@Column(name = "actorName")
	private String actorName;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "stock")
	private int stock;
	
	/*@OneToMany(mappedBy = "disc")
	private Set<Cart> cart = new HashSet<Cart> ();*/
	 
	public Disc(){};
	
	
	public Disc(String name, String directorName, String actorName, String imageUrl, int stock, int price) {
		this.name = name;
		this.directorName = directorName;
		this.actorName = actorName;
		this.imageUrl = imageUrl;
		this.stock = stock;
		this.price = price;	
	}

		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDirectorName() {
		return directorName;
	}
	
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	public String getActorName() {
		return actorName;
	}
	
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
		
	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	/*public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}*/

}