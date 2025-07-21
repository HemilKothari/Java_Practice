package socialsphere.model;

import java.sql.Timestamp;

public class PostUserJoin {
    private String postTitle;
    private String postContent;
    private Timestamp postTime;
    private String userName;

    public PostUserJoin(String postTitle, String postContent, Timestamp postTime, String userName) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTime = postTime;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "PostUserJoin{" +
                "postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postTime=" + postTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}
