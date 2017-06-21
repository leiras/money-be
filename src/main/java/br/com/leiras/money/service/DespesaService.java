package br.com.leiras.money.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.leiras.money.model.Despesa;

public class DespesaService {
	
	Map<Integer, Despesa> mapDespesas = null;
	
	public DespesaService() {
		this.mapDespesas = new HashMap<Integer, Despesa>();				
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Despesa d1 = new Despesa();
	    	d1.setId(12);
	        d1.setValor(900f);  
	        d1.setData(formatter.parse("02/06/2017"));
	        
	        this.mapDespesas.put(d1.getId(), d1);
	        
	    	Despesa d2 = new Despesa();
	    	d2.setId(15);
	        d2.setValor(329f);   
	        d2.setData(formatter.parse("15/06/2017"));
	        this.mapDespesas.put(d2.getId(), d2);  
	        
	        Despesa d3 = new Despesa();
	    	d3.setId(19);
	        d3.setValor(590f);   
	        d3.setData(formatter.parse("20/06/2017"));
	        this.mapDespesas.put(d3.getId(), d3);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	
	public List<Despesa> listarDespesas() throws Exception {
        return new ArrayList<Despesa>(this.mapDespesas.values());
	}
	
	public Despesa obterDespesa(Integer idDespesa) throws Exception {
		return this.mapDespesas.get(idDespesa);
	}
	
	public Despesa adicionarDespesa(Despesa despesa) throws Exception {
		System.out.println("Despesa "+despesa.getId()+" adicionada!");
		this.mapDespesas.put(despesa.getId(), despesa);
		return despesa;
	}
	
	public Despesa atualizarDespesa(Despesa despesa) throws Exception {
		System.out.println("Despesa "+despesa.getId()+" atualizada!");
		this.mapDespesas.put(despesa.getId(), despesa);
		return despesa;
	}	
	
	public void excluirDespesa(Integer idDespesa) throws Exception {
		System.out.println("Despesa "+idDespesa+" excluída!");
		this.mapDespesas.remove(idDespesa);
	}
	
}
