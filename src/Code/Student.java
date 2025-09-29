import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Student
{
    private String     firstName;
    private String     middleName;
    private String     lastName;
    private String     studentEmail;
    private final String     studentNumber;

    private static final int MINIMUM_EMAIL_LENGTH = 15;

    public Student(final String firstName,
                   final String middleName,
                   final String lastName,
                   final String studentEmail,
                   final String studentNumber)
    {
        validateFirstName(firstName);
        validateMiddleName(middleName);
        validateLastName(lastName);
        validateStudentEmail(studentEmail);

        this.firstName     = firstName;
        this.lastName      = lastName;
        this.studentEmail  = studentEmail;
        this.studentNumber = studentNumber;

    }

    final void validateFirstName(final String firstName)
    {
        if((firstName == null) || (firstName.isEmpty()) || (firstName.isBlank()))
        {
            throw new IllegalArgumentException("First Name cannot be empty");
        }
        this.firstName = firstName;
    }

    final void validateMiddleName(final String middleName)
    {
        if((middleName == null) || (middleName.isBlank()) || (middleName.isEmpty()))
        {
            this.middleName = null;
        }
        else
        {
            this.middleName = middleName;
        }
    }

    final void validateLastName(final String lastName)
    {
        if((lastName == null) || (lastName.isEmpty()) || (lastName.isBlank()))
        {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    final void validateStudentEmail(final String studentEmail)
    {

        if((studentEmail != null) && (!studentEmail.isBlank() || (!studentEmail.isEmpty())))
        {
            if((studentEmail.length() > MINIMUM_EMAIL_LENGTH) && (studentEmail.contains("@gmail.com")))
            {
                this.studentEmail = studentEmail;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid student email address\n" +
                                                         "Ensure Email address has a minimum of %d characters",
                                                          MINIMUM_EMAIL_LENGTH));

    }

    final String getFirstName()
    {
        return firstName;
    }

    final String getMiddleName()
    {
        return middleName;
    }

    final String getLastName()
    {
        return lastName;
    }

    final String getFullName()
    {
        if(getMiddleName() != null)
        {
            return getFirstName() + " " + getMiddleName() + " " + getLastName();
        }
        return getFirstName() + " " + getLastName();
    }

    final String getStudentEmail()
    {
        return studentEmail;
    }

    final String getStudentNumber()
    {
        return studentNumber;
    }
}
