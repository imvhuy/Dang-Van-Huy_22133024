package com.javaweb.services.impl;

import java.util.List;

import com.javaweb.dao.ICategoryDAO;
import com.javaweb.dao.impl.CategoryDaoImpl;
import com.javaweb.models.CategoryModel;
import com.javaweb.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	public ICategoryDAO cateDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findByName(String name) {
		return cateDao.findByName(name);
	}

	@Override
	public void insert(CategoryModel category) {
		CategoryModel cate = this.findByName(category.getCategoryName());
		if (cate.getCategoryName() == null) {
			cateDao.insert(category);
		}
	}

	@Override
	public void update(CategoryModel category) {
		cateDao.update(category);
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);		
	}

	@Override
	public void updateStatus(int id, int status) {
		cateDao.updateStatus(id, status);
		
	}

}
