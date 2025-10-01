public class Book
{
    private final String author;
    private final String bookTitle;
    private final String companyPublished;
    private final Integer yearPublished;
    private final String bookDescription;

    public Book(final String author,
                final String bookTitle,
                final String companyPublished,
                final Integer yearPublished,
                final String bookDescription)
    {
        this.author = author;
        this.bookTitle = bookTitle;
        this.companyPublished = companyPublished;
        this.yearPublished = yearPublished;
        this.bookDescription = bookDescription;
    }

    String getAuthor()
    {
        return author;
    }

    String getBookTitle()
    {
        return bookTitle;
    }

    String getCompanyPublished()
    {
        return companyPublished;
    }

    Integer getYearPublished()
    {
        return yearPublished;
    }

    String getBookDescription()
    {
        return bookDescription;
    }

}
