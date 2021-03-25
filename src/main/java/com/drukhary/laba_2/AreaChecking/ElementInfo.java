package com.drukhary.laba_2.AreaChecking;

import java.time.LocalDateTime;

public class ElementInfo {
    private Point point;
    private Double radius;
    private boolean result;
    private LocalDateTime data;
    private double processTime;

    public void setData(LocalDateTime data) {
        this.data = data;
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

    public LocalDateTime getData() {
        return data;
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
    //    public String getElemTableHTML(){
//        return "<tr>"+
//        "<td>"+data.toString()+"</td>"+
//        "<td>"+processTime+"</td>"+
//        "<td>"+""+"</td>"+
//        "<td>"+" "+"</td>"+
//        "<td>"+" "+"</td>"+
//        "</tr>";
//    }
}
