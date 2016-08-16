package com.i2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.CartDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Cart;
import com.i2i.model.Disc;
import com.i2i.model.PurchaseOrder;
import com.i2i.service.CartService;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartDao;
	
    public void addCart(Cart cart)  throws UserApplicationException  {
    	cartDao.insertCart(cart);
    }
	
    /**
     * <p>
     * This method used to get all carts list through cartDao      
     * </p>                
     * @return the carts list.  
     * @throws UserApplicationException
     *         If there is failed or interrupted get carts list operation.               
     */ 
    public List<Cart> getAllCarts() throws UserApplicationException {
    	return cartDao.retrieveAllCarts();
    }
    
    /**
     * <p>
     * This method used to view particular cart by cartId. 
     * </p>
     * @param cartId
     *        Used to find Cart,and it should be type of int
     * @return Cart 
     *         returns the Cart details.
     * @throws UserApplicationException 
     *         If there is failed or interrupted view Cart operation.                        
     */    
    public Cart getCartById(int cartId) throws UserApplicationException  {       
        return cartDao.findCartById(cartId);       
    }
    
    /**
     * <p>
     * This method used to remove particular cart based on the cartId. 
     * </p>
     * @param cartId
     *        Used to remove a cart from the cart list and it should be type of int     
     * @throws UserApplicationException 
     *        If there is failed or interrupted remove cart operation.                      
     */	
    public void removeCartById(int cartId) throws UserApplicationException  {       
    	cartDao.deleteCartById(cartId);       
    }
    
	/**
     * <p>
     * This method used to update the cart by seeting disc into it.
     * </p>
     * @param cart
     *        which can be the cart object to be updated
     * @param disc
     *        which can be the disc object for the cart
     * @throws UserApplicationException
     *         If there is error in deleting Cart object.    
     */  
    public void addToCart(Disc disc, Cart cart) throws UserApplicationException {
    	cartDao.insertDiscToCart(disc ,cart);
    } 
    
	/**
     * <p>
     * This method used to update the cart by setting purchaseOrder into it.
     * </p>
     * @param cart
     *        which can be the cart object to be updated
     * @param purchaseOrder
     *        which can be the purchaseOrder object for the cart
     * @throws UserApplicationException
     *         If there is error in deleting Cart object.    
     */		    
    public void updateCart(Cart cart, PurchaseOrder purchaseOrder) throws UserApplicationException {
    	cartDao.updateCartByPurchaseOrder(cart, purchaseOrder);
    }
}
