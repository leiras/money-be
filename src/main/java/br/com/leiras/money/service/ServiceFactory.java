package br.com.leiras.money.service;

public class ServiceFactory {
	
	private static ExpenseService expenseSevice = null;
	private static CategoryService categorySevice = null;	
	
	public static synchronized ExpenseService getExpenseService() {
		if (ServiceFactory.expenseSevice == null) {
			ServiceFactory.expenseSevice = new ExpenseService();
		}
		return ServiceFactory.expenseSevice;
	}
	
	public static synchronized CategoryService getCategoryService() {
		if (ServiceFactory.categorySevice == null) {
			ServiceFactory.categorySevice = new CategoryService();
		}
		return ServiceFactory.categorySevice;
	}

}
