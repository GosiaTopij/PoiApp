import java.util.*;
import com.model.TestModel;

public class Lista {
	public List<TestModel> findAll() {
		try {			
			List<TestModel> result = new ArrayList<TestModel>(); 
			result.add(new TestModel("p1","name1", "1000"));
			result.add(new TestModel("p2","name2", "2000"));
			result.add(new TestModel("p3","name3", "3000"));
			result.add(new TestModel("p4","name4", "400", "coœ"));			
			return result;
		} catch (Exception e) {
			return null;
		}
		
	}
}
