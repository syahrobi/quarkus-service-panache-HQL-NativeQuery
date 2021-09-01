package mfin.master.dto;

import java.util.Date;

public class MasterKotaDto {
	
    public String id_propinsi;
    public String id_kota;
    public String nama_kota;
    public String type_kota;
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

	public String getId_kota() {
		return id_kota;
	}

	public void setId_kota(String id_kota) {
		this.id_kota = id_kota;
	}

	public String getNama_kota() {
		return nama_kota;
	}

	public void setNama_kota(String nama_kota) {
		this.nama_kota = nama_kota;
	}

	public String getType_kota() {
		return type_kota;
	}

	public void setType_kota(String type_kota) {
		this.type_kota = type_kota;
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
		return "MasterKotaDto [id_propinsi=" + id_propinsi + ", id_kota=" + id_kota 
				+ ", nama_kota=" + nama_kota + ", type_kota=" + type_kota 
				+ ", status=" + status + ", created_dt=" + created_dt + ", created_by=" + created_by 
				+ ", modified_dt=" + modified_dt + ", modified_by" + modified_by + ", end_dt" + end_dt +"]";
	}
}