package com.yb.cheung.template;

public class 父类 {

    public void 学习(){
        System.out.println("每天趴在邻居的窗户上学习");
    }

    public void 爱情(){
        System.out.println("对女孩从一而终");
    }

    public void 工作(){
        System.out.println("对工作从一而终");
    }

    public void 退休(){
        System.out.println("下棋打牌");
    }

    public final void 人生(){

        学习();
        爱情();
        工作();
        退休();

    }

}
