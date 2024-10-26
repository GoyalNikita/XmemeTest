package com.crio.starter.repositoryService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.crio.starter.data.PostEntity;
import com.crio.starter.exceptions.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    private MongoTemplate mongoTemplate;
    
    /**
     * Function to get the bottom 100 entities from the database
     * @return List<PostEntity> posts
     */
    @Override
    public List<PostEntity> getPosts() {
        return mongoTemplate.findAll(PostEntity.class, "userPosts");
    }
    // public List<PostEntity> getPosts() {
    //     // Query to get the latest 100 documents from the MongoDB collection.
    //     Query query = new Query().with(Sort.by(Direction.DESC, "dateOfPosting")).limit(100);
    //     return mongoTemplate.find(query, PostEntity.class, "userPosts");
    // }
    


    /**
     * This function gets a single PostEntity instance from database having the provided id and returns it
     * @param long postId
     * @return PostEntity
     * @throws PostNotFoundException if there is no post with the given id in the database  
     */
    @Override
    public PostEntity getPost(long postId) throws PostNotFoundException {
        Query query = new Query(Criteria.where("id").is(postId));
        PostEntity post = mongoTemplate.findOne(query, PostEntity.class, "userPosts");
        if (post == null) throw new PostNotFoundException();
        return post;
    }


    /**
     * This function saves a PostEntity instance in the database.
     * @return long postId - id of the saved instance
     */
    @Override
    public long savePost(PostEntity post) {
        PostEntity savedPost = mongoTemplate.save(post, "userPosts");
        return savedPost.getId();
    }


    /**
     * This function updates an existing post in the database.
     * @param Map<String, Object> updates
     * @param long postId
     * @throws PostNotFoundException if the entity with the given id is not found in the database
     */
    @Override
    public void updatePost(Map<String, Object> updates, long postId) throws PostNotFoundException{
        Query query = new Query(Criteria.where("id").is(postId));
        PostEntity post = mongoTemplate.findOne(query, PostEntity.class, "userPosts");
        if (post == null) throw new PostNotFoundException();
        
        Object newUrl = updates.get("url");
        Object newCaption = updates.get("caption");

        if (newUrl != null) post.setUrl(newUrl.toString());
        
        if (newCaption != null) post.setCaption(newCaption.toString());

        mongoTemplate.save(post);
    }
}
