package com.project.my.classcodes.day0626.ir.javacup.salary;

public class HrmSalaryListCreator extends SalaryListCreator {

	public HrmSalaryListCreator(Encoder encoder) {
		super(encoder);
	}

	@Override
	protected String doCreate(Employee[] employees) {
		StringBuilder result = new StringBuilder();
		String code = null;
		String itemSeperator = null;
		String strSalary = null;
		for (int i = 0; i < employees.length; i++) {
			code = employees[i].getCode();
			code = encoder.setMaxLength(8).encode(code);
			result.append(code);
			itemSeperator = this.getItemSeparator();
			result.append(itemSeperator);
			strSalary = String.valueOf(employees[i].getSalary());
			strSalary = encoder.setMaxLength(10).encode(strSalary);
			result.append(strSalary);
			if (i != employees.length - 1)
				result.append(getRecordSeparator());
		}
		return result.toString();
	}

}
