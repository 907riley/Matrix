package matrix_project;

public class InverseTest2 {
    public static void main(String[] args) {
        // 3 x 3 test
        // should result in
        //  |  0.192 | -0.041 | -0.068 |
        //  | -0.397 |  0.014 |  0.356 |
        //  |  0.260 |  0.301 | -0.164 |
        Inverse test = new Inverse(3, 3);
        test.setValue(0, 0, 8);
        test.setValue(0, 1, 2);
        test.setValue(0, 2, 1);
        test.setValue(1, 0, -2);
        test.setValue(1, 1, 1);
        test.setValue(1, 2, 3);
        test.setValue(2, 0, 9);
        test.setValue(2, 1, 5);
        test.setValue(2, 2, 1);
        test.setUpMainWindow();
    }
}
