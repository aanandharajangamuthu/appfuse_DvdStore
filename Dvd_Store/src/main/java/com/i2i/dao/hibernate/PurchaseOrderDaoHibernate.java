package com.i2i.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.dao.PurchaseOrderDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.PurchaseOrder;
import com.i2i.model.User;

@Repository("purchaseOrderDao")
@Transactional
public class PurchaseOrderDaoHibernate extends GenericDaoHibernate<PurchaseOrder,Long> implements PurchaseOrderDao {
	
	
	/**
     * Constructor that sets the entity to PurchaseOrder.class.
     */
    public PurchaseOrderDaoHibernate() {
        super(PurchaseOrder.class);
    }

	/**
     * <p>
     * This method used to retrieve all PurchaseOrder list from the database
     * </p>     
     * @return returns the list of all PurchaseOrder.  
     * @throws UserApplicationException
     *         If there is error in returning all PurchaseOrder through session object.  
     */	
	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseOrder> retrieveAllPurchaseOrders() throws UserApplicationException {        
        Session session = getSession();     
        try {         
            return session.createQuery("FROM PurchaseOrder").list();           
        } finally {
            session.flush(); 
        }        
    }
	
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
	@Override
	public PurchaseOrder findUserById(int purchaseOrderId) throws UserApplicationException {       
        Session session = getSession();
        try {            
            return (PurchaseOrder)session.get(User.class, purchaseOrderId);           
        } catch (HibernateException e) {            
            throw new UserApplicationException("Could not find for this purchaseOrderId "+purchaseOrderId, e);
        } finally {
        	session.flush(); 
        }       
    }	
	
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
	@Override
	public void deletePurchaseOrderById(int purchaseOrderId) throws UserApplicationException {
		Session session = getSession();
        try {              
            PurchaseOrder purchaseOrder = (PurchaseOrder)session.get(PurchaseOrder.class, purchaseOrderId);    
            session.delete(purchaseOrder); 
        } catch (HibernateException e) {            
           throw new UserApplicationException("Could not delete for this purchaseOrder Id:"+purchaseOrderId, e);
        } finally {
        	session.flush();
        }    
    
	}
	
	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) throws UserApplicationException {
		Session session = getSession();        
        try {         
	        session.update(purchaseOrder);  
        } catch (HibernateException e) {            
            throw new UserApplicationException("could not update for this Purchase Id "+purchaseOrder.getId(), e);
        } finally {
        	session.flush();
        }
	}
	
	@Override
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) throws UserApplicationException {
		Session session = getSession();
        try {
            session.save(purchaseOrder); 
        } catch (HibernateException e) {
            throw new UserApplicationException("unable to Add for this Purchase Id "+purchaseOrder.getId(),e);
        } finally {
        	session.flush();
        }      	
	}    
}
