package it.unibo.mvc;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberConsoleView;
import it.unibo.mvc.view.DrawNumberSwingView;

import java.lang.Class;
import java.lang.reflect.Constructor;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private static final String CONSOLE_VIEW_CLASS = "it.unibo.mvc.view.DrawNumberConsoleView";
    private static final String SWING_VIEW_CLASS = "it.unibo.mvc.view.DrawNumberSwingView";

    private LaunchApp() {
    }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException    if the fetches class does not exist
     * @throws NoSuchMethodException     if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException    if the constructor throws exceptions
     * @throws IllegalAccessException    in case of reflection issues
     * @throws IllegalArgumentException  in case of reflection issues
     */
    public static void main(final String... args) throws Exception {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        final Class<?> cVC = Class.forName(CONSOLE_VIEW_CLASS);
        final Constructor<?> cVCConstructor = cVC.getConstructor();
        final Class<?> sVC = Class.forName(SWING_VIEW_CLASS);
        final Constructor<?> sVCConstructor = sVC.getConstructor();
        for (int i = 0; i < 3; i++) {
            app.addView((DrawNumberView) cVCConstructor.newInstance());
            app.addView((DrawNumberView) sVCConstructor.newInstance());
        }
    }
}
