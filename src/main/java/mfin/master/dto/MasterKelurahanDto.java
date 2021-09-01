package mfin.master.dto;

import java.util.Date;

public class MasterKelurahanDto {
	
    public String id_kelurahan;
	public String nama_kelurahan;
    public String kode_pos;
    public Integer jumlah_kk;
    public Integer jumlah_penduduk;
    public Integer status;
    public Date created_dt;
    public String created_by;
    public Date modified_dt;
    public String modified_by;
    public Date end_dt;
    public String id_kecamatan;
    
    public String getId_kelurahan() {
		return id_kelurahan;
	}
	public void setId_kelurahan(String id_kelurahan) {
		this.id_kelurahan = id_kelurahan;
	}
	public String getNama_kelurahan() {
		return nama_kelurahan;
	}
	public void setNama_kelurahan(String nama_kelurahan) {
		this.nama_kelurahan = nama_kelurahan;
	}
	public String getKode_pos() {
		return kode_pos;
	}
	public void setKode_pos(String kode_pos) {
		this.kode_pos = kode_pos;
	}
	public Integer getJumlah_kk() {
		return jumlah_kk;
	}
	public void setJumlah_kk(Integer jumlah_kk) {
		this.jumlah_kk = jumlah_kk;
	}
	public Integer getJumlah_penduduk() {
		return jumlah_penduduk;
	}
	public void setJumlah_penduduk(Integer jumlah_penduduk) {
		this.jumlah_penduduk = jumlah_penduduk;
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
	public String getId_kecamatan() {
		return id_kecamatan;
	}
	public void setId_kecamatan(String id_kecamatan) {
		this.id_kecamatan = id_kecamatan;
	}
	
	@Override
    public String toString() {
		return "MasterKelurahanDto [id_kelurahan=" + id_kelurahan + ", nama_kelurahan=" + nama_kelurahan 
				+ ", kode_pos=" + kode_pos + ", jumlah_kk=" + jumlah_kk + ", jumlah_penduduk=" + jumlah_penduduk 
				+ ", status=" + status + ", created_dt=" + created_dt + ", created_by=" + created_by 
				+ ", modified_dt=" + modified_dt + ", modified_by" + modified_by + ", end_dt" + end_dt 
				+ ", id_kecamatan" + id_kecamatan +"]";
	}
}