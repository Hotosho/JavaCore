package lesson21;

public class Demo {
    public static void main(String[] args) throws Exception {
        Company company = new Company(100, "Nokia", "s");
        //company.setLicence("GTP999");
        // Call of method by class
        Company.setLicence("GTP999");

        System.out.println(company.getLicence());

        Company company1 = new Company(9, "Test", "s");

        System.out.println(company1.getLicence());

        //company.setLicence("TTT11");
        //Call of method by class
        Company.setLicence("TTT11");

        System.out.println(company.getLicence());
        System.out.println(company1.getLicence());

        Company.validate();

        //demo utils with static method

        int min = ArrayUtils.minElement(new int[]{1, 43, 54});
    }
}
