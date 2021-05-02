/**
 * This program is a test for the Gauss class. The test is explained in the comments below
 * CPSC 450, Spring 2021
 * Semester Project
 *
 * @author Riley Sikes
 * @version v1.0 04/29/21
 */

package matrix_project;

public class GaussTest3 {
    public static void main(String args[]) {

        // 4 x 4 test
        // should result in (1, 2, 3, 4)
        Gauss test = new Gauss(4, 5);

        test.setValue(0, 0, 1);
        test.setValue(0, 1, 2);
        test.setValue(0, 2, -1);
        test.setValue(0, 3, 1);
        test.setValue(0, 4, 6);
        test.setValue(1, 0, -1);
        test.setValue(1, 1, 1);
        test.setValue(1, 2, 2);
        test.setValue(1, 3, -1);
        test.setValue(1, 4, 3);
        test.setValue(2, 0, 2);
        test.setValue(2, 1, -1);
        test.setValue(2, 2, 2);
        test.setValue(2, 3, 2);
        test.setValue(2, 4, 14);
        test.setValue(3, 0, 1);
        test.setValue(3, 1, 1);
        test.setValue(3, 2, -1);
        test.setValue(3, 3, 2);
        test.setValue(3, 4, 8);
        test.setUpMainWindow();


    }
}
