package models;

public class User {
	private int id;
	private String pin;

	// Modelo básico de usuario

	public User() {
		super();
		this.id = 0;
		this.pin = "6969";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	

}
