package ImageHoster.model;


import javax.persistence.*;
import java.time.LocalDate;

/** Comments by Archana : **/

//Implementing a new feature called Comment  wherein a user can add a comment to any image in the application after he is logged in the application

@Entity
//Here the name of the table to be created in the database is explicitly mentioned as 'comment'. Hence the table named 'comment'
// will be created in the database with all the columns mapped to all the attributes in 'Comment' class
@Table(name = "comment")
public class Comment {
    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "created_date")
    private LocalDate createdDate;

    //The 'comment' table is mapped to 'users' table with Many:One mapping One comment can have only one user (owner) but one user can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'comment' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

    //The 'comment' table is mapped to 'images' table with Many:One mapping as One image can have multiple comments but one comment can only belong to one image
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

