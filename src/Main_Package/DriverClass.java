// --------------------------------------------------------------------------------
// Assignment : 1
// Part : Part 1
// Written by: Bhumika , 40223877 ; Maharaj Teertha Deb , 40227747 ;
// --------------------------------------------------------------------------------

package Main_Package;
import Package_1.*;

public class DriverClass {

	public static void findLeastAndMostExpensiveProgram(Program[] programs) {
		Program leastExpensive = null;
		Program mostExpensive = null;

		for (Program program : programs) {
			if (program instanceof GraduateProgram || program instanceof UndergraduateProgram ||
					program instanceof CertificateProgram || program instanceof SpecialProgram) {
				if (leastExpensive == null || getCreditCost(program) < getCreditCost(leastExpensive)) {
					leastExpensive = program;
				}
				if (mostExpensive == null || getCreditCost(program) > getCreditCost(mostExpensive)) {
					mostExpensive = program;
				}
			}
		}

		if (leastExpensive != null && mostExpensive != null) {
			System.out.println("Least Expensive Program:");
			System.out.println(leastExpensive.toString());
			System.out.println("--------------------------------");
			System.out.println("Most Expensive Program:");
			System.out.println(mostExpensive.toString());
		} else {
			System.out.println("No Program objects found or invalid input array.");
		}
	}

	private static int getCreditCost(Program program) {
		if (program instanceof GraduateProgram) {
			return ((GraduateProgram) program).get_total_CreditCost();
		} else if (program instanceof UndergraduateProgram) {
			return ((UndergraduateProgram) program).get_total_CreditCost();
		} else if (program instanceof CertificateProgram) {
			return ((CertificateProgram) program).get_total_CreditCost();
		} else if (program instanceof SpecialProgram) {
			return ((SpecialProgram) program).get_total_CreditCost();
		}
		return 0;
	}
	

