package model;

/**
 * @author Dylan Zote
 * created on 12/8/2021
 * Project jadeTutorial
 **/
public class ProviderMessage {
    private String name;
    private String website;
    private String logo;
    private String resume;
    private String specialKeyword;
    private String hourlyCompensation;
    private String proofOfBusiness;

    public ProviderMessage(String name, String website, String logo, String resume, String specialKeyword, String hourlyCompensation, String proofOfBusiness) {
        this.name = name;
        this.website = website;
        this.logo = logo;
        this.resume = resume;
        this.specialKeyword = specialKeyword;
        this.hourlyCompensation = hourlyCompensation;
        this.proofOfBusiness = proofOfBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSpecialKeyword() {
        return specialKeyword;
    }

    public void setSpecialKeyword(String specialKeyword) {
        this.specialKeyword = specialKeyword;
    }

    public String getHourlyCompensation() {
        return hourlyCompensation;
    }

    public void setHourlyCompensation(String hourlyCompensation) {
        this.hourlyCompensation = hourlyCompensation;
    }

    public String getProofOfBusiness() {
        return proofOfBusiness;
    }

    public void setProofOfBusiness(String proofOfBusiness) {
        this.proofOfBusiness = proofOfBusiness;
    }
}
