package lt.lukpaz.school;

import java.util.Arrays;

public class School {
    //Tarkime turime masyvą objektų Mokinys. Reikia atspausdinti mokinių vardus ir
    //pavardes surūšiuotus pagal klases ir pagal pavardes bei vardus.
    //Pastaba: nustatykite keliems iš vienos klasės mokiniams tas pačias pavardes bet
    //skirtingus vardus, kad patikrinti ar gerai rūšiuoja.

    public static void main(String[] args) {
        Student[] students = fetchDataFromDb();
        System.out.println("Original student list: ");
        printStudentList(students);

        System.out.println("\nSorted student list: ");
        Student[] sortedStudents = sortStudents(students);
        printStudentList(sortedStudents);
    }

    static void printStudentList(Student[] students) {
        for(Student student : students) {
            System.out.printf("%s grade %d\n", student.getFullName(), student.getGrade());
        }
    }

    static Student[] fetchDataFromDb() {
        return new Student[]{
                new Student("Jonas", "Jonaitis", 7),
                new Student("Jonas", "Petraitis", 7),
                new Student("Petras", "Petraitis", 9),
                new Student("Kazys", "Kazlauskas", 9),
                new Student("Vardenis", "Pavardenis", 3),
                new Student("Tikras", "Vardas", 8),
                new Student("Ona", "Petrauskaite", 3)
        };
    }

    static Student[] sortStudents(Student[] students) {
        Student[] sortedStudents = Arrays.copyOf(students, students.length);
        for(int i=0; i<sortedStudents.length -1; i++) {
            for(int j=i+1; j<sortedStudents.length; j++){
                if(compare(sortedStudents[i], sortedStudents[j])>0) {
                    Student temp = sortedStudents[i];
                    sortedStudents[i] = sortedStudents[j];
                    sortedStudents[j] = temp;
                }
            }
        }

        return sortedStudents;
    }

    static int compare(Student student1, Student student2) {
        if(student1.getGrade() > student2.getGrade()) return 1;
        if(student1.getGrade() < student2.getGrade()) return -1;

        return student1.getFullName().compareTo(student2.getFullName());
    }

}

