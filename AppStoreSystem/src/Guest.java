class Guest extends Person {
    String emergencyType;
    String emergencyDetails;

    public Guest() {
        emergencyType = "";
        emergencyDetails = "";
    }

    public Guest(String name, String phoneNumber, String emergencyType, String emergencyDetails) {
        super(name, "GUEST_" + System.currentTimeMillis(), "guest123", phoneNumber);
        this.emergencyType = emergencyType;
        this.emergencyDetails = emergencyDetails;
    }

    public void displayInfo() {
        System.out.println("=== GUEST USER ===");
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Emergency Details: " + emergencyDetails);
    }
}