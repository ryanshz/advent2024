import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2{
	//make an array, feed line into array, split array, check if all differences are all between -3 to -1, 1 to 3, then check if all increasing or decreasing (or do in last step)
	//if all true, increment x, then parse next line

	public static int safeReports = 0;

	public static boolean safetyCheck(List<Integer> list){
		List<Integer> diffListPos = new ArrayList<>();
		List<Integer> diffListNeg = new ArrayList<>();

		//checks if at least 1 and at most 3
		int start = 0;
		int end = 1;
		while(end != list.size()){
			int diff = list.get(start) - list.get(end);
			if(diff > 0 && (diff <= 3 && diff >= 1)){
				diffListPos.add(diff);
			}else if(diff < 0 && (diff >= -3 && diff <= -1)){
				diffListNeg.add(diff);
			}else if(diff == 0){
				System.out.println("EQUALS ZERO: NOT SAFE");
				System.out.println("list: "+list);
				System.out.println("positive differences: "+diffListPos);
				System.out.println("negative differences: "+diffListNeg);
				return false;
			}else{
				System.out.println("NOT WITHIN LEVELS: NOT SAFE");
				System.out.println("list: "+list);
				System.out.println("positive differences: "+diffListPos);
				System.out.println("negative differences: "+diffListNeg);
				return false;
			}
			start++;
			end++;
		}
		System.out.println("positive differences: "+diffListPos);
		System.out.println("negative differences: "+diffListNeg);
		System.out.println("pos list size: "+diffListPos.size());
		System.out.println("neg list size: "+diffListNeg.size());
		//checks if all dec or inc
		if((diffListPos.size() > 0) && (diffListNeg.size() > 0)){
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		List<Integer> integerList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));

		String line;
		while((line=br.readLine()) != null){
			String[] splitLine = line.split(" ");
			for(int i=0;i<splitLine.length;i++){
				integerList.add(Integer.parseInt(splitLine[i]));
			}
			if(safetyCheck(integerList) == true){
				safeReports++;
				System.out.println("SAFE: "+integerList);
				System.out.println("number of safe reports: "+safeReports);
				System.out.println("-----");
			}else{
				System.out.println("NOT SAFE: "+integerList);
				System.out.println("-----");
			}
			integerList.clear();
		}
		System.out.println("number of safe reports: "+safeReports);
	}
}