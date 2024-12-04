import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Math;

public class day1{
	/* part 1: make two lists, list A and list B, sort each from least to greatest, then
	find distance between two values, then add all distance values into 
	one and return said integer.*/

	public static Map<Integer, Integer> data = new HashMap<>();
	public static List<Integer> list1 = new LinkedList<>();
	public static List<Integer> list2 = new LinkedList<>();
	public static Map<Integer, Integer> similarityMap = new HashMap<>();

	public static void getData(){
		//method to read data from file and add to "data" hashmap
		try{
			Scanner scanner = new Scanner(new File("data.txt"));
			while (scanner.hasNextLine()){
				data.put(scanner.nextInt(),scanner.nextInt());
			}
			scanner.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	//takes given list and sorts by key, returns as list
	public static List<Integer> sortByKey(Map<Integer,Integer> map){
		List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list, (l1, l2) -> l1.getKey().compareTo(l2.getKey()));

		List<Integer> sortedKeyList = new LinkedList<Integer>();
		for (Map.Entry<Integer,Integer> x : list){
			sortedKeyList.add(x.getKey());
		}
		return sortedKeyList;
	}

	//takes given list and sorts by value, returns as list
	public static List<Integer> sortByValue(Map<Integer,Integer> map){
		List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer,Integer> l1, Map.Entry<Integer,Integer> l2){
				return (l1.getValue().compareTo(l2.getValue()));
			}
		});

		List<Integer> sortedValueList = new LinkedList<Integer>();
		for (Map.Entry<Integer,Integer> x : list){
			sortedValueList.add(x.getValue());
		}
		return sortedValueList;
	}

	//manhattan distance calc
	public static int distance(List<Integer> l1, List<Integer> l2){
		int distanceSum = 0;
		for(int i=0;i<l1.size();i++){
			distanceSum += (Math.abs(l1.get(i) - l2.get(i)));
		}
		return distanceSum;
	}

	/* part 2: take sorted lists, put into hashmap, iterate through and multiply amount of key/value pairs, 
	add product to integer and return it */

	/* if value is 3 in list1, find amount of times 3 is in list2, multiply 3 by that value, add to similarity score, go next */

	public static int similarity(Map<Integer,Integer> map){
		int similarityScore = 0;
		for(int i=0;i<list1.size();i++){
			int leftListValue = list1.get(i);
			int matchingTotal = 0;
			for(int j=0;j<list2.size();j++){
				if(leftListValue == list2.get(j)){
					matchingTotal++;
				}
			}
			similarityScore += leftListValue*matchingTotal;
			matchingTotal = 0;
		}
		return similarityScore;
	}

	public static void main(String[] args) {
		//sort data with methods
		getData();
		list1 = sortByKey(data);
		list2 = sortByValue(data);

		for(int i=0;i<list1.size();i++){
			similarityMap.put(list1.get(i), list2.get(i));
		}

		System.out.println("part1: "+distance(list1,list2));
		System.out.println("part2: "+similarity(similarityMap));
	}
}

