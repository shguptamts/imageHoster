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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "image/{imageId}/{imageTitle}/comments")
    public String createComment(@PathVariable("imageId") int imageId, @PathVariable("imageTitle") String imageTitle, @RequestParam("comment") String commentText, HttpSession session){
        User user = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImage(imageId);
        Comment newComment = new Comment();
        newComment.setUser(user);
        newComment.setImage(image);
        newComment.setText(commentText);
        commentService.addComment(newComment);
        return "redirect:/images/" + imageId + "/" + imageTitle;
    }
}
