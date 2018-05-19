/**
 * 
 */
package com.target.app.util;

import java.util.ArrayList;
import java.util.List;

import com.target.app.entity.Maze;
import com.target.app.entity.MazeWall;
import com.target.app.enumeration.Movement;
import com.target.app.exception.ExtryException;

/**
 * @author Pradeep.Shettar
 *
 */
public class MazeResolver {

	List<Movement> shortestMovements;
	int shortestStepsTaken;

	List<Movement> currentTravesal;
	int currentTraversalSteps;
	int currentColumnIndex;
	int currentRowIndex;
	boolean startingDone = false;
	boolean reached = false;
	Movement previousMove;

	/**
	 * 
	 */
	public MazeResolver() {
	}

	/**
	 * @return the shortestMovements
	 */
	public List<Movement> getShortestMovements() {
		return shortestMovements;
	}

	/**
	 * @return the shortestStepsTaken
	 */
	public int getShortestStepsTaken() {
		return shortestStepsTaken;
	}

	/**
	 * @return the currentTravesal
	 */
	public List<Movement> getCurrentTravesal() {
		return currentTravesal;
	}

	/**
	 * @return the currentTraversalSteps
	 */
	public int getCurrentTraversalSteps() {
		return currentTraversalSteps;
	}

	/**
	 * @param mazeStructure
	 * @throws ExtryException
	 */
	public void process(Maze mazeStructure) throws ExtryException {
		currentColumnIndex = mazeStructure.getEntryIndex();
		int exitIndex = mazeStructure.getExitIndex();
		List<MazeWall> mazeWalls = mazeStructure.getMazeWalls();
		shortestStepsTaken = (mazeStructure.getMazeWalls().size()+2) * (mazeStructure.getMazeWalls().size()+2);
		boolean returingFromEnd = false;
//		while (true) {
			while (!reached) {
				if (!startingDone && currentRowIndex == 0) {
					MazeWall mazeWall = mazeWalls.get(currentRowIndex);
					List<Integer> openIndeces = mazeWall.getOpenIndeces();
					if (!openIndeces.contains(currentColumnIndex)) {
						throw new ExtryException("No entry through second wall!");
					}
					startingDone = true;
					move(Movement.DOWN, mazeWalls.size() + 1);
				} else if (startingDone && currentRowIndex == 0
						&& currentColumnIndex == mazeStructure.getEntryIndex()) {
					Movement movement = previousMove;
					if ((isOpenDownwards(mazeWalls) && movement != Movement.UP)
							|| (isOpenLeft(mazeWalls) && movement != Movement.RIGHT)
							|| (isOpenRight(mazeWalls) && movement != Movement.LEFT)) {
						return;
					}
				} else {
					if (previousMove != Movement.UP && isOpenDownwards(mazeWalls,exitIndex, returingFromEnd)) {
						move(Movement.DOWN, mazeWalls.size() + 1);
						if (returingFromEnd) {
							returingFromEnd = false;
						}
					} else if (previousMove != Movement.RIGHT
							&& isOpenLeft(mazeWalls)) {
						move(Movement.LEFT, mazeWalls.size() + 1);
					} else if (previousMove != Movement.LEFT
							&& isOpenRight(mazeWalls)) {
						move(Movement.RIGHT, mazeWalls.size() + 1);
					} else if (previousMove != Movement.DOWN
							&& isOpenUpwards(mazeWalls)) {
						move(Movement.UP, mazeWalls.size() + 1);
					} else {
						moveToPreviousState();
					}
				}
//			}
			if (shortestStepsTaken > currentTraversalSteps) {
				shortestMovements = new ArrayList<>();
				for (Movement movement : currentTravesal) {
					shortestMovements.add(movement);
				}
				shortestStepsTaken = currentTraversalSteps;
				currentTraversalSteps = 0;
				reached = false;
				returingFromEnd = true;
				moveToPreviousState();
			}
		}

	}

