
public class TestPrograms3 {

	    int id;  
	    String name;  
	    //constructor to initialize integer and string  
	    TestPrograms3(int i,String n){  
	    id = i;  
	    name = n;  
	    }  
	    //constructor to initialize another object  
	    TestPrograms3(TestPrograms3 s){  
	    id = s.id;  
	    name =s.name;  
	    }  
	    void display(){System.out.println(id+" "+name);}  
}

class CopyConstructor{
	    public static void main(String args[]){  
	    TestPrograms3 s1 = new TestPrograms3(111,"Karan");  
	    TestPrograms3 s2 = new TestPrograms3(112,"Ashish");
	    TestPrograms3 s3 = new TestPrograms3(s2);
	    s1.display();  
	    //s2.display();
	    s3.display();
	   }  
}

