package com.tekgs.nextgen.duckies.data.login;


public class LoginDataProvider {
    public static LoginDataProvider getInstance() {
        return new LoginDataProvider();
    }

    public LoginData get(LoginDataDefinition loginDataDefinition) {
        return loginDataDefinition.toLoginData();
    }
}
