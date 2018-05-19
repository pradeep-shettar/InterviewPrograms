/**
 * 
 */
package com.target.app.entity;

import java.util.List;

/**
 * @author Pradeep.Shettar
 *
 *         Entity class for representing maze row.
 */
public class MazeWall {

	Integer rowNumber;

	List<Integer> openIndeces;

	/**
	 * 
	 */
	public MazeWall() {
	}
	/**
	 * @return the rowNumber
	 */
	public Integer getRowNumber() {
		return rowNumber;
	}

	/**
	 * @param rowNumber
	 *            the rowNumber to set
	 */
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	/**
	 * @return the openIndeces
	 */
	public List<Integer> getOpenIndeces() {
		return openIndeces;
	}

	/**
	 * @param openIndeces
	 *            the openIndeces to set
	 */
	public void setOpenIndeces(List<Integer> openIndeces) {
		this.openIndeces = openIndeces;
	}

	/**
	 * @param rowNumber
	 * @param openIndeces
	 */
	public MazeWall(Integer rowNumber, List<Integer> openIndeces) {
		super();
		this.rowNumber = rowNumber;
		this.openIndeces = openIndeces;
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
		result = prime * result + ((openIndeces == null) ? 0 : openIndeces.hashCode());
		result = prime * result + ((rowNumber == null) ? 0 : rowNumber.hashCode());
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
		MazeWall other = (MazeWall) obj;
		if (openIndeces == null) {
			if (other.openIndeces != null)
				return false;
		} else if (!openIndeces.equals(other.openIndeces))
			return false;
		if (rowNumber == null) {
			if (other.rowNumber != null)
				return false;
		} else if (!rowNumber.equals(other.rowNumber))
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
		return "MazeRow [rowNumber=" + rowNumber + ", openIndeces=" + openIndeces + "]";
	}

}