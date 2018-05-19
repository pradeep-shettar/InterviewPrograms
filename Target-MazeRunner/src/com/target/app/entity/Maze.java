/**
 * 
 */
package com.target.app.entity;

import java.util.List;

/**
 * @author Pradeep.Shettar
 *
 */
public class Maze {

	int entryIndex;
	int exitIndex;
	List<MazeWall> mazeWalls;

	/**
	 * 
	 */
	public Maze() {
	}

	/**
	 * @param entryIndex
	 * @param exitIndex
	 * @param mazeWalls
	 */
	public Maze(int entryIndex, int exitIndex, List<MazeWall> mazeWalls) {
		super();
		this.entryIndex = entryIndex;
		this.exitIndex = exitIndex;
		this.mazeWalls = mazeWalls;
	}

	/**
	 * @return the entryIndex
	 */
	public int getEntryIndex() {
		return entryIndex;
	}

	/**
	 * @param entryIndex
	 *            the entryIndex to set
	 */
	public void setEntryIndex(int entryIndex) {
		this.entryIndex = entryIndex;
	}

	/**
	 * @return the exitIndex
	 */
	public int getExitIndex() {
		return exitIndex;
	}

	/**
	 * @param exitIndex
	 *            the exitIndex to set
	 */
	public void setExitIndex(int exitIndex) {
		this.exitIndex = exitIndex;
	}

	/**
	 * @return the mazeWalls
	 */
	public List<MazeWall> getMazeWalls() {
		return mazeWalls;
	}

	/**
	 * @param mazeWalls
	 *            the mazeWalls to set
	 */
	public void setMazeWalls(List<MazeWall> mazeWalls) {
		this.mazeWalls = mazeWalls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entryIndex;
		result = prime * result + exitIndex;
		result = prime * result + ((mazeWalls == null) ? 0 : mazeWalls.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maze other = (Maze) obj;
		if (entryIndex != other.entryIndex)
			return false;
		if (exitIndex != other.exitIndex)
			return false;
		if (mazeWalls == null) {
			if (other.mazeWalls != null)
				return false;
		} else if (!mazeWalls.equals(other.mazeWalls))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Maze [entryIndex=" + entryIndex + ", exitIndex=" + exitIndex + ", mazeWalls=" + mazeWalls + "]";
	}

}