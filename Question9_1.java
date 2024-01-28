package Assignment7;
//Nathan Lamoureux
//Creating rectangle class
 class Rectangle {

     double width;
     double height;

    Rectangle() {
        width = 1;
        height = 1;
    }
    Rectangle(double newWidth, double newHeight){
        width = newWidth;
        height = newHeight;
    }
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return width * 2 + height * 2;
    }
}
// Main program
public class Question9_1 {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);

        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        //Display measurements for rectangle 1
        System.out.println("\n Rectangle 1");
        System.out.println("-------------");
        System.out.println("Width:     " + rectangle1.width);
        System.out.println("Height:     " + rectangle1.height);
        System.out.println("Area:       " + rectangle1.getArea());
        System.out.println("Perimeter:        " + rectangle1.getPerimeter());

        //Display measurements for rectangle 2
        System.out.println("\n Rectangle 2");
        System.out.println("-------------");
        System.out.println("Width:       " + rectangle2.width);
        System.out.println("Height:         " + rectangle2.height);
        System.out.println("Area:         " + rectangle2.getArea());
        System.out.println("Perimeter:          " + rectangle2.getPerimeter());
    }

}
