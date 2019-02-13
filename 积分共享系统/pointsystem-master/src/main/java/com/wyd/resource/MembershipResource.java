package com.wyd.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.domain.Membership;
import com.wyd.domain.PointsAccount;
import com.wyd.service.MembershipService;
import com.wyd.service.PointsAccountService;

@Component
@Path("membershipResource")
public class MembershipResource {
	@Resource
	private MembershipService membershipService;
	@Resource
	private PointsAccountService pointsAccountService;
	
	@Path("/save")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional 
	public Response save(Membership membership) {
		PointsAccount pointsAccount = new PointsAccount();
		pointsAccount.setMembership(membership);
		pointsAccountService.save(pointsAccount);
		Integer status = membershipService.save(membership);
		return Response.ok("status:"+status+"\n"+"Create membership successfully").build();
	}
	
	@Path("/findAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<Membership> memberships = membershipService.findAll();
		return Response.ok(memberships).build();
	}
	
	@Path("/getPointsTotal")
	@GET
	@Produces("application/json")
	public Response getPointsTotal(@QueryParam("cellPhone")String cellPhone) {
		int pointsTotal = membershipService.getPointsTotalByCellPhone(cellPhone);
		if(pointsTotal == -1) 
			return Response.ok("Cell phone is error").build();
		else
			return Response.ok("Points total:"+pointsTotal).build();
	}
	
	@Path("/getMembership")
	@GET
	@Produces("application/json")
	public Response getMembership(@QueryParam("cellPhone")String cellPhone) {
		Membership membership = membershipService.getMembershipByCellPhone(cellPhone);
		System.out.println(membership.getMembershipId());
		return Response.ok(membership).build();
	}
	
	@Path("/depositPoints")
	@GET
	@Produces("application/json")
	public Response depositPoints(@QueryParam("cellPhone")String cellPhone,
			@QueryParam("depositPoints")int depositPoints) {
		Integer status = membershipService.pointsDeposit(cellPhone, depositPoints);
		return Response.ok("status:"+status+"\n"+"Deposit " + depositPoints +" points successfully").build();
	}
	
	@Path("/spendPoints")
	@GET
	@Produces("application/json")
	public Response spendPoints(@QueryParam("cellPhone")String cellPhone,
			@QueryParam("spendPoints")int spendPoints) {
		Integer status = membershipService.pointsSpend(cellPhone, spendPoints);
		if(status == 0) 
			return Response.ok("status:"+status+"\n"+"Insufficient balance").build();
		else
			return Response.ok("status:"+status+"\n"+"Spend "+ spendPoints +" points successfully").build();
	}
}
