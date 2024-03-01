package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame("Simple GUI");

    public SimpleGUI(final Controller controller) {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setString(textField.getText());
                controller.printString();
            }
        });
        final JButton historyButton = new JButton("Show history");
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText(controller.getHistory().toString());
            }
        });
        panel2.add(printButton, BorderLayout.CENTER);
        panel2.add(historyButton, BorderLayout.LINE_END);
        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
    }

    public void start() {
        this.frame.setVisible(true);
    }

    public static void main(final String[] args){
        final SimpleGUI simpleGUI = new SimpleGUI(new SimpleController());
        simpleGUI.start();
    }
}
