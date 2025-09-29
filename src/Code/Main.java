import java.util.Scanner;

public class Main
{
    private static final int ADMIN    = 1;
    private static final int STUDENT  = 2;

    private static final int LIBRARIAN_REGISTRATION = 1;
    private static final int LIBRARIAN_SIGN_IN      = 2;

    private static final int STUDENT_REGISTRATION = 1;
    private static final int STUDENT_SIGN_IN      = 2;

    private static final int BACK_TO_MAIN_PAGE      = 3;

    private static final Scanner userInput = new Scanner(System.in);

    public static void main(final String[] args)
    {
        final int option;
        final int userOption;

        System.out.printf("%d. Admin\n%d. Student\nOption: ", ADMIN, STUDENT);

        option = userInput.nextInt();
        userInput.nextLine();

        switch(option)
        {
            case ADMIN:
                System.out.printf("%d. Librarian Registration\n%d. Librarian Sign-in\n%d. Back to Main Page\nOption: ",
                                  LIBRARIAN_REGISTRATION, LIBRARIAN_SIGN_IN, BACK_TO_MAIN_PAGE);

                userOption = userInput.nextInt();
                userInput.nextLine();

                switch(userOption)
                {
                    case LIBRARIAN_REGISTRATION:
                         MyFunctions.librarianRegistration();
                        break;

                    case LIBRARIAN_SIGN_IN:
                        MyFunctions.librarianSignIn();
                        break;

                    case BACK_TO_MAIN_PAGE:
                        System.out.println("Returns back to main page...");
                        break;
                }
                break;

            case STUDENT:
                System.out.printf("%d. Student Registration\n%d. Student Sign-in\n%d. Back to Main Page\nOption: ",
                                  STUDENT_REGISTRATION, STUDENT_SIGN_IN, BACK_TO_MAIN_PAGE);

                userOption = userInput.nextInt();
                userInput.nextLine();

                switch(userOption)
                {
                    case STUDENT_REGISTRATION:
                        MyFunctions.registerNewStudent();
                        break;

                    case STUDENT_SIGN_IN:
                        MyFunctions.signInOptions();
                        break;

                    case BACK_TO_MAIN_PAGE:
                        System.out.println("Returns back to the main page...");
                        break;
                }
                break;

        }

        userInput.close();
    }
}
