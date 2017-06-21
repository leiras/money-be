package br.com.leiras.money.service;

public class ServiceFactory {
	
	private static DespesaService despesaSevice = null;
	
	
	public static synchronized DespesaService getDespesaService() {
		if (ServiceFactory.despesaSevice == null) {
			ServiceFactory.despesaSevice = new DespesaService();
		}
		return ServiceFactory.despesaSevice;
	}

}
