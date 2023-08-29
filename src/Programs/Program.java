/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/

/**
 * The Program class is an abstract class that represents a program with a name, specialization,
 * institution, and a list of required and elective courses.
 */

package Programs;
import Exceptions.InvalidName;

public abstract class Program {
	protected String name , specialization , institution;
	private Course[] requiredCourses , electiveCourses;
	private int required_courses_assigned , elective_courses_assigned;
	
	//Constructors:
	
	/** Default Constructors:
	 * The `public Program()` constructor is the default constructor for the `Program` class. It
	 * initializes the instance variables `name`, `specialization`, and `institution` to `null`. It also
	 * creates two arrays, `requiredCourses` and `electiveCourses`, with sizes of 60 and 20 respectively.
	 * Finally, it sets the variables `required_courses_assigned` and `elective_courses_assigned` to 0.
	 * This constructor is used to create a new `Program` object with default values. 
	 */
	public Program(){
		name = specialization = institution = null;
		requiredCourses  = new Course[60];
		electiveCourses   = new Course[20];
		required_courses_assigned = elective_courses_assigned = 0;
		//There could be a maximum of 60 required courses and 20 elective courses for any program.
	}
	
	/** Parameterized Constructor with all the details provided by user:
	 * 
	 * @param name [String] : Name of the program
	 * @param specialization [String] : What specialization 
	 * @param institution [String] : Name of the institute
	 * @param RequiredCourseList [Course[]] : Required courses
	 * @param ElectiveCourseList [Course[]] : elective courses
	 * 
	 * @throws InvalidName
	 */
	
	public Program(String name, String specialization, String institution , Course[] RequiredCourseList , Course[] ElectiveCourseList) throws InvalidName
	{
		this(); // Calling the default constructor so that the required courses and elective courses arrays are sized to 60 and 20 respectively.
		setName(name);
		setSpecialization(specialization);
		setInstitution(institution);
		setRequiredCourses(RequiredCourseList);
		setElectiveCourses(ElectiveCourseList);
	}
	
	
	/**  Copy Constructor
	 * 
	 * @param other [Program] : Another program to be copied
	 */
	public Program(final Program other){
		this.name = other.name;
		this.specialization = other.specialization;
		this.institution = other.institution;
		setRequiredCourses(other.getRequiredCourses());
		setElectiveCourses(other.getElectiveCourses());
	}

