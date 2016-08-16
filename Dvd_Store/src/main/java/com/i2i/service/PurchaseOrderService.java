package com.i2i.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.PurchaseOrder;
import com.i2i.dao.PurchaseOrderDao;
import com.i2i.exception.UserApplicationException;

/**
 * @author Manikandan
 *
 */
@WebService
@Path("/purchaseOrders")
public interface PurchaseOrderService {	
	
		
	/**
     * <p>
     * This method used to get all purchaseOrder list through purchaseOrderDao      
     * </p>                
     * @return returns the purchaseOrder list.  
     * @throws UserApplicationException
     *         If there is failed or interrupted get purchaseOrder list operation.               
     */
    public List<PurchaseOrder> getAllPurchaseOrders()throws UserApplicationException;
    
    /**
     * <p>
     * This method used to view particular PurchaseOrder by purchaseOrderId. 
     * </p>
     * @param purchaseOrderId
     *        Used to find PurchaseOrder,and it should be type of int
     * @return PurchaseOrder 
     *         returns the PurchaseOrder
     * @throws UserApplicationException 
     *         If there is failed or interrupted view user operation.                        
     */    
    public PurchaseOrder getPurchaseOrderById(int purchaseOrderId) throws UserApplicationException;
	
    /**
     * <p>
     * This method used to remove PurchaseOrder based on the purchaseOrderId. 
     * </p>
     * @param purchaseOrderId
     *        Used to remove PurchaseOrder from the PurchaseOrderlist and it should be type of int     
     * @throws UserApplicationException 
     *        If there is failed or interrupted remove PurchaseOrder operation.                      
     */
    public void removePurchaseOrderById(int purchaseOrderId) throws UserApplicationException;
    
    public void update(PurchaseOrder purchaseOrder) throws UserApplicationException;
    
    public void add(PurchaseOrder purchaseOrder) throws UserApplicationException;
}