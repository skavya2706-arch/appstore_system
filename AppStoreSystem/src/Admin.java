class Admin extends Person {
    static final String ADMIN_ID = "admin";
    static final String ADMIN_PASSWORD = "admin123";

    public Admin() {
        super("System Admin", ADMIN_ID, ADMIN_PASSWORD, "0000000000");
    }

    public void displayInfo() {
        System.out.println("=== ADMIN ===");
        super.displayInfo();
    }

    public void showStats() {
        System.out.println("Total Users: " + User.getTotalUsers());
        System.out.println("Total Helpers: " + Helper.getTotalHelpers());
    }

    public void showStats(boolean flag) {
        showStats();
        if (flag) {
            System.out.println("Admin Credentials: ID=" + ADMIN_ID + ", Password=" + ADMIN_PASSWORD);
        }
    }
}