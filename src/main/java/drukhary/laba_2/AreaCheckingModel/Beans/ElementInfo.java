package drukhary.laba_2.AreaCheckingModel.Beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ElementInfo implements Serializable {
    private static final long serialVersionUID = 2041275512219239990L;

    public ElementInfo() {
    }

    private Point point;
    private Double radius;
    private boolean result;
    private LocalDateTime date;
    private double processTime;

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setProcessTime(double processTime) {
        this.processTime = processTime;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getFormatDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd - HH:mm:ss"));
    }

    public double getProcessTime() {
        return processTime;
    }

    public Double getRadius() {
        return radius;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isResult() {
        return result;
    }

    public String getFormatResult() {
        return this.result ? "Точка входит в область" : "Точка не входит в область";
    }

    public String getFormatProcessTime() {
        return java.math.BigDecimal.valueOf(this.processTime).toPlainString() + "c";
    }
}
