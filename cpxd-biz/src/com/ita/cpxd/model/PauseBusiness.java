package com.ita.cpxd.model;

/**
 * Created by ACER on 9/14/2016.
 */
public class PauseBusiness {
    private String uuid;
    private String homeBusiness_ID;
    private String dayofPause;
    private String dateStart;
    private String reason;
    private long dateSubmit=System.currentTimeMillis();
    private String statusProcess;
    private String taskID;

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getStatusProcess() {
        return statusProcess;
    }

    public void setStatusProcess(String statusProcess) {
        this.statusProcess = statusProcess;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHomeBusiness_ID() {
        return homeBusiness_ID;
    }

    public void setHomeBusiness_ID(String homeBusiness_ID) {
        this.homeBusiness_ID = homeBusiness_ID;
    }

    public String getDayofPause() {
        return dayofPause;
    }

    public void setDayofPause(String dayofPause) {
        this.dayofPause = dayofPause;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(long dateSubmit) {
        this.dateSubmit = dateSubmit;
    }
}
