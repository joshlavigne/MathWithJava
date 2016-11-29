package post4;

public class TriangleSquare {
	public static void main(String[] args){
		boolean triangle = false;
		long square = 0;
		
		for(long i = 1; i < 50000000; i++){
			triangle = false;
			square = i * i;
			triangle = isTriangle(square);
			if(triangle){
				System.out.println(square + "");
			}
		}	
	}
	
	public static boolean isTriangle(long num){
		double x = num*-2;
		double n = (-1 + Math.sqrt(1 - 4 * x))/2;
		
		return n % 1 == 0;
	}
}