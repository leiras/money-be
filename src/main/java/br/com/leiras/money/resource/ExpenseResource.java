package br.com.leiras.money.resource;

import java.text.SimpleDateFormat;
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

import br.com.leiras.money.model.Expense;
import br.com.leiras.money.service.ServiceFactory;

@Path("/despesas")
public class ExpenseResource {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> listAllExpenses() {    	
    	List<Expense> expenses = null;    	
    	try {
    		expenses = ServiceFactory.getExpenseService().listAllExpenses();
		} catch (Exception e) {
			e.printStackTrace();
		}     	
        return expenses;
    }
    
    @GET
    @Path("/{expenseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expense getExpense(@PathParam("expenseId") String expenseId) {    	
    	Expense d = null;    	
    	try {
			d = ServiceFactory.getExpenseService().getExpense(new Integer(expenseId));
		} catch (Exception e) {
			e.printStackTrace();
		}   	
        return d;
    } 
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addExpense(Expense expense) {
    	Response r = null;    	
    	System.out.println("Adding expense "+expense.getId()+";"+expense.getValue());
    	try {
			Expense d = ServiceFactory.getExpenseService().addExpense(expense);
			r = Response.status(Response.Status.CREATED).entity(d).build();
		} catch (Exception e) {		
			r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
			//e.printStackTrace();			
		}   	
        return r;
    }
 
    @PUT
    @Path("/{expenseId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Expense updateExpense(Expense expense) {
    	Expense d = null;    	
    	try {
			d = ServiceFactory.getExpenseService().updateExpense(expense);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Updating expense "+expense.getId()+";"+formatter.format(expense.getDate())+";"+expense.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}   	
        return d;
    }    
    
    @DELETE
    @Path("/{expenseId}")
    public void deleteExpense(@PathParam("expenseId") String expenseId) {
    	System.out.println("Deleting expense "+expenseId);
        try {
        	ServiceFactory.getExpenseService().deleteExpense(new Integer(expenseId));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }    
    
}
