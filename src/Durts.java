import java.util.Scanner;

public class Durts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().trim().split(" ");
        int circleX = Integer.parseInt(firstLine[0]);
        int circleY = Integer.parseInt(firstLine[1]);

        String secondLine = scanner.nextLine();
        int radius = Integer.parseInt(secondLine);

        double[] horizontalYdimensions = {(circleY + 0.5*radius), (circleY - 0.5*radius)};
        double[] horizontalXdimensions = {(circleX - radius), (circleX + radius)};

        double[] verticalYdimensions = {(circleY + radius), (circleY - radius)};
        double[] verticalXdimensions = {(circleX - 0.5*radius), (circleX + 0.5*radius)};

        String thirdLine = scanner.nextLine();
        int numberOfDarts = Integer.parseInt(thirdLine);

        for (int i = 0; i < numberOfDarts; i ++) {
            int hitX = scanner.nextInt();
            int hitY = scanner.nextInt();

            if (isInside(horizontalXdimensions, horizontalYdimensions, hitX, hitY)||
                            isInside(verticalXdimensions, verticalYdimensions, hitX, hitY)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isInside(double[] xDim, double[] yDim, int hitX, int hitY) {
        if (hitX >= xDim[0] && hitX <= xDim[1]) {
            if (hitY <= yDim[0] && hitY >= yDim[1]) {
                return true;
            }
        }
        return false;
    }
}
