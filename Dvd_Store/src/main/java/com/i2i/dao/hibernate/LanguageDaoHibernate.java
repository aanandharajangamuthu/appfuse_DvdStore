package com.i2i.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.dao.LanguageDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Language;

@Repository("languageDao")
@Transactional
public class LanguageDaoHibernate extends GenericDaoHibernate<Language, Long> implements LanguageDao {

	/**
     * Constructor that sets the entity to User.class.
     */  

	
    public LanguageDaoHibernate() {
	    super(Language.class);
	}

	

    /**
     * {@inheritDoc}
     */
    public Language saveLanguage(Language language) throws UserApplicationException {
        try {
            getSession().saveOrUpdate(language);        
            return language;
        } catch (HibernateException e) {
    	    throw new UserApplicationException("Unable to inset the language "+language,e);
        } finally {
            getSession().flush();
        }       
    }

    /**
     * Overridden simply to call the saveUser method. This is happening
     * because saveUser flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param user the user to save
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Language save(Language language) {
        try {
		    return this.saveLanguage(language);
		} catch (UserApplicationException e) {			
		    e.printStackTrace();
		}
        return null;
    }


	@Override
	public List<Language> retrieveAllLanguages() throws UserApplicationException {
		Session session =  getSession();
    	try {
            List<Language> languages= session.createQuery("FROM Language").list();
            return languages;        
        } catch(HibernateException e) {
            throw new UserApplicationException("Unable to list the languages ",e);
        } finally {
        	session.flush();
        }
		
	}



	@Override
	public Language findLanguageById(int id) throws UserApplicationException{
        Session session = getSession();
    	try {
            Language language = (Language)session.get(Language.class, id);
            return language;
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to find language having id: "+id);
        } finally {
            session.flush();
        }
	}



	@Override
	public void removeLanguageById(int id) throws UserApplicationException {
		// TODO Auto-generated method stub		
	}



	@Override
	public void updateLanguageById(Language language) throws UserApplicationException {
		// TODO Auto-generated method stub		
	}
}
