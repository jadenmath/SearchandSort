//*****************************************************************
//  Student.java (Search and Sort Project) Created by: Jaden Mathew
// This class defines a Student object with two properties, firstName and lastName, and three methods, a constructor, compareTo, and toString. The constructor takes two String parameters, firstName and lastName, and assigns them to the Student object instance. The getter and setter methods provide access to the firstName and lastName properties. The compareTo method takes a Student object and an int option parameter. If option is 0, the method compares the two Student object's firstName properties. If option is not 0, the method compares the two Student object's lastName properties. If the parameter is less than 0, the method returns -1. If the parameter is greater than 0, the method returns 1. If the parameter is equal to 0, the method returns 0. The toString method returns the firstName and lastName properties as a single String.
//  
//*****************************************************************
public class Student {
  private String firstName;
  private String lastName;

  // Constructor: takes two parameters, firstName and lastName as type String.
  // Assigns the parameters to the respective fields.
  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Getters and Setters
  // getFirstName(): returns the String value of the field firstName.
  public String getFirstName() {
    return firstName;
  }

  // setFirstName(): takes one parameter, firstName as type String. Assigns this
  // parameter to the field firstName.
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  // getLastName(): returns the String value of the field lastName.
  public String getLastName() {
    return lastName;
  }

  // setLastName(): takes one parameter, lastName as type String. Assigns this
  // parameter to the field lastName.
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  // CompareTo method: takes two parameters, option as type int and other as type
  // Student. Compares the two objects based on the value of option. If option is
  // 0, then the objects are compared by their first names, if option is 1 then
  // the objects are compared by their last names.
  public int compareTo(int option, Student other) {
    if (option == 0) {
      // Compare first names
      if (this.firstName.compareTo(other.firstName) < 0) {
        return -1;
      } else if (this.firstName.compareTo(other.firstName) > 0) {
        return 1;
      } else {
        return 0;
      }
    } else {
      // Compare last names
      if (this.lastName.compareTo(other.lastName) < 0) {
        return -1;
      } else if (this.lastName.compareTo(other.lastName) > 0) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  // ToString method: returns a String representation of the object, consisting of
  // the first and last name separated by a space.
  public String toString() {
    return firstName + " " + lastName;
  }
}