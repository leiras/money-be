package br.com.leiras.money.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.leiras.money.model.Despesa;
import br.com.leiras.money.service.ServiceFactory;

@Path("/despesas")
public class DespesaResource {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Despesa> listarDespesas() {    	
    	List<Despesa> despesas = null;    	
    	try {
			despesas = ServiceFactory.getDespesaService().listarDespesas();
		} catch (Exception e) {
			e.printStackTrace();
		}     	
        return despesas;
    }
    
    @GET
    @Path("/{idDespesa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Despesa obterDespesa(@PathParam("idDespesa") String idDespesa) {    	
    	Despesa d = null;    	
    	try {
			d = ServiceFactory.getDespesaService().obterDespesa(new Integer(idDespesa));
		} catch (Exception e) {
			e.printStackTrace();
		}   	
        return d;
    } 
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionarDespesa(Despesa despesa) {
    	Response r = null;    	
    	System.out.println("Adicionar despesa "+despesa.getId()+";"+despesa.getValor());
    	try {
			Despesa d = ServiceFactory.getDespesaService().adicionarDespesa(despesa);
			r = Response.status(Response.Status.CREATED).entity(d).build();
		} catch (Exception e) {		
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
			//e.printStackTrace();			
		}   	
        return r;
    }
 
    @PUT
    @Path("/{idDespesa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Despesa atualizarDespesa(Despesa despesa) {
    	Despesa d = null;    	
    	try {
			d = ServiceFactory.getDespesaService().atualizarDespesa(despesa);
		} catch (Exception e) {
			e.printStackTrace();
		}     	
    	System.out.println("Atualizar despesa "+despesa.getId()+";"+despesa.getValor());
        return d;
    }    
    
    @DELETE
    @Path("/{idDespesa}")
    public void excluirDespesa(@PathParam("idDespesa") String idDespesa) {
    	System.out.println("Exluindo despesa "+idDespesa);
        try {
        	ServiceFactory.getDespesaService().excluirDespesa(new Integer(idDespesa));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }    
    
}
