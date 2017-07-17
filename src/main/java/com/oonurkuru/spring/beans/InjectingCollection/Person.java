package com.oonurkuru.spring.beans.InjectingCollection;

import java.util.List;

/**
 * Created by Onur Kuru on 17.7.2017.
 */

public class Person {

    private List<String> followers;
    private List<String> projects;

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
