package com.example.menu.HTTPCLIENT;

public class UserBuilder {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;



    public static User Build() {
        User.Address address1 = new User.Address(
                "Baltimore",
                "Eko Hotels and suite",
                "Lagos",
                "223304",
                new User.Address.Geo("-1245", "9340")


        );
        User.Company company = new User.Company(
                "My Great Company",
                "We develop software!",
                "software, development, java");


        return new User(
                null,
                "Jon Doe",
                "Jane_peps",
                "JonDoe@gmail.com",
                address1,
                "08135875494",
                "https://github.com/LorenzoOyani/",
                company
        );
    }
}
