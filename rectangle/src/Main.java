/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rectangle;

public class Main {


    public static void main(String[] args) {
        Rectangle Rectangle1 = new Rectangle();
        System.out.println("A Rectangle with a Width of " + Rectangle1.width + " and a Height of: " + Rectangle1.height);
        System.out.println("The area of the rectangle is: " + Rectangle1.getArea());
        System.out.println("The perimeter of the rectangle is: " + Rectangle1.getPerimeter());
        System.out.println("");

        Rectangle Rectangle2 = new Rectangle(4, 40);
        System.out.println("A Rectangle with a Width of " + Rectangle2.width + " and a Height of: " + Rectangle2.height);
        System.out.println("The area of the rectangle#2 is: " + Rectangle2.getArea());
        System.out.println("The perimeter of the rectangle#2 is: " + Rectangle2.getPerimeter());
        System.out.println("");

        Rectangle Rectangle3 = new Rectangle(3.5, 35.9);
        System.out.println("A Rectangle with a Width of " + Rectangle3.width + " and a Height of: " + Rectangle3.height);
        System.out.println("The area of the rectangle#3 is: " + Rectangle3.getArea());
        System.out.println("The perimeter of the rectangle#3 is: " + Rectangle3.getPerimeter());
    }


}

class Rectangle{
    double width = 1.0;
    double height = 1.0;
    double area;
    double perimeter;

Rectangle(){
}


Rectangle (double newWidth, double newHeight){
        width = newWidth;
        height = newHeight;
}
double getArea(){

    area = (height * width);
    return area;

}

double getPerimeter(){

    perimeter = 2*(height + width);
    return perimeter;

    }
}