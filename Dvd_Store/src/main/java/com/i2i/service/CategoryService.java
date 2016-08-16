/**
 * 
 */
package com.i2i.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.i2i.model.Category;
import com.i2i.exception.UserApplicationException;

/**
 * 
 * <h1>CategoryService</h1>
 * <p>
 * This Service used to processing the input and returns the output. 
 * </p>
 * @author Anandharaj Angamuthu
 *
 */
@WebService
@Path("/categories")
public interface CategoryService {
	
	  /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param userId the identifier for the user
     * @return User
     */
    @GET
    @Path("{id}")
    Category getCategory(@PathParam("id") String categoryId);

    /**
     * Finds a user by their categoryname.
     *
     * @param username the user's categoryname used to login
     * @return User a populated user object
     */
    Category getCategoryByCategoryname(@PathParam("categoryname") String categoryname);

    /**
     * Retrieves a list of all users.
     *
     * @return List
     */
    @GET
    List<Category> getCategories();

    /**
     * Saves a user's information
     *
     * @param user the user's information
     * @return updated user
     * @throws UserExistsException thrown when user already exists
     */
    @POST
    Category saveCategory(Category category) throws UserExistsException;

    /**
     * Removes a user from the database by their userId
     *
     * @param categoryId the user's id
     */
    @DELETE
    void removeCategory(String categoryId);
	
    /**
     * <p>
     * Creates a new category
     * Accepts input from the admin & assign  it to the category. Insert the category into database
     * Using insertCategory method
     * </p>
     *
     * @param name
     *        which is the name of the category
     * 
     * @throws UserApplicationException
     *         if there is any error in the given input or error while inserting into database
     */
    public void createCategory(Category category) throws UserApplicationException; 
    
    /**
     * <p>
     * Retrieves list of Category from the database
     * Using listOfCategories method
     * </p>
     *
     * @return categories
     *         List of categories available in the database
     */
    public List<Category> categoryList() throws UserApplicationException;
    
    /**
     * <p>
     * Finds & Retrieves particular category from the database
     * Using findCategoryById method
     * </p>
     *
     * @param id
     *        which is the unique id of the category
     * @return category
     *         category object retrieved by that id
     * @throws UserApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public Category findByCategoryId(int id) throws UserApplicationException;

    /**
     * <p>
     * Removes particular category from database
     * Using removeCategoryById method
     * </p>
     *
     * @param id
     *        which is the unique id of the category to be removed
     * @throws UserApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public void removeByCategoryId(int id) throws UserApplicationException;
    /**
     * <p>
     * Updates the particular category detail in the database
     * Using updateCategoryById method
     * </p>
     *
     * @param id
     *        which is the unique id of the category
     * @param name
     *        which will be the new name for the category
     * @throws ApplicaionException
     *         if there is any error in the given input or error while updating into databse  
     */  
    public void updateByCategoryId(int id, String name) throws UserApplicationException;

}