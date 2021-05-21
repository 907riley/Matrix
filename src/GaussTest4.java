/**
 * This program is a test for the Gauss class. The test is explained in the comments below
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

public class GaussTest4 {
    public static void main(String args[]) {

        // 2 x 2 test
        // should result in (2, 1)
        Gauss test = new Gauss(2, 3);

        test.setValue(0, 0, 1);
        test.setValue(0, 1, 1);
        test.setValue(0, 2, 3);
        test.setValue(1, 0, 3);
        test.setValue(1, 1, -2);
        test.setValue(1, 2, 4);
        test.setUpMainWindow();


    }
}
