import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Student
{
    private final String     firstName;
    private String           middleName;
    private final String     lastName;
    private final String     studentEmail;
    private final String     studentNumber;

    public Student(final String firstName,
                   final String middleName,
                   final String lastName,
                   final String studentEmail,
                   final String studentNumber)
    {
        validateMiddleName(middleName);

        this.firstName     = firstName;
        this.lastName      = lastName;
        this.studentEmail  = studentEmail;
        this.studentNumber = studentNumber;

    }

    void validateMiddleName(final String middleName)
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
