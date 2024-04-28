package minegame.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Map {
	int width;	
	int mineNum;
	int[][] invisibleMineMap;
	int[][] visibleMap;
	HashMap<Integer, Integer> mineLocation;  
	
	public Map(int width, int mineNum) {
		this.width = width;
		this.mineNum = mineNum;
		
		// create map
		System.out.println("Create new   "+ width+" X "+ width + "  map");
		invisibleMineMap = new int[width][width];
		visibleMap = new int[width][width];
		for (int i = 0; i < width * width; i++) {
			invisibleMineMap[i / width][i % width] = 0;
			visibleMap[i / width][i % width] = 0;
		}
		
		// create mines
		System.out.println("Create new "+ mineNum +"  mines");
		Random r = new Random();
		mineLocation = new HashMap<>(); 
		for (int i = 0; i < mineNum; i++) {
			int Location = r.nextInt(width * width);
			while (mineLocation.containsValue(Location))   // check repetition
				Location = r.nextInt(width * width);			
			mineLocation.put(i, Location);
		}
		
		// deploy mines
		System.out.println("Mines have been deployed at the following positions");
		for (int i = 0; i < mineNum; i++) {
			int x = mineLocation.get(i) / width;
			int y = mineLocation.get(i) % width;
			System.out.println(x+", "+y);
			invisibleMineMap[x][y] = 1;
		}
		
		printMap(invisibleMineMap);
		
	}
		
	public int findMine(int x, int y) {
		int pos = (x * width) + y;
		
		if (mineLocation.containsValue(pos)) {
			System.out.println("   Boom! you find mine at ("+x+", "+y+")");		
			return pos;
		}
		else { 
			System.out.println("   You did not find any mines at ("+x+", "+y+")");
			return -1;
		}
		
	}

	public void printMap(int[][] a) {
		System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][0]);
            for (int j = 1; j < a[0].length; j++) 
                System.out.print(" " + a[i][j]);            
            System.out.println();
        }
    }
	
	public void updateVisibleMap(int x, int y) {
		visibleMap[x][y]=1;
		printMap(visibleMap);
	}
	
	public int getVisibleMapIndex(int x, int y) {
		if (visibleMap[x][y] == 1) {
			return 1;
		} else {
			return 0;
		}
	}
		
	
}
