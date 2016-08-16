package com.i2i.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.DiscDao;
import com.i2i.exception.UserApplicationException;
import com.i2i.model.Category;
import com.i2i.model.Disc;
import com.i2i.model.Language;
import com.i2i.service.DiscService;

@Service("DiscService")
public class DiscServiceImpl implements DiscService {
	
	@Autowired
	DiscDao discDao;
	
	public void createDisc(Disc disc) throws UserApplicationException {
		discDao.insertDisc(disc);
	}
	
	 public List<Disc> discList() throws UserApplicationException{
		 return discDao.listOfDiscs();
	 }

	@Override
	public Disc findByDiscId(int id) throws UserApplicationException {
		return discDao.findDiscById(id);
	}

	@Override
	public void removeByDiscId(int id) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByDiscId(int id, String name, String directorName, String actorName, String imageUrl, int stock,
			int price) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void categoryForDiscs(Set<Disc> discs, Category category) throws UserApplicationException {
        for(Disc disc : discs) {
            discDao.allocateCategoryToDiscs(disc, category);
        }
	}

	@Override
	public void languageForDiscs(Set<Disc> discs, Language language) throws UserApplicationException {
        for(Disc disc : discs) {
            discDao.allocateLanguageToDiscs(disc, language);
          }		
	}

	@Override
	public void updateByDiscStock(Disc disc, int stock) throws UserApplicationException {
		// TODO Auto-generated method stub
		
	}
}
