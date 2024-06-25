package org.example.designpattern.creational;

public class AbstractFactoryExample {
}

interface Bank{
    String getBankName();
}

class HDFC implements Bank{
    private final String BNAME;
    public HDFC(){
        BNAME="HDFC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}


class ICICI implements Bank{
    private final String BNAME;
    ICICI(){
        BNAME="ICICI BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}


class SBI implements Bank{
    private final String BNAME;
    public SBI(){
        BNAME="SBI BANK";
    }
    public String getBankName(){
        return BNAME;
    }
}


abstract class Loan{
    protected double rate;
    abstract void setInterestRate(double rate);
    public void calculateLoanPayment(double loanamount, int years)
    {
        /*
              to calculate the monthly loan payment i.e. EMI

              rate=annual interest rate/12*100;
              n=number of monthly installments;
              1year=12 months.
              so, n=years*12;

            */

        double EMI;
        int n;

        n=years*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanamount+" you have borrowed");
    }
}


class HomeLoan extends Loan{
    public void setInterestRate(double r){
        rate=r;
    }
}


class BussinessLoan extends Loan{
    public void setInterestRate(double r){
        rate=r;
    }

}


class EducationLoan extends Loan{
    public void setInterestRate(double r){
        rate=r;
    }
}


abstract class AbstractFactory{
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}


class BankFactory extends AbstractFactory{
    public Bank getBank(String bank){
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("HDFC")){
            return new HDFC();
        } else if(bank.equalsIgnoreCase("ICICI")){
            return new ICICI();
        } else if(bank.equalsIgnoreCase("SBI")){
            return new SBI();
        }
        return null;
    }
    public Loan getLoan(String loan) {
        return null;
    }
}


class LoanFactory extends AbstractFactory{
    public Bank getBank(String bank){
        return null;
    }

    public Loan getLoan(String loan){
        if(loan == null){
            return null;
        }
        if(loan.equalsIgnoreCase("Home")){
            return new HomeLoan();
        } else if(loan.equalsIgnoreCase("Business")){
            return new BussinessLoan();
        } else if(loan.equalsIgnoreCase("Education")){
            return new EducationLoan();
        }
        return null;
    }

}


class FactoryCreator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}


class AbstractFactoryPatternExample {
    public static void main(String args[]) {

        String bankName="ICICI";
        String loanName="Home";
        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
        Bank b=bankFactory.getBank(bankName);

        double rate=5.0d;

        double loanAmount=10000.0d;
        int years=5;

        System.out.println("you are taking the loan from "+ b.getBankName());

        AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
        Loan l=loanFactory.getLoan(loanName);
        l.setInterestRate(rate);
        l.calculateLoanPayment(loanAmount,years);
    }
}