package application;

import javafx.beans.property.SimpleStringProperty;

public class User {
	private final SimpleStringProperty ID;
	private final SimpleStringProperty emri;
	private final SimpleStringProperty mbiemri;
	private final SimpleStringProperty ditelindja;
	private final SimpleStringProperty email;
	private final SimpleStringProperty numri;
	private final SimpleStringProperty qyteti;
	private final SimpleStringProperty adresa;
	private final SimpleStringProperty vitiStudimev;
	private final SimpleStringProperty niveliStudimev;
	private final SimpleStringProperty universiteti;
	private final SimpleStringProperty fakulteti;
	private final SimpleStringProperty drejtimi;
	private final SimpleStringProperty bursaId;
	



public User(String id, String fName, String lName,String dt, String mail, String no, String ct, String ad, String vs, String ns, String uni, String fk, String dr, String bu)
{
	this.ID = new SimpleStringProperty(id);
	this.emri = new SimpleStringProperty(fName);
	this.mbiemri = new SimpleStringProperty(lName);
	this.ditelindja = new SimpleStringProperty(dt);
	this.email = new SimpleStringProperty(mail);
	this.numri = new SimpleStringProperty(no);
	this.qyteti = new SimpleStringProperty(ct);
	this.adresa = new SimpleStringProperty(ad);
	this.vitiStudimev = new SimpleStringProperty(vs);
	this.niveliStudimev = new SimpleStringProperty(ns);
	this.universiteti = new SimpleStringProperty(uni);
	this.fakulteti = new SimpleStringProperty(fk);
	this.drejtimi = new SimpleStringProperty(dr);
	this.bursaId = new SimpleStringProperty(bu);
	
	
	
}
public String getID()
{
	return ID.get();
	
}

public String getFirstName()
{
	return emri.get();
	
}
public String getLastName()
{
	return mbiemri.get();
	
}
public String getDate()
{
	return ditelindja.get();
	
}
public String getEmail()
{
	return email.get();
	
}
public String getNumri()
{
	return numri.get();
	
}
public String getQyteti()
{
	return qyteti.get();
	
}
public String getAdresa()
{
	return adresa.get();
	
}
public String getVitiS()
{
	return vitiStudimev.get();
	
}
public String getniveliS()
{
	return niveliStudimev.get();
	
}
public String getUniversiteti()
{
	return universiteti.get();
	
}
public String getFakulteti()
{
	return fakulteti.get();
	
}
public String getDrejtimi()
{
	return drejtimi.get();
	
}
public String getBursa()
{
	return bursaId.get();
}
public void setID(String id)
{
	ID.set(id);
	
}
public void setFirstName(String fName)
{
	emri.set(fName);
	
}
public void setLastName(String lName)
{
	mbiemri.set(lName);
	
}
public void setEmail(String mail)
{
	email.set(mail);
	
}
public void setDitelindja(String dt)
{
	ditelindja.set(dt);
	
}

public void setNumri(String no)

{
	numri.set(no);
	
}
public void setQyteti(String ct)

{
	qyteti.set(ct);
	
}
public void setAdresa(String ad)

{
	adresa.set(ad);
	
}

public void setVitiStudimev(String vs)
{
	vitiStudimev.set(vs);
	
}
public void setUniversiteti(String uni)
{
	universiteti.set(uni);
	
}

public void setFakulteti(String fk)
{
	fakulteti.set(fk);
	
}
public void setDrejtimi(String dr)
{
	drejtimi.set(dr);
	
}
public void setBursa(String bu)
{
	bursaId.set(bu);
	
}
}

