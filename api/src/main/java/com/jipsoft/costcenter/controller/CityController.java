package com.jipsoft.costcenter.controller;

import com.jipsoft.costcenter.model.entity.City;
import com.jipsoft.costcenter.model.repository.CityRepository;
import com.jipsoft.costcenter.model.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Controller
@Path("/city")
public class CityController extends BaseController {

    @Autowired
    private CityRepository repository;

    @GET
    public Response findAll() {
        return Response.ok(repository.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(repository.findById(id).get()).build();
    }

//    @GET
//    @Path("/state/{id}")
//    public Response findByState(@PathParam("id") int id) {
//        var state = City.State.findByCode(id);
//        return Response.ok( repository.findCityByState(state) ).build();
//    }

    @GET
    @Path("/state")
    public Response findByState() {
        return Response.ok(City.State.values()).build();
    }

}
