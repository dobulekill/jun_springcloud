package com.wujunshen.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Books class.</p>
 *
 * @author Wujun
 * @version $Id: $Id
 */
public class Books implements Serializable {
    private static final long serialVersionUID = -5070487415443208853L;
    private List<Book> bookList;

    /**
     * <p>Constructor for Books.</p>
     */
    public Books() {
        super();
    }

    /**
     * <p>Constructor for Books.</p>
     *
     * @param bookList a {@link List} object.
     */
    public Books(final List<Book> bookList) {
        super();
        this.bookList = bookList;
    }

    /**
     * <p>Getter for the field <code>bookList</code>.</p>
     *
     * @return a {@link List} object.
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * <p>Setter for the field <code>bookList</code>.</p>
     *
     * @param bookList a {@link List} object.
     */
    public void setBookList(final List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "{" + bookList + "}";
    }
}
