package com.pga;

public class TableInfo {
	private int tableId;
	private int capacity;
	private boolean isOccupied;

	public TableInfo(int tableId, int capacity, boolean isOccupied) {
		super();
		this.tableId = tableId;
		this.capacity = capacity;
		this.isOccupied = isOccupied;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	
	
}
