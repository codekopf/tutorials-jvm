package com.codepills;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface BidService {

    /**
     * Get document content based document ID
     *
     * @param token - Authorization token
     * @param tenderId - Document ID
     * @return document content.
     */
    @GET("v3/documents/{documentId}/content")
    @Streaming
    Call<ResponseBody> getDocumentContent(@Header("Authorization") String token, @Path("documentId") String documentId);

}

