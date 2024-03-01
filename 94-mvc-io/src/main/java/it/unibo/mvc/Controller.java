package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Set the string to print
     * 
     * @param str the string to print
     */
    void setString(final String str);

    /**
     * Return the string that was set to be written
     * @return the string that was set to be written
     */
    String getActualString();

    /**
     * Return the history of the printed strings
     * 
     * @return the history of the printed strings
     */
    List<String> getHistory();

    /**
     * Print the current string
     * 
     * @throws IllegalStateException if the current string is unset
     */
    void printString() throws IllegalStateException;


}
