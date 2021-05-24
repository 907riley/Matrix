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

    Determinant inverse_check;

    public Inverse (int r, int c) {

        // create the inverse_check determinant to check if it has an inverse
        // need to change this so that the inverse_check matrix gets filled out as an event action
        // make it so the main one gets made as a determinant, that way the inverse_matrix
        // with the extra columns doesn't need to do goofy things
        inverse_check = new Determinant(r, c);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (!matrix[i][j].updateValue()) {
                    System.out.println("Something wrong with input, everything must be numbers!");
                    return;
                }
            }
        }

        // calculate the determinant, if it is 0, then no inverse
        inverse_check.calculate_determinant();
        determinant_solution = inverse_check.determinant_solution;

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

    @Override
    public void setUpSolutions() {
        solutions = new JPanel();
        solutions.setLayout(new FlowLayout());

        JLabel inverse_label = new JLabel("Inverse will update above");
        solutions.add(inverse_label);

        main_window.add(solutions, BorderLayout.SOUTH);
    }

    @Override
    public void updateSolutions() {
        solutions = new JPanel();
        solutions.setLayout(new FlowLayout());

        JLabel inverse_label;

        if (determinant_solution == 0) {
            inverse_label = new JLabel("Determinant is 0. No inverse");
        } else {
            inverse_label = new JLabel("There's the inverse!");
        }
        solutions.add(inverse_label);
        main_window.add(solutions, BorderLayout.SOUTH);
    }


    public Determinant getInverse_check() {
        return inverse_check;
    }
}
