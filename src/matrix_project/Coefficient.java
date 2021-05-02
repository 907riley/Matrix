/**
 * This program is a class that represents each individual number in the Matrix. Allows for easy control over the
 * value, variable, and visual representation of each matrix number.
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

import javax.swing.*;

public class Coefficient {

    private double value;
    private int row;
    private int column;
    private int last_column;
    private char variable;

    private JPanel single_view;
    private JTextField user_input;

    /**
     DVC for the Coefficient class. Doesn't really get used but I wanted to explicitly write one.
     *
     */
    public Coefficient() {
        row = 0;
        column = 0;
        value = 0;
    }

    /**
     EVC for the Coefficient class. Makes a Coefficient object that represents a single value in the Matrix object.
     *
     * @param row the row that the Coefficient is in.
     * @param column the column that the Coefficient is in.
     * @param value the double value that the Coefficient represents.
     * @param last_column the index of the last column so the function knows when to stop labeling with variables.
     */
    public Coefficient(int row, int column, double value, int last_column) {

        // set all the values
        this.row = row;
        this.column = column;
        this.value = value;
        this.last_column = last_column;

        // make a new JPanel
        single_view = new JPanel();
        single_view.setSize(10, 10);

        // make a new JTextField for user input. Allows for 10 digit numbers
        user_input = new JTextField(0.0 + "", 10);

        // make the variable for the value and set it to variable
        JLabel label;

        if (column != last_column - 1) {
            variable = (char)(122 - column);
            label = new JLabel(variable + ": ");
        } else {
            label = new JLabel("= ");
        }

        // add the label and textField to the GUI view
        single_view.add(label);
        single_view.add(user_input);
    }

    /**
     Helper function for updating the value. Reads in the user entered value from the text box.
     *
     * @return true if all the values were valid. Catches the error and returns false otherwise.
     */
    public boolean updateValue() {

        // grab the value from the text field and convert it to a double
        String new_value = user_input.getText();
        try {
            setValue(Double.parseDouble(new_value));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     Helper function for updating the GUI of a Coefficient object. Useful after something liks Gaussian Elimination
     has been ran so the user can see the results.
     *
     */
    public void updateGUIValue() {

        // clear out the current GUI
        single_view.removeAll();

        // grab the new value from the text field
        user_input = new JTextField(getValue() + "", 10);

        // make the new label
        JLabel label;

        if (column != last_column - 1) {
            label = new JLabel(variable + ": ");
        } else {
            label = new JLabel("= ");
        }

        // add the text field and the label to the GUI
        single_view.add(label);
        single_view.add(user_input);

    }

    /**
     The setter for the value variable.
     *
     * @param value the double value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     The getter for the value variable.
     *
     * @return the double value
     */
    public double getValue() {
        return value;
    }

    /**
     The getter for the row variable.
     *
     * @return the int row
     */
    public int getRow() {
        return row;
    }

    /**
     The getter for the column variable.
     *
     * @return the int column
     */
    public int getColumn() {
        return column;
    }

    /**
     The getter for the variable variable.
     *
     * @return the char variable
     */
    public char getVariable() {
        return variable;
    }

    /**
     The getter for the GUI view of the Coefficient. Used to build up the main GUI.
     *
     * @return the JPanel single_view
     */
    public JPanel getSingle_view() {
        return single_view;
    }
}
