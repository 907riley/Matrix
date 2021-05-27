package matrix_project;

public class InverseTest4 {
    public static void main(String[] args) {
        // 4 x 4 test
        // should result in
        //  | -3.811 | -2.946 |  1.541 |  0.243 |
        //  | -5.595 | -4.027 |  1.730 |  0.378 |
        //  |  1.027 |  0.865 | -0.351 | -0.108 |
        //  |  1.243 |  0.784 | -0.162 |  0.027 |
        Inverse test = new Inverse(4, 4);
        test.setValue(0, 0, 1);
        test.setValue(0, 1, -2);
        test.setValue(0, 2, -5);
        test.setValue(0, 3, -1);
        test.setValue(1, 0, -1);
        test.setValue(1, 1, 3);
        test.setValue(1, 2, 9);
        test.setValue(1, 3, 3);
        test.setValue(2, 0, 2);
        test.setValue(2, 1, 0);
        test.setValue(2, 2, 5);
        test.setValue(2, 3, 2);
        test.setValue(3, 0, -5);
        test.setValue(3, 1, 5);
        test.setValue(3, 2, -1);
        test.setValue(3, 3, 8);
        test.setUpMainWindow();
    }
}
