package demoSecurity.model;

import javax.persistence.*;

@Entity
public class ApUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String passWord;

    @ManyToOne
    Role role;

    public ApUser() {
    }

    public ApUser(long id, String userName, String passWord, Role role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
