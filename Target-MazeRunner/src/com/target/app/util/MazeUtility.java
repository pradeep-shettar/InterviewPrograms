/**
 * 
 */
package com.target.app.util;

import java.util.ArrayList;
import java.util.List;

import com.target.app.entity.Maze;
import com.target.app.entity.MazeWall;
import com.target.app.exception.ExtryException;

/**
 * @author Pradeep.Shettar
 *
 */
public class MazeUtility {

	/**
	 * @param mazeWallsInput
	 * @throws ExtryException
	 */
	public static Maze restructureMaze(String[] mazeWallsInput) throws ExtryException {
		Maze maze = new Maze();
		for (int wallIndex = 0; wallIndex < mazeWallsInput.length; wallIndex++) {
			if (wallIndex == 0) {
				int indexOfOpening = mazeWallsInput[wallIndex].indexOf(' ');
				if (indexOfOpening < 0) {
					throw new ExtryException("Entry point not found!");
				}
				maze.setEntryIndex(indexOfOpening);
				continue;
			} else if (wallIndex == mazeWallsInput.length - 1) {
				int indexOfOpening = mazeWallsInput[wallIndex].indexOf(' ');
				if (indexOfOpening < 0) {
					throw new ExtryException("Exit point not found!");
				}
				maze.setExitIndex(indexOfOpening);
				continue;
			}
			else if (maze.getMazeWalls() == null) {
				List<MazeWall> mazeWalls = new ArrayList<>();
				maze.setMazeWalls(mazeWalls);
			}
			List<MazeWall> mazeWalls = maze.getMazeWalls();
			mazeWalls.add(processMazeWall(mazeWallsInput[wallIndex], wallIndex));
		}
		return maze;
	}

	/**
	 * @param mazeWallInput
	 * @param wallIndex
	 * @return
	 */
	private static MazeWall processMazeWall(String mazeWallInput, int wallIndex) {
		List<Integer> openIndeces = new ArrayList<>();
		MazeWall mazeWall = new MazeWall();
		for (int charIndex = 0; charIndex < mazeWallInput.length(); charIndex++) {
			if (mazeWallInput.charAt(charIndex) == ' ') {
				openIndeces.add(charIndex);
			}
		}
		mazeWall.setOpenIndeces(openIndeces);
		mazeWall.setRowNumber(wallIndex);
		return mazeWall;
	}

}
