package by.fpmibsu.PCBuilder.dao.utils;

public class PCComponents {

    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCPUID() {
        return CPUID;
    }

    public void setCPUID(int CPUID) {
        this.CPUID = CPUID;
    }

    public int getGPUID() {
        return GPUID;
    }

    public void setGPUID(int GPUID) {
        this.GPUID = GPUID;
    }

    public int getCoolerID() {
        return coolerID;
    }

    public void setCoolerID(int coolerID) {
        this.coolerID = coolerID;
    }

    public int getHDDID() {
        return HDDID;
    }

    public void setHDDID(int HDDID) {
        this.HDDID = HDDID;
    }

    public int getMotherBoardID() {
        return motherBoardID;
    }

    public void setMotherBoardID(int motherBoardID) {
        this.motherBoardID = motherBoardID;
    }

    public int getPcCaseID() {
        return pcCaseID;
    }

    public void setPcCaseID(int pcCaseID) {
        this.pcCaseID = pcCaseID;
    }

    public int getPowerSupplyID() {
        return powerSupplyID;
    }

    public void setPowerSupplyID(int powerSupplyID) {
        this.powerSupplyID = powerSupplyID;
    }

    public int getRAMID() {
        return RAMID;
    }

    public void setRAMID(int RAMID) {
        this.RAMID = RAMID;
    }

    public int getSSDID() {
        return SSDID;
    }

    public void setSSDID(int SSDID) {
        this.SSDID = SSDID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private int CPUID;
    private int GPUID;
    private int coolerID;
    private int HDDID;
    private int motherBoardID;
    private int pcCaseID;

    private int id;
    private int powerSupplyID;
    private int RAMID;
    private int SSDID;

    public PCComponents(int id, int userID, int CPUID, int GPUID, int coolerID, int HDDID, int motherBoardID, int pcCaseID, int powerSupplyID, int RAMID, int SSDID) {
        this.id = id;
        this.userID = userID;
        this.CPUID = CPUID;
        this.GPUID = GPUID;
        this.coolerID = coolerID;
        this.HDDID = HDDID;
        this.motherBoardID = motherBoardID;
        this.pcCaseID = pcCaseID;
        this.powerSupplyID = powerSupplyID;
        this.RAMID = RAMID;
        this.SSDID = SSDID;
    }

    public  PCComponents() {

    }
}
