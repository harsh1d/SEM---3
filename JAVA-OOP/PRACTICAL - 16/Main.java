package PRACTICAL - 16;

public class Main {
    class Rectangle {
    protected int len;
    protected int wid;

     public Rectangle(){
        len = wid = 0;
    }

    public Rectangle(int x, int y){
        len = x;
        wid = y;
    }


    void show(){
        System.out.println("Length: " + len + " meter");
        System.out.println("Width: " + wid + " meter");
    }


    void area(){
        System.out.println("Area: " + (len * wid) + " meter square");
    }
}


class Box extends Rectangle{
    protected int height;

     public Box(int len, int wid, int h){

        super(len, wid);
        height = h;
    }

     void show(){
        super.show(); 
        System.out.println("Height: " + height + " meter");
    }


    void volume(){
        System.out.println("Volume: " + (len * wid * height) + " meter cube");
    }
}


class BoxWeight extends Box{
    int weight;

      public BoxWeight(int len, int wid, int height, int w){
               super(len, wid, height);
        weight = w;
    }

    void show(){
        super.show();  
        System.out.println("Weight: " + weight + " kilograms");
    }
}

public class Main{
    public static void main(String[] args) {
        Rectangle R = new Rectangle(2, 3);
        R.show(); 
        System.out.println("");


        Box B = new Box(21, 32, 10);
        B.show(); 
        System.out.println("");


        BoxWeight Bw = new BoxWeight(11, 22, 33, 7);
        Bw.show(); 
        System.out.println("");
    }
}
}
