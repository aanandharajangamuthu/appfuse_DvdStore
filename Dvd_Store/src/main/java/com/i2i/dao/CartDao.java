package com.i2i.dao;

import java.util.List;

import com.i2i.model.Cart;
import com.i2i.model.Disc;
import com.i2i.model.PurchaseOrder;
import com.i2i.exception.UserApplicationException;


/**
 *
 * CategoryDao --- Subclass of GenericDao
 * Manipulates the categories in the database
 *
 * @author Anandharaj Angamuthu
 * @version 1.0
 * @modified 2016-07-26
 * 
 */

public interface CartDao extends GenericDao<Cart, Long> {
	
	/**
     * <p>
     * This  method used to insert the cart details to the database
     * </p>
     * @param cart 
     *        cart object to be inserted,and it contains cart details     
     * @throws UserApplicationException
     *        If there is error in inserting user through session object.     
     */		
	
	public void insertCart(Cart cart) throws UserApplicationException;
	
	/**
     * <p>
     * This method used to retrieve all cart list from the database
     * </p>     
     * @return returns the list of all cart.  
     * @throws UserApplicationException
     *         If there is error in returning all cart through session object.  
     */	
	public List<Cart> retrieveAllCarts() throws UserApplicationException;
	
	/**
     * <p>
     * This method used to find particular cart by cartId from database
     * </p>
     * @param cartId 
     *        cartId should be type of int.  
     * @return returns the Cart.
     * @throws UserApplicationException
     *        If there is error in returning Cart object.    
     */	
	public Cart findCartById(int cartId) throws UserApplicationException;
	
	/**
     * <p>
     * This method used to delete particular Cart by cartId from database
     * </p>
     * @param cartId 
     *        used to find Cart object,it should be type of int  
     * Cart object can be deleted using session object.
     * @throws UserApplicationException
     *         If there is error in deleting Cart object.    
     */	
	public void deleteCartById(int cartId) throws UserApplicationException;
	/**
     * <p>
     * This method used to insert disc into cart & update the cart details in  database
     * </p>
     * @param cart
     *        which can be the cart object to be updated
     * @param disc
     *        which can be the disc object for the cart
     * @throws UserApplicationException
     *         If there is error in deleting Cart object.    
     */		
	public void insertDiscToCart(Disc disc, Cart cart) throws UserApplicationException;
	
	/**
     * <p>
     * This method used to insert purchaseOrder into cart & update the cart details in  database
     * </p>
     * @param cart
     *        which can be the cart object to be updated
     * @param purchaseOrder
     *        which can be the purchaseOrder object for the cart
     * @throws UserApplicationException
     *         If there is error in deleting Cart object.    
     */		
	
	public void updateCartByPurchaseOrder(Cart cart,PurchaseOrder purchaseOrder) throws UserApplicationException;

}
