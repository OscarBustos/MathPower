package com.bustos.oscar.mathpower.common.services.pythagoras;

public class Pythagoras {

	public static class Builder {

		private double catheti1;
		private double catheti2;
		private double hypotenuse;

		public Pythagoras build() {
			Pythagoras pythagoras = new Pythagoras();
			pythagoras.setCatheti1(catheti1);
			pythagoras.setCatheti2(catheti2);
			pythagoras.setHypotenuse(hypotenuse);
			return pythagoras;
		}

		public Builder catheti1(double catheti1) {
			this.catheti1 = catheti1;
			return this;
		}

		public Builder catheti2(double catheti2) {
			this.catheti2 = catheti2;
			return this;
		}

		public Builder hypotenuse(double hypotenuse) {
			this.hypotenuse = hypotenuse;
			return this;
		}

	}

	private Pythagoras() {

	}

	private double catheti1;
	private double catheti2;
	private double hypotenuse;

	public double getCatheti1() {
		return catheti1;
	}

	public void setCatheti1(double catheti1) {
		this.catheti1 = catheti1;
	}

	public double getCatheti2() {
		return catheti2;
	}

	public void setCatheti2(double catheti2) {
		this.catheti2 = catheti2;
	}

	public double getHypotenuse() {
		return hypotenuse;
	}

	public void setHypotenuse(double hypotenuse) {
		this.hypotenuse = hypotenuse;
	}

}
