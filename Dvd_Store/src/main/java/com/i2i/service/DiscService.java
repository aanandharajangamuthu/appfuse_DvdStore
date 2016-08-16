package com.i2i.service;

import java.util.List;
import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Category;
import com.i2i.model.Disc;
import com.i2i.model.Language;

@WebService
@Path("/discs")
public interface DiscService {
	
    public void createDisc(Disc disc) throws UserApplicationException; 
    
    /**
     * <p>
     * Retrieves list of Disc from the database
     * Using listOfDiscs method
     * </p>
     *
     * @return discDao.listOfDiscs()
     *         List of discs available in the database
     */
    public List<Disc> discList() throws UserApplicationException; 
    
    /**
     * <p>
     * Finds & Retrieves particular disc from the database
     * Using findDiscById method
     * </p>
     *
     * @param id
     *        which is the unique id of the disc
     * @return discDao.findDiscById(id)
     *         disc
     * @throws UserApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public Disc findByDiscId(int id) throws UserApplicationException; 

    /**
     * <p>
     * Removes particular disc from database
     * Using removeDiscById method
     * </p>
     *
     * @param id
     *        which is the unique id of the disc
     * @throws UserApplicationException
     *         if there is error in the given input like IllegalArgumentException
     */
    public void removeByDiscId(int id) throws UserApplicationException;
    
    /**
     * <p>
     * Updates the particular disc detail in the database
     * Using updateDiscById method
     * </p>
     *
     * @param id
     *        which is the unique id of the disc
     * @param name
     *        which will be the new name of the language
       * @param directorName
     *        which is the name of the director
     * @param actorName
     *        which is the name of the actor
     * @param imageUrl
     *        which is the image of the disc
     * @param stock
     *        which is the number of the available disc
     * @param price
     *        which is the cost of the disc
     * @throws ApplicaionException
     *         if there is any error in the given input or error while updating into databse  
     */  
    public void updateByDiscId(int id, String name, String directorName, String actorName, String imageUrl, int stock, int price) throws UserApplicationException;	

    /**
     * <p>
     * Allocates category to a set of discs
     * Using allocateCategoryToDiscs method
     * </p>
     *
     * @param discs
     *        Set of discs allocate for the category
     * @param category
     *        where the category belongs to discs
     */
    public void categoryForDiscs(Set<Disc> discs, Category category) throws UserApplicationException;
    
    /**
     * <p>
     * Allocates language to a set of discs
     * </p>
     *
     * @param discs
     *        Set of discs to be allocate
     * @param language
     *        where the language belongs to discs
     */
    public void languageForDiscs(Set<Disc> discs, Language language) throws UserApplicationException;
    
    /**
     * <p>
     * This method used to update disc object by stock element
     * </p>     
     * @param disc object should not be null
     * @param stock should be integer
     * @throws UserApplicationException
     *         If there is error in updating disc by stock.  
     */    
    public void updateByDiscStock(Disc disc, int stock) throws UserApplicationException;
}
