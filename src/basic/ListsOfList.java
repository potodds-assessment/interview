package basic;

import java.util.List;
import java.util.LinkedList;

public class ListsOfList {
	boolean alternate = false;
	
	public List<Object> setup() {
		List<Object> main = new LinkedList<>();
		
		List<Object> one = new LinkedList<>();
		one.add("a"); //
		one.add("b"); 
		one.add("c"); //
		one.add("d");

		List<List<Object>> seven = new LinkedList<>();
		List<Object> two = new LinkedList<>();
		two.add("e"); //
		two.add("f");
		two.add("g"); //
		seven.add(two);

		List<Object> six = new LinkedList<>();
		six.add("1"); 
		six.add("2");//
		six.add("3"); 
		seven.add(six);
		
		List<List<Object>> three = new LinkedList<>();
		List<Object> four = new LinkedList<>();
		four.add("h"); //
		four.add("i"); 
		four.add("j"); //
		four.add("k"); 
		three.add(four);

		List<Object> five = new LinkedList<>();
		five.add("l"); //
		five.add("m"); 
		five.add("n"); //
		five.add("o"); 
		three.add(five);
		
		main.add(one);
		main.add(seven);
		main.add(three);
		
		return main;
	}

	public void print(List list) {
		for(Object z : list) {
			if ( alternate ) {
				System.out.println( z.toString().toUpperCase() );
				alternate = false;
			} else 
				alternate = true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void recurseList(List list) {
		if ( ! (list.get(0) instanceof List) ) {
			print( list );
			return;
		}
		
		for(int i=0; i<list.size(); i++) {
			recurseList( (List)list.get(i) );
		}
	}
	
	public void run() {
		List<Object> items = setup();
		for(Object item : items) {
			recurseList( (List<Object>)item );
		}
	}
	
	public static void main(String[] args) {
		new ListsOfList().run();
	}
}
