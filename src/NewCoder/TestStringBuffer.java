package NewCoder;

public class TestStringBuffer {
	public static void operator(StringBuffer x,StringBuffer y){
		x.append(y);
		System.out.println("y="+y);
		System.out.println("x="+x);
		//y = x;
		y.append("378");
	}
	public static void main(String[] args){
		StringBuffer a=new StringBuffer("A");
		StringBuffer b=new StringBuffer("B");
		operator(a, b);
		System.out.println(a+","+b);
	}
}
