package com.itmuch.yes.util.snowflake;

/**
 * Key generator interface.
 *
 * @author Wujun
 */
public interface KeyGenerator {

    /**
     * Generate key.
     *
     * @return generated key
     */
    Number generateKey();
}