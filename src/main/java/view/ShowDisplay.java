package view;

public class ShowDisplay {
    private static final String INPUT_MESSAGE = "좌표를 입력해주세요.";
    private static final String INVALID_INPUT_ERROR_MESSAGE = "입력 값이 유효하지 않습니다";
    private static final String LINE_PRINT_DISTANCE = "두 점 사이 거리는";
    private static final String SHAPE_PRINT_AREA = "%s의 넓이는 %f%n";

    private ShowDisplay(){}
    public static void showInputDisplay() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void showErrorDisplay() {
        System.out.println(INVALID_INPUT_ERROR_MESSAGE);
    }

    public static void showArea(String shape, double area) {
        if (shape.equals("직선")) {
            System.out.println(LINE_PRINT_DISTANCE + area);
            return;
        }

        System.out.printf(SHAPE_PRINT_AREA, shape, area);
    }
}
