package com.ivanshyrai.profile;

import com.ivanshyrai.date.PastLocalDate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfileForm {

    // Verification annotations
    // one of the options set error message
    // cons - will be always in english
    //@Size(min = 2, message = "Enter valid ID")
    @Size(min = 2)
    private String twitterHandle;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    @PastLocalDate // custom date validation annotation
    private LocalDate birthDate;

    @NotEmpty
    private List<String> tastes = new ArrayList<>();

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getTastes() {
        return tastes;
    }

    public void setTastes(List<String> tastes) {
        this.tastes = tastes;
    }

    @Override
    public String toString() {
        return "ID:" + twitterHandle + ", EMAIL:" + email + ", BIRTH DATE:" + birthDate;
    }
}
