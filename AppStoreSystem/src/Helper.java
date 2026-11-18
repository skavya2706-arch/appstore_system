class Helper extends Person {
    String type;
    String assignedEmergency;
    static int totalHelpers = 0;
    int emergencyCount = 0;

    public Helper() {
        type = "";
        assignedEmergency = "None";
    }

    public Helper(String id, String password, String type, String name, String phoneNumber) {
        super(name, id, password, phoneNumber);
        this.type = type;
        this.assignedEmergency = "None";
        totalHelpers++;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type + ", Emergencies Handled: " + emergencyCount);
        if (!assignedEmergency.equals("None")) {
            System.out.println("Currently Assigned: " + assignedEmergency);
        }
    }

    public static int getTotalHelpers() {
        return totalHelpers;
    }

    public int compareTo(Helper other) {
        return this.name.compareTo(other.name);
    }
}