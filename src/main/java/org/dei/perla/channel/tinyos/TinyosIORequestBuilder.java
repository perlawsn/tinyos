package org.dei.perla.channel.tinyos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.dei.perla.core.channel.IORequest;
import org.dei.perla.core.channel.IORequestBuilder;


public class TinyosIORequestBuilder implements IORequestBuilder {
	private static final List<IORequestParameter> paramList;
	private String reqId;
	static  {
		IORequestParameter[] paramArray = new IORequestParameter[1];
		paramArray[0]=new IORequestParameter("data", true);
		paramList = Collections.unmodifiableList(Arrays.asList(paramArray));
	}

	TinyosIORequestBuilder(String id) {
		this.reqId = id;
		
	}

	@Override
	public String getRequestId() {
		return reqId;
	}

	@Override
	public IORequest create() {

		return new TinyosIORequest(reqId);
	}

	@Override
	public List<IORequestParameter> getParameterList() {
		
		return paramList;
	}

}
