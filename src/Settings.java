/**
 * This program is a class representation of the Settings for a class of Matrix operations. It handles the GUI
 * representation of the settings as well as loading the settings into the actual Matrix objects.
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings implements ActionListener {

    protected int rows;
    protected int columns;
    protected String mode;

    protected JFrame settings_window;
    protected JComboBox<String> settings;
    protected JComboBox<String> mode_choose;
    protected JButton confirm_settings;

    /**
     DVC that just calls the settingsMenu() function to bring up the settings GUI
     *
     */
    public Settings() {
        settingsMenu();
    }


    /**
     Starts the program by asking for the settings to be chosen.
     *
     */
    public void settingsMenu() {
        settings_window = new JFrame();
        settings_window.setTitle("Settings");
        settings_window.setSize(600, 300);
        settings_window.setLocationRelativeTo(null);
        settings_window.setLayout(new BorderLayout());

        JPanel variables_panel = new JPanel();

        JPanel mode_panel = new JPanel();

        settings = new JComboBox<String>();
        settings.addItem("5");
        settings.addItem("4");
        settings.addItem("3");
        settings.addItem("2");

        mode_choose = new JComboBox<String>();
        mode_choose.addItem("Gaussian Elimination");
        mode_choose.addItem("Calculate Determinant");
        mode_choose.addItem("Compute Inverse");

        JTextArea instructions = new JTextArea("This is a calculator for solving a series of linear equations " +
                "using Gaussian \nElimination and for finding the determinant of an n x n matrix. To use it, \nsimply select the " +
                "number of rows you need and the desired operation. Then \nclick the Confirm Settings button. \nFor the Gaussian" +
                " Elimination, if it ever returns NaN as any value, that means \nthere is either no solution or " +
                "infinitely many solutions.");

        instructions.setEditable(false);

        Font font = new Font("Calibri", Font.PLAIN, 15);
        instructions.setFont(font);

        // setup the confirm settings button
        confirm_settings = new JButton("Confirm Settings");
        confirm_settings.addActionListener(this);

        // setup the rows dropbox
        JLabel variable_label = new JLabel("Choose number of rows");
        variables_panel.add(variable_label);
        variables_panel.add(settings);

        // setup the operation dropbox
        JLabel mode_label = new JLabel("Choose the operation");
        mode_panel.add(mode_label);
        mode_panel.add(mode_choose);

        // add all the widgets to the screen
        settings_window.add(variables_panel, BorderLayout.WEST);
        settings_window.add(mode_panel, BorderLayout.EAST);
        settings_window.add(confirm_settings, BorderLayout.SOUTH);
        settings_window.add(instructions, BorderLayout.NORTH);

        settings_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings_window.setVisible(true);
    }

    /**
     actionPerformed function that listens for events. When the confirm settings button is pressed, it checks to see
     what mode the user has chosen, grabs the number of rows, and then creates a Matrix object with those qualities.
     *
     * @param e, the event that was performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String temp_mode = (String)mode_choose.getSelectedItem();
        String temp_n = (String)settings.getSelectedItem();

        // if the user chose to use solving a system of linear equations
        if (temp_mode.equals("Gaussian Elimination")) {

            int r = Integer.parseInt(temp_n);
            int c = r + 1;

            rows = r;
            columns = c;
            mode = temp_mode;

            Gauss gaussian = new Gauss(r, c);
            gaussian.setUpMainWindow();

        // if the user chose to use Determinant mode
        } else if (temp_mode.equals("Calculate Determinant")) {

            int r = Integer.parseInt(temp_n);

            rows = r;
            columns = r;
            mode = temp_mode;

            Determinant determinant = new Determinant(r, r);
            determinant.setUpMainWindow();

        } else if (temp_mode.equals("Compute Inverse")) {

            int r = Integer.parseInt(temp_n);

            rows = r;
            columns = r;
            mode = temp_mode;

            Inverse inverse = new Inverse(r, r);
            inverse.setUpMainWindow();
        }
    }
}
