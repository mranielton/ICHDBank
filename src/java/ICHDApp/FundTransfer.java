/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ICHDApp;

/**
 *
 * @author Espi
 */
public class FundTransfer {
    
    private double amount;
    private String transactionPassword;
    private String toAccount;
    
    public FundTransfer()
    {
       
    }

    public FundTransfer(double amount)
    {
         this.amount = amount;
    }
    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the trasactionPassword
     */
    public String getTransactionPassword() {
        return transactionPassword;
    }

    /**
     * @param transactionPassword the transactionPassword to set
     */
    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }

    /**
     * @return the toAccount
     */
    public String getToAccount() {
        return toAccount;
    }

    /**
     * @param toAccount the toAccount to set
     */
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    
}
