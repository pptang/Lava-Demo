
package com.lava.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FundTransferBody {

    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("destination_account_id")
    @Expose
    private String destinationAccountId;
    @SerializedName("memo")
    @Expose
    private String memo;
    @SerializedName("payee_desc")
    @Expose
    private String payeeDesc;
    @SerializedName("payee_id")
    @Expose
    private String payeeId;
    @SerializedName("payee_type")
    @Expose
    private int payeeType;
    @SerializedName("payment_type")
    @Expose
    private int paymentType;
    @SerializedName("transaction_date")
    @Expose
    private String transactionDate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FundTransferBody() {
    }

    /**
     * 
     * @param amount
     * @param memo
     * @param destinationAccountId
     * @param paymentType
     * @param payeeDesc
     * @param payeeId
     * @param payeeType
     * @param transactionDate
     * @param currency
     */
    public FundTransferBody(int amount, String currency, String destinationAccountId, String memo, String payeeDesc, String payeeId, int payeeType, int paymentType, String transactionDate) {
        this.amount = amount;
        this.currency = currency;
        this.destinationAccountId = destinationAccountId;
        this.memo = memo;
        this.payeeDesc = payeeDesc;
        this.payeeId = payeeId;
        this.payeeType = payeeType;
        this.paymentType = paymentType;
        this.transactionDate = transactionDate;
    }

    /**
     * 
     * @return
     *     The amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The destinationAccountId
     */
    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    /**
     * 
     * @param destinationAccountId
     *     The destination_account_id
     */
    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    /**
     * 
     * @return
     *     The memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 
     * @param memo
     *     The memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 
     * @return
     *     The payeeDesc
     */
    public String getPayeeDesc() {
        return payeeDesc;
    }

    /**
     * 
     * @param payeeDesc
     *     The payee_desc
     */
    public void setPayeeDesc(String payeeDesc) {
        this.payeeDesc = payeeDesc;
    }

    /**
     * 
     * @return
     *     The payeeId
     */
    public String getPayeeId() {
        return payeeId;
    }

    /**
     * 
     * @param payeeId
     *     The payee_id
     */
    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    /**
     * 
     * @return
     *     The payeeType
     */
    public int getPayeeType() {
        return payeeType;
    }

    /**
     * 
     * @param payeeType
     *     The payee_type
     */
    public void setPayeeType(int payeeType) {
        this.payeeType = payeeType;
    }

    /**
     * 
     * @return
     *     The paymentType
     */
    public int getPaymentType() {
        return paymentType;
    }

    /**
     * 
     * @param paymentType
     *     The payment_type
     */
    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 
     * @return
     *     The transactionDate
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * 
     * @param transactionDate
     *     The transaction_date
     */
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

}
