package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java graphical interface";
    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame(TITLE);

    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton saveButton = new JButton("Save");
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(saveButton, BorderLayout.SOUTH);
        final JPanel canvas2 = new JPanel(new BorderLayout());
        final JButton browseButton = new JButton("Browse...");
        final JTextField textField = new JTextField(controller.getFilePath());
        textField.setEditable(false);
        canvas2.add(textField, BorderLayout.CENTER);
        canvas2.add(browseButton, BorderLayout.LINE_END);
        canvas.add(canvas2, BorderLayout.NORTH);
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
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
    }

    public void start() {
        this.frame.setVisible(true);
    }

}
