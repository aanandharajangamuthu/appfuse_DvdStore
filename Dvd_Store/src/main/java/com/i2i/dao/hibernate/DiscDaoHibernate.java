package com.i2i.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.dao.DiscDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Category;
import com.i2i.model.Disc;
import com.i2i.model.Language;

@Repository("discDao")
@Transactional
public class DiscDaoHibernate extends GenericDaoHibernate<Disc,Long> implements DiscDao  {
	
	/**
     * Constructor that sets the entity to Disc.class.
     */
    public DiscDaoHibernate() {
        super(Disc.class);
    }

	@Override
	public Disc get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
    /**
     * Insert the Disc into the database
     * @param disc
     *        Disc object contains its attributes
     * @exception HibernateException
     *      
     */
	@Override
	public void insertDisc(Disc disc) throws UserApplicationException {
	   	try {
    		System.out.println("Entering into insert Disc");
    		System.out.println(disc);
    		getSession().saveOrUpdate(disc);
        } catch (HibernateException e) {
            throw new UserApplicationException("Unable to insert disc",e);
        } finally {
            //closeSession(session);
        }        
    }

    /**
     * Retrieves the list of disc available in the database
     * @return discs
     *         List of discs  
     * @throws UserApplicationException 
     *         if there is an error occurs while retrieve
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Disc> listOfDiscs() throws UserApplicationException {
    	Session session = getSession();
        try {
            List<Disc> discs= session.createQuery("FROM Disc").list();
        return discs;        
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to list disc",e);
        } finally {
           // closeSession(session); 
        } 
	}

	@Override
	public Disc findDiscById(int id) throws UserApplicationException {
    	Session session = getSession();
        try {        	
        	Disc disc = (Disc)session.get(Disc.class, id);
            return disc;
        } catch(HibernateException e) { 
            throw new UserApplicationException("unable to find disc having id: "+id);
        } finally {
            //closeSession(session);
        }

	}

	@Override
	public void removeDiscById(int id) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDiscById(Disc disc) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void allocateCategoryToDiscs(Disc disc, Category category) throws UserApplicationException {
    	Session session = getSession();
    	//Transaction transaction = null;
        try {
        	System.out.println("Enter into Category allocation");
        	System.out.println(disc);
        	System.out.println(category);
        	//transaction = session.beginTransaction();
            disc.setCategory(category);
            session.update(disc);
            System.out.println("Category allocated");
           // transaction.commit();
        }catch(HibernateException e) {
            throw new UserApplicationException("unable to allocate category");
        }finally {
            //closeSession(session); 
      }

		
	}

	@Override
	public void allocateLanguageToDiscs(Disc disc, Language language) throws UserApplicationException {
    	Session session = getSession();
    	//Transaction transaction = null;
        try {
        	System.out.println("Enter into Language allocation");
        	//transaction = session.beginTransaction();
            disc.setLanguage(language);
            session.update(disc);
            System.out.println("Language allocated");
            //transaction.commit();
        }catch(HibernateException e) {
            throw new UserApplicationException("unable to allocate language");
        }finally {
            //closeSession(session); 
      }

		
	}

	@Override
	public void updateStock(Disc disc, int stock) throws UserApplicationException {
    	Session session = getSession();
    	//Transaction transaction = null;
        try {
        	//transaction = session.beginTransaction();
            disc.setStock(stock);
            session.update(disc);
            //transaction.commit();
        } catch(HibernateException e) {
            throw new UserApplicationException("unable to modified Stock");
        } finally {
            //closeSession(session); 
        }    
		
	}

}
