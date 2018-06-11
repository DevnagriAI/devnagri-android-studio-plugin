package com.devnagri.androidstudio.actions;

import com.devnagri.androidstudio.LinkOpener;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;

public class HelpAction extends AnAction {
    public HelpAction() {
        super();
    }

    public HelpAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }
  /*  public void actionPerformed(AnActionEvent e) {
        LinkOpener.open("http://docs.phraseapp.com/guides/setup/android/");
    }*/
    public void actionPerformed(AnActionEvent e) {
        LinkOpener.open("https://www.devnagri.com/contact-us/");
    }


}
