package com.simbirsoft.spring_demo;

public interface Urls {

    String API = "api";
    String API_VERSION = "v1";
    String ROOT = "/" + API + "/" + API_VERSION;

    interface Authors {
        String PART = "authors";
        String FULL = ROOT + "/" + PART;
    }

    interface Books {

        String PART = "books";
        String FULL = ROOT + "/" + PART;
    }

    interface Users {

        String PART = "users";
        String FULL = ROOT + "/" + PART;
    }

    interface Publishers {

        String PART = "publishers";
        String FULL = ROOT + "/" + PART;
    }
}
