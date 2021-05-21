/**
 * This program is a test for the Determinant class. The test is explained in the comments below
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

public class DeterminantTest4 {
    public static void main(String args[]) {

        // 2 x 2 test
        // should result in -2
        Determinant test = new Determinant(2, 2);

        test.setValue(0, 0, 1);
        test.setValue(0, 1, 2);
        test.setValue(1, 0, 3);
        test.setValue(1, 1, 4);
        test.setUpMainWindow();


    }
}
