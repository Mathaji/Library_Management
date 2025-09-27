public class Librarian
{
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String workEmail;
    private final String password;
    private final int librarianAge;
    private final String phoneNumber;


    public Librarian(final String firstName,
                     final String middleName,
                     final String lastName,
                     final String workEmail,
                     final String password,
                     final int librarianAge,
                     final String phoneNumber)
    {
        this.firstName    = firstName;
        this.middleName   = middleName;
        this.lastName     = lastName;
        this.workEmail    = workEmail;
        this.password     = password;
        this.librarianAge = librarianAge;
        this.phoneNumber  = phoneNumber;
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

    final String getWorkEmail()
    {
        return workEmail;
    }

    final String getPassword()
    {
        return password;
    }

    final int getLibrarianAge()
    {
        return librarianAge;
    }

    final String getPhoneNumber()
    {
        return phoneNumber;
    }

    final String getFullName()
    {
        return getFirstName() + " " + getMiddleName() + " " + getLastName();
    }
}
