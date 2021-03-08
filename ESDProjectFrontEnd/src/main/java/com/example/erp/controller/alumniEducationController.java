package com.example.erp.controller;

import com.example.erp.bean.alumni_details;
import com.example.erp.bean.alumni_education;
import com.example.erp.service.alumniEducationService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("alumni_edu")
public class alumniEducationController {
    alumniEducationService alumni= new alumniEducationService();

    @POST
    @Path("/view")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMaxi(alumni_education al) throws URISyntaxException {

        List<alumni_education> result=alumni.find(al);
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@FormDataParam("deg") String deg,
                        @FormDataParam("py") Integer py,
                        @FormDataParam("jy") Integer jy,
                        @FormDataParam("cname") String cn,
                        @FormDataParam("addr") String adr,
                        @FormDataParam("aid") Integer aid) throws URISyntaxException{
        System.out.println(aid);
        alumni_education al=new alumni_education(aid, deg, py, jy, cn, adr);
        boolean result=alumni.add(al);
        if(result == false){
            return Response.status(203).build();
        }

        return Response.ok().build();
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateDetails(alumni_education al) throws URISyntaxException{
        boolean result=alumni.updateDetails(al);
        System.out.println("In Update Edu");
        if(result == false){
            return Response.status(203).build();
        }

        return Response.ok().build();
    }



    @POST
    @Path("/del")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteDetails(alumni_education al) throws URISyntaxException{
        System.out.println("in controller");
        boolean result=alumni.deleteDetails(al);
        if(result == false){
            return Response.status(203).build();
        }

        return Response.ok().build();
    }

}
