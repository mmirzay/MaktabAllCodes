package com.project.my.classcodes.day0626.ir.javacup.salary;

public abstract class SalaryListCreator {

	protected Encoder encoder;

	public SalaryListCreator(Encoder encoder) {
		this.encoder = encoder;
	}

	public String create(Employee[] employees) {
		String rawStr = doCreate(employees);
		return encoder.encode(rawStr);
	}

	protected abstract String doCreate(Employee[] employees);

	protected String getRecordSeparator() {
		return System.lineSeparator();
	}

	protected String getItemSeparator() {
		return " ";
	}
}
