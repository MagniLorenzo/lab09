package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private Optional<String> actualString;
    private final List<String> history;

    public SimpleController() {
        this.actualString = Optional.empty();
        this.history = new LinkedList<>();
    }

    @Override
    public void setString(final String str) {
        this.actualString = Optional.of(str);
        this.history.add(str);
    }

    @Override
    public String getActualString() {
        return this.actualString.get();
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }

    @Override
    public void printString() throws IllegalStateException {
        try {
            System.out.println(getActualString());
        } catch (NoSuchElementException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
