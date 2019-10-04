package ImageHoster.service;

import ImageHoster.repository.CommentRepository;
import ImageHoster.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/** comments by Archana: **/
//Defined the Comment service class
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //The method calls the createComment() method in the Repository and passes the comment to be persisted in the database
    public void createComment(Comment comment) {
        commentRepository.createComment(comment);
    }

    //Call the getAllComments() method in the Repository and obtain a List of all the comments in the database for a particular image
    public List<Comment> getAllComments(Integer imageId) {
        return commentRepository.getAllComments(imageId);
    }
}

