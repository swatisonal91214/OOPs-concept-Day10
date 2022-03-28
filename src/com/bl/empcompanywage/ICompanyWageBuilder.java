package com.bl.empcompanywage;

public interface ICompanyWageBuilder {

	public void addCompany(String companyName,
			int maxWorkingDay, int maxWorkingHour,
			int wagePerHour);

	public void computeEmpWage();
	
	public int totalCompanies();
	
	public CompanyWage getTotalEmpWage(String companyName);
}