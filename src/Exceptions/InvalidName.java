/**
 * @author Maharaj Teertha Deb
 * Student Registration System Beta 0.1
 * created by : Maharaj Teertha Deb
 * linked IN : https://www.linkedin.com/in/maharaj-teertha-deb/
 * released on : August-26-2023
*/

/**
 * The `InvalidName` class is a custom exception class in Java that is used to handle invalid names by
 * checking if a given name contains any digits or special characters.
 */
package Exceptions;

public class InvalidName extends Exception {

	/**
	 * Default Constructor
	 * The default constructor is creating an instance of the `InvalidName`
	 * exception class
	 * with a default error message "Can not set Invalid Name: ". This constructor
	 * is called when an
	 * instance of `InvalidName` is created without passing a custom error message.
	 */
	public InvalidName() {
		super("Can not set Invalid Name: ");
	}

	/**
	 * The peremeterized constructor
	 * 
	 * @param message [String] : message
	 */
	public InvalidName(String message) {
		super(message);
	}

	@Override
	/**
	 * The `toString()` method is overriding the `toString()` method of the
	 * `Exception` class. It returns
	 * a string representation of the exception object. In this case, it is calling
	 * the `toString()`
	 * method of the superclass (`Exception`) to get the default string
	 * representation of the exception.
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * The function checks if a given name is valid by ensuring that it does not
	 * contain any digits.
	 * 
	 * @param name[String] The name parameter is a String that represents a person's
	 *                     name.
	 * @return The method is returning a boolean value true if there is no number
	 *         and no special character
	 */
	public static boolean checkNameValidity(String name) {
		for (int i = 0; name.length() < i; i++) {
			// The `if` statement is checking if the character at index `i` in the `name`
			// string is a digit or
			// not. If it is a digit, it returns `false` indicating that the name is
			// invalid.
			if (Character.isDigit(name.charAt(i))
					|| (!Character.isLetter(name.charAt(i)) || (!Character.isWhitespace(name.charAt(i))))) {
				return false;
			}

		}
		return true;
	}
}
