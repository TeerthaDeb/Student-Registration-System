/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/

/**
 * The `UndergraduateProgram` class is a subclass of the `Program` class and represents an
 * undergraduate program with additional attributes and methods.
 */

package Programs;

import Exceptions.InvalidName;

public class UndergraduateProgram extends Program {
	private boolean accredited;
	static int creditCost;
	
	/** Default Constructor
	 * 
	 */
	public UndergraduateProgram(){
		accredited = false;
	}

	
	/** Perameterized Constructor
	 * 
	 * This is a constructor for the `UndergraduateProgram` class. It takes several
	 * parameters including
	 * `accredited`, `name`, `specialization`, `institution`, `RequiredCourseList`,
	 * and `ElectiveCourseList`.
	 * 
	 * @param accredited         [boolean] 	: if the course is accrediated
	 * @param name               [string] 	: Name of the program
	 * @param specialization     [string] 	: specialization for the program
	 * @param institution        [string] 	: name of the institute
	 * @param RequiredCourseList [Course[]] : Required Courses for the program
	 * @param ElectiveCourseList [Course[]] : Elective Courses for the program
	 * @throws InvalidName
	 */
	public UndergraduateProgram(boolean accredited , String name, String specialization, String institution , Course[] RequiredCourseList , Course[] ElectiveCourseList)throws InvalidName
	{
		super(name , specialization , institution , RequiredCourseList , ElectiveCourseList);
		setAccredited(accredited);
	}

	/** Copy Constructor
	 * 
	 * @param other [UndergraduateProgram] : other program to be copied
	 */
	public UndergraduateProgram(final UndergraduateProgram other){
		if (other != null){
			setAccredited(accredited);
			this.name = other.name;
			this.specialization = other.specialization;
			this.institution = other.specialization;
			setRequiredCourses(other.getRequiredCourses());
			setElectiveCourses(other.getElectiveCourses());
		}
	}

	//CreateCopy
	public UndergraduateProgram createCopy() throws InvalidName {
		return new UndergraduateProgram(getAccredited() , getProgramName() , getSpecialization() , getInstitution() , getRequiredCourses() , getElectiveCourses());
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		UndergraduateProgram obj1 = new UndergraduateProgram((UndergraduateProgram) obj);
		return (super.equals(obj1) && obj1.getAccredited() == this.getAccredited());
	}

	//Setters:
	public void setAccredited(boolean accredited) {
        this.accredited = accredited;
    }
	public static void setCreditCost(int creditCost) {
        UndergraduateProgram.creditCost = creditCost;
	}

	//Getters:
	public boolean getAccredited(){
		return this.accredited;
	}

	public static int getCreditCost(){
		return UndergraduateProgram.creditCost;
	}

	public int get_total_CreditCost() {
		return UndergraduateProgram.creditCost * this.getTotalCredits();
    }

	
	@Override
	public String toString() {
		String str="";
		str += "\nPROGRAM NAME : " + this.getProgramName();
		str += "\nSPECIALIZATION : " + this.getSpecialization();
		str += "\nINSTITUTION : " + this.getInstitution();
		str += ".\nThe Total Cost of the course: " +  this.get_total_CreditCost() + ".";
		str += this.get_courses();
		if(this.accredited){
			str += " is a accredited Program.";
		}
		else{
			str += " This program has not been Accredited yet.";
		}
		return  str;
	}
}
