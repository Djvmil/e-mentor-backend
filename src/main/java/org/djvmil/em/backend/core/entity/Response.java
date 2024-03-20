package org.djvmil.em.backend.core.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Response")
@NamedEntityGraph(name = "response.join.tables",
        attributeNodes = {
        @NamedAttributeNode("user"),
        @NamedAttributeNode("interview"),
        @NamedAttributeNode("question")})
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "interviewID")
    private Interview interview;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "questionID")
    private Question question;

    private String responseText;
    private Long score;

    public Response() {
    }

    public Response(Long responseID, User user, Interview interview, Question question, String responseText, Long score) {
        this.responseID = responseID;
        this.user = user;
        this.interview = interview;
        this.question = question;
        this.responseText = responseText;
        this.score = score;
    }

    public Long getResponseID() {
        return responseID;
    }

    public void setResponseID(Long responseID) {
        this.responseID = responseID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseID=" + responseID +
                ", user=" + user +
                ", interview=" + interview +
                ", question=" + question +
                ", responseText='" + responseText + '\'' +
                ", score=" + score +
                '}';
    }
}