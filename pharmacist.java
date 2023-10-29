package com.pharmacist;

public class pharmacist {
	private int pid;
	private String pname;
	private String pemail;
	private String meditype;
	private String paddress;
	private String pphone;
	
	public pharmacist(int pid, String pname, String pemail, String meditype, String paddress, String pphone) {
		this.pid = pid;
		this.pname = pname;
		this.pemail = pemail;
		this.meditype = meditype;
		this.paddress = paddress;
		this.pphone = pphone;
	}

	public int getPid() {
		return pid;
	}


	public String getPname() {
		return pname;
	}

	public String getPemail() {
		return pemail;
	}

	public String getMeditype() {
		return meditype;
	}

	public String getPaddress() {
		return paddress;
	}

	public String getPphone() {
		return pphone;
	}

}
