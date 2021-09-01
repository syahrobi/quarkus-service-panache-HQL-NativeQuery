package mfin.master.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import mfin.master.common.Helper;
import mfin.master.common.HibernateUtil;
import mfin.master.dto.MasterKotaDto;
import mfin.master.model.MstKota;

@ApplicationScoped
public class MasterKotaSvc {

	private final static Logger LOGGER = LoggerFactory.getLogger(MasterKotaSvc.class.getName());
	
	@Inject
	EntityManager em;
	
	public List getAllKota() throws Exception{
        String sql = 
                "select ID_PROPINSI, ID_KOTA, NAMA_KOTA, TYPE_KOTA "+
                "from CORE.MST_KOTA "+
                "where STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query query = em.createNativeQuery(sql);
        
        //query.setFirstResult(11);
        //query.setMaxResults(10);
        
        LOGGER.info("success get All Kota");
        return Helper.createListOfMapFromArray(query.getResultList(), "id_propinsi", "id_kota", "nama_kota", "type_kota");
    }
	
	public List getMasterKotaById(String idKota) throws Exception{
        String sql = 
        		"select ID_PROPINSI, ID_KOTA, NAMA_KOTA, TYPE_KOTA "+
                "from CORE.MST_KOTA "+
                "where ID_PROPINSI = :id_kelurahan and STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
        
        Query q = em.createNativeQuery(sql);
        q.setParameter("id_kelurahan", idKota);
        LOGGER.info("success get Kota id "+idKota);
        return Helper.createListOfMapFromArray(q.getResultList(), "id_propinsi", "id_kota", "nama_kota", "type_kota");
    }
	
	@Transactional
    public void insert(MasterKotaDto masterKotaDto){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.beginTransaction();
		  final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .configure() // configures settings from hibernate.cfg.xml
	                .build();
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
		
		 MstKota mstKota = new MstKota();
        
		 mstKota.setId_propinsi(masterKotaDto.getId_propinsi());
		 mstKota.setId_kota(masterKotaDto.getId_kota());
		 mstKota.setNama_kota(masterKotaDto.getNama_kota());
		 mstKota.setType_kota(masterKotaDto.getType_kota());
//		 mstKota.setStatus(1);
//		 mstKota.setCreated_dt(new Date());
//		 mstKota.setCreated_by(masterKotaDto.getCreated_by()); 
		 
//		 mstKota.persist();
		 
		 session.persist(mstKota);

//         transaction.commit();
//          
         
         
//         Query query = session.createQuery("insert into MstKota (id_propinsi, id_kota, nama_kota, type_kota) " + 
//        		 " '9', '2', 'sdfdsf', 't' ");
//         int result = query.executeUpdate();
         transaction.commit();
         session.close();
         factory.close();
         LOGGER.info("insert for id : "+masterKotaDto.getId_propinsi()+" is success\n"+masterKotaDto.toString());
    }
	
	@Transactional
    public int updateById(MasterKotaDto masterKotaDto) throws SQLException {
        int statusUpdate = 0;

        try{

        	MstKota mstKota = MstKota.findById(masterKotaDto.getId_propinsi());
            
        	mstKota.setId_kota(masterKotaDto.getId_kota());
        	mstKota.setNama_kota(masterKotaDto.getNama_kota());
        	mstKota.setNama_kota(masterKotaDto.getNama_kota());
        	mstKota.setType_kota(masterKotaDto.getType_kota());
        	mstKota.setModified_dt(new Date());
        	mstKota.setModified_by(masterKotaDto.getModified_by());
        	mstKota.persist();
            
            statusUpdate = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusUpdate = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusUpdate;
    }
	
	@Transactional
    public int deleteById(MasterKotaDto masterKotaDto) throws SQLException {
        int statusDelete = 0;
        
        try {

        	MstKota mstKota = MstKota.findById(masterKotaDto.getId_propinsi());
            
        	mstKota.setModified_dt(new Date());
        	mstKota.setModified_by(masterKotaDto.getModified_by());
        	mstKota.setEnd_dt(new Date());
        	mstKota.setStatus(0);
        	mstKota.persist();
            
            statusDelete = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusDelete = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusDelete;
    }
}
