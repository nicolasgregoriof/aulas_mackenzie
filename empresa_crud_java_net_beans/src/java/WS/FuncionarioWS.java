/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package WS;

import DAO.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author nick
 */
@Path("rest")
public class FuncionarioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FuncionarioWS
     */
    public FuncionarioWS() {
    }

    /**
     * Retrieves representation of an instance of WS.FuncionarioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("funcionarios")
    public String getFuncionario() {
        FuncionarioDao dao = new FuncionarioDao();
        ArrayList <Funcionario> listaFuncionarios = dao.getLista();
        Gson gson = new Gson();
        return gson.toJson(listaFuncionarios);
        
        
        /*String resposta = "";
        for (Funcionario func : listaFuncionarios)
               resposta += "Mat: " + func.getMat()+" "+
                                  "Nome: "+ func.getNome()+" "+
                                  "Salario: "+ func.getSalario()+" "+
                                  "Sexo: "+func.getSexo()+" "+
                                  "Dpto: "+func.getDpto()+" "+
                                  "Supervisor: "+func.getSupervisor() +"\n";
        return resposta;*/
    }
    
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("funcionarios/{ID}")
    public String getFuncionario(@PathParam("ID") int id) {
        FuncionarioDao dao = new FuncionarioDao();
        Funcionario funcionario = dao.consulta(id);
        Gson gson = new Gson();
        return gson.toJson(funcionario);
    }
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("supervisores")
    public String getSupervisores() {
        FuncionarioDao dao = new FuncionarioDao();
        ArrayList <Funcionario> listaFuncionarios = dao.getSup();
        Gson gson = new Gson();
        return gson.toJson(listaFuncionarios);
    }
    
    /*VAMOS REALIZAR UM CRUDE*/
    /*O READ JÁ ESTÁ IMPLEMENTADO ACIMA*/
    
    @DELETE
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("funcionarios/{ID}")
    public Response delFuncionario(@PathParam("ID") int id){
        FuncionarioDao dao = new FuncionarioDao();
        if(dao.remove(id)){
            return Response.status(Response.Status.OK).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("funcionarios")
    public Response addFuncionario(String content){
        Gson gson = new Gson();
        Funcionario funcionario = (Funcionario) gson.fromJson(content, Funcionario.class);
        FuncionarioDao dao = new FuncionarioDao();
        try{
            dao.adiciona(funcionario);
        }
        catch(RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).build();
    }
    
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Path("funcionarios")
    public Response setFuncionario(String content){
        Gson gson = new Gson();
        Funcionario funcionario = (Funcionario) gson.fromJson(content, Funcionario.class);
        FuncionarioDao dao = new FuncionarioDao();
        try{
            if(dao.atualiza(funcionario))
                return Response.status(Response.Status.OK).build();
            else
                return Response.status(Response.Status.NOT_FOUND).build();
        }
        catch(RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
