package com.reformluach.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ServiceAsync extends AsyncTask {
    private final Context context;
    private final String request;
    private final ServiceStatus serviceStatus;
    private final String url;
    private final String methodName;
    private final boolean progressBar;
    private ProgressDialog progressDialog;

    public ServiceAsync(Context context, String request, String url, String methodName, ServiceStatus serviceStatus) {
        this.request = request;
        this.serviceStatus = serviceStatus;
        this.url = url;
        this.methodName = methodName;
        this.context = context;
        this.progressBar = true;
    }

    public ServiceAsync(Context context, String request, String url, String methodName, boolean progressBar, ServiceStatus serviceStatus) {
        this.request = request;
        this.serviceStatus = serviceStatus;
        this.url = url;
        this.methodName = methodName;
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        try {
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...");
            if (progressBar) progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            ServiceCall serviceCall = new ServiceCall();
            //  OCCSession occSession = new OCCSession(context);
            String response = serviceCall.getServiceResponse(url, request, methodName);
            if (response != null) {
                Gson gson = new Gson();
                ServicesResponse servicesResponse = null;
                try {
                    servicesResponse = gson.fromJson(response, ServicesResponse.class);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                return servicesResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        try {
            if (progressBar && progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (o != null) {
            ServicesResponse servicesResponse = (ServicesResponse) o;
            serviceStatus.onSuccess(servicesResponse);
            /*if (servicesResponse.responseCode.equals("200")) {
                serviceStatus.onSuccess(servicesResponse);
            } else {
                serviceStatus.onFailed(servicesResponse);
            }*/
        } else {
            ServicesResponse servicesResponse = new ServicesResponse();
            servicesResponse.responseCode = "0";
            servicesResponse.responseMessage = "The requested operation could not be completed at this moment. Please try again after some time.";
            serviceStatus.onFailed(servicesResponse);
        }
    }
}

