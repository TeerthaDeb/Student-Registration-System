/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/


/**
 * The `GraduateProgram` class is a subclass of the `Program` class and represents a graduate program
 * with a coordinator, credit cost, and various methods for managing and manipulating program information.
 */

package Programs;
import Exceptions.InvalidName;


public class GraduateProgram extends Program {
	private String coordinator;
	static int creditCost;

	/**
	 * Default Constructor
	 * 
	 * Default Constructor setting coordinator = null
	 */
	public GraduateProgram() {
		coordinator = null;
	}

	/**
	 * Parameterized Constructor:
	 * 
	 * The code snippet is a parameterized constructor for the `GraduateProgram`
	 * class. It takes in
	 * several parameters: `coordinator`, `name`, `specialization`, `institution`,
	 * `RequiredCourseList`,
	 * and `ElectiveCourseList`.
	 * 
	 * @param coordinator        [string] 	: Name of the coordinator
	 * @param name               [string] 	: Name of the program
	 * @param specialization     [string] 	: specialization for the program
	 * @param institution        [string] 	: name of the institute
	 * @param RequiredCourseList [Course[]] : Required Courses for the program
	 * @param ElectiveCourseList [Course[]] : Elective Courses for the program
	 * @throws InvalidName
	 */
	public GraduateProgram(String coordinator, String name, String specialization, String institution,
			Course[] RequiredCourseList, Course[] ElectiveCourseList) throws InvalidName {
		super(name, specialization, institution, RequiredCourseList, ElectiveCourseList);
		setCoordinator(coordinator);
		setCreditCost(creditCost);
	}

	/**
	 * Copy Constructor
	 * 
	 * The code snippet is a copy constructor for the `GraduateProgram` class. It
	 * creates a new instance
	 * of the `GraduateProgram` class by copying the attributes of another
	 * `GraduateProgram` (other)
	 * 
	 * @param other [GraduateProgram] : the object to be copied
	 */
	public GraduateProgram(final GraduateProgram other) {
		if (other != null) {
			setCoordinator(other.coordinator);
			this.name = other.name;
			this.specialization = other.specialization;
			this.institution = other.institution;
			setRequiredCourses(other.getRequiredCourses());
			setElectiveCourses(other.getElectiveCourses());
		}
	}

	/**
	 * CreateCopy
	 * 
	 * The `createCopy()` method in the `GraduateProgram` class is used to create a
	 * copy of an existing
	 * `GraduateProgram` object.
	 * 
	 * @return [GraduateProgram] : A deep copy of the object
	 * @throws InvalidName
	 */
	@Override
	public GraduateProgram createCopy() throws InvalidName {
		return new GraduateProgram(getCoordinator(), getProgramName(), getSpecialization(), getInstitution(),
				getRequiredCourses(), getElectiveCourses());
	}

	/**
	 * Equals Method
	 * 
	 * The `equals` method in the `GraduateProgram` class is used to compare two
	 * `GraduateProgram` objects
	 * for equality
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		GraduateProgram obj1 = new GraduateProgram((GraduateProgram) obj);
		return (super.equals(obj1) && obj1.getCoordinator() == this.getCoordinator());
	}

	// Setters:
	/**
	 * The function sets the value of the "coordinator" variable.
	 * 
	 * @param coordinator The coordinator parameter is a String that represents the
	 *                    name or identifier of
	 *                    the coordinator.
	 */
	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}

	/**
	 * The function sets the credit cost for a graduate program.
	 * 
	 * @param creditCost The credit cost is an integer value that represents the
	 *                   cost of each credit for a
	 *                   graduate program.
	 */
	public static void setCreditCost(int creditCost) {
		GraduateProgram.creditCost = creditCost;
	}

	// Getters:
	/**
	 * The function returns the value of the "coordinator" variable.
	 * 
	 * @return The coordinator variable is being returned as a String.
	 */
	public String getCoordinator() {
		return this.coordinator;
	}

	/**
	 * The function calculates the total credit cost of a graduate program by
	 * multiplying the credit cost
	 * per credit hour with the total number of credits.
	 * 
	 * @return The method is returning the total credit cost of a graduate program,
	 *         which is calculated by
	 *         multiplying the credit cost per credit hour by the total number of
	 *         credits.
	 */
	public int get_total_CreditCost() {
		return GraduateProgram.creditCost * this.getTotalCredits();
	}

	/**
	 * The function returns the credit cost of a graduate program.
	 * 
	 * @return The method is returning the value of the static variable "creditCost"
	 *         from the
	 *         "GraduateProgram" class.
	 */
	public static int getCreditCost() {
		return GraduateProgram.creditCost;
	}

	
	// The `toString()` method in the `GraduateProgram` class is used to convert the
	// object into a string representation.
	@Override
	public String toString() {
		String str = "";
		str += "\nPROGRAM NAME : " + this.getProgramName();
		str += "\nSPECIALIZATION : " + this.getSpecialization();
		str += "\nINSTITUTION : " + this.getInstitution() + "\n";
		str += "\nThe Coordinator is : " + this.getCoordinator() 
				+ ".\nThe Total Cost of the course: "
				+ this.get_total_CreditCost() + ".";
		str += this.get_courses();
		return str;
	}
}
