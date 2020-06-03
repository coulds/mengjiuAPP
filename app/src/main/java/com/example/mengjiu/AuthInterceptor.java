package com.example.mengjiu;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    private Mypreference prefs=Mypreference.getInstance();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest=chain.request();
        Request authRequest=originalRequest.newBuilder()
//                .addHeader("token","12345678")
                .addHeader("token",prefs.currentToken())
                .build();
        return chain.proceed(authRequest);
    }
}
