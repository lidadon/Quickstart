package ru.geekbrains.homework4;

public class Triangle {
    public static double calculateTriangleSquare (int a, int b, int c) throws DegenerateTriangleException, TriangleNotExistsException {
        if (a <= 0 || b <= 0 || c <= 0) throw new TriangleNotExistsException();
        if (a > b + c || b > a + c || c > a + b) throw new DegenerateTriangleException();
        double halfPerimeter = (a + b + c) / 2;
        double triangleSquare = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
        return triangleSquare;
    }
}
