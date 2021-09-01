package mfin.master.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="mst_kota")
public class MstKota extends PanacheEntityBase{
	
	@Id
	@Column(name="id_propinsi", length = 30)
	public String id_propinsi;

	@Column(name="id_kota", length = 30)
	public String id_kota;
	
	@Column(name="nama_kota", length = 100)
	public String nama_kota;
	
	@Column(name = "type_kota", length = 30)
    public String type_kota;
	
	@Column(name="status", columnDefinition = "Integer default 1")
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
}
