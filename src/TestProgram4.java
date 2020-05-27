
public class TestProgram4 {

	void m(){System.out.println("hello m");}  
	void n(){  
	System.out.println("hello n");  
	//m();//same as this.m()  
	this.m();
	}  
	
	public static void main(String args[]){  
		TestProgram4 a=new TestProgram4();  
	a.n();  
	}
	
	
}
