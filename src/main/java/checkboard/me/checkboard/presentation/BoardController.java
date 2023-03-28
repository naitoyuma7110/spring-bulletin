package checkboard.me.checkboard.presentation;

import checkboard.me.checkboard.application.form.CommentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class BoardController {
    @GetMapping("/board")
    public ModelAndView viewBoard(ModelAndView modelAndView){
//      ModelAndViewをreturnする方法で画面描画：入力画面'board'へのパス、引き渡すオブジェクトを設定(オブジェクトで入力値の型チェック？)
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
        return new ModelAndView("redirect:/board");
    }
}
