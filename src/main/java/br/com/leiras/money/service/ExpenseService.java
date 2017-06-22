package br.com.leiras.money.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.leiras.money.model.Category;
import br.com.leiras.money.model.Expense;

public class ExpenseService {
	
	private Map<Integer, Expense> expensesMap = null;
	private Integer expenseIndex = null;
	
	public ExpenseService() {
		this.expensesMap = new HashMap<Integer, Expense>();	
		this.expenseIndex = 0;
		try {
			List<Category> categories = ServiceFactory.getCategoryService().listAllCategories();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Expense d1 = new Expense();
	    	d1.setId(++this.expenseIndex);
	        d1.setValue(900f);  
	        d1.setDate(formatter.parse("02/06/2017"));
	        d1.setCategory(categories.get(0));
	        
	        this.expensesMap.put(d1.getId(), d1);
	        
	    	Expense d2 = new Expense();
	    	d2.setId(++this.expenseIndex);
	        d2.setValue(329f);   
	        d2.setDate(formatter.parse("15/06/2017"));
	        d2.setCategory(categories.get(2));
	        this.expensesMap.put(d2.getId(), d2);  
	        
	        Expense d3 = new Expense();
	    	d3.setId(++this.expenseIndex);
	        d3.setValue(590f);   
	        d3.setDate(formatter.parse("20/06/2017"));
	        d3.setCategory(categories.get(3));
	        this.expensesMap.put(d3.getId(), d3);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	
	public List<Expense> listAllExpenses() throws Exception {
        return new ArrayList<Expense>(this.expensesMap.values());
	}
	
	public Expense getExpense(Integer expenseId) throws Exception {
		return this.expensesMap.get(expenseId);
	}
	
	public Expense addExpense(Expense expense) throws Exception {					
		this.expensesMap.put(++this.expenseIndex, expense);
		expense.setId(this.expenseIndex);	
		return expense;
	}
	
	public Expense updateExpense(Expense expense) throws Exception {		
		this.expensesMap.put(expense.getId(), expense);
		return expense;
	}	
	
	public void deleteExpense(Integer expenseId) throws Exception {		
		this.expensesMap.remove(expenseId);
	}
	
}
