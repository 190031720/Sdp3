package com.customer.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="NgoFormData")
public class NgoData 
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String orgname;
	private String orgurl;
	private String orgemail;
	private String orgmobile;
	private String orgdesc;
	private boolean verify;
	private double orgfunds;
	private double raisedfunds=0;
	private String orgtype;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String orglogo;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String orgcertificate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getOrgurl() {
		return orgurl;
	}
	public void setOrgurl(String orgurl) {
		this.orgurl = orgurl;
	}
	public String getOrgemail() {
		return orgemail;
	}
	public void setOrgemail(String orgemail) {
		this.orgemail = orgemail;
	}
	public String getOrgmobile() {
		return orgmobile;
	}
	public void setOrgmobile(String orgmobile) {
		this.orgmobile = orgmobile;
	}
	public String getOrgdesc() {
		return orgdesc;
	}
	public void setOrgdesc(String orgdesc) {
		this.orgdesc = orgdesc;
	}
	public boolean isVerify() {
		return verify;
	}
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	public double getOrgfunds() {
		return orgfunds;
	}
	public void setOrgfunds(double orgfunds) {
		this.orgfunds = orgfunds;
	}
	public double getRaisedfunds() {
		return raisedfunds;
	}
	public void setRaisedfunds(double raisedfunds) {
		this.raisedfunds = raisedfunds;
	}
	public String getOrglogo() {
		return orglogo;
	}
	public void setOrglogo(String orglogo) {
		this.orglogo = orglogo;
	}
	public String getOrgcertificate() {
		return orgcertificate;
	}
	public void setOrgcertificate(String orgcertificate) {
		this.orgcertificate = orgcertificate;
	}
	public String getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	
	
	
/*
1. image
2. certificate
3. charity name
4. charity url
4. email
6. phone number
7. funds
8. decription
9. type
10. enable
11. remaining funds
*/

}
