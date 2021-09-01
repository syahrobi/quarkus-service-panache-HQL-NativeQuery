package mfin.master.dto;

import java.util.Date;

public class MasterKecamatanDto {
	
	public String id_kecamatan;
	public String nama_kecamatan;
	public Integer status;
    public Date created_dt;
	public String created_by;
    public Date modified_dt;
	public String modified_by;
    public Date end_dt;
	public String id_kota;
	
	public String getId_kecamatan() {
		return id_kecamatan;
	}
	public void setId_kecamatan(String id_kecamatan) {
		this.id_kecamatan = id_kecamatan;
	}
	public String getNama_kecamatan() {
		return nama_kecamatan;
	}
	public void setNama_kecamatan(String nama_kecamatan) {
		this.nama_kecamatan = nama_kecamatan;
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
	public String getId_kota() {
		return id_kota;
	}
	public void setId_kota(String id_kota) {
		this.id_kota = id_kota;
	}
	
	@Override
    public String toString() {
		return "MasterKecamatanDto [id_kecamatan=" + id_kecamatan + ", nama_kecamatan=" + nama_kecamatan 
				+ ", status=" + status + ", created_by=" + created_by + ", created_dt=" + created_dt 
				+ ", modified_by=" + modified_by + ", modified_dt=" + modified_dt + ", end_dt=" + end_dt 
				+ ", id_kota=" + id_kota +"]";
	}
}