	public static void main(String[] args) {
		//Deriving some courses so that I can assign them to some Programs:

		//Required Courses:
		Course c1 = new Course("SQL" , 3);
		Course c2 = new Course("Java" , 4);
		Course c3 = new Course("C++" , 4);
		Course c4 = new Course("Python" , 4);
		Course c5 = new Course("C#" , 4);
		Course c6 = new Course("JavaScript" , 3);
		Course c7 = new Course("HTML" , 3);
		Course c8 = new Course("CSS" , 3);
		Course c9 = new Course("Ruby" , 3);
		Course c10 = new Course("Kotlin" , 3);

		//Some elective courses:
		Course e1 = new Course("Philosophy" , 3);
		Course e2 = new Course("Economics" , 3);
		Course e3 = new Course("Spanish" , 3);
		Course e4 = new Course("Anthropology" , 3);
		Course e5 = new Course("Music" , 3);
		Course e6 = new Course("Drama" , 3);
		Course e7 = new Course("History" , 3);
		Course e8 = new Course("Dance" , 3);


		//Combinig some courses, so that we can use them for different courses
		//required courses:
		Course[] required_courses_for_graduate_program = new Course[3];
		required_courses_for_graduate_program[0] = c1; // SQL
		required_courses_for_graduate_program[1] = c2; // Java
		required_courses_for_graduate_program[2] = c3; // C++

		Course[] required_courses_for_undergraduate_program = new Course[4];
		required_courses_for_undergraduate_program[0] = c4; //Python
		required_courses_for_undergraduate_program[1] = c5; //C#
		required_courses_for_undergraduate_program[2] = c6; //JavaScript
		required_courses_for_undergraduate_program[3] = c7; //HTML

		//elective Courses:
		Course[] elective_coureses_for_graduate_program = new Course[2];
		elective_coureses_for_graduate_program[0] = e1; //Philosophy
		elective_coureses_for_graduate_program[1] = e2; //Economics

		Course[] elective_coureses_for_undergraduate_program = new Course[2];
		elective_coureses_for_undergraduate_program[0] = e5; //Music
		elective_coureses_for_undergraduate_program[1] = e8; //Dance
		
		//5 Graduate Programs:
		GraduateProgram.setCreditCost(509);
		GraduateProgram g1 = new GraduateProgram("Coordinator 1" , "Graduate Program 1" , "Specialization 1" ,
		 "Insitution 1" , required_courses_for_graduate_program , elective_coureses_for_graduate_program);
		GraduateProgram g2 = new GraduateProgram(g1);
		g2.setName("Graduate Program 2");
		g2.setCoordinator("Coordinator 2");
		g2.setInstitution("Insitution 2");
		g2.insertARequiredCourse(c10); // Kotlin
		
		GraduateProgram g3 = new GraduateProgram(g2);

		GraduateProgram g4 = new GraduateProgram("Coordinator 4" , "Graduate Program 2" ,
		 "Specialization " , "Institution 4" , required_courses_for_graduate_program , elective_coureses_for_graduate_program);
		
		GraduateProgram	g5 = new GraduateProgram(g4);
		g5.insertARequiredCourse(e8);
		g5.insertARequiredCourse(c9);

		
		//5 Undergraduate Programs:
		UndergraduateProgram.setCreditCost(200); // setting the credit cost = 200 for all objects.
		UndergraduateProgram ug_1 = new UndergraduateProgram(true , "UG Course 1" , "Engineering" , 
		 "Institution-UG1" , required_courses_for_undergraduate_program , elective_coureses_for_undergraduate_program);
		UndergraduateProgram ug_2 = new UndergraduateProgram(false , "UG Course 2" , "Science" , 
		 "Instituition-UG2" , required_courses_for_undergraduate_program , elective_coureses_for_undergraduate_program);
		ug_2.insertARequiredCourse(c10); //Kotlin
		ug_2.insertARequiredCourse(c5); //C#
		ug_2.insertAnElectiveCourse(e1);
		UndergraduateProgram ug_3 = new UndergraduateProgram(ug_2);
		ug_3.setAccredited(false);
		ug_3.setAccredited(true);
		UndergraduateProgram ug_4 = new UndergraduateProgram(true, "UG 4" , "UG specialization 4" , 
		"Institute 4" , required_courses_for_graduate_program , required_courses_for_undergraduate_program);
		UndergraduateProgram ug_5 = new UndergraduateProgram(true , "UG 5", "Business",
				"Institution-UG5", required_courses_for_undergraduate_program , elective_coureses_for_graduate_program);
		ug_5.insertARequiredCourse(c7); // Accounting
		ug_5.insertARequiredCourse(c5); // C#
		ug_5.insertAnElectiveCourse(e3); // Spanish



		//5 Certificate Programs:
		//Setiing creditCOst = 100 for all the courses.
		CertificateProgram.setCreditCost(100);
		CertificateProgram cp_1 = new CertificateProgram(200 , "CP-1" , "Specialization-1" ,
		 "institute-2" , elective_coureses_for_graduate_program , required_courses_for_graduate_program);
		cp_1.insertARequiredCourse(e8);
		cp_1.insertAnElectiveCourse(c10);
		CertificateProgram cp_2 = new CertificateProgram(cp_1);
		cp_2.setName("CP-2");
		cp_2.setSpecialization("Specialization - 2");
		cp_2.setInstitution("institute-2");
		CertificateProgram cp_3 = new CertificateProgram(200, "CP-3", "Specialization-3",
			"Institute-3", elective_coureses_for_undergraduate_program , required_courses_for_graduate_program);
		cp_3.insertARequiredCourse(c2); 
		cp_3.insertAnElectiveCourse(e5);
		CertificateProgram cp_4 = new CertificateProgram(cp_3);
		cp_4.setName("CP-4");
		cp_4.setSpecialization("Specialization-4");
		cp_4.setInstitution("Institute-4");
		CertificateProgram cp_5 = new CertificateProgram(300, "CP-5", "Specialization-5",
			"Institute-5", elective_coureses_for_undergraduate_program, required_courses_for_undergraduate_program);
		cp_5.insertARequiredCourse(c8);
		cp_5.insertAnElectiveCourse(e7);



		//5 Special Programs:
		SpecialProgram.setCreditCost(500);
		SpecialProgram sp_1 = new SpecialProgram(2  , "SpecialProgram-1" , "Specialization - 1" , "Institute -1" , required_courses_for_undergraduate_program , required_courses_for_graduate_program);
		SpecialProgram sp_2 = new SpecialProgram(sp_1);
		sp_2.setName("SP-2");
		sp_2.setDuration(1);
		sp_2.setSpecialization("Specialization 2");
		sp_2.insertARequiredCourse(e8);
		sp_2.insertAnElectiveCourse(e1);
		SpecialProgram sp_3 = new SpecialProgram(sp_2);
		sp_3.setName("SP-3");
		sp_3.setDuration(3);
		sp_3.setSpecialization("Specialization-3");
		sp_3.insertARequiredCourse(c9);
		SpecialProgram sp_4 = new SpecialProgram(3, "SP-4", "Specialization-4",
			"Institute-4", required_courses_for_undergraduate_program, required_courses_for_graduate_program);

		sp_4.insertARequiredCourse(c4);
		sp_4.insertAnElectiveCourse(c5);
		SpecialProgram sp_5 = new SpecialProgram(sp_4);
		//So SP_4 and SP_5 are same.



		/////Question 1:

		// Create an array to store the objects
		System.out.println("\n\n");
		Program[] array_of_programs = new Program[10];
		// Insert the created objects into the array

		array_of_programs[0] = g1;
		array_of_programs[1] = g2;
		array_of_programs[2] = g3;
		array_of_programs[3] = cp_3;
		array_of_programs[4] = ug_1;
		array_of_programs[5] = ug_2;
		array_of_programs[6] = cp_3;
		array_of_programs[7] = ug_4;
		array_of_programs[8] = ug_5;
		array_of_programs[9] = sp_1;

		// Display the information using the toString() method
		int i = 1;
		for (Program program : array_of_programs) {
			if (program != null) {
				System.out.print("Program: " + i + " : ");
				System.out.println(program.toString());
				System.out.println("--------------------------------");
				i++;
			}
		}


		System.out.println("\n\n\n");
		//Question 2
		// Objects from different classes
		System.out.println("Are g1 and ug_1 equal? " + g1.equals(ug_1)); // false
		System.out.println("Are cp_1 and sp_1 equal? " + cp_1.equals(sp_1)); // false

		// Objects from the same class with different values
		System.out.println("Are g1 and g2 equal? " + g1.equals(g2)); // false
		System.out.println("Are ug_2 and ug_3 equal? " + ug_2.equals(ug_3)); // false

		// Objects with similar values
		System.out.println("Are g_3 and g_2 equal? " + g3.equals(g2)); // true
		System.out.println("Are sp_4 and sp_5 equal? " + sp_4.equals(sp_5)); // true

		System.out.println("\n\n\n");

		// First array: Mixed objects including at least one object from each class
		Program[] mixedArray1 = new Program[20];
		Program[] mixedArray2 = new Program[15];
		mixedArray1[0] = new GraduateProgram(g1);
		mixedArray1[1] = new GraduateProgram(g2);
		mixedArray1[2] = new GraduateProgram(g3);
		mixedArray1[3] = new GraduateProgram(g4);
		mixedArray1[4] = new UndergraduateProgram(ug_1);
		mixedArray1[5] = new UndergraduateProgram(ug_2);
		mixedArray1[6] = new UndergraduateProgram(ug_3);
		mixedArray1[7] = new UndergraduateProgram(ug_4);
		mixedArray1[8] = new UndergraduateProgram(ug_5);
		mixedArray1[9] = new CertificateProgram(cp_1);
		mixedArray1[10] = new CertificateProgram(cp_2);
		mixedArray1[11] = new CertificateProgram(cp_3);
		mixedArray1[12] = new CertificateProgram(cp_4);
		mixedArray1[13] = new CertificateProgram(cp_5);
		mixedArray1[14] = new SpecialProgram(sp_1);
		mixedArray1[15] = new SpecialProgram(sp_2);
		mixedArray1[16] = new SpecialProgram(sp_3);
		mixedArray1[17] = new SpecialProgram(sp_4);
		mixedArray1[18] = new SpecialProgram(sp_5);
		mixedArray1[19] = new GraduateProgram(g5);

		//Second array excluding Special Program class.
		mixedArray2[0] = new GraduateProgram(g1);
		mixedArray2[1] = new GraduateProgram(g2);
		mixedArray2[2] = new GraduateProgram(g3);
		mixedArray2[3] = new GraduateProgram(g4);
		mixedArray2[4] = new UndergraduateProgram(ug_1);
		mixedArray2[5] = new UndergraduateProgram(ug_2);
		mixedArray2[6] = new UndergraduateProgram(ug_3);
		mixedArray2[7] = new UndergraduateProgram(ug_4);
		mixedArray2[8] = new UndergraduateProgram(ug_5);
		mixedArray2[9] = new CertificateProgram(cp_1);
		mixedArray2[10] = new CertificateProgram(cp_2);
		mixedArray2[11] = new CertificateProgram(cp_3);
		mixedArray2[12] = new CertificateProgram(cp_4);
		mixedArray2[13] = new CertificateProgram(cp_5);
		mixedArray2[14] = new GraduateProgram(g5);
		
		
		findLeastAndMostExpensiveProgram(mixedArray1);
		System.out.println("\n\n\n");
		findLeastAndMostExpensiveProgram(mixedArray2);
		System.out.println("\n");
	}
}
