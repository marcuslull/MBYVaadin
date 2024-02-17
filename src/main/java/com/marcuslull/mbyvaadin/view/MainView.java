package com.marcuslull.mbyvaadin.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("")
@PageTitle("Main | My BackYard")
@PermitAll
public class MainView extends VerticalLayout {
    public MainView() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        add(
                new H1("My BackYard"),
                new Paragraph("Welcome " + authentication.getName())
        );
    }
}
