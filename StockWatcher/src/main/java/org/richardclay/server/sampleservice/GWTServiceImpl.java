/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.richardclay.server.sampleservice;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.richardclay.client.sampleservice.GWTService;

/**
 *
 * @author Richard
 */
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService
{

	public String myMethod(String s)
	{
		// Do something interesting with 's' here on the server.
		s = "Hello Brian!";
		return "Server says: " + s;
	}
}
