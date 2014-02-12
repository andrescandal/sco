package com.ceop.pd.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.ceop.pd.model.RequestResponse;

public interface GateWayService {

	@GET
	@Path("/comenzarcampania")
	RequestResponse loginCampaignWithNeotelUser(@QueryParam("campania") int campaign, @QueryParam("usuario") String neotelUser);

	@GET
	@Path("/atenderllamada")
	RequestResponse answerCall(@QueryParam("usuario") String neotelUser);

	@GET
	@Path("/aceptarllamada")
	RequestResponse acceptCall(@QueryParam("usuario") String neotelUser);

	@GET
	@Path("/finalizarcampania")
	RequestResponse logoutCampaign(@QueryParam("usuario") String neotelUser);

	@GET
	@Path("/pausarencuestador")
	RequestResponse pause(@QueryParam("usuario") String neotelUser, @QueryParam("tipodescanso") String subtipoDescanso);

	@GET
	@Path("/discar")
	RequestResponse dialPhone(@QueryParam("usuario") String neotelUser, @QueryParam("telefono") String telephone);

	@GET
	@Path("/stoppeollamadas")
	RequestResponse stopCalls(@QueryParam("idcampania") String idCampania, @QueryParam("campo1") String campo1, @QueryParam("campo2") String campo2);

	@GET
	@Path("/activarllamadas")
	RequestResponse activeCalls(@QueryParam("idcampania") String idCampania, @QueryParam("campo1") String campo1, @QueryParam("campo2") String campo2);

}
