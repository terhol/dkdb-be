package czdbdk.dbdkbe.models.parameters;

import czdbdk.dbdkbe.repositories.BookRepository;
import czdbdk.dbdkbe.utils.SlugMaker;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tereza Holm
 */
@Data
public class BookSizeInfo {

    private String slug;
    private String name;
    private Long booksMatchesValue;
    private int minPages;
    private int maxPages;
    @Autowired
    BookRepository bookRepository;

    public BookSizeInfo(String name, int minPages, int maxPages){
        this.name = name;
        this.minPages = minPages;
        this.maxPages = maxPages;
        this.slug = SlugMaker.prepareSlug(name);
        this.booksMatchesValue = bookRepository.countByNumberOfPages(minPages, maxPages);


    }

}