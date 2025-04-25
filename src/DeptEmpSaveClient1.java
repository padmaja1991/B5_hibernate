import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeptEmpSaveClient1 {

	public static void main(String[] args) {
		Emp e1=new Emp(0, "rama", 100000.00, "developer", null);
		Emp e2=new Emp(0, "krishna", 100000.00, "tester", null);
		Emp e3=new Emp(0, "balaram", 100000.00, "programmer", null);
		Emp e4=new Emp(0, "vishnu", 200000.00, "hr", null);
		
		
		
		List<Emp> empList=new ArrayList<Emp>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		Dept d1=new Dept(0, "Datascience", "Hyderbad", empList);
		
		
		
		Session s=HSFactory.getSession();
		Transaction t=s.beginTransaction();
		
		try {
			
			s.save(d1);
			s.flush();
			t.commit();
			System.out.println("TX Success");
		} catch (Exception e) {
			t.rollback();
			System.out.println("TX Failed");
			e.printStackTrace();
		}
	}
}
