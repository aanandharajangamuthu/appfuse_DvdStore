/**
 * 
 */
package com.i2i.service;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Language;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.ws.rs.POST;


/**
 * @author ideas2it
 *
 */
@Service
public interface LanguageService {
    
	
	    @POST
	    public void saveLanguage(Language language) throws UserApplicationException;

	    public List<Language> languageList() throws UserApplicationException;
	  
	    public Language findByLanguageId(int id) throws UserApplicationException;

	    /**
	     * <p>
	     * Removes particular language from database
	     * Using removelanguageById method
	     * </p>
	     *
	     * @param id
	     *        which is the unique id of the language to be removed
	     * @throws UserApplicationException
	     *         if there is error in the given input like IllegalArgumentException
	     */
	    public void removeByLanguageId(int id) throws UserApplicationException;
	    /**
	     * <p>
	     * Updates the particular language detail in the database
	     * Using updatelanguageById method
	     * </p>
	     *
	     * @param id
	     *        which is the unique id of the language
	     * @param name
	     *        which will be the new name for the language
	     * @throws ApplicaionException
	     *         if there is any error in the given input or error while updating into database  
	     */  
	    public void updateByLanguageId(int id, String name) throws UserApplicationException;

}
