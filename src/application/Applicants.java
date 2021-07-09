package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Applicants {
	
	private int id;
	private int idStudentit;
	private String emri;
	private String mbiemri;
//	private int ditelindja;
	private String mesatarja;
	private String email;
	private int numri;
	private String qyteti;
	private String adresa;
	private int VitiiStudimeve;
	private String NiveliiStudimeve;
	private String fakulteti;
	private String drejtimi;
	private String bursa;
	
	public Applicants(int id1, int idStudentit1, String emri1, String mbiemri1,
//			int ditelindja, 
			String mesatarja1, String email1,int numri1, String qyteti1, String adresa1, int VitiiStudimeve1, 
			String NiveliiStudimeve1, String fakulteti1, String drejtimi1, String bursa1)
	{
		this.id = id1;
		this.idStudentit = idStudentit1;
		this.emri= emri1;
		this.mbiemri = mbiemri1;
//		this.ditelindja = ditelindja;
		this.mesatarja =mesatarja1;
		this.email = email1;
		this.numri = numri1;
		this.qyteti = qyteti1;
		this.adresa = adresa1;
		this.VitiiStudimeve = VitiiStudimeve1;
		this.NiveliiStudimeve = NiveliiStudimeve1;
		this.fakulteti = fakulteti1;
		this.drejtimi = drejtimi1;
		this.bursa = bursa1;
		
		
	}
	




	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public int getIdStudentit() {
		return idStudentit;
	}
	
	public void setIdStudentit(int idStudentit) {
		 this.idStudentit = idStudentit;
		
	}
	
	public String getEmri() {
		return emri;
	}
	
	public void setEmri(String emri) {
		this.emri = emri;
		
	}
	public String getMbiemri() {
		return mbiemri;
	}
	
	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
		
	}
//	public int getDitelindja() {
//		return ditelindja;
//	}
//	
//	public void setDitelindja(int ditelindja) {
//		this.ditelindja = ditelindja;
//		
//	}
	public String getMesatarja() {
		return mesatarja;
	}
	
	public void setMesatarja(String mesatarja) {
		this.mesatarja = mesatarja;
		
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
		
	}
	public int getNumri() {
		return numri;
	}
	
	public void setNumri(int numri) {
		this.numri = numri;
		
	}
	public String getQyteti() {
		return qyteti;
	}
	
	public void setSqyteti(String qyteti) {
		 this.qyteti = qyteti;
		
	}
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		 this.adresa = adresa;
		
	}
	public int getVitiiStudimeve() {
		return VitiiStudimeve;
	}
	
	public void setVitiiStudimeve(int VitiiStudimeve) {
		 this.VitiiStudimeve = VitiiStudimeve;
		
	}

	
	public void getNiveliiStudimeve(String NiveliiStudimeve) {
		 this.NiveliiStudimeve = NiveliiStudimeve;
		
	}
	public String getfakulteti() {
		return fakulteti;
	}
	
	public void setFakulteti(String fakulteti) {
		 this.fakulteti = fakulteti;
		
	}
	public String getdrejtimi() {
		return drejtimi;
	}
	
	public void setDrejtimi(String drejtimi) {
		 this.drejtimi = drejtimi;
		
	}
	public String getBursa() {
		return bursa;
	}
	
	public void setBursa(String bursa) {
		 this.bursa = bursa;
		
	}
	
	public static boolean addApplicants(int id, int idStudentit, String emri, String mbiemri,
//			int ditelindja, 
			String mesatarja, String email, int numri, String qyteti, String adresa, int VitiiStudimeve, 
			String NiveliiStudimeve, String fakulteti, String drejtimi, String bursa) {
		String query = "INSERT INTO aplikuesit(id, idStudentit, emri, mbiemri, "
//				+ "ditelindja, "
				+ "mesatarja, email, numri, qyteti, adresa, VitiiStudimeve, NiveliiStudimeve, fakulteti, drejtimi, bursa) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(query);
			
			pst.setInt(1, id);
			pst.setInt(2, idStudentit);
			pst.setString(3, emri);
			pst.setString(4, mbiemri);
//			pst.setInt(5, ditelindja);
			pst.setString(5, mesatarja);
			pst.setString(6, email);
			pst.setInt(7,numri);
			pst.setString(8, qyteti);
			pst.setString(9, adresa);
			pst.setInt(10, VitiiStudimeve);
			pst.setString(11, NiveliiStudimeve);
			pst.setString(12, fakulteti);
			pst.setString(13, drejtimi);
			pst.setString(14, bursa);
			
			return (pst.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
	
	public static boolean updateApplicants(int id, int idStudentit, String emri, String mbiemri,
//			int ditelindja, 
			String mesatarja, String email, int numri, String qyteti, String adresa, int VitiiStudimeve, 
			String NiveliiStudimeve, String fakulteti, String drejtimi, String bursa) {
		String query = "Update aplikuesit SET id=?, idStudentit=?, emri=?, mbiemri=?, "
//				+ "ditelindja=?,
				+"mesatarja=?, email=?, numri=?, "
				+ "qyteti=?, adresa=?, VitiiStudimeve=?, NiveliiStudimeve=?, fakulteti=?, drejtimi=?, bursa=?";
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(query);
			pst.setInt(1, id );
			pst.setInt(2, idStudentit);
			pst.setString(3, emri);
			pst.setString(4, mbiemri);
//			pst.setInt(5, ditelindja);
			pst.setString(5, mesatarja);
			pst.setString(6, email);
			pst.setInt(7, numri);
			pst.setString(8, qyteti);
			pst.setString(9, adresa);
			pst.setInt(10, VitiiStudimeve);
			pst.setString(11, NiveliiStudimeve);
			pst.setString(12, fakulteti);
			pst.setString(13, drejtimi);
			pst.setString(14, bursa);
			return (pst.executeUpdate() > 0);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteApplicants(int id) {
		String query = "Delete from aplikuesit where id=?";
		try {
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(query);
			pst.setInt(1, id);
			return(pst.executeUpdate()>0);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	
	
	public static List<Applicants> getApplicants(){
		List<Applicants> applicantsList = new ArrayList();
	
		String query = "Select * from aplikuesit";
		try {
		PreparedStatement pst = DBConnection.getConnection().prepareStatement(query);
		ResultSet rst = pst.executeQuery();
		
		while(rst.next()) {
			Applicants applicants = new Applicants(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getString(6), rst.getString(7), rst.getInt(8), 
					rst.getString(9), rst.getString(10), rst.getInt(11), rst.getString(12), rst.getString(13), rst.getString(14), rst.getString(15));
			
			applicantsList.add(applicants);
		}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		

		return applicantsList;
	}
	
	
}
