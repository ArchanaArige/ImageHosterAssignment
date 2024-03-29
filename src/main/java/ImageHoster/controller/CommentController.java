package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;


/** comments by Archana: **/
//The controller class method  maps to the POST request URL ‘/image/{imageId}/{imageTitle}/comments’ for creating a new comment.
//After persisting the comment in the database, the controller logic redirects to the same page displaying all the details of that particular image.
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value="/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String title,
                                @RequestParam("comment") String comment, Comment newComment, HttpSession session) {
        {
            User user = (User) session.getAttribute("loggeduser");
            Image image = imageService.getImage(imageId);
            newComment.setText(comment);
            newComment.setImage(image);
            newComment.setUser(user);
            newComment.setCreatedDate(LocalDate.now());
            commentService.createComment(newComment);
            return "redirect:/images/" + imageId + "/" + title;
        }
    }
}

