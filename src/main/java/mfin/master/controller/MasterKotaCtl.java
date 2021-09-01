package mfin.master.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import mfin.master.common.ConstantUtil;
import mfin.master.dto.MasterKotaDto;
import mfin.master.dto.ResponseInfo;
import mfin.master.service.MasterKotaSvc;

@Path("/kota/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MasterKotaCtl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MasterKotaCtl.class.getName());
	
    @Inject
    MasterKotaSvc masterKotaSvc;

    @GET
	@Path("/findall")
	public Response getAllData(){
	ResponseInfo response = new ResponseInfo();
		try{
			response.setStatus(ConstantUtil.SUCCESS_STATUS);
	        response.setMessage(ConstantUtil.SUCCESS);
	        response.setPayload(masterKotaSvc.getAllKota());
	    } catch (Exception e) {
	    	response.setStatus(ConstantUtil.FAILED_STATUS);
	        response.setMessage(e.getMessage());
	    }
	        LOGGER.info(response.toString());
	        return Response.ok(response).build();
	}
    
    @GET
	@Path("/findbyid/{id}")
	public Response getMasterKelurahanById(@PathParam("id") String idKota){
	        ResponseInfo response = new ResponseInfo();
	        try{
	            List list = masterKotaSvc.getMasterKotaById(idKota);

	            if(list.size() > 0){
	                response.setMessage(ConstantUtil.SUCCESS);
	                response.setStatus(ConstantUtil.SUCCESS_STATUS);
	                response.setPayload(list);
	            }else{
	                response.setMessage(ConstantUtil.STATUS_300);
	                response.setStatus("data not found");
	                response.setPayload(list);
	            }
	        } catch (Exception e){
	            LOGGER.error(e.getMessage());
	            response.setMessage(e.getMessage());
	            response.setStatus(ConstantUtil.FAILED_STATUS);
	        } finally {
	            return Response.ok(response).build();
	        }
	    }
    
	@POST
    @Path("/insert")
    public Response InsertMasterKota(MasterKotaDto masterKotaDto){
        ResponseInfo response = new ResponseInfo();
        
        try{
        	masterKotaSvc.insert(masterKotaDto);
            response.setMessage(ConstantUtil.SUCCESS);
            response.setStatus(ConstantUtil.SUCCESS_STATUS);
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(ConstantUtil.FAILED_STATUS);
        }
        LOGGER.info(response.toString());
        return Response.ok(response).build();
    }
	
	@POST
    @Path("/update")
    public Response updateById(MasterKotaDto masterKotaDto) {
        
        ResponseInfo response = new ResponseInfo();
        Map m = new HashMap<>();
       
        try{
            int hsl = masterKotaSvc.updateById(masterKotaDto);
            
            if(hsl > 0){
                response.setMessage(ConstantUtil.SUCCESS);
                response.setStatus(ConstantUtil.SUCCESS_STATUS);
            } else {
                response.setMessage(ConstantUtil.STATUS_300);
                response.setStatus("data not found");
            }
            
           
       } catch (SQLException e){
            response.setMessage(e.getMessage());
            response.setStatus(ConstantUtil.FAILED_STATUS);
       } catch(Exception ex){
            response.setMessage(ex.getMessage());
            response.setStatus(ConstantUtil.FAILED_STATUS);
       }

       response.setPayload(m);
       LOGGER.info(response.toString());
       return Response.ok(response).build();
    }
	
	@POST
    @Path("/delete")
    public Response deleteById(MasterKotaDto masterKotaDto) {
        
        ResponseInfo response = new ResponseInfo();
        Map m = new HashMap<>();
       
        try{
            int hsl = masterKotaSvc.deleteById(masterKotaDto);
            
            if(hsl > 0){
                response.setMessage(ConstantUtil.SUCCESS);
                response.setStatus(ConstantUtil.SUCCESS_STATUS);
            } else {
                response.setMessage(ConstantUtil.STATUS_300);
                response.setStatus("data not found");
            }
           
       } catch (SQLException e){
            response.setMessage(e.getMessage());
            response.setStatus(ConstantUtil.FAILED_STATUS);
       } catch(Exception ex){
            response.setMessage(ex.getMessage());
            response.setStatus(ConstantUtil.FAILED_STATUS);
       }

       response.setPayload(m);
       LOGGER.info(response.toString());
       return Response.ok(response).build();
    }
}
