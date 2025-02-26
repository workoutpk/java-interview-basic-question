package file;

// Model class representing User
class User {
    private int id;
    private String name;
    private String username;
    private String email;

    // Nested Address class
    static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;

        // Nested Geo class
        static class Geo {
            private String lat;
            private String lng;

            // Getters and Setters
            public String getLat() { return lat; }
            public void setLat(String lat) { this.lat = lat; }
            public String getLng() { return lng; }
            public void setLng(String lng) { this.lng = lng; }
        }

        private Geo geo;

        // Getters and Setters
        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }
        public String getSuite() { return suite; }
        public void setSuite(String suite) { this.suite = suite; }
        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
        public String getZipcode() { return zipcode; }
        public void setZipcode(String zipcode) { this.zipcode = zipcode; }
        public Geo getGeo() { return geo; }
        public void setGeo(Geo geo) { this.geo = geo; }
    }

    private Address address;
    private String phone;
    private String website;

    // Company nested class
    static class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getCatchPhrase() { return catchPhrase; }
        public void setCatchPhrase(String catchPhrase) { this.catchPhrase = catchPhrase; }
        public String getBs() { return bs; }
        public void setBs(String bs) { this.bs = bs; }
    }

    private Company company;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
