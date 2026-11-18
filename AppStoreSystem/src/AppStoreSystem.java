import java.util.Scanner;

// ==================== EMERGENCY APP CLASSES ====================

// Base class for all users - Inheritance


// User class - Inheritance from Person


// Guest class - Inheritance from Person


// Helper class - Inheritance from Person


// Admin class - Inheritance from Person

// ==================== GAME CLASSES ====================




// ==================== MAIN APP STORE SYSTEM ====================

public class AppStoreSystem {
    static Person[] allPersons = new Person[100];
    static User[] users = new User[50];
    static Helper[] helpers = new Helper[50];
    static Admin admin = new Admin();

    static int userCount = 0;
    static int helperCount = 0;
    static int totalPersons = 0;

    static Scanner sc = new Scanner(System.in);

    // ==================== INPUT VALIDATION METHODS ====================

    static int getIntInRange(String prompt, int min, int max) {
        int input = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);

            if (sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine();

                if (input >= min && input <= max) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next();
            }
        }
        return input;
    }

    static String getNonEmptyInput(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty!");
            }
        }
        return input.trim();
    }

    static boolean isAllDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    static String getValidPhoneNumber(String prompt) {
        String phoneNumber = "";

        while (true) {
            System.out.print(prompt);
            phoneNumber = sc.nextLine().trim();

            if (phoneNumber.isEmpty()) {
                System.out.println("Phone number cannot be empty! Please enter a 10-digit phone number.");
                continue;
            }

            if (phoneNumber.length() != 10 || !isAllDigits(phoneNumber)) {
                System.out.println("Invalid phone number! Please enter exactly 10 digits (numbers only).");
                continue;
            }

            boolean phoneExists = false;
            for (int i = 0; i < userCount; i++) {
                if (users[i] != null && users[i].phoneNumber != null &&
                        users[i].phoneNumber.equals(phoneNumber)) {
                    phoneExists = true;
                    break;
                }
            }

            if (phoneExists) {
                System.out.println("Phone number already registered! Please use a different number.");
                continue;
            }

            break;
        }
        return phoneNumber;
    }

    static String getOptionalPhoneNumber(String prompt) {
        String phoneNumber = "";

        while (true) {
            System.out.print(prompt);
            String tempPhone = sc.nextLine().trim();

            if (tempPhone.isEmpty()) {
                break;
            }

            if (tempPhone.length() != 10 || !isAllDigits(tempPhone)) {
                System.out.println("Invalid phone number! Please enter exactly 10 digits or press Enter to skip.");
                continue;
            }

            phoneNumber = tempPhone;
            break;
        }
        return phoneNumber;
    }

    public static void main(String[] args) {
        helpers[helperCount++] = new Helper("doc001", "doc123", "doctor", "Dr. Smith", "9876543210");
        helpers[helperCount++] = new Helper("fire001", "fire123", "firefighter", "Firefighter John", "9876543211");
        helpers[helperCount++] = new Helper("police001", "police123", "police", "Officer Mike", "9876543212");

        helpers[helperCount++] = new Helper("doc002", "doc456", "doctor", "Dr. Johnson", "9876543213");
        helpers[helperCount++] = new Helper("doc003", "doc789", "doctor", "Dr. Williams", "9876543214");
        helpers[helperCount++] = new Helper("fire002", "fire456", "firefighter", "Firefighter Mike", "9876543215");
        helpers[helperCount++] = new Helper("fire003", "fire789", "firefighter", "Firefighter Brown", "9876543216");
        helpers[helperCount++] = new Helper("police002", "police456", "police", "Officer Davis", "9876543217");
        helpers[helperCount++] = new Helper("police003", "police789", "police", "Officer Taylor", "9876543218");
        helpers[helperCount++] = new Helper("doc004", "doc101", "doctor", "Dr. Miller", "9876543219");

        users[userCount++] = new User("Alice Johnson", "alice01", "pass123", "9876543220", "Medical", "Chest pain and breathing difficulty");
        users[userCount++] = new User("Bob Smith", "bob02", "pass456", "9876543221", "Fire", "Kitchen fire, need immediate assistance");
        users[userCount++] = new User("Charlie Brown", "charlie03", "pass789", "9876543222", "Police", "Suspicious activity in neighborhood");
        users[userCount++] = new User("David Wilson", "david04", "pass101", "9876543223", "None", "No emergency reported");
        users[userCount++] = new User("Emma Davis", "emma05", "pass202", "9876543224", "Medical", "Broken leg after fall");
        users[userCount++] = new User("Frank Miller", "frank06", "pass303", "9876543225", "Fire", "Smoke coming from neighbor's house");
        users[userCount++] = new User("Grace Taylor", "grace07", "pass404", "9876543226", "Police", "Car theft reported");
        users[userCount++] = new User("Henry Clark", "henry08", "pass505", "9876543227", "Medical", "Allergic reaction, difficulty breathing");
        users[userCount++] = new User("Ivy Rodriguez", "ivy09", "pass606", "9876543228", "None", "No emergency reported");
        users[userCount++] = new User("Jack White", "jack10", "pass707", "9876543229", "Fire", "Electrical fire in apartment");
        users[userCount++] = new User("Karen Lee", "karen11", "pass808", "9876543230", "Police", "Noise complaint");
        users[userCount++] = new User("Liam Harris", "liam12", "pass909", "9876543231", "Medical", "High fever and vomiting");
        users[userCount++] = new User("Mia Martin", "mia13", "pass010", "9876543232", "None", "No emergency reported");
        users[userCount++] = new User("Noah Thompson", "noah14", "pass111", "9876543233", "Fire", "Small fire in garage");
        users[userCount++] = new User("Olivia Garcia", "olivia15", "pass212", "9876543234", "Police", "Lost wallet with important documents");

        allPersons[totalPersons++] = admin;

        for (int i = 0; i < helperCount; i++) {
            allPersons[totalPersons++] = helpers[i];
        }

        for (int i = 0; i < userCount; i++) {
            allPersons[totalPersons++] = users[i];
        }

        System.out.println("=====================================");
        System.out.println("        WELCOME TO APP STORE        ");
        System.out.println("=====================================");
        System.out.println("System initialized with:");
        System.out.println("- " + helperCount + " helpers (10 predefined)");
        System.out.println("- " + userCount + " users (15 predefined)");
        System.out.println("- 1 admin account (admin/admin123)");
        System.out.println("\nSample User Logins:");
        System.out.println("1. alice01 / pass123 (Medical emergency)");
        System.out.println("2. bob02 / pass456 (Fire emergency)");
        System.out.println("3. charlie03 / pass789 (Police emergency)");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Emergency App");
            System.out.println("2. Games");
            System.out.println("3. Exit");

            int choice = getIntInRange("Choose an option (1-3): ", 1, 3);

            if (choice == 1) {
                emergencyApp();
            } else if (choice == 2) {
                gamesMenu();
            } else if (choice == 3) {
                System.out.println("Thank you for using the App Store. Goodbye!");
                return;
            }
        }
    }

    static void emergencyApp() {
        System.out.println("\n=====================================");
        System.out.println("         EMERGENCY APP SYSTEM        ");
        System.out.println("=====================================");

        while (true) {
            System.out.println("\nEmergency App Menu:");
            System.out.println("1. Register (Create Account)");
            System.out.println("2. Login (Existing User/Helper/Admin)");
            System.out.println("3. Login as Guest (Quick Emergency)");
            System.out.println("4. Report Urgent Emergency");
            System.out.println("5. Back to Main Menu");

            int choice = getIntInRange("Choose an option (1-5): ", 1, 5);

            if (choice == 1) {
                registerUser();
            } else if (choice == 2) {
                loginUser();
            } else if (choice == 3) {
                loginAsGuest();
            } else if (choice == 4) {
                reportUrgentEmergency();
            } else if (choice == 5) {
                return;
            }
        }
    }

    static void registerUser() {
        if (userCount >= users.length) {
            System.out.println("User database is full!");
            return;
        }

        System.out.println("\n=== USER REGISTRATION ===");
        String name = getNonEmptyInput("Enter your name: ");
        String id = getNonEmptyInput("Enter your ID: ");

        for (int i = 0; i < userCount; i++) {
            if (users[i].id.equals(id)) {
                System.out.println("ERROR: ID already exists! Please choose a different ID.");
                return;
            }
        }

        String password = getNonEmptyInput("Enter your password: ");
        String phoneNumber = getValidPhoneNumber("Enter your phone number (10 digits): ");

        users[userCount] = new User(name, id, password, phoneNumber, "None", "No emergency reported");
        allPersons[totalPersons++] = users[userCount];
        userCount++;

        System.out.println("\nRegistration successful!");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Total registered users: " + User.getTotalUsers());
        System.out.println("\nNote: You can report emergencies after login.");
    }

    static void loginUser() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (id.equals(Admin.ADMIN_ID) && password.equals(Admin.ADMIN_PASSWORD)) {
            adminLogin();
            return;
        }

        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].id.equals(id) && helpers[i].password.equals(password)) {
                helperLogin(helpers[i]);
                return;
            }
        }

        for (int i = 0; i < userCount; i++) {
            if (users[i].id.equals(id) && users[i].password.equals(password)) {
                userLogin(users[i]);
                return;
            }
        }

        System.out.println("ERROR: Invalid credentials! User not found.");
    }

    static void adminLogin() {
        System.out.println("\nWelcome, Admin!");
        admin.displayInfo();
        admin.showStats(true);

        System.out.println("\n=== ALL HELPERS INFORMATION ===");
        viewAllHelpers();

        while (true) {
            System.out.println("\n=== ADMIN DASHBOARD ===");
            System.out.println("1. View Statistics");
            System.out.println("2. Search Operations");
            System.out.println("3. Sort Operations");
            System.out.println("4. Delete Operations");
            System.out.println("5. View All Information");
            System.out.println("6. Logout");

            int choice = getIntInRange("Choose option (1-6): ", 1, 6);

            if (choice == 1) {
                adminStatsMenu();
            } else if (choice == 2) {
                adminSearchMenu();
            } else if (choice == 3) {
                adminSortMenu();
            } else if (choice == 4) {
                adminDeleteMenu();
            } else if (choice == 5) {
                adminViewAllMenu();
            } else if (choice == 6) {
                System.out.println("Logging out...");
                return;
            }
        }
    }

    static void adminStatsMenu() {
        System.out.println("\n=== STATISTICS MENU ===");
        System.out.println("1. Show Basic Statistics");
        System.out.println("2. Show Detailed Statistics");
        System.out.println("3. Find Helper with Maximum Emergencies");
        System.out.println("4. Back to Admin Dashboard");

        int choice = getIntInRange("Choose option (1-4): ", 1, 4);

        if (choice == 1) {
            admin.showStats();
        } else if (choice == 2) {
            admin.showStats(true);
        } else if (choice == 3) {
            findHelperWithMaxEmergencies();
        } else if (choice == 4) {
            return;
        }
    }

    static void adminSearchMenu() {
        System.out.println("\n=== SEARCH OPERATIONS ===");
        System.out.println("1. Search Helper");
        System.out.println("2. Search User");
        System.out.println("3. Back to Admin Dashboard");

        int choice = getIntInRange("Choose option (1-3): ", 1, 3);

        if (choice == 1) {
            searchHelperMenu();
        } else if (choice == 2) {
            searchUserMenu();
        } else if (choice == 3) {
            return;
        }
    }

    static void searchHelperMenu() {
        System.out.println("\n=== SEARCH HELPER ===");
        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Type (doctor/firefighter/police)");
        System.out.println("3. ID");
        System.out.println("4. Phone Number");
        System.out.println("5. Back to Search Operations");

        int choice = getIntInRange("Choose option (1-5): ", 1, 5);

        if (choice == 1) {
            System.out.print("Enter helper name to search: ");
            String searchName = sc.nextLine();
            searchHelperByName(searchName);
        } else if (choice == 2) {
            System.out.print("Enter helper type (doctor/firefighter/police): ");
            String searchType = sc.nextLine();
            searchHelperByType(searchType);
        } else if (choice == 3) {
            System.out.print("Enter helper ID to search: ");
            String searchId = sc.nextLine();
            searchHelperById(searchId);
        } else if (choice == 4) {
            System.out.print("Enter helper phone number to search: ");
            String searchPhone = sc.nextLine();
            searchHelperByPhone(searchPhone);
        } else if (choice == 5) {
            return;
        }
    }

    static void searchUserMenu() {
        System.out.println("\n=== SEARCH USER ===");
        System.out.print("Enter user ID, name, or phone number to search: ");
        String searchTerm = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < userCount; i++) {
            if (users[i].id.equals(searchTerm) ||
                    users[i].name.toLowerCase().indexOf(searchTerm.toLowerCase()) != -1 ||
                    users[i].phoneNumber.equals(searchTerm)) {
                System.out.println("\nUser found:");
                users[i].displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No user found with: " + searchTerm);
        }
    }

    static void adminSortMenu() {
        System.out.println("\n=== SORT OPERATIONS ===");
        System.out.println("1. Sort Helpers Alphabetically");
        System.out.println("2. Sort Helpers by Emergency Count");
        System.out.println("3. Back to Admin Dashboard");

        int choice = getIntInRange("Choose option (1-3): ", 1, 3);

        if (choice == 1) {
            sortHelpersAlphabetically();
        } else if (choice == 2) {
            sortHelpersByEmergencyCount();
        } else if (choice == 3) {
            return;
        }
    }

    static void sortHelpersByEmergencyCount() {
        System.out.println("\n=== HELPERS SORTED BY EMERGENCY COUNT ===");

        Helper[] sortedHelpers = new Helper[helperCount];
        for (int i = 0; i < helperCount; i++) {
            sortedHelpers[i] = helpers[i];
        }

        for (int i = 0; i < helperCount - 1; i++) {
            for (int j = 0; j < helperCount - i - 1; j++) {
                if (sortedHelpers[j].emergencyCount < sortedHelpers[j + 1].emergencyCount) {
                    Helper temp = sortedHelpers[j];
                    sortedHelpers[j] = sortedHelpers[j + 1];
                    sortedHelpers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < helperCount; i++) {
            System.out.println("\n" + (i + 1) + ". " + sortedHelpers[i].name +
                    " (" + sortedHelpers[i].type + ")" +
                    " - Phone: " + sortedHelpers[i].phoneNumber +
                    " - Emergencies: " + sortedHelpers[i].emergencyCount);
        }
    }

    static void adminDeleteMenu() {
        System.out.println("\n=== DELETE OPERATIONS ===");
        System.out.println("1. Delete a User");
        System.out.println("2. Delete a Helper");
        System.out.println("3. Delete an Emergency Assignment");
        System.out.println("4. Back to Admin Dashboard");

        int choice = getIntInRange("Choose option (1-4): ", 1, 4);

        if (choice == 1) {
            deleteUser();
        } else if (choice == 2) {
            deleteHelper();
        } else if (choice == 3) {
            deleteEmergencyAssignment();
        } else if (choice == 4) {
            return;
        }
    }

    static void adminViewAllMenu() {
        System.out.println("\n=== VIEW ALL INFORMATION ===");
        System.out.println("1. View All Emergency Entries");
        System.out.println("2. View All Users");
        System.out.println("3. View All Helpers");
        System.out.println("4. View All Persons in System");
        System.out.println("5. Back to Admin Dashboard");

        int choice = getIntInRange("Choose option (1-5): ", 1, 5);

        if (choice == 1) {
            showAllEntries();
        } else if (choice == 2) {
            viewAllUsers();
        } else if (choice == 3) {
            viewAllHelpers();
        } else if (choice == 4) {
            viewAllPersons();
        } else if (choice == 5) {
            return;
        }
    }

    static void viewAllUsers() {
        System.out.println("\n=== ALL REGISTERED USERS ===");
        if (userCount == 0) {
            System.out.println("No users registered yet.");
            return;
        }
        for (int i = 0; i < userCount; i++) {
            System.out.println("\nUser " + (i + 1) + ":");
            users[i].displayInfo();
        }
    }

    static void viewAllHelpers() {
        System.out.println("\n=== ALL HELPERS ===");
        for (int i = 0; i < helperCount; i++) {
            System.out.println("\nHelper " + (i + 1) + ":");
            helpers[i].displayInfo();
        }
    }

    static void viewAllPersons() {
        System.out.println("\n=== ALL PERSONS IN SYSTEM ===");
        for (int i = 0; i < totalPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            allPersons[i].displayInfo();
        }
    }

    static void userLogin(User user) {
        System.out.println("\nLogin Successful!");
        System.out.println("Welcome, " + user.name + "!");
        System.out.println("Phone: " + user.phoneNumber);

        while (true) {
            System.out.println("\n=== USER DASHBOARD ===");
            System.out.println("1. Report Emergency");
            System.out.println("2. View My Emergency Status");
            System.out.println("3. View Assigned Helper");
            System.out.println("4. Update Emergency Details");
            System.out.println("5. Update Phone Number");
            System.out.println("6. Logout");

            int choice = getIntInRange("Choose option (1-6): ", 1, 6);

            if (choice == 1) {
                reportEmergency(user);
            } else if (choice == 2) {
                viewUserEmergencyStatus(user);
            } else if (choice == 3) {
                viewAssignedHelper(user);
            } else if (choice == 4) {
                updateEmergencyDetails(user);
            } else if (choice == 5) {
                updatePhoneNumber(user);
            } else if (choice == 6) {
                System.out.println("Logging out...");
                return;
            }
        }
    }

    static void reportEmergency(User user) {
        System.out.println("\n=== REPORT EMERGENCY ===");

        if (!user.emergencyType.equals("None")) {
            System.out.println("You already have an active emergency!");
            System.out.println("Current emergency: " + user.emergencyType);
            System.out.print("Do you want to update it? (yes/no): ");
            String response = sc.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                return;
            }
        }

        System.out.println("\nSelect emergency type:");
        System.out.println("1. Medical Emergency");
        System.out.println("2. Fire Emergency");
        System.out.println("3. Police Emergency");
        System.out.println("4. Other Emergency");

        int emergencyChoice = getIntInRange("Choose (1-4): ", 1, 4);

        String emergencyType = "";
        if (emergencyChoice == 1) {
            emergencyType = "Medical";
        } else if (emergencyChoice == 2) {
            emergencyType = "Fire";
        } else if (emergencyChoice == 3) {
            emergencyType = "Police";
        } else if (emergencyChoice == 4) {
            emergencyType = "Other";
        }

        System.out.print("Describe your emergency: ");
        String emergencyDetails = sc.nextLine();

        user.emergencyType = emergencyType;
        user.emergencyDetails = emergencyDetails;

        String logbookEntry = "User: " + user.name +
                " | ID: " + user.id +
                " | Phone: " + user.phoneNumber +
                " | Emergency Type: " + emergencyType +
                " | Details: " + emergencyDetails;

        boolean assigned = false;
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].type.equalsIgnoreCase(getHelperTypeForEmergency(emergencyType)) &&
                    helpers[i].assignedEmergency.equals("None")) {
                helpers[i].assignedEmergency = logbookEntry;
                helpers[i].emergencyCount++;
                assigned = true;
                System.out.println("Emergency assigned to: " + helpers[i].name + " (" + helpers[i].type + ")");
                System.out.println("Helper Phone: " + helpers[i].phoneNumber);
                break;
            }
        }

        if (!assigned) {
            System.out.println("Warning: No available helper found. Emergency logged in queue.");
        }

        System.out.println("\nEmergency reported successfully!");
    }

    static void viewUserEmergencyStatus(User user) {
        System.out.println("\n=== MY EMERGENCY STATUS ===");
        System.out.println("Name: " + user.name);
        System.out.println("ID: " + user.id);
        System.out.println("Phone: " + user.phoneNumber);
        System.out.println("Emergency Type: " + user.emergencyType);
        System.out.println("Emergency Details: " + user.emergencyDetails);
    }

    static void viewAssignedHelper(User user) {
        System.out.println("\n=== ASSIGNED HELPER ===");
        boolean foundHelper = false;
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].assignedEmergency.indexOf("ID: " + user.id) != -1) {
                System.out.println("Assigned to: " + helpers[i].name + " (" + helpers[i].type + ")");
                System.out.println("Helper Phone: " + helpers[i].phoneNumber);
                foundHelper = true;
                break;
            }
        }

        if (!foundHelper) {
            System.out.println("Warning: Your emergency is still in queue.");
        }
    }

    static void updateEmergencyDetails(User user) {
        System.out.println("\n=== UPDATE EMERGENCY DETAILS ===");

        if (user.emergencyType.equals("None")) {
            System.out.println("You haven't reported any emergency yet.");
            return;
        }

        System.out.println("Current emergency: " + user.emergencyType);
        System.out.println("Current details: " + user.emergencyDetails);

        System.out.print("Enter new emergency details: ");
        String newDetails = sc.nextLine();

        user.emergencyDetails = newDetails;
        System.out.println("Emergency details updated successfully!");
    }

    static void updatePhoneNumber(User user) {
        System.out.println("\n=== UPDATE PHONE NUMBER ===");
        System.out.println("Current phone number: " + user.phoneNumber);

        String newPhoneNumber = getValidPhoneNumber("Enter new phone number (10 digits): ");

        if (newPhoneNumber.equals(user.phoneNumber)) {
            System.out.println("New phone number is same as current. No changes made.");
            return;
        }

        for (int i = 0; i < userCount; i++) {
            if (users[i] != user && users[i].phoneNumber.equals(newPhoneNumber)) {
                System.out.println("Phone number already in use by another user!");
                return;
            }
        }

        user.phoneNumber = newPhoneNumber;
        System.out.println("Phone number updated successfully!");
    }

    static void helperLogin(Helper helper) {
        System.out.println("\nLogin Successful!");
        System.out.println("Welcome, " + helper.name + " (" + helper.type + ")!");
        System.out.println("Phone: " + helper.phoneNumber);

        if (helper.assignedEmergency.equals("None")) {
            System.out.println("No emergency assigned currently.");
        } else {
            System.out.println("\nASSIGNED EMERGENCY:");
            System.out.println(helper.assignedEmergency);
            System.out.println("\n1. Mark as resolved");
            System.out.println("2. Keep as pending");

            int choice = getIntInRange("Choose (1-2): ", 1, 2);

            if (choice == 1) {
                System.out.println("Emergency marked as resolved!");
                helper.assignedEmergency = "None";
            }
        }
    }

    static void loginAsGuest() {
        System.out.println("\n=== LOGIN AS GUEST ===");
        String name = getNonEmptyInput("Enter your name: ");
        String phoneNumber = getOptionalPhoneNumber("Enter your phone number (10 digits, optional - press Enter to skip): ");

        System.out.println("\nSelect emergency type:");
        System.out.println("1. Medical Emergency");
        System.out.println("2. Fire Emergency");
        System.out.println("3. Police Emergency");
        System.out.println("4. Other Emergency");

        int emergencyChoice = getIntInRange("Choose (1-4): ", 1, 4);

        String emergencyType = "";
        if (emergencyChoice == 1) {
            emergencyType = "Medical";
        } else if (emergencyChoice == 2) {
            emergencyType = "Fire";
        } else if (emergencyChoice == 3) {
            emergencyType = "Police";
        } else if (emergencyChoice == 4) {
            emergencyType = "Other";
        }

        System.out.print("Describe your emergency: ");
        String emergencyDetails = sc.nextLine();

        Guest guest = new Guest(name, phoneNumber, emergencyType, emergencyDetails);
        guest.displayInfo();

        String logbookEntry = "Guest: " + name;
        if (!phoneNumber.isEmpty()) {
            logbookEntry += " | Phone: " + phoneNumber;
        }
        logbookEntry += " | Emergency Type: " + emergencyType +
                " | Details: " + emergencyDetails;

        boolean assigned = false;
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].type.equalsIgnoreCase(getHelperTypeForEmergency(emergencyType)) &&
                    helpers[i].assignedEmergency.equals("None")) {
                helpers[i].assignedEmergency = logbookEntry;
                helpers[i].emergencyCount++;
                assigned = true;
                System.out.println("\nEmergency assigned to: " + helpers[i].name + " (" + helpers[i].type + ")");
                break;
            }
        }

        if (!assigned) {
            System.out.println("\nWarning: No available helper found. Emergency logged in queue.");
        }

        System.out.println("\nNote: As a guest, your emergency will be handled but no account is created.");
        System.out.println("Register for full features and to track your emergencies.");
    }

    static void reportUrgentEmergency() {
        System.out.println("\n=== URGENT EMERGENCY REPORT ===");
        System.out.println("WARNING: Use this only for life-threatening situations!");
        System.out.println("Call local emergency services immediately if needed!\n");

        String name = getNonEmptyInput("Enter your name: ");
        String phoneNumber = getValidPhoneNumber("Enter your phone number (10 digits): ");

        System.out.println("\nSelect emergency type:");
        System.out.println("1. Medical Emergency (Life-threatening)");
        System.out.println("2. Fire Emergency");
        System.out.println("3. Police Emergency (Crime in progress)");
        System.out.println("4. Natural Disaster");

        int emergencyChoice = getIntInRange("Choose (1-4): ", 1, 4);

        String emergencyType = "";
        if (emergencyChoice == 1) {
            emergencyType = "Medical (URGENT)";
        } else if (emergencyChoice == 2) {
            emergencyType = "Fire (URGENT)";
        } else if (emergencyChoice == 3) {
            emergencyType = "Police (URGENT)";
        } else if (emergencyChoice == 4) {
            emergencyType = "Natural Disaster (URGENT)";
        }

        System.out.print("Describe your emergency: ");
        String emergencyDetails = sc.nextLine();

        System.out.print("Enter your location: ");
        String location = sc.nextLine();

        System.out.println("\n=== EMERGENCY ALERT! ===");
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Location: " + location);
        System.out.println("Details: " + emergencyDetails);

        String logbookEntry = "URGENT: " + name +
                " | Phone: " + phoneNumber +
                " | Type: " + emergencyType +
                " | Location: " + location +
                " | Details: " + emergencyDetails;

        boolean assigned = false;
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].assignedEmergency.equals("None")) {
                helpers[i].assignedEmergency = logbookEntry;
                helpers[i].emergencyCount++;
                assigned = true;
                System.out.println("\nEmergency assigned to: " + helpers[i].name + " (" + helpers[i].type + ")");
                System.out.println("Helper Phone: " + helpers[i].phoneNumber);
                System.out.println("Help is on the way!");
                break;
            }
        }

        if (!assigned) {
            int minEmergencies = 999999;
            int minIndex = -1;
            for (int i = 0; i < helperCount; i++) {
                if (helpers[i].emergencyCount < minEmergencies) {
                    minEmergencies = helpers[i].emergencyCount;
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                helpers[minIndex].assignedEmergency = logbookEntry;
                helpers[minIndex].emergencyCount++;
                System.out.println("\nEmergency assigned to: " + helpers[minIndex].name + " (" + helpers[minIndex].type + ")");
                System.out.println("Helper Phone: " + helpers[minIndex].phoneNumber);
                System.out.println("Help is on the way!");
            }
        }

        System.out.println("\n=== IMPORTANT ===");
        System.out.println("1. Stay calm and stay on the line if possible");
        System.out.println("2. Do not move if injured");
        System.out.println("3. Clear the area if there's danger");
        System.out.println("4. Follow instructions from emergency personnel");
    }

    static void showAllEntries() {
        System.out.println("\n=====================================");
        System.out.println("         ALL EMERGENCY ENTRIES       ");
        System.out.println("=====================================");

        boolean hasEntries = false;
        for (int i = 0; i < helperCount; i++) {
            if (!helpers[i].assignedEmergency.equals("None")) {
                System.out.println("\nHelper: " + helpers[i].name + " (" + helpers[i].type + ")");
                System.out.println("Helper Phone: " + helpers[i].phoneNumber);
                System.out.println("Emergency Entry: " + helpers[i].assignedEmergency);
                System.out.println("-------------------------------------");
                hasEntries = true;
            }
        }

        if (!hasEntries) {
            System.out.println("No emergency entries found.");
        }
    }

    static void searchHelperByName(String name) {
        boolean found = false;
        System.out.println("\nSearch Results for Name: " + name);
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].name.toLowerCase().indexOf(name.toLowerCase()) != -1) {
                System.out.println("\nFound Helper:");
                helpers[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No helper found with name containing: " + name);
        }
    }

    static void searchHelperByType(String type) {
        boolean found = false;
        System.out.println("\nSearch Results for Type: " + type);
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].type.equalsIgnoreCase(type)) {
                System.out.println("\nFound Helper:");
                helpers[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No helper found with type: " + type);
        }
    }

    static void searchHelperById(String id) {
        boolean found = false;
        System.out.println("\nSearch Results for ID: " + id);
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].id.equals(id)) {
                System.out.println("\nFound Helper:");
                helpers[i].displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No helper found with ID: " + id);
        }
    }

    static void searchHelperByPhone(String phone) {
        boolean found = false;
        System.out.println("\nSearch Results for Phone: " + phone);
        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].phoneNumber.equals(phone)) {
                System.out.println("\nFound Helper:");
                helpers[i].displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No helper found with phone: " + phone);
        }
    }

    static void sortHelpersAlphabetically() {
        System.out.println("\n=== HELPERS SORTED ALPHABETICALLY ===");

        Helper[] sortedHelpers = new Helper[helperCount];
        for (int i = 0; i < helperCount; i++) {
            sortedHelpers[i] = helpers[i];
        }

        for (int i = 0; i < helperCount - 1; i++) {
            for (int j = 0; j < helperCount - i - 1; j++) {
                if (sortedHelpers[j].name.compareTo(sortedHelpers[j + 1].name) > 0) {
                    Helper temp = sortedHelpers[j];
                    sortedHelpers[j] = sortedHelpers[j + 1];
                    sortedHelpers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < helperCount; i++) {
            System.out.println("\n" + (i + 1) + ". " + sortedHelpers[i].name +
                    " (" + sortedHelpers[i].type + ")" +
                    " - Phone: " + sortedHelpers[i].phoneNumber +
                    " - Emergencies: " + sortedHelpers[i].emergencyCount);
        }
    }

    static void deleteUser() {
        System.out.println("\n=== DELETE USER ===");
        if (userCount == 0) {
            System.out.println("No users to delete.");
            return;
        }

        System.out.println("Current Users:");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ". " + users[i].name + " (ID: " + users[i].id + ", Phone: " + users[i].phoneNumber + ")");
        }

        int userNum = getIntInRange("Enter user number to delete (1-" + userCount + "): ", 1, userCount);

        int indexToDelete = userNum - 1;
        String deletedUserName = users[indexToDelete].name;
        String deletedUserId = users[indexToDelete].id;

        for (int i = indexToDelete; i < userCount - 1; i++) {
            users[i] = users[i + 1];
        }
        users[userCount - 1] = null;
        userCount--;

        for (int i = 0; i < totalPersons; i++) {
            if (allPersons[i] instanceof User) {
                User user = (User) allPersons[i];
                if (user.id.equals(deletedUserId)) {
                    for (int j = i; j < totalPersons - 1; j++) {
                        allPersons[j] = allPersons[j + 1];
                    }
                    allPersons[totalPersons - 1] = null;
                    totalPersons--;
                    break;
                }
            }
        }

        User.totalUsers--;
        System.out.println("User '" + deletedUserName + "' deleted successfully!");
    }

    static void deleteHelper() {
        System.out.println("\n=== DELETE HELPER ===");
        if (helperCount <= 3) {
            System.out.println("Cannot delete initial helpers. Only additional helpers can be deleted.");
            return;
        }

        System.out.println("Current Helpers:");
        for (int i = 0; i < helperCount; i++) {
            System.out.println((i + 1) + ". " + helpers[i].name + " (" + helpers[i].type + ", Phone: " + helpers[i].phoneNumber + ")");
        }

        int helperNum = getIntInRange("Enter helper number to delete (4-" + helperCount + "): ", 4, helperCount);

        int indexToDelete = helperNum - 1;
        String deletedHelperName = helpers[indexToDelete].name;

        if (!helpers[indexToDelete].assignedEmergency.equals("None")) {
            System.out.println("Warning: This helper has an assigned emergency!");
            System.out.println("Emergency: " + helpers[indexToDelete].assignedEmergency);
            System.out.print("Reassign to another helper? (yes/no): ");
            String response = sc.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Available helpers:");
                for (int i = 0; i < helperCount; i++) {
                    if (i != indexToDelete && helpers[i].type.equals(helpers[indexToDelete].type)) {
                        System.out.println((i + 1) + ". " + helpers[i].name + " (Phone: " + helpers[i].phoneNumber + ")");
                    }
                }
                System.out.print("Choose helper number to reassign to: ");
                int reassignTo = sc.nextInt() - 1;
                sc.nextLine();

                if (reassignTo >= 0 && reassignTo < helperCount && reassignTo != indexToDelete) {
                    helpers[reassignTo].assignedEmergency = helpers[indexToDelete].assignedEmergency;
                    System.out.println("Emergency reassigned to " + helpers[reassignTo].name);
                }
            }
        }

        for (int i = indexToDelete; i < helperCount - 1; i++) {
            helpers[i] = helpers[i + 1];
        }
        helpers[helperCount - 1] = null;
        helperCount--;

        Helper.totalHelpers--;
        System.out.println("Helper '" + deletedHelperName + "' deleted successfully!");
    }

    static void deleteEmergencyAssignment() {
        System.out.println("\n=== DELETE EMERGENCY ASSIGNMENT ===");

        System.out.println("Helpers with assigned emergencies:");
        boolean hasAssignments = false;
        for (int i = 0; i < helperCount; i++) {
            if (!helpers[i].assignedEmergency.equals("None")) {
                System.out.println((i + 1) + ". " + helpers[i].name +
                        " (Phone: " + helpers[i].phoneNumber + ")" +
                        " - " + helpers[i].assignedEmergency);
                hasAssignments = true;
            }
        }

        if (!hasAssignments) {
            System.out.println("No emergency assignments to delete.");
            return;
        }

        int helperNum = getIntInRange("Enter helper number to clear assignment: ", 1, helperCount);

        int helperIndex = helperNum - 1;
        if (helpers[helperIndex].assignedEmergency.equals("None")) {
            System.out.println("This helper has no emergency assignment.");
            return;
        }

        System.out.println("Clearing emergency assignment for " + helpers[helperIndex].name);
        System.out.println("Assignment: " + helpers[helperIndex].assignedEmergency);
        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            helpers[helperIndex].assignedEmergency = "None";
            System.out.println("Emergency assignment cleared!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    static void findHelperWithMaxEmergencies() {
        System.out.println("\n=== HELPER WITH MAXIMUM EMERGENCIES ===");

        if (helperCount == 0) {
            System.out.println("No helpers available.");
            return;
        }

        int maxEmergencies = -1;
        Helper maxHelper = null;

        for (int i = 0; i < helperCount; i++) {
            if (helpers[i].emergencyCount > maxEmergencies) {
                maxEmergencies = helpers[i].emergencyCount;
                maxHelper = helpers[i];
            }
        }

        if (maxHelper != null && maxEmergencies > 0) {
            System.out.println("Top Helper:");
            System.out.println("Name: " + maxHelper.name);
            System.out.println("Type: " + maxHelper.type);
            System.out.println("Phone: " + maxHelper.phoneNumber);
            System.out.println("Total Emergencies Handled: " + maxEmergencies);

            System.out.println("\nAll Helpers Statistics:");
            for (int i = 0; i < helperCount; i++) {
                System.out.println((i + 1) + ". " + helpers[i].name +
                        " (Phone: " + helpers[i].phoneNumber + ")" +
                        " - Emergencies: " + helpers[i].emergencyCount);
            }
        } else {
            System.out.println("No emergencies have been handled yet.");
        }
    }

    static String getHelperTypeForEmergency(String emergencyType) {
        if (emergencyType.equals("Medical") || emergencyType.equals("Medical (URGENT)")) {
            return "doctor";
        } else if (emergencyType.equals("Fire") || emergencyType.equals("Fire (URGENT)")) {
            return "firefighter";
        } else if (emergencyType.equals("Police") || emergencyType.equals("Police (URGENT)")) {
            return "police";
        } else {
            return "doctor";
        }
    }

    static void gamesMenu() {
        System.out.println("\n=====================================");
        System.out.println("            GAMES SECTION            ");
        System.out.println("=====================================");

        while (true) {
            System.out.println("\nAvailable Games:");
            System.out.println("1. Word Guessing Game");
            System.out.println("2. Color Confusion Game");
            System.out.println("3. Guess the Number Game");
            System.out.println("4. Back to Main Menu");

            int choice = getIntInRange("Choose a game (1-4): ", 1, 4);

            if (choice == 1) {
                playWordGuessGame();
            } else if (choice == 2) {
                playColorGame();
            } else if (choice == 3) {
                playNumberGame();
            } else if (choice == 4) {
                return;
            }
        }
    }

    static void playWordGuessGame() {
        System.out.println("\n=====================================");
        System.out.println("       WORD GUESSING GAME            ");
        System.out.println("=====================================");

        WordGuessGame game = new WordGuessGame();

        System.out.println("1. Single Player");
        System.out.println("2. Multi Player");

        int choice = getIntInRange("Choose mode (1-2): ", 1, 2);

        if (choice == 1) {
            int tries = game.play("Player 1");
            System.out.println("\nAttempts Used: " + tries);
        } else if (choice == 2) {
            int tries1 = game.play("Player 1");
            int tries2 = game.play("Player 2");

            System.out.println("\nSCOREBOARD");
            System.out.println("Player 1 Attempts: " + tries1);
            System.out.println("Player 2 Attempts: " + tries2);

            if (tries1 < tries2)
                System.out.println("Player 1 Wins!");
            else if (tries2 < tries1)
                System.out.println("Player 2 Wins!");
            else
                System.out.println("It's a Tie!");
        }
    }

    static void playColorGame() {
        System.out.println("\n=====================================");
        System.out.println("       COLOR CONFUSION GAME          ");
        System.out.println("=====================================");

        ColorGame game = new ColorGame();

        System.out.println("1. Single Player");
        System.out.println("2. Multi Player");

        int choice = getIntInRange("Choose mode (1-2): ", 1, 2);

        if (choice == 1) {
            int score = game.play("Player 1");
            System.out.println("\nFinal Score: " + score);
        } else if (choice == 2) {
            int score1 = game.play("Player 1");
            int score2 = game.play("Player 2");

            System.out.println("\nFINAL RESULTS");
            System.out.println("Player 1: " + score1);
            System.out.println("Player 2: " + score2);

            if (score1 > score2)
                System.out.println("Player 1 Wins!");
            else if (score2 > score1)
                System.out.println("Player 2 Wins!");
            else
                System.out.println("It's a Draw!");
        }
    }

    static void playNumberGame() {
        System.out.println("\n=====================================");
        System.out.println("      GUESS THE NUMBER GAME          ");
        System.out.println("=====================================");

        GuessTheNumberGame game = new GuessTheNumberGame(10);
        game.startGame();
    }
}