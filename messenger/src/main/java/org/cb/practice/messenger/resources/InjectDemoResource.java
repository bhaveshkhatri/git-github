package org.cb.practice.messenger.resources;



import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectbean")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	
	@GET
	@Path("annotaitons")
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("myheader") String myHeader,
											@CookieParam("mycookie") String myCookie ) {
		
		return matrixParam+"\n"+myHeader+"\n"+myCookie;
	}
	
	
	@GET
	@Path("context")
	public  String getTheParamContext(@Context UriInfo uriInfo, @Context HttpHeaders header) {
				
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = header.getCookies().toString();
		return path+"\n"+cookies;
	}

}
