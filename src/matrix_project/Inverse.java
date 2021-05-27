/**
 * This program is a subclass of the Matrix class. it represents the GUI being setup for calculating the inverse of
 * an n x n matrix.
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 05/15/21
 */

package matrix_project;

import javax.swing.*;
import java.awt.*;

public class Inverse extends Matrix {

    /**
     The EVC for the Inverse class. Uses a row and column amount to create a Matrix with double the column count. The
     extra columns are for the identity matrix that is needed for computing the matrix.
     *
     * @param r int row count
     * @param c int column count
     */
    public Inverse (int r, int c) {

        // make the matrix have extra columns for the identity matrix
        matrix = new Coefficient[r][2 * c];
        solutions_array = new double[r];
        rows = r;
        columns = c;

        // make each of the coefficient objects
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < 2 * columns; ++col) {
                matrix[row][col] = new Coefficient(row, col, 0, columns + 1);
            }
        }

        // add on the identity matrix
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < 2 * columns; ++j) {
                if (j == (i + rows)) {
                    matrix[i][j].setValue(1);
                }
            }
        }

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
        main_window.setTitle("Compute Inverse");
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

        perform_inverse = new JButton("Compute Inverse");
        perform_inverse.addActionListener(this);
        top_buttons.add(perform_inverse);

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

        JLabel inverse_label = new JLabel("Inverse will update above");
        solutions.add(inverse_label);

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

        JLabel inverse_label;

        // if there is no inverse (when the determinant is 0)
        if (determinant_solution == 0) {
            inverse_label = new JLabel("Determinant is 0. No inverse");
            System.out.println("in determinant_solution == 0");
        // if there is an inverse
        } else {
            inverse_label = new JLabel("There's the inverse!");
        }
        solutions.add(inverse_label);
        main_window.add(solutions, BorderLayout.SOUTH);
    }

    /**
     Needed a special reset for the Inverse class since it has extra columns
     *
     */
    @Override
    public void resetSolutions() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < 2 * columns; ++j) {
                matrix[i][j].setValue(0);
                if (j == (i + rows)) {
                    matrix[i][j].setValue(1);
                }
                matrix[i][j].updateGUIValue();
            }
            solutions_array[i] = 0;
        }

        determinant_solution = 0;

        setUpSolutions();
        matrix_view.updateUI();
        solutions.updateUI();
    }
}
