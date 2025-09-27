import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFunctions
{
    // Student Navigating Options
    private static final int VIEW_STUDENT_DETAILS = 1;
    private static final int VIEW_BOOKS_READ      = 2;
    private static final int ADD_NEW_BOOK         = 3;

    private static final String REGEX_SECTION_SPLIT = "\\|";
    private static final String SECTION_SPLIT       = "|";

    private static final String REGEX_MID_SECTION_SPLIT   = "\\*";
    private static final String MID_SECTION_SPLIT         = "*";

    private static final String FILEPATH_STUDENT   = "src" + File.separator + "Resources" + File.separator + "Student";
    private static final String FILEPATH_LIBRARIAN = "src" + File.separator + "Resources" + File.separator + "Librarian";

    static final Scanner input = new Scanner(System.in);

// For Option 1: Librarian Sign in
    static void librarianRegistration()
    {
        final String firstName;
        final String middleName;
        final String lastName;
        final String workEmail;
        final String password;
        final int    librarianAge;
        final String phoneNumber;
        final Librarian librarian;
        final String filename;

        System.out.print("Enter First Name: ");
        firstName = input.nextLine();

        System.out.print("Enter Middle Name(Optional): ");
        middleName = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = input.nextLine();

        System.out.print("Enter Work Email: ");
        workEmail = input.nextLine();

        System.out.print("Enter Password: ");
        password = input.nextLine();

        System.out.print("Enter Librarian Age: ");
        librarianAge = input.nextInt();

        input.nextLine();

        System.out.print("Enter Phone Number: ");
        phoneNumber = input.nextLine();

        librarian = new Librarian(firstName, middleName, lastName, workEmail, password, librarianAge, phoneNumber);
        filename = String.format(FILEPATH_LIBRARIAN + File.separator + "%s%s.txt",
                librarian.getFirstName(), librarian.getPassword());

        try(final BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write(String.format("Librarian Details%s", SECTION_SPLIT));
            writer.write(String.format("First Name: %s%s ", librarian.getFirstName(), MID_SECTION_SPLIT));
            writer.write(String.format("Middle Name: %s%s ", librarian.getMiddleName(), MID_SECTION_SPLIT));
            writer.write(String.format("Last Name: %s%s ", librarian.getLastName(), MID_SECTION_SPLIT));
            writer.write(String.format("Work Email: %s%s ", librarian.getWorkEmail(), MID_SECTION_SPLIT));
            writer.write(String.format("Age: %d%s ", librarian.getLibrarianAge(), MID_SECTION_SPLIT));
            writer.write(String.format("Phone Number: %s", librarian.getPhoneNumber()));
        }
        catch(final Exception e)
        {
            throw new RuntimeException(e);
        }

        input.close();
    }

    static void librarianSignIn()
    {
        System.out.println("Librarian Sign in...");
    }

// For Option 2: Registration of new Student
    static void registerNewStudent()
    {
        System.out.println("=======================\nWelcome to Registration Form\n=======================");
        
        final String  studentName;
        final String  middleName;
        final String  lastName;
        final String  studentEmail;
        final String  studentNumber;
        final Student student;
        final String  filename;


        System.out.print("First name: ");
        studentName = input.nextLine();

        System.out.print("Middle name(optional): ");
        middleName = input.nextLine();

        System.out.print("Last name: ");
        lastName = input.nextLine();

        System.out.print("Student Email: ");
        studentEmail = input.nextLine();

        System.out.print("Student number: ");
        studentNumber = input.nextLine();


        student = new Student(studentName, middleName, lastName, studentEmail, studentNumber);

        filename = String.format(FILEPATH_STUDENT + File.separator + "%s.txt", studentNumber);

        try(final BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write(String.format("Student Details%s", SECTION_SPLIT));
            writer.write(String.format("First Name: %s%s", student.getFirstName(), MID_SECTION_SPLIT));
            writer.write(String.format("Middle Name: %s%s ", student.getMiddleName(), MID_SECTION_SPLIT));
            writer.write(String.format("Last Name: %s%s ", student.getLastName(), MID_SECTION_SPLIT));
            writer.write(String.format("Student Email: %s%s ", student.getStudentEmail(), MID_SECTION_SPLIT));
            writer.write(String.format("Student Number: %s", student.getStudentNumber()));
            writer.write(String.format("%sBooks%s==========================%s", SECTION_SPLIT, SECTION_SPLIT, MID_SECTION_SPLIT));

        }
        catch(final Exception e)
        {
            throw new RuntimeException(e);
        }
        System.out.printf("\n%s (Account Successfully registered)\n", student.getFullName());

        signInOptions();
        input.close();
    }

// For option 3: Sign in Student
    static void signInOptions()
    {
        final String signInNumber;
        final int    optionNumber;

        System.out.print("Enter Student Number: ");
        signInNumber = input.nextLine();

        System.out.printf("%d. View Student Details\n%d. View Books Read\n%d. Add New Books Read\nOption: "
                , VIEW_STUDENT_DETAILS, VIEW_BOOKS_READ, ADD_NEW_BOOK);

        optionNumber = input.nextInt();
        input.nextLine();

        switch(optionNumber)
        {
            case VIEW_STUDENT_DETAILS:
                viewStudentDetails(signInNumber);
                break;
            case VIEW_BOOKS_READ:
                viewBooksRead(signInNumber);
                break;
            case ADD_NEW_BOOK:
                addBook(signInNumber);
                break;
        }
    }

    static void signInOptions(String studentNumber)
    {
        final int    optionNumber;
        final String signInNumber;

        signInNumber = studentNumber;

        System.out.printf("%d. View Student Details\n%d. View Books Read\n%d. Add New Books Read\nOption: "
                , VIEW_STUDENT_DETAILS, VIEW_BOOKS_READ, ADD_NEW_BOOK);

        optionNumber = input.nextInt();
        input.nextLine();

        switch(optionNumber)
        {
            case VIEW_STUDENT_DETAILS:
                viewStudentDetails(signInNumber);
                break;
            case VIEW_BOOKS_READ:
                viewBooksRead(signInNumber);
                break;
            case ADD_NEW_BOOK:
                addBook(signInNumber);
                break;
        }
    }

    static void viewStudentDetails(final String studentNumber)
    {
        final String fileToRead;
        fileToRead = String.format(FILEPATH_STUDENT + File.separator + "%s.txt", studentNumber);

        final List<String> fileContents;

        fileContents = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileToRead)))
        {
            // Add a file reader that reads a specific line
            String line;

            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(REGEX_SECTION_SPLIT);

                if(parts.length < 5)
                {
                    String oneLine = parts[0].trim();
                    String secondLine = parts[1].trim();
                    String thirdLine = parts[2].trim();
                    String fourthLine = parts[3].trim();

                    fileContents.add(oneLine);
                    fileContents.add(secondLine);
                    fileContents.add(thirdLine);
                    fileContents.add(fourthLine);


                    String[] sectionsOfSecondLine = secondLine.split(REGEX_MID_SECTION_SPLIT);

                    for(String studentDetail: sectionsOfSecondLine)
                    {
                        System.out.println(studentDetail.trim());
                    }
                }
            }
        }
        catch(final Exception e) 
        {
            throw new RuntimeException(e);
        }

        signInOptions(studentNumber);
    }

    static void viewBooksRead(final String studentNumber)
    {

        final String fileToRead;
        final List<String> fileContents;

        fileToRead = String.format(FILEPATH_STUDENT + File.separator + "%s.txt", studentNumber);

        fileContents = new ArrayList<>();

        try(final BufferedReader reader = new BufferedReader(new FileReader(fileToRead)))
        {
            // Add a file reader that reads a specific line
            String line;

            while((line = reader.readLine()) != null)
            {
                final String[] parts;
                parts = line.split(REGEX_SECTION_SPLIT);

                if(parts.length < 5)
                {
                    final String   oneLine;
                    final String   secondLine;
                    final String   thirdLine;
                    final String   fourthLine;
                    final String[] sectionsOfFourthLine;

                    oneLine    = parts[0].trim();
                    secondLine = parts[1].trim();
                    thirdLine  = parts[2].trim();
                    fourthLine = parts[3].trim();

                    fileContents.add(oneLine);
                    fileContents.add(secondLine);
                    fileContents.add(thirdLine);
                    fileContents.add(fourthLine);

                    sectionsOfFourthLine = fourthLine.split(REGEX_MID_SECTION_SPLIT);

                    for(final String studentDetail: sectionsOfFourthLine)
                    {
                        System.out.println(studentDetail.trim());
                    }
                }
            }
        }
        catch(final Exception e)
        {
            throw new RuntimeException(e);
        }

        signInOptions(studentNumber);
    }

    static void addBook(final String file)
    {
        final String  authorName;
        final String  bookTitle;
        final String  companyPublished;
        final int     yearPublished;
        final String  bookDescription;
        final Book    newBook;
        final String  filename;
        final String  option;

        System.out.print("Author: ");
        authorName = input.nextLine();

        System.out.print("Book Title: ");
        bookTitle = input.nextLine();

        System.out.print("Company Published: ");
        companyPublished = input.nextLine();

        System.out.print("Year Published: ");
        yearPublished = input.nextInt();

        // Skips the newline character from the input integer
        input.nextLine();

        System.out.print("Book Description: ");
        bookDescription = input.nextLine();
        newBook = new Book(authorName, bookTitle, companyPublished, yearPublished, bookDescription);

        filename = String.format(FILEPATH_STUDENT + File.separator + "%s.txt", file);


        try(final BufferedWriter write = new BufferedWriter(new FileWriter(filename, true)))
        {
            write.write(String.format("Title: %s%s", newBook.getBookTitle(), MID_SECTION_SPLIT));
            write.write(String.format("Author: %s%s", newBook.getAuthor(), MID_SECTION_SPLIT));
            write.write(String.format("Company Published: %s%s", newBook.getCompanyPublished(), MID_SECTION_SPLIT));
            write.write(String.format("Year Published: %s%s", newBook.getYearPublished(), MID_SECTION_SPLIT));
            write.write(String.format("Book Description%s==================%s%s%s==================%s",
                    MID_SECTION_SPLIT, MID_SECTION_SPLIT,
                    newBook.getBookDescription(),
                    MID_SECTION_SPLIT, MID_SECTION_SPLIT));
        }
        catch(final Exception e)
        {
            throw new RuntimeException(e);
        }

        System.out.print("Press S to submit books read or C to add more books: ");
        option = input.nextLine();

        switch(option.toLowerCase())
        {

            case "s":
                System.out.println("New books successfully added");
                break;

            case "c":
                addBook(file);
                break;
        }

        signInOptions(file);
    }

}
