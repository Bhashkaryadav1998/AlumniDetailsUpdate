package com.example.erp.controller;

import com.example.erp.bean.alumni_details;
import com.example.erp.service.alumniDetailsService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("alumni")
public class alumniDetailsController {
    alumniDetailsService alumni=new alumniDetailsService();
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAlumni(alumni_details al) throws URISyntaxException{
        alumni_details result=alumni.loginValidate(al);
        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }


    @POST
    @Path("/view")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewDetails(alumni_details al) throws URISyntaxException{

        alumni_details result=alumni.view(al);
        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDetails(alumni_details al) throws URISyntaxException{
        System.out.println("In Controller");
        alumni_details result=alumni.updateDetails(al);
        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }
}
