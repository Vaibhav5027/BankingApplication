package com.ineuron.factory;

import com.ineuron.Service.Service;
import com.ineuron.Service.ServiceImpl;

public class ServiceFactory {
	// To Avoid the object creations
	private ServiceFactory() {

	}
	private static Service bankService=null;
	public static Service getServiceBean() {
		if(bankService==null) {
			bankService= new ServiceImpl();
		}
		return bankService;
	}
}
