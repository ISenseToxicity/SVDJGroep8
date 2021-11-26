package models;

public class Grant {

        private String grantID;

        private String name;
        private String description;

        public Grant(String grantID, String name, String description) {
            this.grantID = grantID;
            this.name = name;
            this.description = description;
        }

    public String getGrantID() {
        return grantID;
    }

    public void setGrantID(String grantID) {
        this.grantID = grantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
