package com.commons.webservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.commons.log.AppsLog;

/**
 * @author Lluis Alonso Asc—n
 * 
 * @date 21/08/2013
 */
public class AppsWebService {

	public void getArray() {
	}

	// public void executeGetMethod(String url, HashMap<String, Object> params,
	// Context context, AsyncTaskCompleteListener<RestResponse> response,
	// String title, String detail) {
	//
	// RestRequest request = new JSONRestRequest();
	// request.setMethod(RestRequest.GET_METHOD);
	// request.setURL(url);
	//
	// if (params != null) {
	// request.setContent(params);
	// }
	//
	// RestServiceTask task = new RestServiceTask(context, response, title,
	// detail);
	// task.execute(request);
	//
	// }

	public JSONArray getArray(String url, String nameTag) {

		try {

			JSONArray jsonArray = null;

			// Creating JSON Parser instance
			JSONParser jParser = new JSONParser();

			// getting JSON string from URL
			JSONObject json = jParser.getJSONFromUrl(url);

			if (json != null) {
				jsonArray = json.getJSONArray(nameTag);
			}

			return jsonArray;

		} catch (JSONException e) {
			e.printStackTrace();
			AppsLog.error("WSCOMMONS.ARRAY", e.getLocalizedMessage());
			return null;
		}

	}

	public JSONObject getObject(String url, String nameTag) {

		try {

			JSONObject jsonObj = null;

			// Creating JSON Parser instance
			JSONParser jParser = new JSONParser();

			// getting JSON string from URL
			JSONObject json = jParser.getJSONFromUrl(url);

			jsonObj = json.getJSONObject(nameTag);

			return jsonObj;

		} catch (JSONException e) {
			e.printStackTrace();
			AppsLog.error("WSCOMMONS.OBJECT", e.getLocalizedMessage());
			return null;
		}

	}

}
