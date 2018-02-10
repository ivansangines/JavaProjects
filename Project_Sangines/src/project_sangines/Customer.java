
package project_sangines;


public class Customer {
    private String name;
    private int arrivalTime, serviceTime;
    
    public Customer(){
        this.name="";
        this.arrivalTime= -1;
        this.serviceTime= -1;
        
    }
    
    public Customer (String n, int a, int s){
        this.name=n;
        this.arrivalTime=a;
        this.serviceTime=s;
    }
    
    public String getName(){
        return name;
    }
    
    public int getArrivalTime(){
        return arrivalTime;
    }
    
    public int getServiceTime(){
        return serviceTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    
    
    
}
