package ImageHoster.model;

/*done by -Rushikesh Milind Wadkar*/

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "createdDate")
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "image")
    private Image image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    private User user;

    public Comments(){}

    public Comments(int id,String text,Date createdDate,Image image,User user){
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.image = image;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Image getImage() {
        return this.image;
    }

    public void setimage(Image image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
