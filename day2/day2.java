import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class day2{
	//make an array, feed line into array, split array, check if values are all between -3 to -1, 1 to 3, then check if all increasing or decreasing (or do in last step)
	//if all true, increment x, then parse next line in scanner

	public static void main(String[] args) {
		try{
			List<String> data = Files.readAllLines(Paths.get("./data.txt"));
			for(String value:data){
				return;
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
}