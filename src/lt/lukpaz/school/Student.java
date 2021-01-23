package lt.lukpaz.school;

public class Student {
    private String firstName;
    private String lastName;
    private int grade;

    Student(String firstName, String lastName, int grade) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
    }

    //getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public int getGrade() {
        return grade;
    }

    // setters

    void setFirstName(String firstName) {
        if(firstName == null || firstName.length() < 2) {
            throw new IllegalArgumentException("First Name invalid!");
        }
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        if(firstName == null || firstName.length() < 2) {
            throw new IllegalArgumentException("Last Name invalid!");
        }
        this.lastName = lastName;
    }

    void setGrade(int grade) {
        if(grade > 12 || grade < 1) {
            throw new IllegalArgumentException("Grade must be between 1 and 12!");
        }
        this.grade = grade;
    }
}
