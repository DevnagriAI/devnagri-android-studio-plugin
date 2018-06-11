package com.devnagri.androidstudio.actions;

import com.devnagri.androidstudio.helper.ActionEventHandler;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;

public class PullAction extends AnAction {
    public PullAction() {
        super();
    }

    public PullAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }

    public void actionPerformed(final AnActionEvent e)
    {
        ActionEventHandler handler = new ActionEventHandler();
        handler.handleEvent(e, "pull");
    }
}
