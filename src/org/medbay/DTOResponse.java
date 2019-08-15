package org.medbay;

import java.io.Serializable;

public class DTOResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public DTOResponse() {
		// no-argument constructor
	}
	
	public DTOResponse(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
