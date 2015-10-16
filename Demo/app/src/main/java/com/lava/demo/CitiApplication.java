package com.lava.demo;

import android.app.Application;

import com.lava.demo.api.CitiService;
import com.lava.demo.logger.Dump;
import com.lava.demo.model.Auth;
import com.lava.demo.model.User;

import java.util.concurrent.locks.ReentrantLock;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CitiApplication extends Application {

    public static String myToken = "";
    private static CitiService citiService = null;
    public static final Object lockObject = new Object();
    @Override
    public void onCreate() {
        super.onCreate();

        Thread loginThread = new LoginThread();
        loginThread.start();
    }

    public static CitiService getCitiService() {

        if (citiService == null) {
            synchronized (CitiApplication.class) {
                if (citiService == null) {
                    RestAdapter restAdapter = new RestAdapter.Builder()
                            .setEndpoint(Config.BASE_URL)
                            .build();
                    citiService = restAdapter.create(CitiService.class);
                }
            }
        }
        return citiService;
    }

    public static String getToken() {
        if (myToken != null) {
            return myToken;
        }
        return "";
    }

    public static void setToken(String token) {
        if (token.length() != 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("Bearer ");
            builder.append(token);
            myToken = builder.toString();
        }
    }

    public static class LoginThread extends Thread {
        @Override
        public void run() {
            User user = new User("impatiencesnuffle", "mooBi8jais");

            getCitiService().userLogin(user, Config.CLIENT_ID, new Callback<Auth>() {
                @Override
                public void success(Auth auth, Response response) {

                    if (auth.getToken() != null) {
                        Dump.e(auth.getUsername());
                        synchronized (CitiApplication.lockObject) {
                            Dump.e("LoginThread Synchronized");
                            setToken(auth.getToken());
                            CitiApplication.lockObject.notify();
                        }

                    } else {
                        Dump.e("token is null");
                    }
                }

                @Override
                public void failure(RetrofitError error) {

                    Dump.e(error.toString());
                }
            });
        }
    }

}
