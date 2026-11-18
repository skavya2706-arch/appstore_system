class User extends Person {
    String emergencyType;
    String emergencyDetails;
    static int totalUsers = 0;

    public User() {
        emergencyType = "";
        emergencyDetails = "";
    }

    public User(String name, String id, String password, String phoneNumber, String emergencyType, String emergencyDetails) {
        super(name, id, password, phoneNumber);
        this.emergencyType = emergencyType;
        this.emergencyDetails = emergencyDetails;
        totalUsers++;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Emergency Type: " + emergencyType);
    }

     static int getTotalUsers() {
        return totalUsers;
    }
}
