package mfin.master.dto;

import java.util.Date;

public class MasterProdukDto {
	
    public String id_produk;
	public String id_bu;
    public String nm_produk;
    public Integer status;
    public Date created_dt;
    public String created_by;
    public Date modified_dt;
    public String modified_by;
    public Date end_dt;
    
    public String getId_produk() {
		return id_produk;
	}

	public void setId_produk(String id_produk) {
		this.id_produk = id_produk;
	}

	public String getId_bu() {
		return id_bu;
	}

	public void setId_bu(String id_bu) {
		this.id_bu = id_bu;
	}

	public String getNm_produk() {
		return nm_produk;
	}

	public void setNm_produk(String nm_produk) {
		this.nm_produk = nm_produk;
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
    
	@Override
    public String toString() {
		return "MasterProdukDto [id_produk=" + id_produk + ", nm_produk=" + nm_produk 
				+ ", id_bu=" + id_bu + ", status=" + status + ", created_dt=" + created_dt 
				+ ", created_by=" + created_by + ", modified_dt=" + modified_dt 
				+ ", modified_by" + modified_by + ", end_dt" + end_dt +"]";
	}
}