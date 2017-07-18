package com.as.calendar.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.as.calendar.dao.AppointmentsDao;
import com.as.calendar.model.Appointment;

import jersey.repackaged.com.google.common.collect.Lists;



@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("appointments")
public class CalendarResource {

	
	AppointmentsDao adao = new AppointmentsDao();
	
	@GET
	public List<Appointment> getAllAppointments() {
		
		return adao.getAppointments();		
	}
	
	@POST	
	public void addAppointment(Appointment appointment) {
		//System.out.println("post");
		System.out.println(appointment.getAdate()+" "+appointment.getAtime());
		
		int flag = adao.addAppointment(appointment);
		//if(flag<1) return "failure"; else return "success";
		 
	}
	
	@PUT
	@Path("/{aid}")
	public void updateAppointment(@PathParam("aid") int aid ,Appointment appointment) {
		System.out.println("cb1");
		int flag = adao.updateAppointment(aid, appointment);
		System.out.println("cb1");
		//if(flag<1) return "failure"; else return "success";
		
	}
	
	@DELETE
	@Path("/{aid}")
	public void deleteAppointment(@PathParam("aid") int aid) {
		
		boolean flag = adao.deleteAppointment(aid);
		//if(flag==true) return "failure"; else return "success";
	}
}
