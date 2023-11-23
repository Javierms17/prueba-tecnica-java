package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Operation {

	@Column
	private int pos;
	
	@Column
	private long result;
	
	@Column
	private int count;

	public Operation(int pos, long result, int count) {
		super();
		this.pos = pos;
		this.result = result;
		this.count = count;
	}


	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Operation() {
		super();
	}
	
}
