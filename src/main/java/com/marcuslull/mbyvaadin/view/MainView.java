package com.marcuslull.mbyvaadin.view;

import com.marcuslull.mbyvaadin.repository.AnimalRepository;
import com.marcuslull.mbyvaadin.repository.PlantRepository;
import com.marcuslull.mbyvaadin.repository.UserRepository;
import com.marcuslull.mbyvaadin.repository.YardRepository;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
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
    private final UserRepository userRepository;
    private final YardRepository yardRepository;
    private final PlantRepository plantRepository;
    private final AnimalRepository animalRepository;
    public MainView(UserRepository userRepository, YardRepository yardRepository, PlantRepository plantRepository, AnimalRepository animalRepository) {
        this.userRepository = userRepository;
        this.yardRepository = yardRepository;
        this.plantRepository = plantRepository;
        this.animalRepository = animalRepository;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MultiSelectListBox<String> multiSelectListBox1 = new MultiSelectListBox<>();
        multiSelectListBox1.setItems(userRepository.findAll().toString());
        MultiSelectListBox<String> multiSelectListBox2 = new MultiSelectListBox<>();
        multiSelectListBox2.setItems(yardRepository.findAll().toString());
        MultiSelectListBox<String> multiSelectListBox3 = new MultiSelectListBox<>();
        multiSelectListBox3.setItems(plantRepository.findAll().toString());
        MultiSelectListBox<String> multiSelectListBox4 = new MultiSelectListBox<>();
        multiSelectListBox4.setItems(animalRepository.findAll().toString());

        add(
                new H1("My BackYard"),
                new Paragraph("Welcome " + authentication.getName()),
                multiSelectListBox1,
                multiSelectListBox2,
                multiSelectListBox3,
                multiSelectListBox4
        );
    }
}
