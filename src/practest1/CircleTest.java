package practest1;
public class CircleTest {

	public static void main(String[] args) {
		try{
			Circle c=new Circle(7);
			System.out.println(c.getCircumference());

			c=new Circle(-7);
			System.out.println(c.getCircumference());
		}
		catch (IllegalRadiusException ex){
			System.out.println("Illegal Radius");
		}
	}
}
