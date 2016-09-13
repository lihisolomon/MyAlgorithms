package algorithms.demo;


import java.io.*;

import algorithms.mazeGenerators.*;
import io.*;
/**
 * Demo class
 */
public class Demo {
	/**
	 * run class the run the search
	 */
	public static void main(String[] args) {
	//public void run(int x,int y,int z){
		SimpleMaze3dGenerator m=new SimpleMaze3dGenerator();
		//GrowingTreeGenerator m=new GrowingTreeGenerator();lololo
		//Maze3d maze=m.generate(x,y,z);
		Maze3d maze=m.generate(6,6,6);
		//Maze3dSearchable searchableMaze=new Maze3dSearchable(maze);
		
		System.out.println(maze);
		System.out.println("_____________________________________________________________________");
		try {
			OutputStream out=new MyCompressorOutputStream(new FileOutputStream("1.maz")); 
			byte[] arr=maze.toByteArray();
			int counter=arr.length;
			while(counter>=255)
			{
				out.write(255);
				counter-=255;
			}
			out.write(counter);
			out.write(arr);
			out.flush();
			out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStream in;
		try {
			in = new MyDecompressorInputStream( new FileInputStream("1.maz"));
			int size=in.read();
			int sum=0;
			while(size==255)
			{	sum+=size;
				size=in.read();
			}
			sum+=size;
			byte b[]=new byte[sum]; 
			try {
				in.read(b);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			Maze3d loaded=new Maze3d(b); 
			System.out.println(loaded);
			System.out.println(loaded.equals(maze));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	/*/	System.out.println(maze);
		System.out.println("Start:");
		maze.getStartPosition().printPosition();
		System.out.println("end:");
		maze.getGoalPosition().printPosition();
		/*/
		
		/*/
		byte testMaze2[] = maze.toByteArray();
		Maze3d mazeLior=new Maze3d(testMaze2);
		System.out.println("\n\nNew maze : \n\n" + mazeLior);
		/*/
		
		/*/---------BFS-----------
		System.out.println("-----------BFS-------------:");
		BFS<Position> searcherBFS=new BFS<Position>();
		Solution<Position> s1=new Solution<Position>();
		s1=searcherBFS.search(searchableMaze);
		System.out.println(s1);
		
		//---------DFS-----------
		System.out.println("-----------DFS-------------:");
		DFS<Position> searcherDFS=new DFS<Position>();
		Solution<Position> s2=new Solution<Position>();
		s2=searcherDFS.search(searchableMaze);
		System.out.println(s2);
		
		System.out.println("finish!!!");
		/*/
	}

}