	//Equals:
	@Override
	/** Equals method for comparing two courses.
	 * The code is implementing the `equals` method for a `Program` class in Java. The `equals`
	 * method is used to compare two objects of the `Program` class for equality.
	 */
	public boolean equals(Object obj) {
		// The code is checking if the current object (`this`) is the (eg. in the same memory address)
		// same as the object being compared (`obj`). If they are the same object, it means they are equal,
		// so the method returns `true`. This is a common optimization technique to quickly check if two
		// objects are the same instance in memory.
		if (this == obj) {
			return true;
		}
		// This code block is checking if the object being compared (`obj`) is null or if it is not an
		// instance of the same class as the current object (`this`). If either of these conditions is true,
		// it means that the objects are not equal, so the method returns `false`. This is a common check to
		// ensure that the objects being compared are of the same type before performing any further
		// comparisons.
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		//if other is the instance of program class , let's convert it to Program class and then compare the rest
		Program other = (Program) obj;
		// This code block is checking if the current `Program` object (`this`) is equal to another `Program`
		// object (`other`). It compares the values of the `name`, `specialization`, `institution`,
		// `elective_courses_assigned`, and `required_courses_assigned` variables of both objects. If any of
		// these values are not equal, it means that the objects are not equal, so the method returns `false`.
		if(	!this.getProgramName().equals(other.getProgramName())
			|| !this.getSpecialization().equals(other.getSpecialization())
			|| !this.getInstitution().equals(other.getInstitution())
			|| this.elective_courses_assigned != other.elective_courses_assigned
			|| this.required_courses_assigned != other.required_courses_assigned){
			
				return false;
		}

		boolean found;

		// Check the elective courses
		// The code block is checking if the elective courses of the current `Program` object are equal to
		// the elective courses of another `Program` object. Searching using 'Buble sort' algorithms
		for (int i = 0; i < elective_courses_assigned; i++) {
			found = false;
			for (int j = 0; j < other.elective_courses_assigned; j++) {
				if (electiveCourses[i].equals(other.electiveCourses[j])) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}

		// Check the required courses
		// The code block is checking if the required courses of the current `Program` object are equal to
		// the required courses of another `Program` object. Searching using 'Buble sort' algorithms
		for (int i = 0; i < required_courses_assigned; i++) {
			found = false;
			for (int j = 0; j < other.required_courses_assigned; j++) {
				if (requiredCourses[i].equals(other.requiredCourses[j])) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		//If everything is matched , they are equal. return true;
		return true;
	} // end of equals method

	//setters:

	/**
	 * The function sets the name of a program class, but throws an exception if the name is null or does
	 * not pass a validity check.
	 * 
	 * @param name The name parameter is a String that represents the name to be set for the program class.
	 * @throws InvalidName
	 */
	public void setName (String name) throws InvalidName
	{
		if(name == null || !InvalidName.checkNameValidity(name)){
			throw new InvalidName("Can not set Invalid name for program class");
		}
		else{
			try {
				this.name = name;
			} catch (Exception e) {
				System.out.println("Fatal Error Setting Name for Program. Illegal name passed.");
			}
		}
	}
	
	/**
	 * The function sets the specialization of an object, but throws an exception if the specialization is
	 * null or invalid.
	 * 
	 * @param specialization The specialization parameter is a String that represents the specialization
	 * of a program.
	 * @throws InvalidName
	 */
	public void setSpecialization(String specialization) throws InvalidName
	{
		if(specialization == null || !InvalidName.checkNameValidity(specialization)){
			throw new InvalidName("Can not set Invalid Specialization");
		}
		else{
			try {
				this.specialization= specialization ;
			} catch (Exception e) {
				System.out.println("Fatal Error Setting Specilazation for Program.");
			}
		}
	}

	/**
	 * The function sets the institution name, but throws an exception if the name is invalid.
	 * 
	 * @param institution The "institution" parameter is a String that represents the name of an
	 * institution.
	 * @throws InvalidName
	 */
	public void setInstitution(String institution) throws InvalidName
	{
		if(institution==null || !InvalidName.checkNameValidity(institution)){
			throw new InvalidName("Can not set Invalid Institution");
		}
		else{
			try {
				this.institution = institution;
			} catch (Exception e) {
				System.out.println("Fatal Error Setting Institution.");
			}
		}
	}

	/**
	 * The function sets the required courses for a student, but checks if the total number of assigned
	 * required courses exceeds a limit before assigning them.
	 * 
	 * @param courseList An array of Course objects that represents the list of courses to be assigned as
	 * required courses.
	 */
	public void setRequiredCourses(Course[] courseList)
	{
		if(courseList.length + required_courses_assigned >= 60 ){
			System.out.println("Can not assign more " + courseList.length +  " required courses to existing " + required_courses_assigned + " courses.");
			return;
		}
		try {
			for (int j = 0; j < courseList.length; j++) {
				insertARequiredCourse(courseList[j]);
			}
		}
		catch (Exception e) {
			System.out.println("Error in assigning course" );
		}		
	}

	/**
	 * The function inserts a required course into an array of courses if it is not already assigned and
	 * there is space available.
	 * 
	 * @param course The parameter "course" is of type Course, which represents a specific course that
	 * needs to be assigned as a required course.
	 */
	public void insertARequiredCourse(Course course){
		if(required_courses_assigned + 1 >= 60 ){
			System.out.println("Can not assign 1 more required courses to existing " + required_courses_assigned + " courses.");
			return;
		}
		if(course != null){
			boolean good_to_assign = true;
			for(int j = 0 ; j < required_courses_assigned ; j++){
				if(course.equals(requiredCourses[j])){
					good_to_assign = false;
					break; //already assigned, skip it and move on with the next one!
				}
			}
			if(good_to_assign){
				requiredCourses[required_courses_assigned++] = course;
			}
		}
	}

	/**
	 * The function sets the elective courses for a student, checking if the number of courses assigned
	 * does not exceed the limit of 20.
	 * 
	 * @param courseList The parameter `courseList` is an array of `Course` objects.
	 */
	public void setElectiveCourses(Course[] courseList) {
		if (courseList.length + elective_courses_assigned >= 20) {
			System.out.println("Cannot assign more than " + 20 + " elective courses.");
			return;
		}
		try {
			for (int j = 0; j < courseList.length; j++) {
				insertAnElectiveCourse(courseList[j]);
			}
		} catch (Exception e) {
			System.out.println("Error in assigning course");
		}
	}
	
	/**
	 * The function inserts an elective course into an array of elective courses, checking if it is
	 * already assigned and if the maximum number of courses has been reached.
	 * 
	 * @param course The parameter "course" is of type Course, which represents an elective course that
	 * needs to be inserted.
	 */
	public void insertAnElectiveCourse(Course course) {
		if (elective_courses_assigned + 1 > 20) {
			System.out.println("Cannot assign more than " + 20 + " elective courses.");
			return;
		}
		if (course != null) {
			boolean good_to_assign = true;
			for (int j = 0; j < elective_courses_assigned; j++) {
				if (course.equals(electiveCourses[j])) {
					good_to_assign = false;
					break; // already assigned, skip it and move on to the next one!
				}
			}
			if (good_to_assign) {
				electiveCourses[elective_courses_assigned++] = course;
			}
		}
	}

	//Getters:
	/**
	 * The function returns the name of the program.
	 * 
	 * @return The method is returning the value of the variable "name".
	 */
	public String getProgramName(){
		return this.name;
	}

	/**
	 * The function returns the specialization of an object.
	 * 
	 * @return The method is returning the value of the "specialization" variable.
	 */
	public String getSpecialization(){
		return this.specialization;
	}

	/**
	 * The function returns the institution.
	 * 
	 * @return The method is returning the value of the variable "institution".
	 */
	public String getInstitution(){
		return institution;
	}

	/**
	 * The function returns an array of required courses by creating new Course objects based on the
	 * requiredCourses array.
	 * 
	 * @return The method is returning an array of Course objects.
	 */
	public Course[] getRequiredCourses(){
		Course[] c = new Course[required_courses_assigned];
		for (int i = 0; i < required_courses_assigned ; i++) {
			c[i] = new Course(requiredCourses[i]);
		}
		return c;
	}

	/**
	 * The function "getElectiveCourses" returns an array of Course objects representing the elective
	 * courses assigned.
	 * 
	 * @return The method is returning an array of Course objects.
	 */
	public Course[] getElectiveCourses(){
		Course[] c = new Course[elective_courses_assigned];
		for (int i = 0; i < elective_courses_assigned ; i++) {
			c[i] = new Course(electiveCourses[i]);
		}
		return c;
	}

	/** toString
	 * The toString() function returns a string representation of a program object, including its name,
	 * specialization, institution, required courses, and elective courses.
	 * 
	 * @return The method is returning a string representation of the program, including the program name,
	 * specialization, institution, required courses, and elective courses.
	 */
	@Override
	public String toString(){
		String str="";
		str += "\nPROGRAM NAME : " + name;
		str += "\nSPECIALIZATION : " + specialization ;
		str += "\nINSTITUTION : " +institution+"\n";
		str += "\n\n" + required_courses_assigned + " REQUIRED COURSES:\n";
		for(int j=0 ; j < required_courses_assigned ; j++){
			str += "\t" + requiredCourses[j].toString() + "\n";
		}
		str += "\n\n" + elective_courses_assigned +" ELECTIVE COURSES:\n";
		for(int j=0 ; j < elective_courses_assigned ; j++){
			str += "\t" + electiveCourses[j].toString() + "\n";
		}
		return  str;
	}

	/**
	 * The function "print_courses" prints the list of required and elective courses.
	 */
	public void print_courses(){
		System.out.print(required_courses_assigned + "REQUIRED COURSES:\n");
		for(int j=0 ; j < required_courses_assigned ; j++){
			System.out.println("\t" + requiredCourses[j].toString());
		}
		System.out.print("\n\n" + elective_courses_assigned + "ELECTIVE COURSES:\n");
		for(int j=0 ; j < elective_courses_assigned ; j++){
			System.out.println("\t" + electiveCourses[j].toString());
		}
	}

	/**
	 * The function "get_courses" returns a string representation of the required and elective courses
	 * assigned.
	 * 
	 * @return The method is returning a string that contains information about the required courses and
	 * elective courses assigned.
	 */
	public String get_courses(){
		String str = "";
		str += "\n\n" + required_courses_assigned + " REQUIRED COURSES:\n";
		for(int j=0 ; j < required_courses_assigned ; j++){
			str += "\t" + requiredCourses[j].toString() + "\n";
		}
		str += "\n\n" + elective_courses_assigned +" ELECTIVE COURSES:\n";
		for(int j=0 ; j < elective_courses_assigned ; j++){
			str += "\t" + electiveCourses[j].toString() + "\n";
		}
		return  str;
	}

	/**
	 * The function getTotalCredits calculates the total number of credits for all assigned elective and
	 * required courses.
	 * 
	 * @return The method is returning the total number of credits for all the elective and required
	 * courses assigned.
	 */
	public int getTotalCredits()
	{
		int result = 0;
		for (int i = 0; i < elective_courses_assigned; i++) {
			if(electiveCourses[i] != null){
				result += electiveCourses[i].getCredit();
			}
			else System.out.println("Elective" + i + " is null");
		}
		for (int i = 0; i < required_courses_assigned; i++) {
			if(requiredCourses[i] != null){
				result += requiredCourses[i].getCredit();
			}
			else System.out.println("Required" + i + " is null");
		}
		return result;
	}
	
	/**
	 * The function creates a copy of a program derived class.
	 * 
	 * @return The method is returning an object of type subclass of "Program".
	 */
	
	public abstract Program createCopy() throws InvalidName;

}