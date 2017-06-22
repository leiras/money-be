package br.com.leiras.money.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.leiras.money.model.Expense;

public class ExpenseService {
	
	Map<Integer, Expense> expensesMap = null;
	
	public ExpenseService() {
		this.expensesMap = new HashMap<Integer, Expense>();				
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Expense d1 = new Expense();
	    	d1.setId(12);
	        d1.setValue(900f);  
	        d1.setDate(formatter.parse("02/06/2017"));
	        
	        this.expensesMap.put(d1.getId(), d1);
	        
	    	Expense d2 = new Expense();
	    	d2.setId(15);
	        d2.setValue(329f);   
	        d2.setDate(formatter.parse("15/06/2017"));
	        this.expensesMap.put(d2.getId(), d2);  
	        
	        Expense d3 = new Expense();
	    	d3.setId(19);
	        d3.setValue(590f);   
	        d3.setDate(formatter.parse("20/06/2017"));
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
		System.out.println("Expense "+expense.getId()+" added!");
		this.expensesMap.put(expense.getId(), expense);
		return expense;
	}
	
	public Expense updateExpense(Expense expense) throws Exception {
		System.out.println("Expense "+expense.getId()+" updated!");
		this.expensesMap.put(expense.getId(), expense);
		return expense;
	}	
	
	public void deleteExpense(Integer expenseId) throws Exception {
		System.out.println("Expense "+expenseId+" deleted!");
		this.expensesMap.remove(expenseId);
	}
	
}
