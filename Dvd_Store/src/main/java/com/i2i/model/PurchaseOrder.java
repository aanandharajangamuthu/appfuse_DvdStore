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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author Anandharaj Angamuthu
 *
 */
@Entity
@Table(name="PurchaseOrder")
public class PurchaseOrder {
	
	
	@Id
	@GeneratedValue
	@Column(name = "id")		
    private int id;
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name ="userId")	
	private User user;
	
	@OneToMany(mappedBy = "purchaseOrder")
	private Set<Cart> cart = new HashSet<Cart> (); 
		
	public PurchaseOrder(){};
	    
    public PurchaseOrder(String payment, String status, User user) {
	    this.payment = payment;
	    this.status = status;
	    this.user = user;
    }
    public PurchaseOrder(Set<Cart> cart,User user) {
    	this.user = user;
    	this.cart = cart;
    }    

	// Getter and Setter	    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}	
	    
}
