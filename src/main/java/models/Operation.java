package models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Operation {

	
	@Id
	@GeneratedValue
	private int id;
	
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
