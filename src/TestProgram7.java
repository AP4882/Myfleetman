

interface drawable{
	
	void draw();
}
 public class TestProgram7 implements drawable{

	public void draw () {
		System.out.println("Drawing circle");
				
	}
	
	
}

class finalTest1{
	
	public static void main(String args[]){  
		drawable d = new TestProgram7();
		d.draw();
		
	}
	
}