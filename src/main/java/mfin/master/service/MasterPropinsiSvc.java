package mfin.master.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import mfin.master.common.Helper;
import mfin.master.dto.MasterPropinsiDto;
import mfin.master.model.MstPropinsi;

@ApplicationScoped
public class MasterPropinsiSvc {

	private final static Logger LOGGER = LoggerFactory.getLogger(MasterPropinsiSvc.class.getName());
	
	@Inject
	EntityManager em;
	
	public List getAllPropinsi() throws Exception{
        String sql = 
                "select ID_PROPINSI, NAMA_PROPINSI "+
                "from CORE.MST_PROPINSI "+
                "where STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query query = em.createNativeQuery(sql);
        
        //query.setFirstResult(11);
        //query.setMaxResults(10);
        
        LOGGER.info("success get All Propinsi");
        return Helper.createListOfMapFromArray(query.getResultList(), "id_propinsi", "nama_propinsi");
    }
	
	public List getMasterPropinsiById(String idPropinsi) throws Exception{
        String sql = 
        		"select ID_PROPINSI, NAMA_PROPINSI "+
                "from CORE.MST_PROPINSI "+
                "where ID_PROPINSI = :id_propinsi and STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query q = em.createNativeQuery(sql);
        q.setParameter("id_propinsi", idPropinsi);
        LOGGER.info("success get propinsi id "+ idPropinsi);
        return Helper.createListOfMapFromArray(q.getResultList(), "id_propinsi", "nama_propinsi");
    }
	
	@Transactional
    public void insert(MasterPropinsiDto masterPropinsiDto){
		 MstPropinsi mstPropinsi = new MstPropinsi();
        
		 mstPropinsi.setId_propinsi(masterPropinsiDto.getId_propinsi());
		 mstPropinsi.setNama_propinsi(masterPropinsiDto.getNama_propinsi());
		 mstPropinsi.setStatus(1);
		 mstPropinsi.setCreated_dt(new Date());
		 mstPropinsi.setCreated_by(masterPropinsiDto.getCreated_by()); ;
		 mstPropinsi.persist();
         LOGGER.info("insert for id : "+masterPropinsiDto.getId_propinsi()+" is success\n"+masterPropinsiDto.toString());
    }
	
	@Transactional
    public int updateById(MasterPropinsiDto masterPropinsiDto) throws SQLException {
        int statusUpdate = 0;

        try{

        	MstPropinsi mstPropinsi = MstPropinsi.findById(masterPropinsiDto.getId_propinsi());
            
        	mstPropinsi.setNama_propinsi(masterPropinsiDto.getNama_propinsi());
        	mstPropinsi.setModified_dt(new Date());
        	mstPropinsi.setModified_by(masterPropinsiDto.getModified_by());
        	mstPropinsi.persist();
            
            statusUpdate = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusUpdate = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusUpdate;
    }
	
	@Transactional
    public int deleteById(MasterPropinsiDto masterPropinsiDto) throws SQLException {
        int statusDelete = 0;
        
        try {

        	MstPropinsi mstPropinsi = MstPropinsi.findById(masterPropinsiDto.getId_propinsi());
            
        	mstPropinsi.setModified_dt(new Date());
        	mstPropinsi.setModified_by(masterPropinsiDto.getModified_by());
        	mstPropinsi.setEnd_dt(new Date());
        	mstPropinsi.setStatus(0);
        	mstPropinsi.persist();
            
            statusDelete = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusDelete = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusDelete;
    }
}
