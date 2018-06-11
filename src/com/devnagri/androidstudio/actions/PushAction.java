package com.devnagri.androidstudio.actions;

import com.devnagri.androidstudio.helper.ActionEventHandler;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;


public class PushAction extends AnAction {
    public PushAction() {
        super();
    }

    public PushAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }

    public final void actionPerformed(final AnActionEvent e) {
        ActionEventHandler handler = new ActionEventHandler();
        handler.handleEvent(e, "push");
    }
}

