package com.i2i.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.LanguageDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Language;
import com.i2i.model.Role;
import com.i2i.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{
	 
	@Autowired
	LanguageDao languageDao;

	@Override
	public void saveLanguage(Language language) throws UserApplicationException{	
		languageDao.saveLanguage(language);
	}
	
	@Override
	public  List<Language> languageList() throws UserApplicationException {		
		return languageDao.retrieveAllLanguages();
	}

	@Override
	public Language findByLanguageId(int id) throws UserApplicationException {
		return languageDao.findLanguageById(id);
	}

	@Override
	public void removeByLanguageId(int id) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByLanguageId(int id, String name) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}
	

}
