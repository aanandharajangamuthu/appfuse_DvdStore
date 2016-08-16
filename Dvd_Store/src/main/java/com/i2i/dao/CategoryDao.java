/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException; 
import com.i2i.model.Category;
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
public interface CategoryDao extends GenericDao<Category, Long> {
	
    /**
     * Gets Category information based on login name.
     * @param categoryname the category's categoryname
     * @return categoryDetails populated categoryDetails object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException thrown when user not
     * found in database
     */
    /*@Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;*/

    /**
     * Gets a list of categories ordered by the uppercase version of their categoryname.
     *
     * @return List populated list of categories
     * @throws UserApplicationException 
     */
    List<Category> getCategories() throws UserApplicationException;

    /**
     * Saves a category's information.
     * @param category the object to be saved
     * @return the persisted Category object
     */
    Category saveCategory(Category category);

    /**
     * Retrieves the password in DB for a user
     * @param userId the user's id
     * @return the password in DB, if the user is already persisted
     */
   /* @Transactional(propagation = Propagation.NOT_SUPPORTED)
    String getUserPassword(Long userId);*/
	
    /**
     * Insert the category into the database
     * @param category
     *        Category object contains its attributes
     * @exception HibernateException
     *      
     */
    public void insertCategory(Category category) throws UserApplicationException;
    
    /**
     * Retrieves the list of categories available in the database
     * @return categories
     *         List of categories  
     * @throws UserApplicationException 
     *         if there is an error occurs while retrieve
     */
    public List<Category> listOfCategories() throws UserApplicationException;
    
    /**
     * Finds & retrieves the particular category detail from the database
     * @param id
     *        by which the category can be retrieved
     * @return category
     *         Category object contains its attributes
     * @throws UserApplicationException 
     *         if there is any error occurs while retrieving  
     */
    public Category findCategoryById(int id) throws UserApplicationException;
    
    /**
     * Removes the particular category from the database
     * @param id
     *        by which the category can be removed
     * @throws UserApplicationException
     *         if there is any error occurs while removing
     */
    public void removeCategoryById(int id) throws UserApplicationException;
        
    /**
     * Updates the particular category in the database
     * @param category
     *        Category object contains its attributes
     * @throws UserApplicationException
     *         if there is any error occurs while updating
     * 
     */
    public void updateCategoryById(Category category) throws UserApplicationException;
}