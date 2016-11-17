package com.ita.cpxd.model;

import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.annotation.XPortalModel;

/**
 * Created by HS on 13/09/2016.
 */
@XPortalModel(name = "ita-personrepresent", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class PersonRepresent {
    private String uuid;
    private String gender;
    private String nameRepresent;
    private String birthday;
    private String race;
    private String regilion;
    private String idnumber;
    private String issueDate;
    private String issuePlace;

    public String getBirthday() {
        return birthday;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNameRepresent() {
        return nameRepresent;
    }

    public void setNameRepresent(String nameRepresent) {
        this.nameRepresent = nameRepresent;
    }



    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRegilion() {
        return regilion;
    }

    public void setRegilion(String regilion) {
        this.regilion = regilion;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }



    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }






}
