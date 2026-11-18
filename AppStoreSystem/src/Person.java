class Person {
    String name;
    String id;
    String password;
    String phoneNumber;

    public Person() {
        name = "";
        id = "";
        password = "";
        phoneNumber = "";
    }

    public Person(String name, String id, String password, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id + ", Phone: " + phoneNumber);
    }
}