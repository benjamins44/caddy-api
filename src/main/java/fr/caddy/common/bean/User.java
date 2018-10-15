package fr.caddy.common.bean;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;

public class User {

    public static final String COLLECTION_NAME = "User";

    @Id
    private Long id;

    private String firstname;

    @UniqueElements
    private String login;

    private String lastname;

    private String loginCoursesU;

    private String passwordCoursesU;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLoginCoursesU() {
        return loginCoursesU;
    }

    public void setLoginCoursesU(String loginCoursesU) {
        this.loginCoursesU = loginCoursesU;
    }

    public String getPasswordCoursesU() {
        return passwordCoursesU;
    }

    public void setPasswordCoursesU(String passwordCoursesU) {
        this.passwordCoursesU = passwordCoursesU;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, login=%s, firstname=%s, lastname=%s, loginCoursesU=%s, passwordCoursesU=%s ]",
                id, login, firstname, lastname, loginCoursesU, passwordCoursesU);
    }
}
