/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferFund;

/**
 *
 * @author Espi
 */
public class ValidatingFundTransfer {
    static public String staticPasswordStatus;
    static public String staticAmountStatus;
    static public String staticBalanceStatus;
    static public double staticNewBalanceStatus;
    
    public ValidatingFundTransfer()
    {}
    
    public void validateAmount(double amount,double balance)
    {
        if(staticPasswordStatus.compareTo("Valid")==0)
        {
            if(amount>0)
            {
                if(amount>balance)
                {
                    staticAmountStatus="InSufficientFunds";
                }
                else
                {
                    staticAmountStatus="SufficientFunds";
                }
            }
            else
            {
                staticAmountStatus="IllegalValue";
            }
        }
    }
    public void validatePassword(String trnPassword)
    {
        if(trnPassword.compareTo("trn0001")==0)
        {
            staticPasswordStatus="Valid";
        }
        else
        {
            staticPasswordStatus="Invalid";
        }
    }
    
    public void updateBalance(double amount,double balance)
    {
        if(staticPasswordStatus.compareTo("Valid")==0 && staticAmountStatus.compareTo("SufficientFunds")==0)
        {
            staticNewBalanceStatus = balance - amount;
        }
    }
}
