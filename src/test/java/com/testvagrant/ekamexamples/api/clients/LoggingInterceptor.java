package com.testvagrant.ekamexamples.api.clients;

import okhttp3.*;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.apache.logging.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class LoggingInterceptor implements Interceptor {

    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private final Logger logger;
    private String curlOptions;

    public LoggingInterceptor(Logger logger) {
        this.logger = logger;
    }

    public void setCurlOptions(String curlOptions) {
        this.curlOptions = curlOptions;
    }
//    @NotNull
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//
//        String curlCmd = getCurlCmd(request);
//
//
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, "--------- Start of Request --------");
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, curlCmd);
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, "--------- End of request ---------");
//        logger.log(Level.INFO, "-----------------------------------");
//
//        Response response = chain.proceed(request);
//        Response.Builder builder = response.newBuilder();
//
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, "--------- Start of Response --------");
//        logger.log(Level.INFO, "-----------------------------------");
//
//        Headers responseHeaders = response.headers();
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, "--------- Response headers ---------");
//        logger.log(Level.INFO, "-----------------------------------");
//
//        for (int i = 0, count = responseHeaders.size(); i < count; i++) {
//            String name = responseHeaders.name(i);
//            String value = responseHeaders.value(i);
//            logger.log(Level.INFO, "\"" + name + ": " + value + "\"");
//        }
//
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, "--------- Response message ---------");
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, response.message());
//
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, "--------- Response code ---------");
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, response.code());
//
//        ResponseBody responseBody = response.body();
//        if (responseBody != null) {
//            String rawJson = responseBody.string();
//            logger.log(Level.INFO, "-----------------------------------");
//            logger.log(Level.INFO, "--------- Response body ---------");
//            logger.log(Level.INFO, "-----------------------------------");
//            logger.log(Level.INFO, rawJson);
//            builder.body(ResponseBody.create(responseBody.contentType(), rawJson));
//        }
//
//        logger.log(Level.INFO, "-----------------------------------");
//        logger.log(Level.INFO, "--------- End of response ---------");
//        logger.log(Level.INFO, "-----------------------------------");
//
//        return builder.build();
//    }

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String curlCmd = getCurlCmd(request);
        logger.info("--------- Start of Request --------");
        logger.info("-----------------------------------");
        logger.info(curlCmd);
        logger.info("-----------------------------------");
        logger.info("--------- End of request ---------");
        logger.info("-----------------------------------");
        Response response = chain.proceed(request);
        Response.Builder builder = response.newBuilder();
        logger.info("-----------------------------------");
        logger.info("--------- Start of Response --------");
        logger.info("-----------------------------------");
        Headers responseHeaders = response.headers();
        logger.info("-----------------------------------");
        logger.info("--------- Response headers ---------");
        logger.info("-----------------------------------");
        for (int i = 0, count = responseHeaders.size(); i < count; i++) {
            String name = responseHeaders.name(i);
            String value = responseHeaders.value(i);
            logger.info("\"" + name + ": " + value + "\"");
        }
        logger.info("-----------------------------------");
        logger.info("--------- Response message ---------");
        logger.info("-----------------------------------");
        logger.info(response.message());
        logger.info("-----------------------------------");
        logger.info("--------- Response code ---------");
        logger.info("-----------------------------------");
        logger.info(String.valueOf(response.code()));
        ResponseBody responseBody = response.body();
        if (responseBody != null) {
            String rawJson = responseBody.string();
            logger.info("-----------------------------------");
            logger.info("--------- Response body ---------");
            logger.info("-----------------------------------");
            logger.info(rawJson);
            builder.body(ResponseBody.create(responseBody.contentType(), rawJson));
        }
        logger.info("-----------------------------------");
        logger.info("--------- End of response ---------");
        logger.info("-----------------------------------");
        return builder.build();
    }

    @NotNull
    private String getCurlCmd(Request request) throws IOException {
        boolean compressed = false;
        String curlCmd = "curl";
        if (curlOptions != null) {
            curlCmd += " " + curlOptions;
        }
        curlCmd += " -X " + request.method();
        Headers headers = request.headers();
        for (int i = 0, count = headers.size(); i < count; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ("Accept-Encoding".equalsIgnoreCase(name) && "gzip".equalsIgnoreCase(value)) {
                compressed = true;
            }
            curlCmd += " -H " + "\"" + name + ": " + value + "\"";
        }
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            // try to keep to a single line and use a subshell to preserve any line breaks
            String requestBodyAsString = buffer.readString(charset).replace("\n", "\\n");
            if (!requestBodyAsString.isBlank()) {
                curlCmd += " -H " + "\"Content-Type: application/json\"";
                curlCmd += " --data $'" + requestBodyAsString + "'";
            }
        }
        curlCmd += ((compressed) ? " --compressed " : " ") + request.url();
        return curlCmd;
    }
}