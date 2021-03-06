package lesson9;

import lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {

        Company company = new Company();
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());

        Checker checker = new Checker();
        checker.checkCompanyName(company.getName());
        System.out.println(checker.checkCompanyName(company.getCountryFounded()));
        System.out.println(checker.companyNamesValidatedCount);
    }
}
