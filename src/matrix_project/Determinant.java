/**
 * This program is a subclass of the Matrix class. it represents the GUI being setup for calculating a determinant of
 * an n x n matrix.
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

import javax.swing.*;
import java.awt.*;

public class Determinant extends Matrix{

    /**
     The EVC for the Determinant class. Doesn't call the parent constructor because it does something slightly
     different. r and c should be equal for the Determinant class.
     *
     * @param r, the number of rows
     * @param c, the number of columns
     */
    public Determinant(int r, int c) {

        matrix = new Coefficient[r][c];
        solutions_array = new double[r];
        rows = r;
        columns = c;

        // make each of the coefficient objects
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < columns; ++col) {
                matrix[row][col] = new Coefficient(row, col, 0, columns + 1);
            }
        }
        determinant_solution = 0;
    }

    /**
     Function for setting up the GUI for use. Also the function that basically starts the program since it is event
     driven.
     *
     */
    public void setUpMainWindow() {
        // new JFrame, this will hold everything
        main_window = new JFrame();
        main_window.setTitle("Calculate Determinant");
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

        // make a new JButton, this will be the button for executing the Determinant calculation
        JPanel top_buttons = new JPanel(new FlowLayout());

        perform_determinant = new JButton("Calculate Determinant");
        perform_determinant.addActionListener(this);
        top_buttons.add(perform_determinant);

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

        JLabel determinant_label = new JLabel("Determinant: ");
        solutions.add(determinant_label);

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

        JLabel determinant_label = new JLabel("Determinant: " + determinant_solution);
        solutions.add(determinant_label);

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
