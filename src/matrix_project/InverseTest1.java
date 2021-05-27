package matrix_project;

public class InverseTest1 {
    public static void main(String[] args) {
        // 2 x 2 test
        // should result in
        //  | -0.2 | 0.3  |
        //  |  0.4 | -0.1 |
        Inverse test = new Inverse(2, 2);
        test.setValue(0, 0, 1);
        test.setValue(0, 1, 3);
        test.setValue(1, 0, 4);
        test.setValue(1, 1, 2);
        test.setUpMainWindow();
    }
}
