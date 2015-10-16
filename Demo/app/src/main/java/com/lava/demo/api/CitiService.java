package com.lava.demo.api;

import com.lava.demo.model.Auth;
import com.lava.demo.model.FundTransferBody;
import com.lava.demo.model.GetAccountDetailResponse;
import com.lava.demo.model.GetTransactionsResponse;
import com.lava.demo.model.TransferResponse;
import com.lava.demo.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Bible on 10/16/15.
 */
public interface CitiService {

    @POST("/retailbanking/v1/login")
    void userLogin(@Body User user, @Query("client_id") String clientId, Callback<Auth> cb);

    @GET("/retailbanking/v1/accounts/{account_id}")
    void getMyAccountDetail(@Header("Authorization") String token, @Path("account_id") String accountId,
                            @Query("client_id") String clientId, Callback<List<GetAccountDetailResponse>> cb);

    @GET("/retailbanking/v1/accounts/{account_id}/transactions")
    void getMyTransactions(@Header("Authorization") String token, @Path("account_id") String accountId,
                           @Query("client_id") String clientId, Callback<List<GetTransactionsResponse>> cb);

    @POST("/retailbanking/v1/accounts/{account_id}/fund_transfers")
    void transferFund(@Header("Authorization") String token, @Path("account_id") String accountId,
                      @Query("client_id") String clientId,
                      @Body FundTransferBody transferBody, Callback<TransferResponse> cb);
}
