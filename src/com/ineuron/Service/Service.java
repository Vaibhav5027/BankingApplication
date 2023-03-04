package com.ineuron.Service;

public interface Service {

	public float checkBalance(String username);
	public String depositeAmount(String userName,Float amount);
	public String widrawAmount(String username, Float amount);
	public boolean verifyUser(String userName);
}
