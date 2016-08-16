package com.i2i.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * <p>Cart class contains attributes include id, order
 * disc, quantity, totalPrice
 * </p>  
 * @author Anandharaj Angamuhtu
 *
 */
@Entity
@Table(name="Cart")
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name = "id")		
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="purchaseOrderId")	
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne
	@JoinColumn(name ="discId")	
	private Disc disc;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalPrice")
	private double totalPrice;
	
	public Cart(){}
	
	public Cart(Disc disc, int quantity, double totalPrice) {		
		this.disc = disc;
		this.quantity = quantity;
		this.totalPrice  = totalPrice;
	}
	
	public Cart(PurchaseOrder purchaseOrder, Disc disc, int quantity, double totalPrice) {
		this.purchaseOrder = purchaseOrder;
		this.disc = disc;
		this.quantity = quantity;
		this.totalPrice  = totalPrice;
	}

   // Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Disc getDisc() {
		return disc;
	}

	public void setDisc(Disc disc) {
		this.disc = disc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
}