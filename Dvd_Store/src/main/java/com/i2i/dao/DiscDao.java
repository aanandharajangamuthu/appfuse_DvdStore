package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.i2i.model.Category;
import com.i2i.model.Disc;
import com.i2i.model.Language;
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
public interface DiscDao extends GenericDao<Disc, Long> {
	
    /**
     * Insert the Disc into the database
     * @param disc
     *        Disc object contains its attributes
     * @exception HibernateException
     *      
     */
    public void insertDisc(Disc disc) throws UserApplicationException;
    
    /**
     * Retrieves the list of disc available in the database
     * @return discs
     *         List of discs  
     * @throws UserApplicationException 
     *         if there is an error occurs while retrieve
     */
    public List<Disc> listOfDiscs() throws UserApplicationException;
    
    /**
     * Finds & retrieves the particular disc detail from the database
     * @param id
     *        by which the disc can be retrieved 
     * @return disc
     *         Disc object contains its attributes
     * @throws UserApplicationException 
     *         if there is any error occurs while retrieving  
     */
    public Disc findDiscById(int id) throws UserApplicationException;
    
    /**
     * Removes the particular disc from the database
     * @param id
     *        by which the disc can be removed
     * @throws UserApplicationException
     *         if there is any error occurs while removing
     */
    public void removeDiscById(int id) throws UserApplicationException;
        
    /**
     * Updates the particular disc in the database
     * @param disc
     *        Disc object contains its attributes
     * @throws UserApplicationException
     *         if there is any error occurs while updating
     * 
     */
    public void updateDiscById(Disc disc) throws UserApplicationException;
    
    /**
     * Allocates category to a set of discs
     * @param  disc
     *         Disc object which belongs to category
     * @param category
     *        Category object which is allocated for discs
     */
    public void allocateCategoryToDiscs(Disc disc, Category category) throws UserApplicationException;
    
    /**
     * Allocates languages to a set of discs
     * @param  disc
     *         Disc object belongs to the respective language
     * @param language
     *        Language object which is allocated for discs
     */
    public void allocateLanguageToDiscs(Disc disc, Language language) throws UserApplicationException;
    
    /**
     * This method used to update disc object by stock element with hibernate operation 
     * @param disc object should not be null
     * @param stock should be integer
     * @throws UserApplicationException
     *         If there is error in modified disc by stock
     */
    public void updateStock(Disc disc, int stock) throws UserApplicationException;

}
