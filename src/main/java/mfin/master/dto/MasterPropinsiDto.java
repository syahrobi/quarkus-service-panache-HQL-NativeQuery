package mfin.master.dto;

import java.util.Date;

public class MasterPropinsiDto {
	
    public String id_propinsi;
	public String nama_propinsi;
    public Integer status;
    public Date created_dt;
    public String created_by;
    public Date modified_dt;
    public String modified_by;
    public Date end_dt;
    
	public String getId_propinsi() {
		return id_propinsi;
	}

	public void setId_propinsi(String id_propinsi) {
		this.id_propinsi = id_propinsi;
	}
	
	public String getNama_propinsi() {
		return nama_propinsi;
	}

	public void setNama_propinsi(String nama_propinsi) {
		this.nama_propinsi = nama_propinsi;
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
		return "MasterKotaDto [id_propinsi=" + id_propinsi + ", id_kota=" + nama_propinsi + ", nama_propinsi"
				+ ", status=" + status + ", created_dt=" + created_dt + ", created_by=" + created_by 
				+ ", modified_dt=" + modified_dt + ", modified_by" + modified_by + ", end_dt" + end_dt +"]";
	}
}