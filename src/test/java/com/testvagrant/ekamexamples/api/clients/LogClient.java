package com.testvagrant.ekamexamples.api.clients;

import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import org.apache.log4j.Logger;


import static com.testvagrant.ekam.internal.injectors.InjectorsCacheProvider.injectorsCache;

public class LogClient extends RetrofitBaseClient {

    public LogClient(String baseUrl) {
        super(baseUrl,
                new LoggingInterceptor(injectorsCache().getInjector().getInstance(Logger.class)),
                new AllureOkHttp3()
        );
    }

}
