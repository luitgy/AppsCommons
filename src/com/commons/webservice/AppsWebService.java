package com.commons.webservice;

import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.commons.log.AppsLog;
import com.commons.util.AppsConstants;

/*
 * This file is part of the Deg framework.
 *
 * @author Lluis Alonso <luitgy@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
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

	private String createUrl(String url, String userId, String locale) {

		if (userId != null
				&& (!userId.trim().equals(AppsConstants.EMPTY_STRING))) {
			url += "?_uid=" + userId;
		}

		if (locale != null
				&& (!locale.trim().equals(AppsConstants.EMPTY_STRING))) {

			if (url.contains("?")) {
				url += "&_locale=" + locale;
			} else {
				url += "?_locale=" + locale;
			}

		}

		return url;

	}

	private JSONObject getJSON(String url, String userId, String locale,
			boolean isGet, List<NameValuePair> pairs) {

		// Creating JSON Parser instance
		JSONParser jParser = new JSONParser();

		String urlFormated = createUrl(url, userId, locale);

		// getting JSON string from URL
		JSONObject json = null;

		if (isGet) {
			json = jParser.getJSONFromUrlGet(urlFormated);
		} else {
			json = jParser.getJSONFromUrlPost(url, pairs);
		}

		return json;

	}

	public JSONArray getArrayByGet(String url, String userId, String locale,
			String nameTag) {

		try {

			JSONObject json = getJSON(url, userId, locale, Boolean.TRUE, null);

			JSONArray jsonArray = null;

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

	public JSONObject getObjectByGet(String url, String userId, String locale,
			String nameTag) {

		try {

			JSONObject json = getJSON(url, userId, locale, Boolean.TRUE, null);

			JSONObject jsonObj = null;

			if (json != null) {
				jsonObj = json.getJSONObject(nameTag);
			}

			return jsonObj;

		} catch (JSONException e) {
			e.printStackTrace();
			AppsLog.error("WSCOMMONS.OBJECT", e.getLocalizedMessage());
			return null;
		}

	}

	public JSONObject getObjectByPost(String url, String userId, String locale,
			List<NameValuePair> pairs, String nameTag) {

		try {

			JSONObject json = getJSON(url, userId, locale, Boolean.FALSE, pairs);

			JSONObject jsonObj = null;

			if (json != null) {
				jsonObj = json.getJSONObject(nameTag);
			}

			return jsonObj;

		} catch (JSONException e) {
			e.printStackTrace();
			AppsLog.error("WSCOMMONS.OBJECT", e.getLocalizedMessage());
			return null;
		}

	}

}
