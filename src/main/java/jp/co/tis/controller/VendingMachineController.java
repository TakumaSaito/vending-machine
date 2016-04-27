package jp.co.tis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自動販売機のコントローラークラス。
 *
 * @author Saito Takuma
 * @since 1.0
 */
@RestController
public class VendingMachineController {

    /**
     * TOP画面へ遷移する。
     *
     * @return ModelAndView
     */
    @RequestMapping("/")
    public ModelAndView top() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("top");

        return modelAndView;
    }

    /**
     * ステップ１画面へ遷移する。
     *
     * @return ModelAndView
     */
    @RequestMapping("/step1")
    public ModelAndView step1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("step1");

        return modelAndView;
    }

    /**
     * ステップ２画面へ遷移する。
     *
     * @return ModelAndView
     */
    @RequestMapping("/step2")
    public ModelAndView step2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("step2");

        return modelAndView;
    }

    /**
     * ステップ３画面へ遷移する。
     *
     * @return ModelAndView
     */
    @RequestMapping("/step3")
    public ModelAndView step3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("step3");

        return modelAndView;
    }

    /**
     * ステップ４画面へ遷移する。
     *
     * @return ModelAndView
     */
    @RequestMapping("/step4")
    public ModelAndView step4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("step4");

        return modelAndView;
    }

    /**
     * ステップ５画面へ遷移する。
     *
     * @return ModelAndView
     */
    @RequestMapping("/step5")
    public ModelAndView step5() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("step5");

        return modelAndView;
    }

    /**
     * ステップ６画面へ遷移する。
     *
     * @return ModelAndView
     */
    @RequestMapping("/step6")
    public ModelAndView step6() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("step6");

        return modelAndView;
    }
}
