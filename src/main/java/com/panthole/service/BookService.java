package com.panthole.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panthole.dao.BookDao;
import com.panthole.domain.Book;
import com.panthole.domain.Books;

@Service
/**
 * <p>BookService class.</p>
 *
 * @author hanl
 * @version $Id: $Id
 */
public class BookService {
    private static final Logger LOGGER = Logger.getLogger(BookService.class);
    @Autowired
    private BookDao bookDao;

    /**
     * <p>Constructor for BookService.</p>
     */
    public BookService() {
    }

    /**
     * <p>saveBook.</p>
     *
     * @param book a {@link com.panthole.domain.Book} object.
     * @return a {@link com.panthole.domain.Book} object.
     */
    public Book saveBook(final Book book) {
        return bookDao.store(book);
    }

    /**
     * <p>getBook.</p>
     *
     * @param bookId a {@link java.lang.Integer} object.
     * @return a {@link com.panthole.domain.Book} object.
     */
    public Book getBook(final Long bookId) {
        try {
            return bookDao.findById(bookId);
        } catch (final Exception e) {
            BookService.LOGGER.error(e);
            return new Book(-1L, "");
        }
    }

    /**
     * <p>getBooks.</p>
     *
     * @return a {@link com.panthole.domain.Books} object.
     */
    public Books getBooks() {
        return new Books(bookDao.findAll());
    }

    /**
     * <p>updateBook.</p>
     *
     * @param bookId a {@link java.lang.Integer} object.
     * @param book a {@link com.panthole.domain.Book} object.
     * @return a {@link com.panthole.domain.Book} object.
     */
    public Book updateBook(final Long bookId, final Book book) {
        book.setBookId(bookId);
        bookDao.update(book);
        return book;
    }

    /**
     * <p>deleteBook.</p>
     *
     * @param bookId a {@link java.lang.Integer} object.
     * @return a boolean.
     */
    public boolean deleteBook(final Long bookId) {
        return bookDao.remove(bookId);
    }
}
