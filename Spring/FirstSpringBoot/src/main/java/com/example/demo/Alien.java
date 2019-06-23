package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // make Alien a Spring bean
public class Alien {
	
	private int aid;
	private String aname;
	private String tech;
	@Autowired
	private Laptop alptp;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public Laptop getAlptp() {
		return alptp;
	}
	public void setAlptp(Laptop alptp) {
		this.alptp = alptp;
	}
	public void show() {
		System.out.println("Alien bean here...");
			alptp.compile();
	}
	

}
