package triangle;

import java.util.Scanner;

public class triangle {
	public static void main(String[] args) {
		System.out.println("�������ж�");
		 @SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);  
	        double a=0, b=0, c=0;  
	        System.out.printf("����a�ĳ��ȣ�");  
	        a =reader.nextDouble();  
	        System.out.printf("����b�ĳ��ȣ�");  
	        b =reader.nextDouble();  
	        System.out.printf("����c�ĳ��ȣ�");  
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
	            return "������������";  
	        }  
	}

}
