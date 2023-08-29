/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/

/**
 * The `DifferentClassException` class is a custom exception class that is used to handle the scenario
 * when a different class object is passed.
 */

package Exceptions;

public class DifferentClassException extends Exception {
	/**
	 * Defalt Constructor
	 * 
	 * The code is the default constructor for the `DifferentClassException` class.
	 * It passess "Passing a different class object" message to the exception class.
	 */
	public DifferentClassException() {
		super("Passing a different class object");
	}

	/**
	 * Perameterized Constructor
	 * 
	 * The code `public DifferentClassException(String message)` is a perameterized
	 * constructor for the
	 * `DifferentClassException` class that takes a `String` parameter called
	 * `message`.
	 * 
	 * @param message [String] : the message you want to pass to the default
	 *                exception class.
	 */
	public DifferentClassException(String message) {
		super(message);
	}

	@Override
	/**
	 * The toString() function returns a string representation of the object.
	 * 
	 * @return The toString() method is returning a string representation of the
	 *         object. In this case, it
	 *         is calling the toString() method of the superclass (i.e., the parent
	 *         class) and returning the result.
	 */
	public String toString() {
		return super.toString();
	}
}