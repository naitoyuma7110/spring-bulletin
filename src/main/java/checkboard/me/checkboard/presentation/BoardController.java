package checkboard.me.checkboard.presentation;

import checkboard.me.checkboard.application.form.CommentForm;
import checkboard.me.checkboard.application.usecase.UserCommentUseCase;
import checkboard.me.checkboard.domain.type.UserComments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class BoardController {
    private final UserCommentUseCase userCommentUseCase;
    @GetMapping("/board")
    public ModelAndView viewBoard(ModelAndView modelAndView){
        UserComments userComments = userCommentUseCase.read();
//      getValuesは@RequiredArgsConstructorで自動生成
        modelAndView.addObject("comments", userComments.getValues());
//      ModelAndViewをreturnする方法で画面描画：入力画面'board'へのパス、引き渡すオブジェクトを設定(オブジェクトで入力値の型チェック)
        modelAndView.setViewName("board");
        modelAndView.addObject("commentForm", new CommentForm());
        return modelAndView;
    }

    @PostMapping("/board")
    public ModelAndView postComment(@Validated @ModelAttribute CommentForm comment, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
//          エラーがあればPostされた内容を渡して再度フォームへ
            ModelAndView modelAndview = new ModelAndView("board");
            modelAndview.addObject("commentForm", comment);
            return modelAndview;
        }

        userCommentUseCase.write(comment);

        return new ModelAndView("redirect:/board");
    }

    @GetMapping("/test") // localhost:8080/helloはここにアクセスが来る
    public String test(Model model){
        return "test";
    }

    @PostMapping("/test")
    public String testComment() {
        userCommentUseCase.testWrite();
        return "redirect:/test";
    }




}
