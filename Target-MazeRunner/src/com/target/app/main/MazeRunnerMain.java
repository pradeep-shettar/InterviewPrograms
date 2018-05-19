/**
 * 
 */
package com.target.app.main;

import com.target.app.entity.Maze;
import com.target.app.exception.ExtryException;
import com.target.app.util.MazeResolver;
import com.target.app.util.MazeUtility;

/**
 * @author Pradeep.Shettar
 *
 *         Main class for maze problem
 */
public class MazeRunnerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] maze = { "#### #", " ##  #", "##  # ", "## ###" };
		//String[] maze = { "# ###", "     ", " ### ", "  ## ", "#    ", "#### " };
		Maze mazeStructure = null;
		try {
			mazeStructure = MazeUtility.restructureMaze(maze);
			System.out.println(mazeStructure.toString());
			MazeResolver mazeResolver = new MazeResolver();
			mazeResolver.process(mazeStructure);
			System.out.println("Shortest Solution:");
			System.out.println("Movements: " + mazeResolver.getShortestMovements().toString());
			System.out.println("steps: " + mazeResolver.getShortestMovements().toString());
		} catch (ExtryException entryException) {
			System.err.println(entryException.getMessage());
		}
	}
}
