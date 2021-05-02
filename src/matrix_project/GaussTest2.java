/**
 * This program is a test for the Gauss class. The test is explained in the comments below
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

public class GaussTest2 {
    public static void main(String args[]) {

        // 3 x 3 test
        // should result in (2, 4, 6)
        Gauss test = new Gauss(3, 4);

        test.setValue(0, 0, 2);
        test.setValue(0, 1, 1);
        test.setValue(0, 2, -3);
        test.setValue(0, 3, -10);
        test.setValue(1, 0, 0);
        test.setValue(1, 1, -2);
        test.setValue(1, 2, 1);
        test.setValue(1, 3, -2);
        test.setValue(2, 0, 0);
        test.setValue(2, 1, 0);
        test.setValue(2, 2, 1);
        test.setValue(2, 3, 6);
        test.setUpMainWindow();


    }
}
