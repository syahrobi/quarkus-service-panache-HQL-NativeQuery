package mfin.master.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
import mfin.master.dto.MasterProdukDto;
import mfin.master.model.MstProduk;

@ApplicationScoped
public class MasterProdukSvc {

	private final static Logger LOGGER = LoggerFactory.getLogger(MasterProdukSvc.class.getName());
	
	@Inject
	EntityManager em;
	
	
	
	public List getAllProduk() throws Exception{
//        String sql = 
//                "select ID_PRODUK, NM_PRODUK, ID_BU "+
//                "from CORE.MST_PRODUK "+
//                "where STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
//        
//        Query query = em.createNativeQuery(sql);
        
        //query.setFirstResult(11);
        //query.setMaxResults(10);
		
		/* findall with hibernate NamedQuery */
		TypedQuery q = HibernateUtil.getSession().getNamedQuery("findAllProduk"); 
        LOGGER.info("success get All Produk");
        return q.getResultList();
//        return Helper.createListOfMapFromArray(query.getResultList(), "id_produk", "nm_produk", "id_bu");
    }
	
	public List getMasterProdukById(String idProduk) throws Exception{
//        String sql = 
//        		"select ID_PRODUK, NM_PRODUK, ID_BU "+
//                "from CORE.MST_PRODUK "+
//                "where ID_PRODUK = :id_produk and STATUS = 1 and (TRUNC(END_DT) >= TRUNC(SYSDATE) or END_DT is NULL)";
//        
//        Query q = em.createNativeQuery(sql);
//        q.setParameter("id_produk", idProduk);
        
		
		
		/* select with queryNamed */
        TypedQuery q = HibernateUtil.getSession().getNamedQuery("findProdukById"); 
        q.setParameter("id_produk", idProduk); 
        
        LOGGER.info("success get produk id "+idProduk);
        return q.getResultList();
//        return Helper.createListOfMapFromArray(q.getResultList(), "id_produk", "nm_produk", "id_bu");
    }
	
	@Transactional
    public void insert(MasterProdukDto masterProdukDto){
     
		/* insert with HQL */
		 MstProduk mstProduk = new MstProduk();
        
		 mstProduk.setId_produk(masterProdukDto.getId_produk());
		 mstProduk.setNm_produk(masterProdukDto.getNm_produk());
		 mstProduk.setId_bu(masterProdukDto.getId_bu());
		 mstProduk.setStatus(1);
		 mstProduk.setCreated_dt(new Date());
		 mstProduk.setCreated_by(masterProdukDto.getCreated_by()); ;
		 
		 HibernateUtil.getSession().save(mstProduk);
		 HibernateUtil.getTransaction().commit();
		 HibernateUtil.getSession().close();
		 HibernateUtil.getFactory().close();
		 
         LOGGER.info("insert for id : "+masterProdukDto.getId_produk()+" is success\n"+masterProdukDto.toString());
    }
	
	@Transactional
    public int updateById(MasterProdukDto masterProdukDto) throws SQLException {
        int statusUpdate = 0;

        try{
			/* update by pancahe */
//        	MstProduk mstProduk = MstProduk.findById(masterProdukDto.getId_produk());
//            
//        	mstProduk.setId_produk(masterProdukDto.getId_produk());
//        	mstProduk.setNm_produk(masterProdukDto.getNm_produk());
//        	mstProduk.setId_bu(masterProdukDto.getId_bu());
//        	mstProduk.setModified_dt(new Date());
//        	mstProduk.setModified_by(masterProdukDto.getModified_by());
//        	mstProduk.persist();
        	
			/* update by HQL */
//        	Query q = HibernateUtil.getSession().createQuery(
//        			"UPDATE MstProduk SET id_bu = :idBu, modified_by = :modifiedBy, nm_produk = :nmProduk WHERE id_produk = :idProduk ");  
//            q.setParameter("idBu", masterProdukDto.getId_bu());
//            q.setParameter("modifiedBy", masterProdukDto.getModified_by());
//            q.setParameter("nmProduk", masterProdukDto.getNm_produk());
//            q.setParameter("idProduk", masterProdukDto.getId_produk());
//            
//            int status=q.executeUpdate(); 
//            HibernateUtil.getTransaction().commit();
//            HibernateUtil.getSession().close();
//   		    HibernateUtil.getFactory().close();
//            LOGGER.error(status);
        	
			/* update by NamedQuery */
        	 TypedQuery q = HibernateUtil.getSession().createNamedQuery("updateProdukById"); 
             q.setParameter("nm_produk", masterProdukDto.getNm_produk());
             q.setParameter("id_bu", masterProdukDto.getId_bu());
             q.setParameter("modified_by", masterProdukDto.getModified_by());
             q.setParameter("id_produk", masterProdukDto.getId_produk());
             int status=q.executeUpdate(); 
             HibernateUtil.getTransaction().commit();
             HibernateUtil.getSession().close();
             HibernateUtil.getFactory().close();
             LOGGER.error(status);
            
            statusUpdate = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusUpdate = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusUpdate;
    }
	
	@Transactional
    public int deleteById(MasterProdukDto masterProdukDto) throws SQLException {
        int statusDelete = 0;
        
        try {

        	MstProduk mstProduk = MstProduk.findById(masterProdukDto.getId_produk());
            
        	mstProduk.setModified_dt(new Date());
        	mstProduk.setModified_by(masterProdukDto.getModified_by());
        	mstProduk.setEnd_dt(new Date());
        	mstProduk.setStatus(0);
        	mstProduk.persist();
            
            statusDelete = 1;
        }catch(Exception ex){
            ex.printStackTrace();
            statusDelete = 0;
            LOGGER.error(ex.getMessage());
        }
        
        return statusDelete;
    }
}
