/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/

/**
 * The `CertificateProgram` class is a subclass of the `Program` class that represents a certificate
 * program with a capacity and credit cost.
 */

package Programs;

import Exceptions.DifferentClassException;
import Exceptions.InvalidName;

public class CertificateProgram extends Program{
	
	private int capacity; 
	private static int creditCost;
	
	
	/** Default Constructor:
	* The code is a default constructor for the `CertificateProgram` class.
	* It initializes the `capacity` variable to 0 when a new
	* `CertificateProgram` object is created without any parameters.
	*/
	public CertificateProgram()
	{
		capacity = 0;
	}


	/** Parameterized Constructor:
	 * This is the Parameterized Constructor for CertificateProgram Class
	 * @param capacity [int] : the capacity of the course
	 * @param name [string] : Name of the program
	 * @param specialization [string] : specialization for the program
	 * @param institution [string] : name of the institute
	 * @param RequiredCourseList [Course[]] : Required Courses for the program
	 * @param ElectiveCourseList [Course[]] : Elective Courses for the program
	 */
	public CertificateProgram(int capacity , String name, String specialization, String institution , Course[] RequiredCourseList , Course[] ElectiveCourseList) throws InvalidName
	{
		super(name , specialization , institution , RequiredCourseList , ElectiveCourseList);
		setCapacity(capacity);
	}

	/** Copy Constructor
	 * This is a copy constructor for the `CertificateProgram` class.
	 * 
	 * @param right [Object] : Expected a Certicate program. 
	 * @throws DifferentClassException if Object is not a Certificate Program
	 */
	public CertificateProgram(Object right) throws DifferentClassException , InvalidName
	{
		if(right.getClass() != this.getClass()){
			throw new DifferentClassException("Trying to compare a different class with a Certificate Program.");
		}
		if (right != null){
			CertificateProgram other = (CertificateProgram) right;
			setCapacity(other.capacity);
			setName(other.getProgramName());
			setSpecialization(other.getSpecialization());
			setInstitution(other.getInstitution());
			setRequiredCourses(other.getRequiredCourses());
			setElectiveCourses(other.getElectiveCourses());
		}
	}

	/** Copy Constructor (Overloaded)
	 * This is a copy constructor for the `CertificateProgram` class.
	 * 
	 * @param right [Object] : Expected a Certicate program. 
	 */
	public CertificateProgram(final CertificateProgram right)
	{
		if (right != null){
			setCapacity(right.capacity);
			this.name = right.name;
			this.specialization = right.specialization;
			this.institution = right.institution;
			setRequiredCourses(right.getRequiredCourses());
			setElectiveCourses(right.getElectiveCourses());
		}
	}

	/**
	 * The function creates a copy of a CertificateProgram object by manually copying its attributes.
	 * 
	 * @return The method is returning a copy of the CertificateProgram object.
	 */
	@Override
	public CertificateProgram createCopy() throws InvalidName
	{
		return new CertificateProgram(this.getCapacity() , this.getProgramName() , this.getSpecialization() , this.getInstitution() , this.getRequiredCourses() , this.getElectiveCourses());
	}


	@Override
	// The `equals()` method in the `CertificateProgram` class is used to compare two `CertificateProgram` objects for equality.
	public boolean equals(Object obj)
	{
		// This code is checking if the `obj` is `null` or if the class of `obj` is different from the class
		// of the current object (`this`). If either of these conditions is true, it means that the objects
		// are not equal and the method returns `false`. This is a common implementation of the `equals()`
		// method to handle cases where the object being compared is `null` or of a different class.
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		// In the code snippet provided, `CertificateProgram obj1 = new
		// CertificateProgram((CertificateProgram) obj);` creates a new `CertificateProgram` object `obj1` by
		// casting the `obj` parameter to a `CertificateProgram` object. This is done to ensure that the
		// `obj` parameter is of the same class as the current object (`this`).
		CertificateProgram obj1 = new CertificateProgram((CertificateProgram) obj);
		return (super.equals(obj1) && obj1.getCapacity() == this.getCapacity());
	}

	//Setters:
	/**
	 * The function sets the capacity of an object.
	 * 
	 * @param capacity [int] The capacity parameter is an integer value that represents the maximum number of
	 * elements that can be stored in a data structure or container.
	 */
	public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

	/**
	 * The function sets the credit cost for a certificate program.
	 * 
	 * @param creditCost [int] The creditCost parameter is an integer value representing the cost of a credit
	 * for a certificate program.
	 */
	public static void setCreditCost(int creditCost) {
        CertificateProgram.creditCost = creditCost;
	}

	//Getters:
	/**
	 * The function returns the capacity of an object.
	 * 
	 * @return [string] The capacity of the object.
	 */
	public int getCapacity(){
		return this.capacity;
	}

	/**
	 * The function returns the credit cost of a certificate program.
	 * 
	 * @return [string] The method is returning the value of the static variable "creditCost" from the class
	 * "CertificateProgram".
	 */
	public static int getCreditCost(){
		return CertificateProgram.creditCost;
	}

	/**
	 * The function calculates the total credit cost of a certificate program by multiplying the credit
	 * cost per credit by the total number of credits.
	 * 
	 * @return [string] The method is returning the total credit cost, which is calculated by multiplying the
	 * credit cost per course (CertificateProgram.creditCost) by the total number of credits
	 * (this.getTotalCredits()).
	 */
	public int get_total_CreditCost() {
		return CertificateProgram.creditCost * this.getTotalCredits();
    }

	
	@Override
	// The `toString()` method in the `CertificateProgram` class is used to convert the object into a string representation.
	// The `toString()` method in the `CertificateProgram` class is used to convert the object into a
	// string representation.
	public String toString() {
		String str="";
		str += "\nPROGRAM NAME : " + this.getProgramName();
		str += "\nSPECIALIZATION : " + this.getSpecialization();
		str += "\nINSTITUTION : " + this.getInstitution() +"\n";
		str += "\nThe Capacity is : " + this.getCapacity() + ".\nThe Total Cost of the course: " +  this.get_total_CreditCost() + ".";
		str += this.get_courses();
		return  str;
	}
}
