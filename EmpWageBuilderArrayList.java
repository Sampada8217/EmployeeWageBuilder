import java.util.*;
public class EmpWageBuilderArrayList{ 
    public static final int IS_FULL_TIME=1; 
    public static final int IS_PART_TIME=2;
 
    private int numOfCompany=0;
    public ArrayList<CompanyEmpWage> companyEmpWageArrayList=new ArrayList<CompanyEmpWage>();
    public Map<String,Integer> totalWage=new HashMap<String,Integer>();

    private void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth){  
        CompanyEmpWage companyWage= new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
        companyEmpWageArrayList.add(companyWage);
        numOfCompany++;
    }

    private void computeEmpWage(){
        for(int i=0;i<numOfCompany;i++){
          int totalEmpWage=this.computeEmpWage(companyEmpWageArrayList.get(i));
          System.out.println("Total Emp Wage for Company"+companyEmpWageArrayList.get(i).company+ "is"+totalEmpWage);
          totalWage.put(companyEmpWageArrayList.get(i).company,totalEmpWage);
        }
    }
   
    private void getCompanyWage(String companyName){
        int totalCompanyWage=(int)totalWage.get(companyName);
        System.out.println("Comany Name:" +companyName+ "totalCompanyWage"+totalCompanyWage);
     }       
    public int computeEmpWage(CompanyEmpWage companyEmpWage){
       	
          int totalEmpHrs=0,totalEmpWage=0,totalWorkingDays=0,dailyWage=0;
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
                dailyWage=companyEmpWage.empRatePerHour*empHrs;
	        System.out.println("Day#: "+totalWorkingDays+ "  empHrs:"+empHrs+ " Daily Wage:"+dailyWage);
		
	 }
	   return totalEmpHrs=totalEmpHrs*companyEmpWage.empRatePerHour;
    }


    public static void main(String[] args){

        EmpWageBuilderArrayList empWageArrayList=new EmpWageBuilderArrayList();
        empWageArrayList.addCompanyEmpWage("DMART",20,2,10);
	empWageArrayList.addCompanyEmpWage("Reliance",30,3,20);
	empWageArrayList.addCompanyEmpWage("Big Basket",40,4,30);
	empWageArrayList.computeEmpWage();
        empWageArrayList.getCompanyWage("DMART");
	empWageArrayList.getCompanyWage("Reliance");
	empWageArrayList.getCompanyWage("Big Basket");

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
