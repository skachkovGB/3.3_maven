package org.example;

public class Triangle {

    public double areaTriangle (int a, int b, int c) throws MyTriangleException {
        if ( a==0 || b==0 || c==0) throw new MyTriangleException("One side have zero value");
        if ( a<0 || b<0 || c<0) throw new MyTriangleException("One side have negative value");
        if ( a+b<c || b+c<a || c+a<b) throw new MyTriangleException("Is not triangle, wrong side value");

        int p = (a+b+c)/2;                  // half perimeter
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
