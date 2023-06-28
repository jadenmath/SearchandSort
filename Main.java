//*****************************************************************
//  Main.java (Search and Sort Project)    Created by: Jaden Mathew
//
//  This code creates two arrays of 20 student objects each, and populates the first array with student names. It then copies the first array into the second array. Both arrays are printed out. Insertion sort is then run on the first array, sorting it by the first name of each student. Selection sort is then run on the second array, sorting it by last name. The user is then asked to search for a student. Linear search and binary search are then run on the first array of students to locate the requested student.
//*****************************************************************
// Import java.util.Scanner is used to allow user input. 
import java.util.Scanner;

// The main method first creates two arrays of 20 student objects each. It then populates the first array with student names. It then copies the first array into the second array. Both arrays are printed out. Insertion sort is then run on the first array, sorting it by the first name of each student. Selection sort is then run on the second array, sorting it by last name. The user is then asked to enter the first and last name of the student they are searching for. Linear search and binary search are then run on the first array of students to locate the requested student. If the student is found, their index is printed out. If not, a message is printed out saying the student was not found.
public class Main {
  public static void main(String[] args) {

    // Create two arrays of 20 student objects each
    Student[] array1 = new Student[20];
    Student[] array2 = new Student[20];

    // Populate the arrays
    array1[0] = new Student("John", "Smith");
    array1[1] = new Student("Jane", "Smith");
    array1[2] = new Student("Chase", "Moynihan");
    array1[3] = new Student("Sarah", "Johnson");
    array1[4] = new Student("Tom", "Williams");
    array1[5] = new Student("Kim", "Williams");
    array1[6] = new Student("David", "Jones");
    array1[7] = new Student("Ivan", "Ozaeta");
    array1[8] = new Student("Chris", "Rock");
    array1[9] = new Student("Lauren", "Brown");
    array1[10] = new Student("Jeff", "Davis");
    array1[11] = new Student("Elizabeth", "Davis");
    array1[12] = new Student("Steven", "Miller");
    array1[13] = new Student("Karen", "Miller");
    array1[14] = new Student("Ryan", "Wilson");
    array1[15] = new Student("Rachel", "Wilson");
    array1[16] = new Student("Andrew", "Moore");
    array1[17] = new Student("Samantha", "Moore");
    array1[18] = new Student("Brian", "Taylor");
    array1[19] = new Student("Megan", "Diaz");

    // Copy array1 into array2
    for (int i = 0; i < array1.length; i++) {
      array2[i] = array1[i];
    }

    // Print out both arrays
    System.out.println("Array 1:");
    for (Student s : array1) {
      System.out.println(s);
    }
    System.out.println();
    System.out.println("Array 2:");
    for (Student s : array2) {
      System.out.println(s);
    }
    System.out.println();

    // Run insertion sort on array1
    insertionSort(array1, 0);
    System.out.println("Array 1 Sorted by First Name:");
    for (Student s : array1) {
      System.out.println(s);
    }
    System.out.println();

    // Run selection sort on array2
    selectionSort(array2, 1);
    System.out.println("Array 2 Sorted by Last Name:");
    for (Student s : array2) {
      System.out.println(s);
    }
    System.out.println();

    // Ask the user to search for a student
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter a student's first name: ");
    String firstName = scanner.nextLine();
    System.out.print("Please enter a student's last name: ");
    String lastName = scanner.nextLine();
    Student student = new Student(firstName, lastName);

    // Run linear search
    System.out.println("Linear Search: ");
    int index = linearSearch(array1, student);
    if (index != -1) {
      System.out.println("Student found at index " + index);
    } else {
      System.out.println("Student not found");
    }
    System.out.println();

    // Run binary search
    System.out.println("Binary Search:");
    index = binarySearch(array1, student);
    if (index != -1) {
      System.out.println("Student found at index " + index);
    } else {
      System.out.println("Student not found");
    }
  }

  // insertionSort method: This method sorts the array by the first name of each
  // student. It takes an array of Student objects and an int, option, as
  // parameters. The int option is used to decide which field to sort by (0 for
  // first name, 1 for last name). It uses an insertion sort algorithm to sort the
  // array.
  public static void insertionSort(Student[] array, int option) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      while (j > 0 && array[j].compareTo(option, array[j - 1]) < 0) {
        Student temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
        j--;
      }
    }
  }

  public String toString() {
    return "Main []";
  }

  // selectionSort method: This method sorts the array by the last name of each
  // student. It takes an array of Student objects and an int, option, as
  // parameters. The int option is used to decide which field to sort by (0 for
  // first name, 1 for last name). It uses an selection sort algorithm to sort the
  // array.
  public static void selectionSort(Student[] array, int option) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j].compareTo(option, array[minIndex]) < 0) {
          minIndex = j;
        }
      }
      Student temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }

  // linearSearch method: This method searches through an array of Student objects
  // for a given student. It takes an array of Student objects and a Student
  // object as parameters. It uses a linear search algorithm to search the array
  // for the student. If the student is found, the index of the student is
  // returned. If the student is not found, -1 is returned.
  public static int linearSearch(Student[] array, Student student) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].compareTo(0, student) == 0 && array[i].compareTo(1, student) == 0) {
        return i;
      }
    }
    return -1;
  }

  // binarySearch method: This method searches through an array of Student objects
  // for a given student. It takes an array of Student objects and a Student
  // object as parameters. It uses a binary search algorithm to search the array
  // for the student. If the student is found, the index of the student is
  // returned. If the student is not found, -1 is returned.
  public static int binarySearch(Student[] array, Student student) {
    int low = 0;
    int high = array.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (array[mid].compareTo(0, student) == 0 && array[mid].compareTo(1, student) == 0) {
        return mid;
      } else if (array[mid].compareTo(0, student) > 0
          || (array[mid].compareTo(0, student) == 0 && array[mid].compareTo(1, student) > 0)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}