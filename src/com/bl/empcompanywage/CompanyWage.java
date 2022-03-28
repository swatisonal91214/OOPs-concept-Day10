package com.bl.empcompanywage;

public class CompanyWage {
	

		String company;
		int maxWorkingDay, maxWorkingHour, wagePerHour,
				totalWorkingHour;

		double totalSalary;

		public CompanyWage(String company, int maxWorkingDay,
				int maxWorkingHour, int wagePerHour) {
			this.company = company;
			this.maxWorkingDay = maxWorkingDay;
			this.maxWorkingHour = maxWorkingHour;
			this.wagePerHour = wagePerHour;
		}

		@Override
		public String toString() {
			return "Employee Company name : " + company
					+ "\nEmployee monthly wage : $"
					+ totalSalary + " USD"
					+ "\nEmployee Total working hour : "
					+ totalWorkingHour + " Hours\n"
					+ "------------------------------------";
		}
	}

