package br.com.leiras.money.service;

public class ServiceFactory {
	
	private static ExpenseService expenseSevice = null;
	
	
	public static synchronized ExpenseService getExpenseService() {
		if (ServiceFactory.expenseSevice == null) {
			ServiceFactory.expenseSevice = new ExpenseService();
		}
		return ServiceFactory.expenseSevice;
	}

}
