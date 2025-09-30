public class Librarian
{
    private final String firstName;
    private String       middleName;
    private final String lastName;
    private final String workEmail;
    private final String password;
    private final int librarianAge;
    private final String phoneNumber;

    private static final int LAST_NAME_INITIAL = 0;

    public Librarian(final String firstName,
                     final String middleName,
                     final String lastName,
                     final String workEmail,
                     final String password,
                     final int librarianAge,
                     final String phoneNumber)
    {
        validateMiddleName(middleName);

        this.firstName    = firstName;
        this.middleName   = middleName;
        this.lastName     = lastName;
        this.workEmail    = workEmail;
        this.password     = password;
        this.librarianAge = librarianAge;
        this.phoneNumber  = phoneNumber;
    }


    final void validateMiddleName(final String middleName)
    {
        if((middleName == null) || (!middleName.isBlank()) || (middleName.isEmpty()))
        {
            this.middleName = null;
        }
        else
        {
            this.middleName = middleName;
        }
    }

//    final void validateName(final String firstName, final String lastName)
//    {
//        if((firstName == null) || (lastName == null) || (firstName.isEmpty()) || (lastName.isEmpty()) || (firstName.isBlank() || (lastName.isBlank()))
//        {
//        }
//    }

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
        if(getMiddleName() != null)
        {
            return getFirstName() + " " + getMiddleName() + " " + getLastName();
        }
        return getFirstName() + " " + " " + getLastName();
    }

    final String fileName()
    {
        return getFirstName() + getLastName().charAt(LAST_NAME_INITIAL);
    }
}
