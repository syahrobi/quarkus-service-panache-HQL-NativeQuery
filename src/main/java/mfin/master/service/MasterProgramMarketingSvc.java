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
import mfin.master.dto.MasterProgramMarketingDto;
import mfin.master.model.MstProgramMarketing;

@ApplicationScoped
public class MasterProgramMarketingSvc {

	private final static Logger LOGGER = LoggerFactory.getLogger(MasterProgramMarketingSvc.class.getName());
	
	@Inject
	EntityManager em;
	
	public List getAllProgramMarketing() throws Exception{
        String sql = 
                "select ID_PRG_MKT, NM_PRG_MKT "+
                "from CORE.MST_PRG_MKT "+
                "where STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query query = em.createNativeQuery(sql);
        
        //query.setFirstResult(11);
        //query.setMaxResults(10);
        
        LOGGER.info("success get All Program Marketing");
        return Helper.createListOfMapFromArray(query.getResultList(), "id_prg_mkt", "nm_prg_mkt");
    }
	
	public List getMasterProgramMarketingById(String idProgramMarketing) throws Exception{
        String sql = 
        		"select ID_PRG_MKT, NM_PRG_MKT "+
                "from CORE.MST_PRG_MKT "+
                "where ID_PRG_MKT = :id_prg_mkt and STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query q = em.createNativeQuery(sql);
        q.setParameter("id_prg_mkt", idProgramMarketing);
        LOGGER.info("success get propinsi id "+ idProgramMarketing);
        return Helper.createListOfMapFromArray(q.getResultList(), "id_prg_mkt", "nm_prg_mkt");
    }
	
	@Transactional
    public void insert(MasterProgramMarketingDto masterProgramMarketingDto){
		 MstProgramMarketing mstProgramMarketing = new MstProgramMarketing();
        
		 mstProgramMarketing.setId_prg_mkt(masterProgramMarketingDto.getId_prg_mkt());
		 mstProgramMarketing.setNm_prg_mkt(masterProgramMarketingDto.getNm_prg_mkt());
		 mstProgramMarketing.setStatus(1);
		 mstProgramMarketing.setCreated_dt(new Date());
		 mstProgramMarketing.setCreated_by(masterProgramMarketingDto.getCreated_by()); ;
		 mstProgramMarketing.persist();
         LOGGER.info("insert for id : "+masterProgramMarketingDto.getId_prg_mkt()+" is success\n"+masterProgramMarketingDto.toString());
    }
	
	@Transactional
    public int updateById(MasterProgramMarketingDto masterProgramMarketingDto) throws SQLException {
        int statusUpdate = 0;

        try{

        	MstProgramMarketing mstProgramMarketing = MstProgramMarketing.findById(masterProgramMarketingDto.getId_prg_mkt());
            
        	mstProgramMarketing.setNm_prg_mkt(masterProgramMarketingDto.getNm_prg_mkt());
        	mstProgramMarketing.setModified_dt(new Date());
        	mstProgramMarketing.setModified_by(masterProgramMarketingDto.getModified_by());
        	mstProgramMarketing.persist();
            
            statusUpdate = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusUpdate = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusUpdate;
    }
	
	@Transactional
    public int deleteById(MasterProgramMarketingDto masterProgramMarketingDto) throws SQLException {
        int statusDelete = 0;
        
        try {

        	MstProgramMarketing mstProgramMarketing = MstProgramMarketing.findById(masterProgramMarketingDto.getId_prg_mkt());
            
        	mstProgramMarketing.setModified_dt(new Date());
        	mstProgramMarketing.setModified_by(masterProgramMarketingDto.getModified_by());
        	mstProgramMarketing.setEnd_dt(new Date());
        	mstProgramMarketing.setStatus(0);
        	mstProgramMarketing.persist();
            
            statusDelete = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusDelete = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusDelete;
    }
}
