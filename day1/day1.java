import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Math;

public class day1{
	/* part 1: make two lists, list A and list B, sort each from least to greatest, then
	find distance between two values, then add all distance values into 
	one and return said integer.*/

	public static List<Integer> list1 = new ArrayList<>();
	public static List<Integer> list2 = new ArrayList<>();

	public static void getData(){
		try{
			Scanner scanner = new Scanner(new File("data.txt"));
			while (scanner.hasNextLine()){
				list1.add(scanner.nextInt());
				list2.add(scanner.nextInt());
			}
			scanner.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	//manhattan distance calc
	public static int distance(List<Integer> l1, List<Integer> l2){
		int distanceSum = 0;
		for(int i=0;i<l1.size();i++){
			distanceSum += (Math.abs(l1.get(i) - l2.get(i)));
		}
		return distanceSum;
	}

	//part 2: take sorted lists, put into hashmap, iterate through and multiply amount of key/value pairs, add product to integer and return it

	//if value is 3 in list1, find amount of times 3 is in list2, multiply 3 by that value, add to similarity score, go next

	public static int similarity(){
		int similarityScore = 0;
		Map<Integer,Integer> duplicates = new HashMap<>();
		for(int value : list2){
			if(duplicates.containsKey(value)){
				duplicates.put(value, duplicates.get(value) + 1);
			}else{
				duplicates.put(value,1);
			}
		}
		for(int value : list1){
			if(duplicates.containsKey(value)){
				similarityScore += value * duplicates.get(value);
			}
		}
		return similarityScore;
	}

	public static void main(String[] args) {
		getData();
		//sort data with methods
		Collections.sort(list1);
		Collections.sort(list2);

		System.out.println("part1: "+distance(list1,list2));
		System.out.println("part2: "+similarity());
	}
}