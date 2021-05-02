/**
 * This program is a test for the Gauss class. The test is explained in the comments below
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

public class GaussTest1 {
    public static void main(String args[]) {

        // 3 x 3 test, good example of having to do a single pivot
        // should result in (-1, -1, -1)
        Gauss test = new Gauss(3, 4);

        test.setValue(0, 0, 1);
        test.setValue(0, 1, 2);
        test.setValue(0, 2, 3);
        test.setValue(0, 3, -6);
        test.setValue(1, 0, 0);
        test.setValue(1, 1, -2);
        test.setValue(1, 2, 10);
        test.setValue(1, 3, -8);
        test.setValue(2, 0, 0);
        test.setValue(2, 1, 4);
        test.setValue(2, 2, -2);
        test.setValue(2, 3, -2);
        test.setUpMainWindow();


    }
}