	/**
	 * @param mazeWalls
	 * @param exitIndex
	 * @return
	 */
	private boolean isOpenDownwards(List<MazeWall> mazeWalls, int exitIndex, boolean returnedFromEnd) {
		if (currentRowIndex < mazeWalls.size() && currentRowIndex >= 0) {
			MazeWall nextMazeWall = mazeWalls.get(currentRowIndex);
			if (nextMazeWall.getOpenIndeces() != null && nextMazeWall.getOpenIndeces().contains(currentColumnIndex)) {
				return true;
			}
		}
		else if (!returnedFromEnd && currentRowIndex == mazeWalls.size() && exitIndex == currentColumnIndex) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	private void moveToPreviousState() {
		if (previousMove.equals(Movement.DOWN)) {
			currentRowIndex--;
			previousMove = Movement.UP;
		} else if (previousMove.equals(Movement.UP)) {
			currentRowIndex++;
			previousMove = Movement.DOWN;
		} else if (previousMove.equals(Movement.LEFT)) {
			currentColumnIndex++;
			previousMove = Movement.RIGHT;
		} else if (previousMove.equals(Movement.RIGHT)) {
			currentColumnIndex--;
			previousMove = Movement.LEFT;
		}
		if (!currentTravesal.isEmpty()) {
			currentTravesal.remove(currentTravesal.size() - 1);
		}
	}

	/**
	 * @param mazeWalls
	 * @return
	 */
	private boolean isOpenUpwards(List<MazeWall> mazeWalls) {
		if (currentRowIndex - 2 < mazeWalls.size() && currentRowIndex - 2 >= 0) {
			MazeWall nextMazeWall = mazeWalls.get(currentRowIndex - 2);
			if (nextMazeWall.getOpenIndeces() != null && nextMazeWall.getOpenIndeces().contains(currentColumnIndex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param mazeWalls
	 * @return
	 */
	private boolean isOpenRight(List<MazeWall> mazeWalls) {
		if (currentRowIndex - 1 < mazeWalls.size() && currentRowIndex - 1 >= 0) {
			MazeWall mazeWall = mazeWalls.get(currentRowIndex - 1);
			List<Integer> openIndeces = mazeWall.getOpenIndeces();
			if (openIndeces != null && openIndeces.contains(currentColumnIndex + 1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param mazeWalls
	 * @return
	 */
	private boolean isOpenLeft(List<MazeWall> mazeWalls) {
		if (currentRowIndex - 1 < mazeWalls.size() && currentRowIndex - 1 >= 0) {
			MazeWall mazeWall = mazeWalls.get(currentRowIndex - 1);
			List<Integer> openIndeces = mazeWall.getOpenIndeces();
			if (openIndeces != null && openIndeces.contains(currentColumnIndex - 1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param i
	 * @param mazeWallIndex
	 * @param mazeWalls
	 * @return
	 */
	private boolean isOpenDownwards(List<MazeWall> mazeWalls) {
		if (currentRowIndex < mazeWalls.size() && currentRowIndex >= 0) {
			MazeWall nextMazeWall = mazeWalls.get(currentRowIndex);
			if (nextMazeWall.getOpenIndeces() != null && nextMazeWall.getOpenIndeces().contains(currentColumnIndex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param i
	 * @param down
	 */
	private void move(Movement direction, int lastRowIndex) {
		currentTraversalSteps++;
		if (currentTravesal == null) {
			currentTravesal = new ArrayList<>();
		}
		previousMove = direction;
		if (direction == Movement.DOWN) {
			if (!currentTravesal.isEmpty() && currentTravesal.get(currentTravesal.size() - 1).equals(Movement.UP)) {
				currentTravesal.remove(currentTravesal.size() - 1);
			}
			else currentTravesal.add(direction);
			currentRowIndex++;
			if (currentRowIndex == lastRowIndex) {
				reached = true;
			}
		} else if (direction == Movement.UP) {
			if (!currentTravesal.isEmpty() && currentTravesal.get(currentTravesal.size() - 1).equals(Movement.DOWN)) {
				currentTravesal.remove(currentTravesal.size() - 1);
			}
			else 
				currentTravesal.add(direction);
			currentRowIndex--;
		} else if (direction == Movement.LEFT) {
			if (!currentTravesal.isEmpty() && currentTravesal.get(currentTravesal.size() - 1).equals(Movement.RIGHT)) {
				currentTravesal.remove(currentTravesal.size() - 1);
			}
			else currentTravesal.add(direction);
			currentColumnIndex--;
		} else if (direction == Movement.RIGHT) {
			if (!currentTravesal.isEmpty() && currentTravesal.get(currentTravesal.size() - 1).equals(Movement.LEFT)) {
				currentTravesal.remove(currentTravesal.size() - 1);
			}
			else currentTravesal.add(direction);
			currentColumnIndex++;
		}
	}

}
