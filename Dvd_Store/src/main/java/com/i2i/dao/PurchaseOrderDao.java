package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Cart;
import com.i2i.model.PurchaseOrder;
import com.i2i.model.User;

/**
 * <h1>PurchaseOrderDao</h1>
 * 
 * This class handles the hibernate operations for different PurchaseOrder methods
 * @author Manikandan
 *
 */
public interface PurchaseOrderDao extends GenericDao<PurchaseOrder, Long>{
	
	/**
     * <p>
     * This method used to retrieve all PurchaseOrder list from the database
     * </p>     
     * @return returns the list of all PurchaseOrder.  
     * @throws UserApplicationException
     *         If there is error in returning all PurchaseOrder through session object.  
     */	
	public List<PurchaseOrder> retrieveAllPurchaseOrders() throws UserApplicationException;	
	/**
     * <p>
     * This method used to find particular PurchaseOrder by purchaseOrderId from database
     * </p>
     * @param purchaseOrderId 
     *        purchaseOrderId should be type of int.  
     * @return returns the PurchaseOrder.
     * @throws UserApplicationException
     *        If there is error in returning PurchaseOrder object.    
     */	
	public PurchaseOrder findUserById(int purchaseOrderId) throws UserApplicationException;       
	
	/**
     * <p>
     * This method used to delete particular PurchaseOrder by purchaseOrderId
     * </p>
     * @param purchaseOrderId 
     *        used to find PurchaseOrder object,it should be type of int  
     * PurchaseOrder object can be deleted using session object.
     * @throws UserApplicationException
     *         If there is error in deleting PurchaseOrder object.    
     */	
	public void deletePurchaseOrderById(int purchaseOrderId) throws UserApplicationException ;
	
	
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) throws UserApplicationException;
	
	
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) throws UserApplicationException;
}
