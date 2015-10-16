
package com.lava.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTransactionsResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("activity")
    @Expose
    private String activity;
    @SerializedName("check_image_eligible")
    @Expose
    private String checkImageEligible;
    @SerializedName("date_posted")
    @Expose
    private String datePosted;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("formatted_amount")
    @Expose
    private String formattedAmount;
    @SerializedName("pending_date")
    @Expose
    private String pendingDate;
    @SerializedName("transaction_amount")
    @Expose
    private int transactionAmount;
    @SerializedName("transaction_identifier")
    @Expose
    private String transactionIdentifier;
    @SerializedName("transaction_index")
    @Expose
    private String transactionIndex;
    @SerializedName("transaction_type")
    @Expose
    private String transactionType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetTransactionsResponse() {
    }

    /**
     * 
     * @param id
     * @param transactionType
     * @param transactionAmount
     * @param datePosted
     * @param checkImageEligible
     * @param accountId
     * @param transactionIndex
     * @param transactionIdentifier
     * @param description
     * @param pendingDate
     * @param formattedAmount
     * @param activity
     */
    public GetTransactionsResponse(String id, String accountId, String activity, String checkImageEligible, String datePosted, String description, String formattedAmount, String pendingDate, int transactionAmount, String transactionIdentifier, String transactionIndex, String transactionType) {
        this.id = id;
        this.accountId = accountId;
        this.activity = activity;
        this.checkImageEligible = checkImageEligible;
        this.datePosted = datePosted;
        this.description = description;
        this.formattedAmount = formattedAmount;
        this.pendingDate = pendingDate;
        this.transactionAmount = transactionAmount;
        this.transactionIdentifier = transactionIdentifier;
        this.transactionIndex = transactionIndex;
        this.transactionType = transactionType;
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
     *     The accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 
     * @param accountId
     *     The account_id
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * 
     * @return
     *     The activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * 
     * @param activity
     *     The activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * 
     * @return
     *     The checkImageEligible
     */
    public String getCheckImageEligible() {
        return checkImageEligible;
    }

    /**
     * 
     * @param checkImageEligible
     *     The check_image_eligible
     */
    public void setCheckImageEligible(String checkImageEligible) {
        this.checkImageEligible = checkImageEligible;
    }

    /**
     * 
     * @return
     *     The datePosted
     */
    public String getDatePosted() {
        return datePosted;
    }

    /**
     * 
     * @param datePosted
     *     The date_posted
     */
    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The formattedAmount
     */
    public String getFormattedAmount() {
        return formattedAmount;
    }

    /**
     * 
     * @param formattedAmount
     *     The formatted_amount
     */
    public void setFormattedAmount(String formattedAmount) {
        this.formattedAmount = formattedAmount;
    }

    /**
     * 
     * @return
     *     The pendingDate
     */
    public String getPendingDate() {
        return pendingDate;
    }

    /**
     * 
     * @param pendingDate
     *     The pending_date
     */
    public void setPendingDate(String pendingDate) {
        this.pendingDate = pendingDate;
    }

    /**
     * 
     * @return
     *     The transactionAmount
     */
    public int getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * 
     * @param transactionAmount
     *     The transaction_amount
     */
    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * 
     * @return
     *     The transactionIdentifier
     */
    public String getTransactionIdentifier() {
        return transactionIdentifier;
    }

    /**
     * 
     * @param transactionIdentifier
     *     The transaction_identifier
     */
    public void setTransactionIdentifier(String transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    /**
     * 
     * @return
     *     The transactionIndex
     */
    public String getTransactionIndex() {
        return transactionIndex;
    }

    /**
     * 
     * @param transactionIndex
     *     The transaction_index
     */
    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    /**
     * 
     * @return
     *     The transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * 
     * @param transactionType
     *     The transaction_type
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}
