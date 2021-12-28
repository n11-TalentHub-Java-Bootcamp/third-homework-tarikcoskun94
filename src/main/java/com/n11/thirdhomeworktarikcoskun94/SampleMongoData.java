package com.n11.thirdhomeworktarikcoskun94;

import com.n11.thirdhomeworktarikcoskun94.entity.ProductComment;
import com.n11.thirdhomeworktarikcoskun94.entity.User;
import com.n11.thirdhomeworktarikcoskun94.service.ProductCommentService;
import com.n11.thirdhomeworktarikcoskun94.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SampleMongoData {

    private final UserService userService;
    private final ProductCommentService productCommentService;

    @PostConstruct
    public void insertRequiredSampleData() {
        insertUsers();
        insertProductComments();
    }

    private void insertUsers() {

        List<User> userList = new ArrayList<>();

        User user1 = User.builder()
                .id("1")
                .username("tcoskun")
                .name("Tarık")
                .surname("COŞKUN")
                .email("tarikcoskun@hotmail.com.tr")
                .phoneNumber("05548960682")
                .build();

        User user2 = User.builder()
                .id("2")
                .username("akeles")
                .name("Ali")
                .surname("KELEŞ")
                .email("alikeles@hotmail.com")
                .phoneNumber("05356987416")
                .build();

        User user3 = User.builder()
                .id("3")
                .username("bcelik")
                .name("Beyza")
                .surname("ÇELİK")
                .email("beyzac@outlook.com.tr")
                .phoneNumber("05421548937")
                .build();

        User user4 = User.builder()
                .id("4")
                .username("ekatip")
                .name("Elif")
                .surname("KATİP")
                .email("katipelif@gmail.com")
                .phoneNumber("05563178965")
                .build();

        User user5 = User.builder()
                .id("5")
                .username("aaslan")
                .name("Ahmet")
                .surname("ASLAN")
                .email("aaslan@yahoo.com")
                .phoneNumber("05555556987")
                .build();

        User user6 = User.builder()
                .id("6")
                .username("kkiraz")
                .name("Kerem")
                .surname("KİRAZ")
                .email("keremkiraz@hotmail.com.tr")
                .phoneNumber("05486587215")
                .build();

        User user7 = User.builder()
                .id("7")
                .username("sakyol")
                .name("Seray")
                .surname("AKYOL")
                .email("serayyyakyol@hotmail.com")
                .phoneNumber("05386649987")
                .build();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);

        userService.deleteAllUsers();
        userService.saveUsers(userList);
        System.out.println("Sample users data has been inserted.");
    }

    private void insertProductComments() {

        List<ProductComment> productCommentList = new ArrayList<>();

        ProductComment productComment1 = ProductComment.builder()
                .id("1")
                .text("The European languages are members of the same family. Their separate existence is a myth. For scien")
                .creationDate(Calendar.getInstance().getTime())
                .productId("2")
                .userId("3")
                .build();

        ProductComment productComment2 = ProductComment.builder()
                .id("2")
                .text("Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large.")
                .creationDate(Calendar.getInstance().getTime())
                .productId("2")
                .userId("7")
                .build();

        ProductComment productComment3 = ProductComment.builder()
                .id("3")
                .text("A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was.")
                .creationDate(Calendar.getInstance().getTime())
                .productId("6")
                .userId("1")
                .build();

        ProductComment productComment4 = ProductComment.builder()
                .id("4")
                .text("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu")
                .creationDate(Calendar.getInstance().getTime())
                .productId("7")
                .userId("7")
                .build();

        ProductComment productComment5 = ProductComment.builder()
                .id("5")
                .text("The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt fox. Bright vixens jump; dozy fowl quack. Qu")
                .creationDate(Calendar.getInstance().getTime())
                .productId("5")
                .userId("6")
                .build();

        ProductComment productComment6 = ProductComment.builder()
                .id("6")
                .text("But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids")
                .creationDate(Calendar.getInstance().getTime())
                .productId("6")
                .userId("3")
                .build();

        productCommentList.add(productComment1);
        productCommentList.add(productComment2);
        productCommentList.add(productComment3);
        productCommentList.add(productComment4);
        productCommentList.add(productComment5);
        productCommentList.add(productComment6);

        productCommentService.deleteAllProductComments();
        productCommentService.saveProductComments(productCommentList);

        System.out.println("Sample product comment data has been inserted.");
    }
}
