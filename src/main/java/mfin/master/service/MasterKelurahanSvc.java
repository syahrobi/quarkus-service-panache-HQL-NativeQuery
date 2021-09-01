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
import mfin.master.dto.MasterKelurahanDto;
import mfin.master.model.MstKelurahan;

@ApplicationScoped
public class MasterKelurahanSvc {

	private final static Logger LOGGER = LoggerFactory.getLogger(MasterKelurahanSvc.class.getName());
	
	@Inject
	EntityManager em;
	
	public List getAllKelurahan() throws Exception{
        String sql = 
                "select ID_KELURAHAN, NAMA_KELURAHAN, KODE_POS, JUMLAH_KK, JUMLAH_PENDUDUK, ID_KECAMATAN "+
                "from CORE.MST_KELURAHAN "+
                "where STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query query = em.createNativeQuery(sql);
        
        //query.setFirstResult(11);
        //query.setMaxResults(10);
        
        LOGGER.info("success get All kelurahan");
        return Helper.createListOfMapFromArray(query.getResultList(), "id_kelurahan", "nama_kelurahan ",
        	   "kode_pos", "jumlah_kk", "jumlah_penduduk", "id_kecamatan");
    }
	
	public List getMasterKelurahanById(String idKelurahan) throws Exception{
        String sql = 
        		"select ID_KELURAHAN, NAMA_KELURAHAN, KODE_POS, JUMLAH_KK, JUMLAH_PENDUDUK, ID_KECAMATAN "+
                "from CORE.MST_KELURAHAN "+
                "where ID_KELURAHAN = :id_kelurahan and STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query q = em.createNativeQuery(sql);
        q.setParameter("id_kelurahan", idKelurahan);
        LOGGER.info("success get Kelurahan id "+idKelurahan);
        return Helper.createListOfMapFromArray(q.getResultList(), "id_kelurahan", "nama_kelurahan", "kode_pos", "jumlah_kk", 
        		"jumlah_penduduk", "id_kecamatan");
    }
	
	@Transactional
    public void insert(MasterKelurahanDto masterKelurahanDto){
		 MstKelurahan mstKelurahan = new MstKelurahan();
        
		 mstKelurahan.setId_kelurahan(masterKelurahanDto.getId_kelurahan());
		 mstKelurahan.setNama_kelurahan(masterKelurahanDto.getNama_kelurahan());
		 mstKelurahan.setKode_pos(masterKelurahanDto.getKode_pos());
		 mstKelurahan.setJumlah_kk(masterKelurahanDto.getJumlah_kk());
		 mstKelurahan.setJumlah_penduduk(masterKelurahanDto.getJumlah_penduduk());
		 mstKelurahan.setId_kecamatan(masterKelurahanDto.getId_kecamatan());
		 mstKelurahan.setStatus(1);
		 mstKelurahan.setCreated_dt(new Date());
		 mstKelurahan.setCreated_by(masterKelurahanDto.getCreated_by()); ;
		 mstKelurahan.persist();
         LOGGER.info("insert for id : "+masterKelurahanDto.getId_kelurahan()+" is success\n"+masterKelurahanDto.toString());
    }
	
	@Transactional
    public int updateById(MasterKelurahanDto masterKeluarahanDto) throws SQLException {
        int statusUpdate = 0;

        try{

        	MstKelurahan mstKelurahan = MstKelurahan.findById(masterKeluarahanDto.getId_kelurahan());
            
        	mstKelurahan.setId_kelurahan(masterKeluarahanDto.getId_kelurahan());
        	mstKelurahan.setNama_kelurahan(masterKeluarahanDto.getNama_kelurahan());
        	mstKelurahan.setKode_pos(masterKeluarahanDto.getKode_pos());
        	mstKelurahan.setJumlah_kk(masterKeluarahanDto.getJumlah_kk());
        	mstKelurahan.setJumlah_penduduk(masterKeluarahanDto.getJumlah_penduduk());
        	mstKelurahan.setId_kecamatan(masterKeluarahanDto.getId_kecamatan());
        	mstKelurahan.setModified_dt(new Date());
        	mstKelurahan.setModified_by(masterKeluarahanDto.getModified_by());
        	mstKelurahan.persist();
            
            statusUpdate = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusUpdate = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusUpdate;
    }
	
	@Transactional
    public int deleteById(MasterKelurahanDto masterKelurahanDto) throws SQLException {
        int statusDelete = 0;
        
        try {

        	MstKelurahan mstKelurahan = MstKelurahan.findById(masterKelurahanDto.getId_kelurahan());
            
        	mstKelurahan.setModified_dt(new Date());
        	mstKelurahan.setModified_by(masterKelurahanDto.getModified_by());
        	mstKelurahan.setEnd_dt(new Date());
        	mstKelurahan.setStatus(0);
        	mstKelurahan.persist();
            
            statusDelete = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusDelete = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusDelete;
    }
}
