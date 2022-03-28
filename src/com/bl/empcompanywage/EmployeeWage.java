package com.bl.empcompanywage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class EmployeeWage implements ICompanyWageBuilder{
	final int PRESENT = 1;
	final int PART_TIME = 2;
	final int WORKING_HOUR = 8;

	List<CompanyWage> companies;

	public EmployeeWage() {
		this.companies = new ArrayList<CompanyWage>();
	}

	@Override
	public void addCompany(String companyName,
			int maxWorkingDay, int maxWorkingHour,
			int wagePerHour) {
		CompanyWage company = new CompanyWage(
				companyName, maxWorkingDay, maxWorkingHour,
				wagePerHour);
		companies.add(company);
	}

	@Override
	public void computeEmpWage() {
		for (int i = 0; i < companies.size(); i++) {
			computeEmpWage(companies.get(i));
//			System.out.println(companies.get(i));
		}
		System.out.println(
				"Total companies : " + totalCompanies());
	}

	@Override
	public int totalCompanies() {
		return companies.size();
	}

	@Override
	public CompanyWage getTotalEmpWage(
			String companyName) {
		for (CompanyWage companyEmpWage : companies) {
			if (companyEmpWage.company.toLowerCase()
					.equals(companyName.toLowerCase()))
				return companyEmpWage;
		}
		return null;
	}

	private void computeEmpWage(CompanyWage company) {
		int totalWorkingHour = 0;
		int day = 0;

		while (day < company.maxWorkingDay
				&& totalWorkingHour < company.maxWorkingHour) {
			int isPresent;
			int remainingWorkingHour = company.maxWorkingHour
					- totalWorkingHour;
			if (remainingWorkingHour < WORKING_HOUR
					&& !(remainingWorkingHour < (WORKING_HOUR
							/ 2))) {
				isPresent = PART_TIME;
			} else if (remainingWorkingHour < (WORKING_HOUR
					/ 2)) {
				break;
			} else {
				isPresent = (int) (Math.random() * 3);
			}

			totalWorkingHour = totalWorkingHour
					+ getWorkingHour(isPresent);
			day++;
		}
		company.totalWorkingHour = totalWorkingHour;
		company.totalSalary = totalWorkingHour
				* company.wagePerHour;

	}

	private int getWorkingHour(int empPresent) {
		switch (empPresent) {
		case PRESENT:
			return WORKING_HOUR;

		case PART_TIME:
			return WORKING_HOUR / 2;

		}
		return 0;
	}

	public static void main(String[] args) {
		EmployeeWage empWageBuilder = new EmployeeWage();
		empWageBuilder.addCompany("DMart", 20, 60, 25);
		empWageBuilder.addCompany("Reliance", 22, 80, 35);
		empWageBuilder.addCompany("Asus", 20, 48, 22);
		empWageBuilder.addCompany("Tech Mahindra", 25, 80,
				40);

		empWageBuilder.computeEmpWage();

		System.out.println(
				empWageBuilder.getTotalEmpWage("hp"));
		int size = empWageBuilder.totalCompanies();
	}
}