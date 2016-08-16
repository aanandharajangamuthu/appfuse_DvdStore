package com.i2i.dao;

import com.i2i.exception.UserApplicationException;
import com.i2i.model.Language;
import com.i2i.model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Data Access Object (GenericDao) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LanguageDao extends GenericDao<Language, Long> {

    

    
   // List<Language> getLanguages();

    
  //  public void saveLanguage(Language language);

	

	Language save(Language language);
	public Language saveLanguage(Language language) throws UserApplicationException;
	
	
	public List<Language> retrieveAllLanguages() throws UserApplicationException;

    /**
     * Retrieves the password in DB for a user
     * @param userId the user's id
     * @return the password in DB, if the user is already persisted
     *
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    String getUserPassword(Long userId);
    */
    /**
     * Finds & retrieves the particular language detail from the database
     * @param id
     *        by which the language can be retrieved 
     * @return language
     *         Language object contains its attributes
     * @throws UserApplicationException 
     *         if there is any error occurs while retrieving  
     */
    public Language findLanguageById(int id) throws UserApplicationException;
    
    /**
     * Removes the particular language from the database
     * @param id
     *        by which the language can be removed
     * @throws UserApplicationException
     *         if there is any error occurs while removing
     */
    public void removeLanguageById(int id) throws UserApplicationException;
        
    /**
     * Updates the particular language in the database
     * @param language
     *        Language object contains its attributes
     * @throws UserApplicationException
     *         if there is any error occurs while updating
     * 
     */
    public void updateLanguageById(Language language) throws UserApplicationException;

}
