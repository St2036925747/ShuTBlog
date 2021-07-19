package self.projects.shutblog.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BlogEntity {
    private int blogId;
    private String title;
    private String briefIntroduction;
    private String content;
    private char publicity;

    private int userId;
    private String nickname;

    private Timestamp publishTime;
    private Timestamp recentModifyTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public char getPublicity() {
        return publicity;
    }

    public void setPublicity(char publicity) {
        this.publicity = publicity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Timestamp getRecentModifyTime() {
        return recentModifyTime;
    }

    public void setRecentModifyTime(Timestamp recentModifyTime) {
        this.recentModifyTime = recentModifyTime;
    }
}
