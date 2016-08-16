package com.i2i.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.CategoryDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Category;
import com.i2i.service.CategoryService;
import com.i2i.service.UserExistsException;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryByCategoryname(String categoryname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category saveCategory(Category category) throws UserExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCategory(String categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCategory(Category category) throws UserApplicationException {
		categoryDao.insertCategory(category);
		
	}

	@Override
	public List<Category> categoryList() throws UserApplicationException {
		return categoryDao.listOfCategories();
	}

	@Override
	public Category findByCategoryId(int id) throws UserApplicationException {
		return categoryDao.findCategoryById(id);
	}

	@Override
	public void removeByCategoryId(int id) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByCategoryId(int id, String name) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

}
