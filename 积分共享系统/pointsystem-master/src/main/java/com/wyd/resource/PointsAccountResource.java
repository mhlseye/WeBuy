package com.wyd.resource;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.wyd.domain.PointsAccount;
import com.wyd.service.PointsAccountService;

@Component
@Path("pointsAccountResource")
public class PointsAccountResource {
	@Resource
	private PointsAccountService pointsAccountService;
	
	@Path("/save")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(PointsAccount pointsAccount) {
		pointsAccountService.save(pointsAccount);
		return Response.ok().build();
	}
}
