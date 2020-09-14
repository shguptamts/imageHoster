package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public void addComment(Comment newComment) {
        newComment.setCreatedDate( LocalDate.now());
        repository.addComment(newComment);
    }
}
