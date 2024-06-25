package org.example.designpattern.creational;

public class FactoryMethodExample {

}

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class  DomesticPlan extends Plan{
    //@override
    public void getRate(){
        rate=3.50;
    }
}

class  CommercialPlan extends Plan {
    //@override
    public void getRate() {
        rate = 7.50;
    }
}


class  InstitutionalPlan extends Plan {
    //@override
    public void getRate() {
        rate = 5.50;
    }
}

class GetPlanFactory{

    //use getPlan method to get object of type Plan
    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        }
        else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

class GenerateBill{
    public static void main(String args[]) {
        GetPlanFactory planFactory = new GetPlanFactory();

        String planName="DomesticPlan";
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units=5;

        Plan p = planFactory.getPlan(planName);

        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
        p.calculateBill(units);
    }
}