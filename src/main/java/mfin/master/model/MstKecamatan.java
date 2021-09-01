package mfin.master.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="mst_kecamatan")
public class MstKecamatan extends PanacheEntityBase{
	
	@Id
	@Column(name="id_kecamatan", length = 30)
	public String id_kecamatan;

	@Column(name="nama_kecamatan", length = 100)
	public String nama_kecamatan;
	
	@Column(name="status", columnDefinition = "int default 1")
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
	
	@Column(name="id_kota", length = 30)
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
}
