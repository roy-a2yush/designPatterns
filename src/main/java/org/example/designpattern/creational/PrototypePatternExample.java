package org.example.designpattern.creational;

public class PrototypePatternExample {
}

interface Prototype {

    public Prototype getClone();

}

class EmployeeRecord implements Prototype{

    private int id;
    private String name, designation;
    private double salary;
    private String address;

    public EmployeeRecord(){
        System.out.println("   Employee Records of Oracle Corporation ");
        System.out.println("---------------------------------------------");
        System.out.println("Eid"+"\t"+"Ename"+"\t"+"Edesignation"+"\t"+"Esalary"+"\t\t"+"Eaddress");

    }

    public  EmployeeRecord(int id, String name, String designation, double salary, String address) {

        this();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord(){

        System.out.println(id+"\t"+name+"\t"+designation+"\t"+salary+"\t"+address);
    }

    @Override
    public Prototype getClone() {

        return new EmployeeRecord(id,name,designation,salary,address);
    }
}


class PrototypeDemo{
    public static void main(String[] args) {

        int eid=1;

        String ename="SpaceDoctor";

        String edesignation="Doctor";

        String eaddress="Saggatarius A*";

        double esalary= 1000.0d;

        EmployeeRecord e1=new EmployeeRecord(eid,ename,edesignation,esalary,eaddress);

        e1.showRecord();
        System.out.println("\n");
        EmployeeRecord e2=(EmployeeRecord) e1.getClone();
        e2.showRecord();
    }
}