package com.codepills;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Main {
    public static void main(String[] argv) {


        // Build HTTP Logger
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Build HTTP Client with potential Proxy Setup / Authentication
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
        ;


        OkHttpClient client = clientBuilder.build();

        String api2BaseURL = "https://api-training.regelleistung.net";

        Retrofit retrofitV3 = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .baseUrl(api2BaseURL)
                .build();

        BidService bidServiceV3	  = retrofitV3.create(BidService.class);

        String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYnNwOmFyY2hpdmUiLCJic3A6aW50cmFkYXktbWFuYWdlbWVudCIsImlwcmwtYnMiLCJic3A6YXBpIiwiYnNwOnRlbmRlcnMiXSwicHJvdmlkZXJJZCI6IjIxNSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE2NzM0ODQ3NDksImF1dGhvcml0aWVzIjpbIlJPTEVfUFJPVklERVIiXSwianRpIjoiNDZjOTRhNTEtOGE1MC00ODJhLWE3ODAtOTlmODIzYTdjYTAxIiwiY2xpZW50X2lkIjoiYmUyZGQ4YTA0Y2JkNmY0OSJ9.NAzO-DxZeizXSNYbB1UtjAnPFJCnqnHR6sVAASDf_0LAI8oD1Sos3-7J5a79uiNGNvf1fJDQ-M7O_uSl3iFNd2vd6z8sFv6tIGpEhH4GIqD-Baf9OeECHLZymgO7qpwCY0IfkRHGzkSFvQq3ty5Z_bk1yiKX8ob3FZNn9PgqUk6hbHtpZ4xl7QDgb1qFGU8nJFkKhWCcocfpQJlhuRA49OR-BSv_FCrZFuHpqM2CmMSwbdgJCsSBe5-FN-xEa4B2VJqgRU-DtQCOVkHR5pLUpwjCssK4ORb00X9dWX7m4N1wRrLZM_URYYVIyOuC11kpg-bzVUGFAB27E_bqOi6rAg";

        Call<ResponseBody> call = bidServiceV3.getDocumentContent(token, "za4UanlPpXicuFhu0U7lp");

        Response<ResponseBody> response = null;
        try {
            response = call.execute();

            if (response.isSuccessful()) {
                String content = writeResponseBodyToString(response.body());
                String x = "x";
            }

//            call.enqueue(new Callback<ResponseBody>() {
//                @Override
//                public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
//                    if (response.isSuccessful()) {
//
//                        String x = "start";
//
//                        String content = writeResponseBodyToString(response.body());
//
//                    }
//                    else {
//                        String x = "server contact failed";
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ResponseBody> call, Throwable t) {
//                    String x = "error";
//                }
//            });
//
//
//            if (!response.isSuccessful() && response.errorBody() != null) {
//                String x = "x";
//            }
//            // https://api-training.regelleistung.net/v3/documents/za4UanlPpXicuFhu0U7lp/content - Postman
//            // https://api-training.regelleistung.net/v3/documents/za4UanlPpXicuFhu0U7lp/content
//
//            if (!response.isSuccessful() || response.body() == null) {
//                String x = "x";
//            }
//
//            ResponseBody documentContent = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static String writeResponseBodyToString(ResponseBody body) {
        try {

            InputStream inputStream = body.byteStream();

            StringBuilder content = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    content.append((char) c);
                }
            }

            String x = content.toString();
//
//
//
//
//            StringBuilder content = new StringBuilder();
//
//            InputStream inputStream = null;
//            OutputStream outputStream = null;
//
//            try {
//                byte[] fileReader = new byte[4096];
//
//                long fileSize = body.contentLength();
//                long fileSizeDownloaded = 0;
//
//                inputStream = body.byteStream();
//                outputStream = new FileOutputStream(futureStudioIconFile);
//
//                while (true) {
//                    int read = inputStream.read(fileReader);
//
//                    if (read == -1) {
//                        break;
//                    }
//
//                    outputStream.write(fileReader, 0, read);
//
//                    fileSizeDownloaded += read;
//
//                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
//                }
//
//                outputStream.flush();
//
//
//



            return x;
            } catch (IOException e) {
                return "";
            } finally {
            return "";
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//
//                if (outputStream != null) {
//                    outputStream.close();
//                }
            }
//        } catch (IOException e) {
//            return "false";
//        }
    }
}
