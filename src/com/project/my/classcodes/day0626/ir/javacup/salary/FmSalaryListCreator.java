package com.project.my.classcodes.day0626.ir.javacup.salary;

public class FmSalaryListCreator extends SalaryListCreator {

	public FmSalaryListCreator(Encoder encoder) {
		super(encoder);

	}

	@Override
	protected String doCreate(Employee[] employees) {
		StringBuilder result = new StringBuilder();
		String code = null;
		String itemSeperator = null;
		String strSalary = null;
		for (int i = 0; i < employees.length; i++) {
			strSalary = String.valueOf(employees[i].getSalary());
			strSalary = encoder.setMaxLength(10).encode(strSalary);
			result.append(strSalary);
			itemSeperator = this.getItemSeparator();
			result.append(itemSeperator);
			code = employees[i].getCode();
			code = encoder.setMaxLength(10).encode(code);
			result.append(code);
			if (i != employees.length - 1)
				result.append(getRecordSeparator());
		}
		return result.toString();
	}

}
