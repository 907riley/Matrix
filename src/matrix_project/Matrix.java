/**
 * This program is an abstract Matrix class. It contains all the functions that a matrix class needs, as well as the
 * functions for performing the Gaussian Elimination for solving a system of linear equations and for computing
 * the determinant of a matrix.
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * Used this website to help with the inverse part of the program
 * https://www.geeksforgeeks.org/finding-inverse-of-a-matrix-using-gauss-jordan-method/
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Matrix implements ActionListener{

    protected Coefficient [][] matrix;
    protected double[] solutions_array;
    protected int rows;
    protected int columns;
    protected double determinant_solution;

    protected JFrame main_window;
    protected JPanel matrix_view;
    protected JPanel solutions;
    protected JButton perform_gaussian_elimination;
    protected JButton perform_determinant;
    protected JButton perform_inverse;
    protected JButton reset;

    public abstract void setUpMainWindow();
    public abstract void setUpSolutions();
    public abstract void updateSolutions();

    /**
     DVC for the sake of the subclasses needing a DVC. It is never used on it's own.
     *
     */
    public Matrix() {

    }

    /**
     EVC for making an r x c matrices
     *
     * @param r for the number of rows
     * @param c for the number of columns
     */
    public Matrix(int r, int c) {
        matrix = new Coefficient[r][c];
        solutions_array = new double[r];
        rows = r;
        columns = c;

        // make each of the coefficient objects
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < columns; ++col) {
                matrix[row][col] = new Coefficient(row, col, 0, columns);
            }
        }
    }

    public Matrix(Matrix rhs) {
        matrix = new Coefficient[rhs.rows][rhs.columns];
        solutions_array = new double[rhs.rows];
        rows = rhs.rows;
        columns = rhs.columns;

        // make each of the coefficient objects
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < columns; ++col) {
                matrix[row][col] = new Coefficient(row, col, rhs.matrix[row][col].getValue(), columns);
            }
        }
    }

    /**
     Function for setting a value in the matrix, also updates the GUI.
     *
     * @param r the row number for the value
     * @param c the column number for the value
     * @param value the number being inserted into the matrix
     */
    public void setValue(int r, int c, double value) {

        // make sure the r and c are in bounds
        if (r >= rows || c >= columns) {
            System.out.println("out of bounds");
            return;
        }
        matrix[r][c].setValue(value);
        matrix[r][c].updateGUIValue();
    }

    /**
     Function for swapping two values in a matrices
     *
     * @param r1 row number for the first value
     * @param c1 column number for the first value
     * @param r2 row number for the second value
     * @param c2 column number for the second value
     * @return boolean for if a swap happened or not.
     */
    public boolean swap(int r1, int c1, int r2, int c2) {
        boolean swaps = false;
        if (r1 >= rows || r2 >= rows || c1 >= columns || c2 >= columns) {
            // System.out.println("out of bounds");
            return false;
        }

        // check to make sure the values being swapped aren't equal
        if (matrix[r1][c1] != matrix[r2][c2]) {
            double temp = matrix[r1][c1].getValue();
            matrix[r1][c1].setValue(matrix[r2][c2].getValue());
            // System.out.println("Swapping: " + temp + " -> " + matrix[r2][c2].getValue());
            swaps = true;
            matrix[r2][c2].setValue(temp);
        }
        return swaps;
    }

    /**
     Function for swapping the contents of two rows
     *
     * @param r1 the index of the first row to swap
     * @param r2 the index of the second row to swap
     */
    public void rowSwap(int r1, int r2) {
        for (int i = 0; i < columns; ++i) {
            swap(r1, i, r2, i);
        }
    }

    /**
     Function for swapping the contents of two columns
     *
     * @param c1 the index of the first column to swap
     * @param c2 the index of the second column to swap
     */
    public void columnSwap(int c1, int c2) {
        for (int i = 0; i < rows; ++i) {
            swap(i, c1, i, c2);
        }
    }

    /**
     Function that performs Gaussian Elimination on the current Matrix. Just updates in place instead of returning
     something new.
     *
     */
    public void gaussianElimination() {
        int n = rows;
        // go through each row
        for (int i = 0; i < n - 1; ++i) {
            //System.out.println("in the first loop");
            // attempting to find the row with the greatest value at the current column
            // this is to fix the issue of dividing by 0 when the rows aren't in the best order already
            int pivot_row = i;
            for (int j = i + 1; j < n; ++j) {
                //System.out.println("second loop");
                if (Math.abs(matrix[j][i].getValue()) > Math.abs(matrix[pivot_row][i].getValue())) {
                    //System.out.println("new pivot row: " + j);
                    pivot_row = j;
                }
            }
            for (int k = i; k <= n; ++k) {
                //System.out.println("third loop");
                swap(i, k, pivot_row, k);
            }
            for (int j = i + 1; j < n; ++j) {
                // get the value to make two rows cancel out when multiplied
                double temp = matrix[j][i].getValue()/matrix[i][i].getValue();
                //System.out.println("fourth loop temp: " + temp);
                // go through and actually perform the gaussian elimination by solving the set of equations
                for (int k = i; k <= n; ++k) {
                    //System.out.println("fifth loop, setting: " + matrix[j][k].getValue() + " to: " + (matrix[j][k].getValue() - matrix[i][k].getValue() * temp));
                    matrix[j][k].setValue(matrix[j][k].getValue() - matrix[i][k].getValue() * temp);
                }
            }
        }

        // backtrack to find the solutions
        backTracking();
        // update the solutions on the GUI
        updateSolutions();
    }


    /**
     Function for calculating the determinant of an n x n matrix. Uses a modified Gaussian Elimination algorithm to
     get the U decomposition. Then multiplies along the diagonal to get the determinant.
     *
     */
    public void calculate_determinant() {

        int n = rows;
        int swap_count = 0;
        boolean swaps = false;
        // go through each row
        for (int i = 0; i < n - 1; ++i) {
            swaps = false;
            //System.out.println("in the first loop");
            // attempting to find the row with the greatest value at the current column
            // this is to fix the issue of dividing by 0 when the rows aren't in the best order already
            int pivot_row = i;
            for (int j = i + 1; j < n; ++j) {
                //System.out.println("second loop");
                if (Math.abs(matrix[j][i].getValue()) > Math.abs(matrix[pivot_row][i].getValue())) {
                    // System.out.println("new pivot row: " + j);
                    pivot_row = j;
                }
            }
            for (int k = i; k < n; ++k) {
                // System.out.println("third loop, i: " + i);
                swaps = swap(i, k, pivot_row, k);

            }

            for (int j = i + 1; j < n; ++j) {
                // get the value to make two rows cancel out when multiplied
                double temp = matrix[j][i].getValue()/matrix[i][i].getValue();
                //System.out.println("fourth loop temp: " + temp);
                // go through and actually perform the gaussian elimination by solving the set of equations
                for (int k = i; k < n; ++k) {
                    //System.out.println("fifth loop, setting: " + matrix[j][k].getValue() + " to: " + (matrix[j][k].getValue() - matrix[i][k].getValue() * temp));
                    matrix[j][k].setValue(matrix[j][k].getValue() - matrix[i][k].getValue() * temp);
                }
            }
            if (swaps) {
                ++swap_count;
            }
        }

        // actually calculating the determinant value
        determinant_solution += matrix[0][0].getValue();
        for (int i = 1; i < rows; ++i) {
            determinant_solution *= matrix[i][i].getValue();
        }

        // accounting for row swaps that require a sign flip
        if (swap_count % 2 == 1) {
            determinant_solution *= -1;
        }
        determinant_solution = Math.round(determinant_solution);
    }

    /**
     Function for going back and finding the answers for each of the variables in the matrix.
     *
     */
    public void backTracking() {

        // for each row, starting at the bottom row
        for (int i = rows - 1; i >= 0; --i) {
            //System.out.println("in backtracking");
            int count = 0;
            // this holds the changing constant value
            double compounding_coefficient = matrix[i][columns - 1].getValue();
            // for each column that needs to be subtracted from the constant before dividing the constant by
            // the current column value
            for (int j = i + 1; j < columns - 1; ++j ) {
                //System.out.println("in inner loop");
                compounding_coefficient = compounding_coefficient - matrix[i][j].getValue() * solutions_array[i + 1 + count];
                //System.out.println("Comp_Co: " + compounding_coefficient);
                ++count;
            }

            // divide the compounded number by the coefficient of the variable we're solving for
            double answer = compounding_coefficient/matrix[i][i].getValue();
            answer = Math.round(answer);
            //System.out.println("Answer: " + answer);
            // put the value into the solutions array
            solutions_array[i] = answer;
        }
    }

    public void compute_inverse() {

        // creating a determinant object to test if the inverse is 0
        Determinant test = new Determinant(rows, columns);
        // copy over all the values from the inverse matrix
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                test.matrix[i][j].setValue(matrix[i][j].getValue());
            }
        }
        test.calculate_determinant();
        determinant_solution = test.determinant_solution;

        // determinant is 0, no inverse
        if (determinant_solution == 0) {
            System.out.println("No inverse solution");
            updateSolutions();
            matrix_view.updateUI();
            return;
        }

        // getting the rows in the correct order
        for (int i = rows - 1; i > 0; --i) {
            if (matrix[i - 1][0].getValue() < matrix[i][0].getValue()) {
                for (int j = 0; j < 2 * rows; ++j) {
                    // check to make sure the values being swapped aren't equal
                    if (matrix[i - 1][j] != matrix[i][j]) {
                        double temp = matrix[i - 1][j].getValue();
                        matrix[i - 1][j].setValue(matrix[i][j].getValue());
                        System.out.println("Swapping: " + temp + " -> " + matrix[i][j].getValue());
                        matrix[i][j].setValue(temp);
                    }
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < rows; ++j) {
                if (i != j) {
                    double temp = matrix[j][i].getValue() / matrix[i][j].getValue();
                    for (int k = 0; k < 2 * rows; ++k) {
                        matrix[j][k].setValue(matrix[j][k].getValue() - matrix[i][k].getValue() * temp);
                    }
                }
            }
        }

        for (int i = 0; i < rows; ++i) {

            double temp = matrix[i][i].getValue();
            for (int j = 0; j < 2 * rows; ++j) {
                matrix[i][j].setValue(matrix[i][j].getValue() / temp);
            }
        }

    }

    /**
     actionPerformed function that listens for when the button is pressed to perform a function and when
     the reset button is being pressed.
     *
     * @param e, the event that just happened
     */
    public void actionPerformed(ActionEvent e) {
        // If trying to solve a system of linear equations
        if (e.getSource().equals(perform_gaussian_elimination)) {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    if (!matrix[i][j].updateValue()) {
                        System.out.println("Something wrong with input, everything must be numbers!");
                        return;
                    }
                }
            }

            // perform the gaussian elimination
            gaussianElimination();
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    matrix[i][j].updateGUIValue();
                }
            }
            matrix_view.updateUI();
        // If trying to reset the matrix and GUI view
        } else if (e.getSource().equals(reset)) {
            reset();
        // If trying to calculate a determinant
        } else if (e.getSource().equals(perform_determinant)) {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    if (!matrix[i][j].updateValue()) {
                        System.out.println("Something wrong with input, everything must be numbers!");
                        return;
                    }
                }
            }

            calculate_determinant();
            updateSolutions();
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    matrix[i][j].updateGUIValue();
                }
            }
            matrix_view.updateUI();
        } else if (e.getSource().equals(perform_inverse)) {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    if (!matrix[i][j].updateValue()) {
                        System.out.println("Something wrong with input, everything must be numbers!");
                        return;
                    }
                }
            }

            compute_inverse();
            updateSolutions();
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    matrix[i][j].updateGUIValue();
                }
            }
            matrix_view.updateUI();
        }
    }

    /**
     Function for resetting the matrix and solutions array values and updating the GUI
     *
     */
    public void reset() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix[i][j].setValue(0);
                matrix[i][j].updateGUIValue();
            }
            solutions_array[i] = 0;
        }

        determinant_solution = 0;

        setUpSolutions();
        matrix_view.updateUI();
        solutions.updateUI();
    }

    /**
     ToString override function for printing out the matrices
     *
     * @return String variable that represents the matrices
     */
    public String toString() {
        String matrices = "";
        for (int r = 0; r < rows; ++r) {
            matrices += "[";
            for (int c = 0; c < columns; ++c) {
                matrices += " " + matrix[r][c].getValue() + " ";
            }
            matrices += "]\n";
        }
        return matrices;
    }
}
