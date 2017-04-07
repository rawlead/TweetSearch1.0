package test;

import org.springframework.mock.web.MockHttpSession;

import java.util.Arrays;

public class SessionBuilder {
    private final MockHttpSession session;
//    private UserProfileSession sessionBean;
    public SessionBuilder() {
        session = new MockHttpSession();
//        sessionBean = new UserProfileSession();
        session.setAttribute("scopedTarget.userProfileSession", new SessionBuilder() /*sessionBean*/);
    }

    public SessionBuilder userTastes(String... tastes) {
//        sessionBean.setTastes(Arrays.asList(tastes));
        return this;
    }

    public MockHttpSession build() {
        return session;
    }
}
