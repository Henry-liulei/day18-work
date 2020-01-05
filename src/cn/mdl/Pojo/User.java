package cn.mdl.Pojo;

import java.util.Date;

public class User {
    private Integer id;
    private String userName;
    private String userPwd;
    private String sex;
    private String chk;
    private String sel;
    private String address;
    private String birthday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", sex='" + sex + '\'' +
                ", chk='" + chk + '\'' +
                ", sel='" + sel + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public User() {
    }

    public User(Integer id, String userName, String userPwd, String sex, String chk, String sel, String address, String birthday) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.chk = chk;
        this.sel = sel;
        this.address = address;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getChk() {
        return chk;
    }

    public void setChk(String chk) {
        this.chk = chk;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
