package mfin.master.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        		name = "findProdukById",  
	        		query = "from MstProduk p where p.id_produk = :id_produk"  
	        ),
	        
	        @NamedQuery(  
	    	        name = "findAllProduk",  
	    	        query = "from MstProduk"  
	    	),
	        
	        @NamedQuery(  
	    	        name = "updateProdukById",  
	    	        query = "update MstProduk p set p.nm_produk = :nm_produk, p.id_bu = :id_bu, p.modified_by = :modified_by where p.id_produk = :id_produk"  
	    	) 
	    }  
	)  
@Entity
@Table(name="mst_produk")
public class MstProduk extends PanacheEntityBase{

	@Id
	@Column(name="id_produk", length = 30)
	public String id_produk;

	@Column(name="nm_produk", length = 100)
	public String nm_produk;
	
	@Column(name="id_bu", length = 30)
	public String id_bu;
	
	@Column(name="status", length = 1)
	@ColumnDefault("1")
	public Integer status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_dt", columnDefinition = "DATE default SYSDATE")
    public Date created_dt;
	
	@Column(name = "created_by", columnDefinition = "varchar(36) default 'SYSTEM'")
	public String created_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "modified_dt")
    public Date modified_dt;
	
	@Column(name = "modified_by", length = 36)
	public String modified_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "end_dt")
    public Date end_dt;
	
	
	public String getId_produk() {
		return id_produk;
	}

	public void setId_produk(String id_produk) {
		this.id_produk = id_produk;
	}

	public String getNm_produk() {
		return nm_produk;
	}

	public void setNm_produk(String nm_produk) {
		this.nm_produk = nm_produk;
	}

	public String getId_bu() {
		return id_bu;
	}

	public void setId_bu(String id_bu) {
		this.id_bu = id_bu;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreated_dt() {
		return created_dt;
	}

	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getModified_dt() {
		return modified_dt;
	}

	public void setModified_dt(Date modified_dt) {
		this.modified_dt = modified_dt;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}
}