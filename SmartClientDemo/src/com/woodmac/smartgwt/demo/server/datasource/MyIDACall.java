package com.woodmac.smartgwt.demo.server.datasource;

import javax.servlet.ServletException;

import com.isomorphic.datasource.DSRequest;
import com.isomorphic.datasource.DSResponse;
import com.isomorphic.rpc.RPCManager;
import com.isomorphic.servlet.IDACall;
import com.isomorphic.servlet.RequestContext;

public class MyIDACall extends IDACall {
	

	@Override
	public DSResponse handleDSRequest(DSRequest dsRequest, RPCManager rpcManager,
			RequestContext requestContext) throws Exception {
		long time = System.currentTimeMillis();
		DSResponse response = super.handleDSRequest(dsRequest, rpcManager, requestContext);
		System.out.println(" --> handleDSRequest Call finished. ["+(System.currentTimeMillis()- time)+" ms]");
		return response;
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println(" --> Init call finished");
	}

}
