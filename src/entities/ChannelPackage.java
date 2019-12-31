package entities;

import java.sql.Date;
import java.util.List;

public class ChannelPackage {

	private String pkgName;
	private String pkgChargeType;
	private List<String> pkgCategoryList;
	private String pkgTransmissionType;
	private double pkgCost;
	private Date pkgFromDate;
	private Date pkgToDate;
	private String pkgByDefault;

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public String getPkgChargeType() {
		return pkgChargeType;
	}

	public void setPkgChargeType(String pkgChargeType) {
		this.pkgChargeType = pkgChargeType;
	}

	public String getPkgTransmissionType() {
		return pkgTransmissionType;
	}

	public void setPkgTransmissionType(String pkgTransmissionType) {
		this.pkgTransmissionType = pkgTransmissionType;
	}

	public double getPkgCost() {
		return pkgCost;
	}

	public void setPkgCost(double pkgCost) {
		this.pkgCost = pkgCost;
	}

	public Date getPkgFromDate() {
		return pkgFromDate;
	}

	public void setPkgFromDate(Date pkgFromDate) {
		this.pkgFromDate = pkgFromDate;
	}

	public Date getPkgToDate() {
		return pkgToDate;
	}

	public void setPkgToDate(Date pkgToDate) {
		this.pkgToDate = pkgToDate;
	}

	public String getPkgByDefault() {
		return pkgByDefault;
	}

	public void setPkgByDefault(String pkgByDefault) {
		this.pkgByDefault = pkgByDefault;
	}

	public List<String> getPkgCategory() {
		return pkgCategoryList;
	}

	public void setPkgCategory(List<String> pkgCategoryList) {
		this.pkgCategoryList = pkgCategoryList;
	}
}
