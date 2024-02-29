package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My first Java graphical interface";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();

    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton saveButton = new JButton("Save");
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.saveOnFile(textArea.getText());
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(frame, e2, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setLocationByPlatform(true);
        frame.pack();
    }

    public void start() {
        this.frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUI().start();
    }
}
