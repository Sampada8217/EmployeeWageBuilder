import java.util.*;
public class EmpWageBuilderArrayList{ 
    public static final int IS_FULL_TIME=1; 
    public static final int IS_PART_TIME=2;
 
    private int numOfCompany=0;
    private ArrayList<CompanyEmpWage> companyEmpWageArrayList=new ArrayList<CompanyEmpWage>();

    private void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth){  
        CompanyEmpWage companyWage= new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
        companyEmpWageArrayList.add(companyWage);
        numOfCompany++;
    }

    private void computeEmpWage(){
       for(int i=0;i<numOfCompany;i++){
          int totalEmpWage=this.computeEmpWage(companyEmpWageArrayList.get(i));
          System.out.println("Total emp Wage for Company"+companyEmpWageArrayList.get(i).company+ "is"+totalEmpWage);
        }
    }
    public int computeEmpWage(CompanyEmpWage companyEmpWage){
       	
          int totalEmpHrs=0,totalEmpWage=0,totalWorkingDays=0;
	  while(totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays <= companyEmpWage.numOfWorkingDays){
		int empHrs=0;
		totalWorkingDays++;
	        int empCheck = (int)Math.floor( Math.random() * 10 ) % 3;

	        switch(empCheck){
		      case IS_FULL_TIME:
		             empHrs=8;
			      break;
		      case IS_PART_TIME:
			     empHrs=4;
			      break;
		      default:
			     empHrs=0;
			      break;

       	        } 
                totalEmpHrs+=empHrs;
	        System.out.println("Day#: "+totalWorkingDays+ "empHrs"+empHrs);
	
	   }
	   return totalEmpHrs=totalEmpHrs*companyEmpWage.empRatePerHour;
    }

    public static void main(String[] args){

        EmpWageBuilderArrayList empWageArrayList=new EmpWageBuilderArrayList();
        empWageArrayList.addCompanyEmpWage("DMART",20,2,10);
	empWageArrayList.addCompanyEmpWage("Reliance",30,3,20);
	empWageArrayList.addCompanyEmpWage("Big Basket",40,4,30);
	empWageArrayList.computeEmpWage();

    }

    private class CompanyEmpWage{
       public String company;
       public int empRatePerHour;
       public int numOfWorkingDays;
       public int maxHoursPerMonth; 
       public CompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth){  
         this.company=company;
         this.empRatePerHour=empRatePerHour;
         this.numOfWorkingDays=numOfWorkingDays;
         this.maxHoursPerMonth=maxHoursPerMonth;
  

     }
  }
}
