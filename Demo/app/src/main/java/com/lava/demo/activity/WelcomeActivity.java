package com.lava.demo.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lava.demo.CitiApplication;
import com.lava.demo.Config;
import com.lava.demo.R;
import com.lava.demo.fragment.WelcomeFragment;
import com.lava.demo.logger.Dump;
import com.lava.demo.model.FundTransferBody;
import com.lava.demo.model.GetAccountDetailResponse;
import com.lava.demo.model.GetTransactionsResponse;
import com.lava.demo.model.TransferResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class WelcomeActivity extends AppCompatActivity {

    public static Thread getAccountDetailThread = new GetAccountDetailThread();
    public static Thread getTransactionsThread = new GetTransactionsThread();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        if (findViewById(R.id.welcome_container) != null) {
            if (savedInstanceState != null) return;

            Fragment fragment = new WelcomeFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.welcome_container, fragment).commit();
        }

//        getAccountDetailThread.start();
        getTransactionsThread.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static class TransferFundThread extends Thread {
        @Override
        public void run() {
            synchronized (CitiApplication.lockObject) {
                try {
                    Dump.e("TransferThread Wait");
                    CitiApplication.lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                FundTransferBody fundTransferBody = new FundTransferBody(12345, "USD",
                        "x0e6874a-3c6d-4093-b5f1-0878fab6b87x", "", "", null, 1, 1, "");
                CitiApplication.getCitiService().transferFund(CitiApplication.getToken(),
                        Config.ACCOUNT_ID, Config.CLIENT_ID, fundTransferBody, new Callback<TransferResponse>() {
                            @Override
                            public void success(TransferResponse transferResponse, Response response) {
                                Dump.e(transferResponse.getAccountId());
                                Dump.e(transferResponse.getFormattedAmount());
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Dump.e(error.toString());
                            }
                        });
            }
        }
    }

    private static class GetTransactionsThread extends Thread {
        @Override
        public void run() {
            synchronized (CitiApplication.lockObject) {
                try {
                    Dump.e("GetTransactionsThread Wait");
                    CitiApplication.lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                CitiApplication.getCitiService().getMyTransactions(CitiApplication.getToken(),
                        Config.ACCOUNT_ID, Config.CLIENT_ID, new Callback<List<GetTransactionsResponse>>() {
                            @Override
                            public void success(List<GetTransactionsResponse> getTransactionsResponseList, Response response) {
                                GetTransactionsResponse getTransactionsResponse = getTransactionsResponseList.get(0);
                                Dump.e(getTransactionsResponse.getFormattedAmount());
                                Dump.e(getTransactionsResponse.getAccountId());
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Dump.e(error.toString());
                            }
                        });
            }
        }
    }

    private static class GetAccountDetailThread extends Thread {
        @Override
        public void run() {
            synchronized (CitiApplication.lockObject) {
                try {
                    Dump.e("GetAccountDetailThread Wait");

                    CitiApplication.lockObject.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            CitiApplication.getCitiService().getMyAccountDetail(CitiApplication.getToken(),
                    Config.ACCOUNT_ID, Config.CLIENT_ID, new Callback<List<GetAccountDetailResponse>>() {
                        @Override
                        public void success(List<GetAccountDetailResponse> getAccountDetailResponseList, Response response) {
                            Dump.e("GetAccountDetailThread getMyAccountDetail");
                            Dump.e("status:" + response.getStatus());
                            Dump.e("size:" + getAccountDetailResponseList.size());
                            GetAccountDetailResponse getAccountDetailResponse = getAccountDetailResponseList.get(0);
                            Dump.e(getAccountDetailResponse.getTxnExist());
                            Dump.e(":currentMoney" + getAccountDetailResponse.getBalances().get(0).getCurrent());
                            Dump.e(getAccountDetailResponse.getDisplayAcctNo());
                            Dump.e(getAccountDetailResponse.getAccountStatus());
                            Dump.e(getAccountDetailResponse.getCopsIndicator());
                            Dump.e(getAccountDetailResponse.getDetailsExist());
                            Dump.e(getAccountDetailResponse.getId());
                            Dump.e(getAccountDetailResponse.getIsDestinationAccount());
                            Dump.e(getAccountDetailResponse.getIsSourceAccount());
                            Dump.e(getAccountDetailResponse.getOffersIndicator());
                            Dump.e(getAccountDetailResponse.getProductCurrency());
                            Dump.e(getAccountDetailResponse.getProductDescription());
                            Dump.e(":categoryCode:" + getAccountDetailResponse.getCategoryCode());

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Dump.e(CitiApplication.getToken());
                            Dump.e(error.toString());
                            Dump.e(error.getUrl());


                        }
                    });
        }
    }
}
