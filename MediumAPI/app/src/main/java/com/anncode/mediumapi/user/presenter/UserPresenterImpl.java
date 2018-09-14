package com.anncode.mediumapi.user.presenter;

import com.anncode.mediumapi.user.interactor.UserInteractor;
import com.anncode.mediumapi.user.interactor.UserInteractorImpl;
import com.anncode.mediumapi.user.model.User;
import com.anncode.mediumapi.user.view.UserView;

public class UserPresenterImpl implements UserPresenter {
    private UserView userView;
    private UserInteractor userInteractor;

    public UserPresenterImpl(UserView userView) {
        this.userView = userView;
        userInteractor = new UserInteractorImpl(this);
    }

    @Override
    public void getDataUser() {
        userInteractor.getDataUser();
    }

    @Override
    public void showDataUser(User user) {
        userView.showDataUser(user);
    }
}
