package drukhary.laba_2.AreaChecking;

//import AreaChecking.AreaCheckingExeption.OutOfRangeException;
//import AreaChecking.AreaCheckingExeption.WrongDataException;

import drukhary.laba_2.AreaChecking.AreaCheckingExeption.OutOfRangeException;
import drukhary.laba_2.AreaChecking.AreaCheckingExeption.WrongDataException;

import java.time.LocalDateTime;

public class PointChecker {

    public static ElementInfo CheckPoint(String x_0, String y_0, String r_0)
            throws NumberFormatException, OutOfRangeException, WrongDataException {
        long start = System.nanoTime();
        if (x_0 == null)
            throw new WrongDataException("Х не найден" + "(примите лабу, пожалуйста)");
        if (y_0 == null)
            throw new WrongDataException("Y не найден" + "(примите лабу, пожалуйста)");
        if (r_0 == null)
            throw new WrongDataException("R не найден" + "(примите лабу, пожалуйста)");
        double x = Double.parseDouble(x_0);
        double y = Double.parseDouble(y_0);
        int r = Integer.parseInt(r_0);
//        if (!(
//                ((Double.toString(x).length() >= x_0.length()))
//                        && (Double.toString(y).length() >= y_0.length())
//                        && (Integer.toString(r).length() >= r_0.length())
//                        && ((x >= -6.25 && x <= 6.25)
//                        && (y >= -6.25 && y <= 6.25)
//                        && (r >= 1 && r <= 5))
//        )) {
//            throw new OutOfRangeException("Данные выходят из области допустимых значений");
//        }
        if (!(r >= 1 && r <= 5))
            throw new OutOfRangeException("Радиус выходит из области допустимых значений[1,2,3,4,5]");
        if (!(y >= -6.25 && y <= 6.25))
            throw new OutOfRangeException("Y выходит из области допустимых значений(-6.25,6.25)");
        if (!(x >= -6.25 && x <= 6.25))
            throw new OutOfRangeException("X выходит из области допустимых значений(-6.25,6.25)");
        Point point = new Point(x, y);
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setRadius((double) r);
        elementInfo.setPoint(point);
        elementInfo.setDate(LocalDateTime.now());
        elementInfo.setResult(AreaCheckCondition(point, elementInfo.getRadius()));
        elementInfo.setProcessTime((System.nanoTime() - start) * 1.0 / 1000000000);
        return elementInfo;
    }

    protected static boolean AreaCheckCondition(Point point, double radius) {
        return (
                (point.getY() >= -radius && point.getY() <= 0) && (point.getX() >= -radius / 2 && point.getX() <= 0) ||
                        (point.getY() <= 0 && point.getX() >= 0 && point.getY() >= point.getX() - radius) ||
                        (point.getY() >= 0 && point.getX() <= 0 && point.getY() * point.getY() + point.getX() * point.getX() <= radius * radius)
        );
    }
}
