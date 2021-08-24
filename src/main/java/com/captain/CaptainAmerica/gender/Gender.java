package com.captain.CaptainAmerica.gender;

public enum Gender {
    MALE("Male"),FEMALE("Female"), TRANSGENDER("Trans Gender");

    private String displayName;

    Gender(String displayName) {
        this.displayName=displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
