package lesson9.utils;

public class Checker {

    //public
    //private
    //default
    //protected


    public int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {

    /*    if (companyName == "Google" || companyName == "Amazon")
            return false;
        return true;
    */
        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }

}
