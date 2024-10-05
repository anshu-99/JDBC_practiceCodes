
public class forNameUse {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Class.forName("Demo"); //will print static block
		Class.forName("Demo").newInstance(); //it will print normal block
	}
}
	class Demo{
		static {
			System.out.println("Static Block");
		}
		{
			System.out.println("Normal Block");
		}
	}