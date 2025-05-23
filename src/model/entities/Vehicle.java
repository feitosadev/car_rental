package model.entities;

import java.util.Objects;

public class Vehicle {

	private String model;
	
	public Vehicle() {}

	public Vehicle(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(model, other.model);
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + "]";
	}
}