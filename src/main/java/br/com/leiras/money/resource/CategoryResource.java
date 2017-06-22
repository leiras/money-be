package br.com.leiras.money.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.leiras.money.model.Category;
import br.com.leiras.money.service.ServiceFactory;

@Path("/categories")
public class CategoryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> listAllCategories() {    	
    	List<Category> categories = null;    	
    	try {
    		categories = ServiceFactory.getCategoryService().listAllCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}     	
        return categories;
    }	
	
}
