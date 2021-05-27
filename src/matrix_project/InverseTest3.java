package matrix_project;

public class InverseTest3 {
    public static void main(String[] args) {
        // 3 x 3 test
        // should result in
        //  | -1.522 |  0.891 |  1.109 |
        //  |  0.087 | -0.065 |  0.065 |
        //  |  0.826 | -0.370 | -0.630 |
        Inverse test = new Inverse(3, 3);
        test.setValue(0, 0, 3);
        test.setValue(0, 1, 7);
        test.setValue(0, 2, 6);
        test.setValue(1, 0, 5);
        test.setValue(1, 1, 2);
        test.setValue(1, 2, 9);
        test.setValue(2, 0, 1);
        test.setValue(2, 1, 8);
        test.setValue(2, 2, 1);
        test.setUpMainWindow();
    }
}
