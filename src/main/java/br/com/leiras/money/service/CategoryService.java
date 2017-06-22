package br.com.leiras.money.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.leiras.money.model.Category;

public class CategoryService {

	private Map<Integer, Category> categoriesMap = null;
	
	public CategoryService() {
		this.categoriesMap = new HashMap<Integer, Category>();
		
		Category c1 = new Category();
		c1.setId(1);
		c1.setName("Moradia");
		this.categoriesMap.put(c1.getId(), c1);
		
		Category c2 = new Category();
		c2.setId(2);
		c2.setName("Transporte");
		this.categoriesMap.put(c2.getId(), c2);
		
		Category c3 = new Category();
		c3.setId(3);
		c3.setName("Saúde");
		this.categoriesMap.put(c3.getId(), c3);
		
		Category c4 = new Category();
		c4.setId(4);
		c4.setName("Lazer");
		this.categoriesMap.put(c4.getId(), c4);
		
		Category c5 = new Category();
		c5.setId(5);
		c5.setName("Outras");
		this.categoriesMap.put(c5.getId(), c5);
	}
	
	public List<Category> listAllCategories() throws Exception {
        return new ArrayList<Category>(this.categoriesMap.values());
	}	
	
}
