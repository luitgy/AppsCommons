package com.commons.webservice;

import org.json.JSONObject;

public class ResponseWebService {

	private boolean success;
	private JSONObject jsonObj;

	public ResponseWebService() {
	}

	public ResponseWebService(boolean success, JSONObject jsonObj) {
		this.success = success;
		this.jsonObj = jsonObj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

}
