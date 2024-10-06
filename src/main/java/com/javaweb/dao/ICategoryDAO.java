package com.javaweb.dao;

import java.util.List;

import com.javaweb.models.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel findById(int id);
	CategoryModel findByName(String name);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	void updateStatus(int id, int status);
}
