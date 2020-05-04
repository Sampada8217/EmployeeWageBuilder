import java.util.*;
public class empWageBuilderObject{
   public static final int IS_FULL_TIME=1;
   public static final int IS_PART_TIME=2;
     
    private final String Company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHoursPerMonth;
   
    public empWageBuilderObject(String  Company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth )
    {
	this.Company=Company;
	this.empRatePerHour=empRatePerHour;
	this.numOfWorkingDays=numOfWorkingDays;
	this.maxHoursPerMonth=maxHoursPerMonth;
    }

   public static void main(String[] args){
       empWageBuilderObject dMart=new empWageBuilderObject("DMArt" , 20, 2, 10);
       	
       int totalEmpHrs=0,totalEmpWage=0,totalWorkingDays=0;
	while(totalEmpHrs <= dMart.maxHoursPerMonth && totalWorkingDays <= dMart.numOfWorkingDays){
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

   	}totalEmpHrs+=empHrs;
	System.out.println("Day#: "+totalWorkingDays+ "empHrs"+empHrs);
	
	}
	totalEmpWage=totalEmpHrs * dMart.empRatePerHour;
	System.out.println("Total emp Wage"+totalEmpWage);
}

}
