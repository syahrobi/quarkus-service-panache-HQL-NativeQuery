package mfin.master.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mfin.master.common.Helper;
import mfin.master.dto.MasterKecamatanDto;
import mfin.master.model.MstKecamatan;

@ApplicationScoped
public class MasterKecamatanSvc {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MasterKecamatanSvc.class.getName());
	
	@Inject
	EntityManager em;
	
	public List getAllKecamatan() throws Exception{
        String sql = 
                "select ID_KECAMATAN, NAMA_KECAMATAN, ID_KOTA " +
                "from CORE.MST_KECAMATAN "+
                "where STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query query = em.createNativeQuery(sql);
        
        //query.setFirstResult(11);
        //query.setMaxResults(10);
        
        LOGGER.info("success get All kecamatan");
        return Helper.createListOfMapFromArray(query.getResultList(), "id_kecamatan", "nama_kecamatan ",
        	   "id_kota");
    }

	public List getMasterKecamatanById(String idKecamatan) throws Exception{
        String sql = 
                "select ID_KECAMATAN, NAMA_KECAMATAN, ID_KOTA " +
                "from CORE.MST_KECAMATAN "+
                "where ID_KECAMATAN = :idKecamatan and STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query q = em.createNativeQuery(sql);
        q.setParameter("idKecamatan", idKecamatan);
        LOGGER.info("success get kecamatan id "+idKecamatan);
        return Helper.createListOfMapFromArray(q.getResultList(), "id_kecamatan", "nama_kecamatan ",
        	   "id_kota");
    }
	
	@Transactional
    public void insert(MasterKecamatanDto masterKecamatanDto){
		 MstKecamatan mstKecamatan = new MstKecamatan();
        
		 mstKecamatan.setId_kecamatan(masterKecamatanDto.getId_kecamatan());
		 mstKecamatan.setNama_kecamatan(masterKecamatanDto.getNama_kecamatan());
		 mstKecamatan.setId_kota(masterKecamatanDto.getId_kota());
		 mstKecamatan.setStatus(1);
		 mstKecamatan.setCreated_dt(new Date());
		 mstKecamatan.setCreated_by(masterKecamatanDto.getCreated_by()); ;
		 mstKecamatan.persist();
         LOGGER.info("insert for id : "+masterKecamatanDto.getId_kecamatan()+" is success\n"+masterKecamatanDto.toString());
    }

	@Transactional
    public int updateById(MasterKecamatanDto masterKecamatanDto) throws SQLException {
        int statusUpdate = 0;

        try{

        	MstKecamatan mstKecamatan = MstKecamatan.findById(masterKecamatanDto.getId_kecamatan());
            
        	mstKecamatan.setNama_kecamatan(masterKecamatanDto.getNama_kecamatan());
        	mstKecamatan.setId_kota(masterKecamatanDto.getId_kota());
        	mstKecamatan.setModified_dt(new Date());
        	mstKecamatan.setModified_by(masterKecamatanDto.getModified_by());
        	mstKecamatan.persist();
            
            statusUpdate = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusUpdate = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusUpdate;
    }
	
	@Transactional
    public int deleteById(MasterKecamatanDto masterKecamatanDto) throws SQLException {
        int statusDelete = 0;
        
        try {

        	MstKecamatan mstKecamatan = MstKecamatan.findById(masterKecamatanDto.getId_kecamatan());
            
        	mstKecamatan.setModified_dt(new Date());
        	mstKecamatan.setModified_by(masterKecamatanDto.getModified_by());
        	mstKecamatan.setEnd_dt(new Date());
        	mstKecamatan.setStatus(0);
        	mstKecamatan.persist();
            
            statusDelete = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusDelete = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusDelete;
    }
}
