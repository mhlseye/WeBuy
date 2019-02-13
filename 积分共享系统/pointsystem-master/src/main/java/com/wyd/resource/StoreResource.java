package com.wyd.resource;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.wyd.domain.Store;
import com.wyd.service.StoreService;

@Component
@Path("storeResource")
public class StoreResource {
	@Resource
	private StoreService storeService;
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Store store) {
		int status = storeService.save(store);
		return Response.ok("status:"+status+"\n"+"Create store successfully").build();
	}
}
