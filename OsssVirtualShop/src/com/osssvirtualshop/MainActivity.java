package com.osssvirtualshop;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.Header;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RequestParams params = new RequestParams();
        params.put("api_auth", "VECeKU2puHatudreb7A3");
        params.put("trigger", "user_profile");
        params.put("id_user", "35");
        params.put("session", "61ff95571aa3db550df827f0cae10c938cd31fd2");

        AsyncHttpClient client = new AsyncHttpClient();
        /*client.post("http://10.0.2.2:5000/api/list/", params, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                System.out.println(response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, java.lang.Throwable throwable, JSONObject errorResponse) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                System.out.println(errorResponse.toString());
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });*/
        
        client.get("http://10.0.2.2:5000/api/list", new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
            	System.out.println("onStart");
                // called before request is started
            	
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
            	System.out.println("onSucess");
                System.out.println(response.toString());
                Toast.makeText(getApplicationContext(), "asdas",Toast.LENGTH_LONG).show();
            
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, java.lang.Throwable throwable, JSONObject errorResponse) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                System.out.println("status code = "+throwable);
            	System.out.println("Pfail");
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            	System.out.println("onRetry");
            }
        });
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
