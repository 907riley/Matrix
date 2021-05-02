/**
 * This program is a test for the Determinant class. The test is explained in the comments below
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

public class DeterminantTest1 {
    public static void main(String args[]) {

        // 3 x 3 test
        // should result in 49
        Determinant test = new Determinant(3, 3);

        test.setValue(0, 0, 2);
        test.setValue(0, 1, -3);
        test.setValue(0, 2, 1);
        test.setValue(1, 0, 2);
        test.setValue(1, 1, 0);
        test.setValue(1, 2, -1);
        test.setValue(2, 0, 1);
        test.setValue(2, 1, 4);
        test.setValue(2, 2, 5);
        test.setUpMainWindow();


    }
}
