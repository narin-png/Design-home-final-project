package az.coders.Design.homes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name = "home_pages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Media media;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private AboutUs aboutUs;
    @OneToMany(mappedBy = "homePage",cascade = CascadeType.ALL)
    private List<ServiceNavigation> services;
    @OneToMany(mappedBy = "homePage",cascade = CascadeType.ALL)
    private List<Project> projects;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Consultation consultation;
    @OneToMany(mappedBy = "homePage", cascade = CascadeType.ALL)
    private List<Testimonial> testimonials;
    @OneToMany(mappedBy = "homePage", cascade = CascadeType.ALL)
    private List<Faq> faqs;




}
