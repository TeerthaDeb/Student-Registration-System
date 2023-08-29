/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/

/**
 * The `Course` class represents a course with a name and number of credits, and provides methods for
 * setting and getting these attributes, as well as checking for equality and generating a string
 * representation of the course.
 */

package Programs;

import Exceptions.InvalidName;

public class Course {
	private String name;
	private int credits;
	
	
	//Constructors:
	
	/** Default constructor */
	// The method is a default constructor for the `Course` class
	// It initializes the `name` variable to `null` and the `credits` variable to `0`. This means
	// that when a new `Course` object is created using this constructor, it will have no name and no
	// credits assigned to it.
	public Course(){
		name = null;
		credits = 0;
	}
	
	/** Parameterized Constructor with all attributes provided as arguments. 
	 * The `public Course (String name , int credit)` constructor is a parameterized constructor for the
	 * `Course` class. It takes two arguments, `name` and `credit`, which are used to initialize the
	 * `name` and `credits` variables of the `Course` object.
	 * @param name [String] : Name of the course
	 * @param credit [int] : credit of course
	 * 
	 * @throws InvalidName
	 */
	public Course (String name , int credit) throws InvalidName
	{
		setName(name);
		setCredit(credit);
	}
	
	/** Copy Constructor
	 * 
	 * It takes another `Course` object `other` as an argument and creates a new `Course` object with the
	 * same `name` and `credits` values as the `other` object.
	 * @param other [Course] Another course to be copied
	 * 
	 */
	public Course(final Course other)
	{
		this.name = other.name;
		this.credits = other.credits;
	}



	
	
	/** Equals Method 
	 * 
	 * The `equals` method is used to compare two `Course` objects for equality.
	 * @return true if they are equal , false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		Course obj1 = new Course((Course) obj);
		return(obj1.name.equalsIgnoreCase(this.name) && obj1.getCredit() == this.getCredit());
	}

	//Setters:
	/**
	 * The function sets the name of a course, but throws an exception if the name is null or invalid.
	 * 
	 * @param name The name parameter is a String that represents the name of the course.
	 * @throws InvalidName
	 */
	public void setName(String name) throws InvalidName
	{
		if(name == null && !InvalidName.checkNameValidity(name))
		{
			throw new InvalidName("Can not set Invalid name for the course");
		}
		else{
			try {
				this.name = name;
			} catch (Exception e) {
				System.out.println("Fatal Error Setting Name for course. Illegal name passed.");
			}
		}
	}

	/**
	 * The function sets the credit length of a course, but if the input is 0 or negative, it prints an
	 * error message and does not set the credit length.
	 * 
	 * @param credit The parameter "credit" is an integer that represents the length or number of credits
	 * for a course.
	 */
	public void setCredit(int credit){
		if(credit <= 0){
			System.out.println("Credit length could not assigned as it was 0 or less than 0");
			return;
		}
		else{
			try {
				this.credits= credit ;
			}
			catch (Exception e){
				System.out.println ("Error setting credits of a course");
			}
		}
	}

	//Getters:
	/**
	 * The function returns the name of an object.
	 * 
	 * @return The method is returning the value of the variable "name".
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * The function returns the value of the "credits" variable.
	 * 
	 * @return The method is returning the value of the variable "credits".
	 */
	public int getCredit(){
		return this.credits;
	}

	/**  toString:
	 * The toString() function returns a string representation of a course object, including the name and
	 * number of credits.
	 * 
	 * @return If the name and credits variables have values, the method will return a string in the
	 * format "name, a credits unit course." If either name or credits is null or 0, the method will
	 * return an empty string.
	 */
	public String toString(){
		if(name != null && credits != 0){
			return (name + ", a " + credits + " unit course.");
		}
		else{
			return ""; //If there are no values to display, return empty string
		}
	}

}