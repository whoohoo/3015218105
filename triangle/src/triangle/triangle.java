package triangle;

import java.util.Scanner;

public class triangle {
	public static void main(String[] args) {
		System.out.println("三角形判断");
		 @SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);  
	        double a=0, b=0, c=0;  
	        System.out.printf("输入a的长度：");  
	        a =reader.nextDouble();  
	        System.out.printf("输入b的长度：");  
	        b =reader.nextDouble();  
	        System.out.printf("输入c的长度：");  
	        c =reader.nextDouble();  
	        
	        System.out.println(triangle(a,b,c));
	}
	
	public static String triangle(double a,double b,double c) {
		if(a < b+c&&b < a+c&&c <a+b){  
	            if(a==b&&b==c){  
	                return "The triangle is equilateral.";  
	            }  
	            else if(a==b||a==c||c==b){  
	                return "The triangle is isosceles.";  
	            }  
	            else {  
	                return "The triangle is scalene.";  
	            }  
	              
	        }  
	        else{  
	            return "构不成三角形";  
	        }  
	}

}
