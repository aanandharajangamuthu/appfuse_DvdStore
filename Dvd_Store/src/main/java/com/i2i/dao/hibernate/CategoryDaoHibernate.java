/**
 * 
 */
package com.i2i.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session; 

import org.springframework.stereotype.Repository;


import com.i2i.model.Category;
import com.i2i.dao.CategoryDao;
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
@Repository("categoryDao")
@Transactional
public class CategoryDaoHibernate extends GenericDaoHibernate<Category,Long> implements CategoryDao {
	
    /**
     * Constructor that sets the entity to User.class.
     */
    public CategoryDaoHibernate() {
        super(Category.class);
    }
    
    /**
     * Insert the category into the database
     * @param category
     *        Category object contains its attributes
     * @exception HibernateException
     *      
     */
    public void insertCategory(Category category) throws UserApplicationException {
    	try {    		
    		getSession().saveOrUpdate(category);           
        } catch (HibernateException e) {
            throw new UserApplicationException("Unable to insert category",e);
        } finally {
        	getSession().flush();
        }        
    }  
  

    /**
     * {@inheritDoc}
     */
    public Category saveCategory(Category category) {
        if (log.isDebugEnabled()) {
            log.debug("user's id: " + category.getId());
        }
        getSession().saveOrUpdate(category);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return category;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listOfCategories() throws UserApplicationException {
    	Session session = getSession();
    	try {
            List<Category> categories = session.createQuery("FROM Category").list();
            return categories;        
        } catch(HibernateException e) {
            throw new UserApplicationException("Unable to list the categories",e);
        } finally {
        	session.flush();
        } 

	}

	@Override
	public Category findCategoryById(int id) throws UserApplicationException {
    	Session session = getSession();
    	try {
            Category category = (Category)session.get(Category.class, id);
            return category;
        } catch(HibernateException e) { 
            throw new UserApplicationException("unable to find category having id: "+id);
        } finally {
        	session.flush();
        }
	}

	@Override
	public void removeCategoryById(int id) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategoryById(Category category) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}
}