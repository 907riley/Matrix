/**
 * This program is a subclass of the Matrix class. it represents the GUI being setup for solving a system of linear
 * equations.
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

import javax.swing.*;
import java.awt.*;

public class Gauss extends Matrix{

    /**
     The EVC for the Gauss class. Just uses the EVC from the parent class.
     *
     * @param r, the number of rows
     * @param c, the number of columns
     */
    public Gauss(int r, int c) {
        super(r, c);
    }

    /**
     Function for setting up the GUI for use. Also the function that basically starts the program since it is event
     driven.
     *
     */
    @Override
    public void setUpMainWindow() {

        // new JFrame, this will hold everything
        main_window = new JFrame();
        main_window.setTitle("Gaussian Elimination");
        main_window.setSize(1200, 800);
        main_window.setLocationRelativeTo(null);
        main_window.setLayout(new BorderLayout());

        // new JPanel, this will hold the matrix
        matrix_view = new JPanel();
        matrix_view.setLayout(new GridLayout(rows, columns));
        matrix_view.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix_view.add(matrix[i][j].getSingle_view());
            }
        }

        main_window.add(matrix_view, BorderLayout.CENTER);

        // make a new JButton, this will be the button for executing the gaussian elimination
        JPanel top_buttons = new JPanel(new FlowLayout());

        perform_gaussian_elimination = new JButton("Perform Gaussian Elimination");
        perform_gaussian_elimination.addActionListener(this);
        top_buttons.add(perform_gaussian_elimination);

        reset = new JButton("Reset Matrix and Solutions");
        reset.addActionListener(this);
        top_buttons.add(reset);

        main_window.add(top_buttons, BorderLayout.NORTH);

        setUpSolutions();

        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_window.setVisible(true);
    }

    /**
     Sets up the GUI to display the solutions to the matrix
     *
     */
    @Override
    public void setUpSolutions() {
        solutions = new JPanel();
        solutions.setLayout(new FlowLayout());
        for (int i = 0; i < rows; ++i) {
            JLabel label = new JLabel(matrix[i][i].getVariable() + ": ");
            solutions.add(label);
        }

        main_window.add(solutions, BorderLayout.SOUTH);
    }


    /**
     Updates the solutions on the GUI
     *
     */
    @Override
    public void updateSolutions() {
        solutions = new JPanel();
        solutions.setLayout(new FlowLayout());
        for (int i = 0; i < rows; ++i) {
            JLabel label = new JLabel(matrix[i][i].getVariable() + ": " + solutions_array[i]);
            solutions.add(label);
        }


        main_window.add(solutions, BorderLayout.SOUTH);
    }

    /**
     Reset function that calls the super class reset
     *
     */
    @Override
    public void resetSolutions() {
        reset();
    }
}
