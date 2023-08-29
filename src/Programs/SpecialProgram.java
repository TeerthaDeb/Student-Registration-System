/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/

/**
 * The `SpecialProgram` class is a subclass of the `Program` class and represents a special program
 * with a duration, credit cost, and specific courses.
 */


package Programs;
import Exceptions.InvalidName;

public class SpecialProgram extends Program {
	private int duration;
	private static int creditCost = 500;

	// The code is the default constructor for the `SpecialProgram`
	// class. It initializes the `duration` variable to 0 when a new
	// `SpecialProgram` object is created
	// without any arguments.
	public SpecialProgram() {
		duration = 0;
	}

	/**
	 * Peremeterized Constructor
	 * 
	 * The code is defining a constructor for the `SpecialProgram` class that takes
	 * several parameters:
	 * `duration`, `name`, `specialization`, `institution`, `RequiredCourseList`,
	 * and
	 * `ElectiveCourseList`.
	 * 
	 * @param duration           [int] : The durantion of the course in Month
	 * @param name               [string] : Name of the program
	 * @param specialization     [string] : specialization for the program
	 * @param institution        [string] : name of the institute
	 * @param RequiredCourseList [Course[]] : Required Courses for the program
	 * @param ElectiveCourseList [Course[]] : Elective Courses for the program
	 * @throws InvalidName
	 */
	public SpecialProgram(int duration, String name, String specialization, String institution,
			Course[] RequiredCourseList, Course[] ElectiveCourseList) throws InvalidName {
		super(name, specialization, institution, RequiredCourseList, ElectiveCourseList);
		setDuration(duration);
		setCreditCost(creditCost);
	}

	/**
	 * Copy Constructor
	 * 
	 * @param other[SpecialProgram] : the SpecialProgram to be copied
	 */
	public SpecialProgram(SpecialProgram other) {
		if (other != null) {
			setDuration(other.duration);
			this.name = other.name;
			this.specialization = other.specialization;
			this.institution = other.institution;
			setRequiredCourses(other.getRequiredCourses());
			setElectiveCourses(other.getElectiveCourses());
		}
	}

	/**
	 * Create Copy
	 * The function creates a copy of a SpecialProgram object.
	 * 
	 * @return The method is returning a new instance of the SpecialProgram class.
	 */
	public SpecialProgram createCopy() throws InvalidName {
		return new SpecialProgram(getDuration(), getProgramName(), getSpecialization(), getInstitution(),
				getRequiredCourses(), getElectiveCourses());
	}

	@Override
	// The `equals` method is overriding the default `equals` method of the `Object`
	// class. It is used to
	// compare two `SpecialProgram` objects for equality.
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		SpecialProgram obj1 = new SpecialProgram((SpecialProgram) obj);
		return (super.equals(obj1) && obj1.getDuration() == this.getDuration());
	}

	// Setters:
	/**
	 * The function sets the duration of an object.
	 * 
	 * @param duration The "duration" parameter is an integer that represents the
	 *                 duration of something,
	 *                 such as the length of a song or the duration of a video.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * The function sets the credit cost for a special program.
	 * 
	 * @param creditCost The credit cost is an integer value that represents the
	 *                   cost of a special program
	 *                   in terms of credits.
	 */
	public static void setCreditCost(int creditCost) {
		SpecialProgram.creditCost = creditCost;
	}

	// Getters:
	/**
	 * The function "getDuration" returns the value of the "duration" variable.
	 * 
	 * @return The method is returning the value of the variable "duration".
	 */
	public int getDuration() {
		return this.duration;
	}

	/**
	 * The function returns the credit cost of a special program.
	 * 
	 * @return The method is returning the value of the static variable "creditCost"
	 *         from the class
	 *         "SpecialProgram".
	 */
	public static int getCreditCost() {
		return SpecialProgram.creditCost;
	}

	/**
	 * The function calculates the total credit cost by multiplying the credit cost
	 * of a special program
	 * by the total number of credits.
	 * 
	 * @return The method is returning the total credit cost, which is calculated by
	 *         multiplying the
	 *         credit cost per credit (SpecialProgram.creditCost) by the total
	 *         number of credits
	 *         (this.getTotalCredits()).
	 */
	public int get_total_CreditCost() {
		System.out.println("");
		return SpecialProgram.creditCost * this.getTotalCredits();
	}

	// The `toString()` method is overriding the default `toString()` method of the
	// `Object` class. It is
	// used to convert the `SpecialProgram` object into a string representation.
	@Override
	public String toString() {
		String str = "";
		str += "\nPROGRAM NAME : " + this.getProgramName();
		str += "\nSPECIALIZATION : " + this.getSpecialization();
		str += "\nINSTITUTION : " + this.getInstitution() + "\n";
		str += "\nThe Duration is : " + this.getDuration() + "Year(s)." + ".\nThe Total Cost of the course: "
				+ this.get_total_CreditCost() + ".";
		str += this.get_courses();
		return str;
	}
}
