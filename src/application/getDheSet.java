package application;

public class getDheSet 
{
	private int idStudentit; //new a
	private String 	emri; //b
	private String mbiemri; //c
	private float mesatarja; //d
	private String email; //new //e
	private int numri; //new //f
	private String fakulteti; //new //g
	private String drejtimi; //h
	private String bursa; //new //i

	getDheSet(int a, String b, String c, float d, String e, int f,String g,String h, String i)
	{
		this.idStudentit = a;
		this.emri = b;
		this.mbiemri= c;
		this.mesatarja = d;
		this.email = e;
		this.numri = f;
		this.fakulteti = g;
		this.drejtimi = h;
		this.bursa = i;
	}
	
	public String getBursa() 
	{
		return bursa;
	}
	
	public void setBursa(String bursa)
	{
		this.bursa= bursa;
	}
	
	public String getFakulteti() 
	{
		return fakulteti;
	}
	
	public void setFakulteti(String universiteti)
	{
		this.fakulteti= fakulteti;
	}

	
	public int getNumri() 
	{
		return numri;
	}
	
	public void setNumri(int numri)
	{
		this.numri = numri;
	}
	
	public int getIdStudentit() 
	{
		return idStudentit;
	}
	
	public void setIdStudentit(int id)
	{
		this.idStudentit = idStudentit;
	}
	
	public String getEmri() 
	{
		return emri;
	}
	
	public void setEmri(String emri)
	{
		this.emri = emri;
	}
	
	public String getMbiemri()
	{
		return mbiemri;
	}
	
	public void setMbiemri(String mbiemri)
	{
		this.mbiemri = mbiemri;
	}
	
	public float getMesatarja()
	{
		return mesatarja;
	}
	
	public void setMesatarja(float mesatarja)
	{
		this.mesatarja = mesatarja;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getDrejtimi()
	{
		return drejtimi;
	}
	
	public void setDrejtimi(String drejtimi)
	{
		this.mbiemri = drejtimi;
	}

	
}



