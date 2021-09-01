package mfin.master.dto;

import java.util.Date;

public class MasterProgramMarketingDto {
	
	public String id_prg_mkt;
	public String nm_prg_mkt;
    public Integer status;
    public Date created_dt;
    public String created_by;
    public Date modified_dt;
    public String modified_by;
    public Date end_dt;
    
    public String getId_prg_mkt() {
		return id_prg_mkt;
	}

	public void setId_prg_mkt(String id_prg_mkt) {
		this.id_prg_mkt = id_prg_mkt;
	}

	public String getNm_prg_mkt() {
		return nm_prg_mkt;
	}

	public void setNm_prg_mkt(String nm_prg_mkt) {
		this.nm_prg_mkt = nm_prg_mkt;
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
		return "MasterProgramMarketingDto [id_prg_mkt=" + id_prg_mkt + ", nm_prg_mkt=" + nm_prg_mkt + ", nm_prg_mkt"
				+ ", status=" + status + ", created_dt=" + created_dt + ", created_by=" + created_by 
				+ ", modified_dt=" + modified_dt + ", modified_by" + modified_by + ", end_dt" + end_dt +"]";
	}
}