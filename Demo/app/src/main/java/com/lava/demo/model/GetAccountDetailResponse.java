
package com.lava.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAccountDetailResponse {

//    @SerializedName("account_status")
    private String accountStatus;
//    @SerializedName("balances")
    private List<Balance> balances = new ArrayList<Balance>();
    @SerializedName("category_code")
    private int categoryCode;
    @SerializedName("cops_indicator")
    private String copsIndicator;
    @SerializedName("details_exist")
    private String detailsExist;
    @SerializedName("display_acct_no")
    private String displayAcctNo;
//    @SerializedName("id")
    private String id;
    @SerializedName("is_destination_account")
    private String isDestinationAccount;
    @SerializedName("is_source_account")
    private String isSourceAccount;
    @SerializedName("offers_indicator")
    private String offersIndicator;
    @SerializedName("product_currency")
    private String productCurrency;
    @SerializedName("product_description")
    private String productDescription;
    @SerializedName("product_type")
    private int productType;
    @SerializedName("reward_points")
    private int rewardPoints;
    @SerializedName("txn_exist")
    private String txnExist;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetAccountDetailResponse() {
    }

    /**
     * 
     * @param detailsExist
     * @param txnExist
     * @param rewardPoints
     * @param isSourceAccount
     * @param productDescription
     * @param categoryCode
     * @param copsIndicator
     * @param productCurrency
     * @param productType
     * @param balances
     * @param id
     * @param displayAcctNo
     * @param isDestinationAccount
     * @param offersIndicator
     * @param accountStatus
     */
    public GetAccountDetailResponse(String accountStatus, List<Balance> balances, int categoryCode, String copsIndicator, String detailsExist, String displayAcctNo, String id, String isDestinationAccount, String isSourceAccount, String offersIndicator, String productCurrency, String productDescription, int productType, int rewardPoints, String txnExist) {
        this.accountStatus = accountStatus;
        this.balances = balances;
        this.categoryCode = categoryCode;
        this.copsIndicator = copsIndicator;
        this.detailsExist = detailsExist;
        this.displayAcctNo = displayAcctNo;
        this.id = id;
        this.isDestinationAccount = isDestinationAccount;
        this.isSourceAccount = isSourceAccount;
        this.offersIndicator = offersIndicator;
        this.productCurrency = productCurrency;
        this.productDescription = productDescription;
        this.productType = productType;
        this.rewardPoints = rewardPoints;
        this.txnExist = txnExist;
    }

    /**
     * 
     * @return
     *     The accountStatus
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * 
     * @param accountStatus
     *     The account_status
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 
     * @return
     *     The balances
     */
    public List<Balance> getBalances() {
        return balances;
    }

    /**
     * 
     * @param balances
     *     The balances
     */
    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    /**
     * 
     * @return
     *     The categoryCode
     */
    public int getCategoryCode() {
        return categoryCode;
    }

    /**
     * 
     * @param categoryCode
     *     The category_code
     */
    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 
     * @return
     *     The copsIndicator
     */
    public String getCopsIndicator() {
        return copsIndicator;
    }

    /**
     * 
     * @param copsIndicator
     *     The cops_indicator
     */
    public void setCopsIndicator(String copsIndicator) {
        this.copsIndicator = copsIndicator;
    }

    /**
     * 
     * @return
     *     The detailsExist
     */
    public String getDetailsExist() {
        return detailsExist;
    }

    /**
     * 
     * @param detailsExist
     *     The details_exist
     */
    public void setDetailsExist(String detailsExist) {
        this.detailsExist = detailsExist;
    }

    /**
     * 
     * @return
     *     The displayAcctNo
     */
    public String getDisplayAcctNo() {
        return displayAcctNo;
    }

    /**
     * 
     * @param displayAcctNo
     *     The display_acct_no
     */
    public void setDisplayAcctNo(String displayAcctNo) {
        this.displayAcctNo = displayAcctNo;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The isDestinationAccount
     */
    public String getIsDestinationAccount() {
        return isDestinationAccount;
    }

    /**
     * 
     * @param isDestinationAccount
     *     The is_destination_account
     */
    public void setIsDestinationAccount(String isDestinationAccount) {
        this.isDestinationAccount = isDestinationAccount;
    }

    /**
     * 
     * @return
     *     The isSourceAccount
     */
    public String getIsSourceAccount() {
        return isSourceAccount;
    }

    /**
     * 
     * @param isSourceAccount
     *     The is_source_account
     */
    public void setIsSourceAccount(String isSourceAccount) {
        this.isSourceAccount = isSourceAccount;
    }

    /**
     * 
     * @return
     *     The offersIndicator
     */
    public String getOffersIndicator() {
        return offersIndicator;
    }

    /**
     * 
     * @param offersIndicator
     *     The offers_indicator
     */
    public void setOffersIndicator(String offersIndicator) {
        this.offersIndicator = offersIndicator;
    }

    /**
     * 
     * @return
     *     The productCurrency
     */
    public String getProductCurrency() {
        return productCurrency;
    }

    /**
     * 
     * @param productCurrency
     *     The product_currency
     */
    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    /**
     * 
     * @return
     *     The productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * 
     * @param productDescription
     *     The product_description
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * 
     * @return
     *     The productType
     */
    public int getProductType() {
        return productType;
    }

    /**
     * 
     * @param productType
     *     The product_type
     */
    public void setProductType(int productType) {
        this.productType = productType;
    }

    /**
     * 
     * @return
     *     The rewardPoints
     */
    public int getRewardPoints() {
        return rewardPoints;
    }

    /**
     * 
     * @param rewardPoints
     *     The reward_points
     */
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    /**
     * 
     * @return
     *     The txnExist
     */
    public String getTxnExist() {
        return txnExist;
    }

    /**
     * 
     * @param txnExist
     *     The txn_exist
     */
    public void setTxnExist(String txnExist) {
        this.txnExist = txnExist;
    }

}
