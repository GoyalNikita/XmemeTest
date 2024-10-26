package com.crio.starter.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Document(collection = "userPosts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostEntity {
    @Transient
    public static final String SEQUENCE_NAME = "posts_sequence";
    
    @Id
    private long id;

    private String name;

    private String url;

    private String caption;

    private LocalDate dateOfPosting;

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDate getDateOfPosting() {
        return dateOfPosting;
    }

    public void setDateOfPosting(LocalDate dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }
}
