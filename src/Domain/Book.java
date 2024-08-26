package Domain;

/**
 * @param title attributes
 */
public record Book(String title, String author, String ISBN) {

    // toString override
    @Override
    public String toString() {
        return "Title: " + title + "Author: " + author + "ISBN: " + ISBN;
    }

    public String getTitle() {
        return title;
    }

}
