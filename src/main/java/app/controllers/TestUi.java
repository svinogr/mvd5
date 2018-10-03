package app.controllers;


import com.vaadin.annotations.Theme;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Locale;
@SpringUI(path = "/UI/log")
@Theme("dashboard")
public class TestUi extends UI {


    @Override
    protected void init(VaadinRequest request) {
setContent(new Label("тест"));
    }
}