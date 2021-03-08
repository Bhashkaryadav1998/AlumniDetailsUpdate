package com.example.erp.controller;

import com.example.erp.bean.alumni_details;
import com.example.erp.bean.alumni_education;
import com.example.erp.bean.alumni_organisation;
import com.example.erp.service.alumniEducationService;
import com.example.erp.service.alumniOrganisationService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("alumni_org")
public class alumniOrganisationController {
    alumniOrganisationService alumni= new alumniOrganisationService();


    @POST
    @Path("/add")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@FormDataParam("org") String org,
                        @FormDataParam("pos") String pos,
                        @FormDataParam("jd") String jd,
                        @FormDataParam("ld") String ld,
                        @FormDataParam("aid") Integer aid) throws URISyntaxException{
        System.out.println(aid);
        alumni_organisation al=new alumni_organisation(org,aid,pos,jd,ld);
        boolean result=alumni.add(al);
        if(result == false){
            return Response.status(203).build();
        }

        return Response.ok().build();
    }


    @POST
    @Path("/view")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findMaxi(alumni_organisation al) throws URISyntaxException {

        List<alumni_organisation> result=alumni.find(al);
        return Response.ok().entity(result).build();
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateDetails(alumni_organisation al) throws URISyntaxException{
        boolean result=alumni.updateDetails(al);
        if(result == false){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }


    @POST
    @Path("/del")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteDetails(alumni_organisation al) throws URISyntaxException{
        boolean result=alumni.deleteDetails(al);
        if(result == false){
            return Response.status(203).build();
        }

        return Response.ok().build();
    }
}
