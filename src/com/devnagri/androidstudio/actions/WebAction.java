package com.devnagri.androidstudio.actions;

import com.devnagri.androidstudio.LinkOpener;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;


public class WebAction extends AnAction {

    public WebAction() {
    }

    public WebAction(String s, String s1, Icon icon) {
        super(s, s1, icon);
    }
/*
    public void actionPerformed(AnActionEvent e) {

        LinkOpener.open("https://phraseapp.com/projects");
    }*/
    public void actionPerformed(AnActionEvent e) {
        LinkOpener.open("https://www.devnagri.com/");
    }


}
